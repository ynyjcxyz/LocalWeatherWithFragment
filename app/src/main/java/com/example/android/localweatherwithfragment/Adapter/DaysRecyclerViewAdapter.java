package com.example.android.localweatherwithfragment.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.android.localweatherwithfragment.DataModel.DaysBaseModel;
import com.example.android.localweatherwithfragment.DataModel.ParameterClass;
import com.example.android.localweatherwithfragment.R;
import java.util.List;

public class DaysRecyclerViewAdapter extends RecyclerView.Adapter<DaysListViewHolder>{
    private final Context context;
    private final List<DaysBaseModel> itemList;

    public DaysRecyclerViewAdapter(Context context, List<DaysBaseModel> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public DaysListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DaysListViewHolder
                (LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.list_item_for_days, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull DaysListViewHolder holder, int position) {
        bind(holder, position);
    }

    @SuppressLint("SetTextI18n")
    private void bind(@NonNull DaysListViewHolder holder, int position) {
        holder.datetime_by_days.setText(itemList.get(position).datetime());
        holder.conditions_by_days.setText(itemList.get(position).conditions());
        Glide.with(context)
                .load(ParameterClass.iconBaseUrl + ParameterClass.second_set_color + itemList.get(position).icon() + ".png")
                .into(holder.icon_by_days);
        holder.temp_max.setText(itemList.get(position).tempmax()+"\u2103 \u21E1");
        holder.temp_min.setText(itemList.get(position).tempmin()+"\u2103 \u21E3");
    }

    @Override
    public int getItemCount() {
        if (itemList != null) {
            return itemList.size();
        }
        return 0;
    }
}
