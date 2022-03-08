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
import java.util.concurrent.TimeUnit;
import io.reactivex.Observable;
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
        Observable
                .interval(0,300, TimeUnit.SECONDS)
                .switchMap(aLong -> DtoRepository.getDto(ParameterClass.PARAM))
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

        /**
         * map() ： 一般用于对原始的参数进行加工处理，返回值还是基本的类型，可以在subscribe中使用(适用)的类型。
         * flatMap() ： 并行无序,一般用于输出一个Observable
         * concatMap() ： concatMap()和flatMap()很像，但串行有序
         * switchMap() ： switchMap()和flatMap()很像，除了一点:当源Observable发射一个新的数据项时，
         *               如果旧数据项订阅还未完成，就取消旧订阅数据和停止监视那个数据项产生的Observable,
         *               开始监视新的数据项；
        * */

/**        DtoRepository
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
                .subscribe(this::onSuccess, this::onError);*/

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