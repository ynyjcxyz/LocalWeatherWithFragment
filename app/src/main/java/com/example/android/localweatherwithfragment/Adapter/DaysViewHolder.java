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
import com.example.android.localweatherwithfragment.Util.AppConstants;
import com.example.android.localweatherwithfragment.DataModel.DaysBaseModel;
import com.example.android.localweatherwithfragment.DataModel.DaysBaseModelWrapper;
import com.example.android.localweatherwithfragment.DataModel.HourlyModel;
import com.example.android.localweatherwithfragment.R;
import java.util.List;

public class DaysViewHolder extends RecyclerView.ViewHolder {
    LinearLayout parent_layout, expandLayout;
    TextView datetime_by_days, conditions_by_days, temp_max, temp_min,
            windspeed_daily,humidity_daily,precipprob_daily,sunrise_sunset;
    ImageView icon_by_days;
    RecyclerView hourly_list;

    public DaysViewHolder(@NonNull View itemView) {
        super(itemView);

        parent_layout = itemView.findViewById(R.id.list_item_un_expand);
        datetime_by_days = itemView.findViewById(R.id.datetime_by_days);
        conditions_by_days = itemView.findViewById(R.id.conditions_by_days);
        temp_max = itemView.findViewById(R.id.temp_max);
        temp_min = itemView.findViewById(R.id.temp_min);
        icon_by_days = itemView.findViewById(R.id.icon_by_days);
        expandLayout = itemView.findViewById(R.id.layoutExpand);
        hourly_list = itemView.findViewById(R.id.hourly_list);

        windspeed_daily = itemView.findViewById(R.id.windspeed_daily);
        humidity_daily = itemView.findViewById(R.id.humidity_daily);
        precipprob_daily = itemView.findViewById(R.id.precipprob_daily);
        sunrise_sunset = itemView.findViewById(R.id.sunrise_sunset);
    }

    @SuppressLint("SetTextI18n")
    public void bindData(DaysBaseModelWrapper wrapper) {
        DaysBaseModel daysBaseModel = wrapper.getDaysBaseModel();
        datetime_by_days.setText(daysBaseModel.datetime());
        conditions_by_days.setText(daysBaseModel.conditions());
        Glide.with(itemView.getContext())
                .load(AppConstants.iconBaseUrl
                        + AppConstants.second_set_color
                        + daysBaseModel.icon() + ".png")
                .into(icon_by_days);
        temp_max.setText(daysBaseModel.tempmax() + "\u2103 \u21E1");
        temp_min.setText(daysBaseModel.tempmin() + "\u2103 \u21E3");

        windspeed_daily.setText(daysBaseModel.windspeed_daily() + "km/h");
        humidity_daily.setText(daysBaseModel.humidity_daily() + "%");
        precipprob_daily.setText(daysBaseModel.precipprob_daily() + "%");
        sunrise_sunset.setText(daysBaseModel.sunrise_daily() + "," + daysBaseModel.sunset_daily());
        bindExpandAction(new DaysBaseModelWrapper(daysBaseModel,false));
    }

    public void bindExpandAction(DaysBaseModelWrapper wrapper) {
        //If we use itemView instead of parent_layout, then the whole view can be touched,
        // and the expandLayout will include into touch area
        parent_layout.setOnClickListener(view -> onItemToggled(wrapper));

        hourly_list.setLayoutManager(new LinearLayoutManager(
                itemView.getContext(),RecyclerView.HORIZONTAL,false));
        hourly_list.setAdapter(new HourlyAdapter(hourly(wrapper)));
    }

    private List<HourlyModel> hourly(DaysBaseModelWrapper wrapper) {
        return wrapper.getDaysBaseModel().hourlyList();
    }

    private void onItemToggled(DaysBaseModelWrapper daysWrapperModel) {
        boolean isExpanded = !daysWrapperModel.isExpanded();
//        Animations.switchBackgroundColor(view, isExpanded);
        if (isExpanded) {
            Animations.expand(expandLayout);
            Animations.setTextBold(datetime_by_days);
        } else {
            Animations.collapse(expandLayout);
            Animations.setTextNormal(datetime_by_days);
        }
        daysWrapperModel.setExpanded(isExpanded);
    }

}