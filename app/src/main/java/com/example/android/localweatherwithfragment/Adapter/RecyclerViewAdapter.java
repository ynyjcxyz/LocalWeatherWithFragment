package com.example.android.localweatherwithfragment.Adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.localweatherwithfragment.DataModel.DaysBaseModelWrapper;
import com.example.android.localweatherwithfragment.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<DayViewHolder> {
    private final List<DaysBaseModelWrapper> itemList;

    public RecyclerViewAdapter(List<DaysBaseModelWrapper> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public DayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DayViewHolder
                (LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.list_item_for_days, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull DayViewHolder holder, int position) {
        holder.bindData(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
