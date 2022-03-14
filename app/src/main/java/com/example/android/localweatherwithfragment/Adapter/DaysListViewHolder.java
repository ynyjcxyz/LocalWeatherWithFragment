package com.example.android.localweatherwithfragment.Adapter;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.android.localweatherwithfragment.DataModel.DaysBaseModel;
import com.example.android.localweatherwithfragment.DataModel.DaysBaseModelWrapper;
import com.example.android.localweatherwithfragment.DataModel.ParameterClass;
import com.example.android.localweatherwithfragment.R;

public class DaysListViewHolder extends RecyclerView.ViewHolder {
    LinearLayout parent_layout, expandLayout;
    TextView datetime_by_days, conditions_by_days, temp_max, temp_min, expendable_textView_test;
    ImageView icon_by_days;

    public DaysListViewHolder(@NonNull View itemView) {
        super(itemView);

        parent_layout = itemView.findViewById(R.id.list_item);
        datetime_by_days = itemView.findViewById(R.id.datetime_by_days);
        conditions_by_days = itemView.findViewById(R.id.conditions_by_days);
        temp_max = itemView.findViewById(R.id.temp_max);
        temp_min = itemView.findViewById(R.id.temp_min);
        icon_by_days = itemView.findViewById(R.id.icon_by_days);
        expendable_textView_test = itemView.findViewById(R.id.expendable_textView_test);
        expandLayout = itemView.findViewById(R.id.layoutExpand);
    }

    @SuppressLint("SetTextI18n")
    public void bindData(DaysBaseModel daysBaseModel) {
        datetime_by_days.setText(daysBaseModel.datetime());
        conditions_by_days.setText(daysBaseModel.conditions());
        Glide.with(itemView.getContext())
                .load(ParameterClass.iconBaseUrl + ParameterClass.second_set_color + daysBaseModel.icon() + ".png")
                .into(icon_by_days);
        temp_max.setText(daysBaseModel.tempmax() + "\u2103 \u21E1");
        temp_min.setText(daysBaseModel.tempmin() + "\u2103 \u21E3");
    }

    private void bindExpandAction(DaysBaseModelWrapper wrapper) {
        parent_layout.setOnClickListener(view -> onItemToggled(wrapper, view));
    }

    private void onItemToggled(DaysBaseModelWrapper daysWrapperModel, View view) {
        boolean isExpanded = !daysWrapperModel.isExpanded();
        Animations.switchBackgroundColor(view, isExpanded);
        if (isExpanded) {
            Animations.expand(expandLayout);
        } else {
            Animations.collapse(expandLayout);
        }
        daysWrapperModel.setExpanded(isExpanded);
    }

}