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

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder>{
    private final Context context;
    private List<DaysBaseModel> itemList;

    public RecyclerViewAdapter(Context context, List<DaysBaseModel> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setItemList(List<DaysBaseModel> listAdd){
        this.itemList = listAdd;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder
                (LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.list_item_for_days, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
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
