package com.hdz.pretendproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hdz.pretendproject.R;
import com.hdz.pretendproject.data.IpProduce;
import com.hdz.pretendproject.utils.DateUtils;
import com.hdz.pretendproject.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class IpProduceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<IpProduce> dataList;
    private Context context;

    public IpProduceAdapter(Context context) {
        this.context = context;
        dataList = new ArrayList<>();
    }

    public void setDataList(List<IpProduce> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    public void updateDataList(List<IpProduce> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View contentView = LayoutInflater.from(context).inflate(R.layout.item_ip_produce_layout, parent, false);
        return new IpProduceHolder(contentView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof IpProduceHolder) {
            IpProduce ipProduce = dataList.get(position);
            ((IpProduceHolder) holder).textNo.setText(String.format("%s", (position + 1)));
            ((IpProduceHolder) holder).textDate.setText(DateUtils.formatDateH(ipProduce.getOperatorTime()));
            ((IpProduceHolder) holder).textAmount.setText(StringUtils.formatToString(ipProduce.getAccount(), 6, false, false)+"Fil");
            ((IpProduceHolder) holder).textRemark.setText(ipProduce.getRemark() == null ? "" : ipProduce.getRemark());
        }
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }


  static class IpProduceHolder extends RecyclerView.ViewHolder {

        TextView textNo;
        TextView textDate;
        TextView textAmount;
        TextView textRemark;

        public IpProduceHolder(@NonNull View itemView) {
            super(itemView);
            textNo = itemView.findViewById(R.id.text_ip_produce_no);
            textDate = itemView.findViewById(R.id.text_ip_produce_date);
            textAmount = itemView.findViewById(R.id.text_ip_produce_amount);
            textRemark = itemView.findViewById(R.id.text_ip_produce_remark);
        }
    }
}
