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
import com.example.android.localweatherwithfragment.R;
import com.example.android.localweatherwithfragment.RecyclerViewAdapter;
import java.util.ArrayList;
import java.util.List;

public class DaysFragment extends Fragment {
    private List<DaysBaseModel> weatherForecastList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerAdapter;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle bundle ) {
        View rootView = inflater.inflate(R.layout.fragment_days_condition, container, false);

        weatherForecastList = getArguments() != null ? getArguments().getParcelableArrayList("weatherForecastList") : null;
        System.out.println(weatherForecastList);

        recyclerView = rootView.findViewById(R.id.recycler_view_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerAdapter = new RecyclerViewAdapter(rootView.getContext(),weatherForecastList);
        recyclerView.setAdapter(recyclerAdapter);

        return rootView;
    }
}