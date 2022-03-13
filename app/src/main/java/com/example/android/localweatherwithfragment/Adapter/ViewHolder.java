package com.example.android.localweatherwithfragment.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.localweatherwithfragment.DataModel.DaysBaseModelWrapper;
import com.example.android.localweatherwithfragment.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    private final View layoutExpand;
    LinearLayout parent_layout;
    TextView datetime_by_days, conditions_by_days, temp_max, temp_min;
    ImageView icon_by_days;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        parent_layout = itemView.findViewById(R.id.list_item);
        datetime_by_days = itemView.findViewById(R.id.datetime_by_days);
        conditions_by_days = itemView.findViewById(R.id.conditions_by_days);
        temp_max = itemView.findViewById(R.id.temp_max);
        temp_min = itemView.findViewById(R.id.temp_min);
        icon_by_days = itemView.findViewById(R.id.icon_by_days);
        layoutExpand = itemView.findViewById(R.id.layoutExpand);
    }


    private void bindExpandAction(DaysBaseModelWrapper wrapper) {
        itemView.setOnClickListener(view -> onItemToggled(wrapper, view));
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