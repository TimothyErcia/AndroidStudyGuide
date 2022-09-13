package com.example.androidstudyguide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.mViewHolder>{

    private ArrayList<String> arrayList;

    public RecyclerViewAdapter(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_2_list_item, parent, false);
        return new mViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {
        holder.fragment2ListItem.setText(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class mViewHolder extends RecyclerView.ViewHolder {
        private TextView fragment2ListItem;
        public mViewHolder(@NonNull View itemView) {
            super(itemView);
            fragment2ListItem = itemView.findViewById(R.id.fragment2ListItem);
        }
    }
}
