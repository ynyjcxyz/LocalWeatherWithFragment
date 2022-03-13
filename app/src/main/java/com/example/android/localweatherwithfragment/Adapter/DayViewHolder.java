package com.example.android.localweatherwithfragment.Adapter;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android.localweatherwithfragment.DataModel.DaysBaseModel;
import com.example.android.localweatherwithfragment.DataModel.DaysBaseModelWrapper;
import com.example.android.localweatherwithfragment.DataModel.HourlyModel;
import com.example.android.localweatherwithfragment.DataModel.ParameterClass;
import com.example.android.localweatherwithfragment.R;

import java.util.List;

public class DayViewHolder extends RecyclerView.ViewHolder {
    private final View layoutExpand;
    LinearLayout parent_layout;
    RecyclerView hourly_list;
    TextView datetime_by_days, conditions_by_days, temp_max, temp_min;
    ImageView icon_by_days;

    public DayViewHolder(@NonNull View itemView) {
        super(itemView);
        parent_layout = itemView.findViewById(R.id.list_item);
        datetime_by_days = itemView.findViewById(R.id.datetime_by_days);
        conditions_by_days = itemView.findViewById(R.id.conditions_by_days);
        temp_max = itemView.findViewById(R.id.temp_max);
        temp_min = itemView.findViewById(R.id.temp_min);
        hourly_list = itemView.findViewById(R.id.hourly_list);
        icon_by_days = itemView.findViewById(R.id.icon_by_days);
        layoutExpand = itemView.findViewById(R.id.layoutExpand);
    }

    @SuppressLint("SetTextI18n")
    public void bindData(DaysBaseModelWrapper wrapper) {
        DaysBaseModel daysBaseModel = wrapper.getDaysBaseModel();
        datetime_by_days.setText(daysBaseModel.datetime());
        conditions_by_days.setText(daysBaseModel.conditions());
        Glide.with(itemView.getContext())
                .load(ParameterClass.iconBaseUrl + ParameterClass.second_set_color + daysBaseModel.icon() + ".png")
                .into(icon_by_days);
        temp_max.setText(daysBaseModel.tempmax() + "\u2103 \u21E1");
        temp_min.setText(daysBaseModel.tempmin() + "\u2103 \u21E3");
        bindExpandAction(new DaysBaseModelWrapper(daysBaseModel, false));
    }


    public void bindExpandAction(DaysBaseModelWrapper wrapper) {
        hourly_list.setLayoutManager(new LinearLayoutManager(itemView.getContext(), RecyclerView.HORIZONTAL, false));
        hourly_list.setAdapter(new HourlyAdapter(hourly(wrapper)));
        itemView.setOnClickListener(view -> onItemToggled(wrapper, view));
    }

    private List<HourlyModel> hourly(DaysBaseModelWrapper wrapper) {
        return  wrapper.getDaysBaseModel().hours();
    }

    private void onItemToggled(DaysBaseModelWrapper personModel, View view) {
        boolean isExpanded = !personModel.isExpanded();
        Animations.switchBackgroundColor(view, isExpanded);
        if (isExpanded) {
            Animations.expand(layoutExpand);
        } else {
            Animations.collapse(layoutExpand);
        }
        personModel.setExpanded(isExpanded);
    }
}