package com.example.android.localweatherwithfragment.Adapter;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.util.Util;
import com.example.android.localweatherwithfragment.DataModel.HourlyModel;
import com.example.android.localweatherwithfragment.R;
import com.example.android.localweatherwithfragment.Util.AppConstants;

public class HourlyViewHolder extends RecyclerView.ViewHolder{
    private final TextView temp_hourly;
    private final TextView datetime_hourly;
    private final ImageView icon_hourly;

    public HourlyViewHolder(@NonNull View itemView) {
        super(itemView);
        temp_hourly = itemView.findViewById(R.id.temp_hourly);
        datetime_hourly = itemView.findViewById(R.id.datetime_hourly);
        icon_hourly = itemView.findViewById(R.id.icon_hourly);
    }
    @SuppressLint("SetTextI18n")
    public void bindData(HourlyModel model){
        temp_hourly.setText(model.temp_hourly() + "\u2103");
        datetime_hourly.setText(model.datetime_hourly());
        Glide
                .with(itemView.getContext())
                .load(AppConstants.iconBaseUrl
                        + AppConstants.second_set_color
                        + model.icon_hourly()
                        + ".png")
                .into(icon_hourly);
    }
}
