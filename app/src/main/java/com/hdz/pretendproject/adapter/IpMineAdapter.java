package com.hdz.pretendproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hdz.pretendproject.R;
import com.hdz.pretendproject.data.IpMine;
import com.hdz.pretendproject.data.IpProduce;
import com.hdz.pretendproject.utils.DateUtils;
import com.hdz.pretendproject.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class IpMineAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<IpMine> dataList;
    private Context context;

    public IpMineAdapter(Context context) {
        this.context = context;
        dataList = new ArrayList<>();
    }

    public void setDataList(List<IpMine> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    public void updateDataList(List<IpMine> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View contentView = LayoutInflater.from(context).inflate(R.layout.item_ip_mine_layout, parent, false);
        return new IpProduceAdapter.IpProduceHolder(contentView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof IpMineHolder) {
            IpMine ipProduce = dataList.get(position);
            ((IpMineHolder) holder).textNo.setText(String.format("%s", (position + 1)));
            ((IpMineHolder) holder).textDate.setText(DateUtils.formatDateH(ipProduce.getCreateTime(), 0));
            ((IpMineHolder) holder).textAmount.setText(String.format("%s%s", StringUtils.formatToString(ipProduce.getAccount(), 6, false, false), ipProduce.getUnit()));
            ((IpMineHolder) holder).textRemark.setText("IPFS矿机 ");
        }
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }


    class IpMineHolder extends RecyclerView.ViewHolder {

        TextView textNo;
        TextView textDate;
        TextView textAmount;
        TextView textRemark;

        public IpMineHolder(@NonNull View itemView) {
            super(itemView);
            textNo = itemView.findViewById(R.id.text_ip_mine_no);
            textDate = itemView.findViewById(R.id.text_ip_mine_date);
            textAmount = itemView.findViewById(R.id.text_ip_mine_amount);
            textRemark = itemView.findViewById(R.id.text_ip_mine_remark);
        }
    }
}
