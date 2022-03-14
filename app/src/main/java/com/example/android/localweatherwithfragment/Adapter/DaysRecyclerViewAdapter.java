package com.example.android.localweatherwithfragment.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.android.localweatherwithfragment.DataModel.DaysBaseModelWrapper;
import com.example.android.localweatherwithfragment.R;
import java.util.List;

public class DaysRecyclerViewAdapter extends RecyclerView.Adapter<DaysViewHolder> {
    private final List<DaysBaseModelWrapper> itemList;

    public DaysRecyclerViewAdapter(List<DaysBaseModelWrapper> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public DaysViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DaysViewHolder
                (LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.list_item_for_days, parent, false));
    }

    @Override
    public void onBindViewHolder(DaysViewHolder holder, int position) {
        holder.bindData(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}