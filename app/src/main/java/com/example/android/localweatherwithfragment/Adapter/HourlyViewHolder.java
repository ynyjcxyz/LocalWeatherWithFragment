package com.example.android.localweatherwithfragment.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.localweatherwithfragment.DataModel.HourlyModel;
import com.example.android.localweatherwithfragment.R;

public class HourlyViewHolder extends RecyclerView.ViewHolder {
    private final TextView tv_hour;
    private final TextView tv_temp;

    public HourlyViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_hour = itemView.findViewById(R.id.tv_hour);
        tv_temp = itemView.findViewById(R.id.tv_temp);
    }

    public void bindData(HourlyModel model) {

        tv_hour.setText(model.hour);
        tv_temp.setText(model.temp);
    }

}