package com.example.android.localweatherwithfragment.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import com.example.android.localweatherwithfragment.DataModel.CurrentModel;
import com.example.android.localweatherwithfragment.DataModel.ParameterClass;
import com.example.android.localweatherwithfragment.R;

public class CurrentConditionFragment extends Fragment {
    TextView server_time, current_temperature, current_condition, precipitation, humidity, wind;
    ImageView icon;
    CurrentModel currentWeather;

    public static CurrentConditionFragment constructCurrentFragment(CurrentModel currentWeather){
        CurrentConditionFragment currentConditionFragment = new CurrentConditionFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putParcelable("currentWeather",currentWeather);
        currentConditionFragment.setArguments(bundle1);
        return currentConditionFragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle bundle) {
        View rootView = inflater.inflate(R.layout.fragment_current_condition, container, false);

        initView(rootView);

        loadData();

        return rootView;
    }

    private void initView(View rootView) {
        server_time = rootView.findViewById(R.id.server_time);
        current_temperature = rootView.findViewById(R.id.current_temperature);
        current_condition = rootView.findViewById(R.id.current_condition);
        precipitation = rootView.findViewById(R.id.precipitation);
        humidity = rootView.findViewById(R.id.humidity);
        wind = rootView.findViewById(R.id.wind);
        icon = rootView.findViewById(R.id.icon);
    }

    @SuppressLint("SetTextI18n")
    private void loadData() {
        currentWeather = requireArguments().getParcelable("currentWeather");

        server_time.setText("Time: " + currentWeather.datetime());
        current_temperature.setText(currentWeather.temp() + "\u2103");
        current_condition.setText("Current Condition: " + currentWeather.conditions());
        precipitation.setText(currentWeather.precip() +"%");
        humidity.setText(currentWeather.humidity() +"%");
        wind.setText(currentWeather.windspeed() +" km/h");
        Glide.with(CurrentConditionFragment.this)
                .load(ParameterClass.iconBaseUrl + ParameterClass.fourth_set_color + currentWeather.icon() + ".png")
                .into(icon);
    }
}