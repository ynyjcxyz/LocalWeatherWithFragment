package com.example.android.localweatherwithfragment.Adapter;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.example.android.localweatherwithfragment.DataModel.CurrentModel;
import com.example.android.localweatherwithfragment.DataModel.DaysBaseModel;
import com.example.android.localweatherwithfragment.DataModel.Dto;
import com.example.android.localweatherwithfragment.Fragment.CurrentConditionFragment;
import com.example.android.localweatherwithfragment.Fragment.DaysFragment;

import java.util.ArrayList;
import java.util.List;

public class ScreenSlidePagerAdapter extends FragmentStateAdapter {
    private final Dto dto;

    public ScreenSlidePagerAdapter(@NonNull FragmentActivity fragmentActivity, Dto dto) {
        super(fragmentActivity);
        this.dto = dto;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return position == 0 ? currentConditionFragment() : daysFragment();
    }

    private Fragment currentConditionFragment() {
        CurrentConditionFragment currentConditionFragment = new CurrentConditionFragment();
        Bundle bundle1 =new Bundle();
        CurrentModel currentWeather = dto.current_weather();
        System.out.println(currentWeather);
        bundle1.putParcelable("currentWeather",currentWeather);
        currentConditionFragment.setArguments(bundle1);
        return currentConditionFragment;

    }

    private Fragment daysFragment() {
        DaysFragment daysFragment = new DaysFragment();
        Bundle bundle2 = new Bundle();
        List<DaysBaseModel> weatherForecastList = dto.weatherForecastList();
        System.out.println(weatherForecastList);
        assert weatherForecastList != null;
        bundle2.putParcelableArrayList("weatherForecastList", new ArrayList<>(weatherForecastList));
        daysFragment.setArguments(bundle2);
        return daysFragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
