package com.example.android.localweatherwithfragment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.android.localweatherwithfragment.DataModel.DaysBaseModel;
import com.example.android.localweatherwithfragment.R;
import java.util.List;

public class DaysRecyclerViewAdapter extends RecyclerView.Adapter<DaysListViewHolder> {
    private final Context context;
    private final List<DaysBaseModel> itemList;

    public DaysRecyclerViewAdapter(Context context, List<DaysBaseModel> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public DaysListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DaysListViewHolder
                (LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.list_item_for_days, parent, false));
    }

    @Override
    public void onBindViewHolder(DaysListViewHolder holder, int position) {
        holder.bindData(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}