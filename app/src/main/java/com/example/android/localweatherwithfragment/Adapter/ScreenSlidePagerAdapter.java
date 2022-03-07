package com.example.android.localweatherwithfragment.Adapter;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
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
        return CurrentConditionFragment.constructCurrentFragment(dto.current_weather());
    }

    private Fragment daysFragment() {
        return DaysFragment.constructDaysFragment(dto.weatherForecastList());
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
