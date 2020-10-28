package com.hdz.pretendproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hdz.pretendproject.R;
import com.hdz.pretendproject.data.IpGet;
import com.hdz.pretendproject.utils.DateUtils;
import com.hdz.pretendproject.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class IpGetAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<IpGet> dataList;
    private Context context;

    public IpGetAdapter(Context context) {
        this.context = context;
        dataList = new ArrayList<>();
    }

    public void setDataList(List<IpGet> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    public void updateDataList(List<IpGet> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View contentView = LayoutInflater.from(context).inflate(R.layout.item_ip_get_layout, parent, false);
        return new IpGetHolder(contentView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof IpGetHolder) {
            IpGet ipGet = dataList.get(position);
            ((IpGetHolder) holder).textNo.setText(String.format("%s", (position + 1)));
            ((IpGetHolder) holder).textAmount.setText(StringUtils.formatPrice(ipGet.getExtractNum(), false) + "Fil");
            ((IpGetHolder) holder).textDate.setText(DateUtils.formatDateH(ipGet.getCreateTime()));
            String state = ipGet.getState();
            if ("0".equals(state)) {
                ((IpGetHolder) holder).textState.setTextColor(0xff999999);
                ((IpGetHolder) holder).textState.setText("审核中");
            } else if ("1".equals(state)) {
                ((IpGetHolder) holder).textState.setTextColor(0xff00ff00);
                ((IpGetHolder) holder).textState.setText("提取成功");
            } else if ("2".equals(state)) {
                ((IpGetHolder) holder).textState.setTextColor(0xffff0000);
                ((IpGetHolder) holder).textState.setText("提取失败");
            }
            ((IpGetHolder) holder).textKey.setText("");
        }
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }


    class IpGetHolder extends RecyclerView.ViewHolder {
        TextView textNo;
        TextView textAmount;
        TextView textState;
        TextView textDate;
        TextView textKey;

        public IpGetHolder(@NonNull View itemView) {
            super(itemView);
            textNo = itemView.findViewById(R.id.text_ip_get_no);
            textAmount = itemView.findViewById(R.id.text_ip_get_amount);
            textState = itemView.findViewById(R.id.text_ip_get_state);
            textDate = itemView.findViewById(R.id.text_ip_get_time);
            textKey = itemView.findViewById(R.id.text_ip_get_key);
        }
    }
}
