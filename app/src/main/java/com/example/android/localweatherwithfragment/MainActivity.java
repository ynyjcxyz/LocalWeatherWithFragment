package com.example.android.localweatherwithfragment;

import static android.widget.Toast.LENGTH_SHORT;
import static com.uber.autodispose.AutoDispose.autoDisposable;
import static com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider.from;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import android.widget.Toast;
import com.example.android.localweatherwithfragment.Adapter.ScreenSlidePagerAdapter;
import com.example.android.localweatherwithfragment.DataModel.Dto;
import com.example.android.localweatherwithfragment.DataModel.ParameterClass;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewpager);

        initListener();
        loadData();
    }

    private void loadData() {
        DtoRepository
                .getDto(ParameterClass.PARAM)
                .filter(rawDto -> rawDto.weatherForecastList() != null)
                .map(rawDto -> Dto
                        .create(rawDto.resolvedAddress(),
                                rawDto.weatherForecastList(),
                                rawDto.current_weather()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(autoDisposable(from(this)))
                //automatically unsubscribe from Observable obj
                .subscribe(this::onSuccess, this::onError);
    }

    private void onSuccess(Dto dto) {
        bindViewPagerWithData(dto);
        this.setTitle(dto.resolvedAddress());
    }

    private void bindViewPagerWithData(Dto dto) {
        viewPager.setAdapter(new ScreenSlidePagerAdapter(this,dto));
        viewPager.setCurrentItem(0);
        bindTab();
    }

    private void bindTab() {
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) ->
                tab.setText(ParameterClass.fragmentTitles[position])).attach();
    }

    private void onError(Throwable throwable) {
        Toast.makeText(getApplication(), throwable.getMessage(), LENGTH_SHORT).show();
    }

    private void initListener() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
}