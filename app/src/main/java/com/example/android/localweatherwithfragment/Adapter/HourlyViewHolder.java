package com.example.android.localweatherwithfragment.Adapter;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.android.localweatherwithfragment.DataModel.HourlyModel;
import com.example.android.localweatherwithfragment.R;

public class HourlyViewHolder extends RecyclerView.ViewHolder{
    private final TextView tv_temp;
    private final TextView tv_hour;
    public HourlyViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_temp = itemView.findViewById(R.id.tv_temp);
        tv_hour = itemView.findViewById(R.id.tv_hour);
    }
    public void bindData(HourlyModel model){
        tv_temp.setText(model.temp);
        tv_hour.setText(model.hour);
    }
}
