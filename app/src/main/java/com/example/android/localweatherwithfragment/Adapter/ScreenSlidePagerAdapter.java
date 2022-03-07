package com.example.android.localweatherwithfragment.Adapter;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.example.android.localweatherwithfragment.DataModel.DaysBaseModel;
import com.example.android.localweatherwithfragment.DataModel.SantizedWeatherDto;
import com.example.android.localweatherwithfragment.Fragment.CurrentConditionFragment;
import com.example.android.localweatherwithfragment.Fragment.DaysFragment;

import java.util.ArrayList;
import java.util.List;

public class ScreenSlidePagerAdapter extends FragmentStateAdapter {
    private final SantizedWeatherDto dto;

    public ScreenSlidePagerAdapter(@NonNull FragmentActivity fragmentActivity, SantizedWeatherDto dto) {
        super(fragmentActivity);
        this.dto = dto;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return position == 0 ? currentConditionFragment() : daysFragment();
    }

    private Fragment currentConditionFragment() {
        return CurrentConditionFragment.constructFragment(dto.current_weather());

    }

    //p0 参考CurrentConditionFragment 做修改。
    private Fragment daysFragment() {
        DaysFragment daysFragment = new DaysFragment();
        Bundle bundle2 = new Bundle();
        List<DaysBaseModel> weatherForecastList = dto.weatherForecastList();
        System.out.println(weatherForecastList);
        bundle2.putParcelableArrayList("weatherForecastList", new ArrayList<>(weatherForecastList));
        daysFragment.setArguments(bundle2);
        return daysFragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
