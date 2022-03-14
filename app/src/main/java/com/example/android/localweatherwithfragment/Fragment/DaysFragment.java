package com.example.android.localweatherwithfragment.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.android.localweatherwithfragment.DataModel.DaysBaseModel;
import com.example.android.localweatherwithfragment.DataModel.DaysBaseModelWrapper;
import com.example.android.localweatherwithfragment.R;
import com.example.android.localweatherwithfragment.Adapter.DaysRecyclerViewAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DaysFragment extends Fragment {
    private List<DaysBaseModel> weatherForecastList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DaysRecyclerViewAdapter recyclerAdapter;

    public static DaysFragment constructDaysFragment(List<DaysBaseModel> weatherForecastList){
        DaysFragment daysFragment = new DaysFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putParcelableArrayList("weatherForecastList", new ArrayList<>(weatherForecastList));
        daysFragment.setArguments(bundle2);
        return daysFragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle bundle) {
        View rootView = inflater.inflate(R.layout.fragment_days_condition, container, false);
        weatherForecastList = requireArguments().getParcelableArrayList("weatherForecastList");
        System.out.println(weatherForecastList);

        recyclerView = rootView.findViewById(R.id.recycler_view_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(requireActivity(), DividerItemDecoration.VERTICAL));//add divider in the recyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        recyclerAdapter = new DaysRecyclerViewAdapter(transform(weatherForecastList));
        recyclerView.setAdapter(recyclerAdapter);

        return rootView;
    }

    private static List<DaysBaseModelWrapper> transform(List<DaysBaseModel> daysBaseModelList) {
        return daysBaseModelList.stream().map(item -> new DaysBaseModelWrapper(item,false)).collect(Collectors.toList());
    }
}