package com.example.androidstudyguide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.mViewHolder> {

    private ArrayList<Car> carList;

    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_3_list_item, parent, false);
        return new mViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {
        holder.carName.setText(carList.get(position).getCarName());
        holder.carType.setText(carList.get(position).getCarType());
        holder.carQuantity.setText("" + carList.get(position).getCarQuantity());
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    public void setCarList(ArrayList<Car> carList) {
        this.carList = carList;
    }

    public class mViewHolder extends RecyclerView.ViewHolder {
        private TextView carName, carType, carQuantity;
        public mViewHolder(@NonNull View itemView) {
            super(itemView);
            carName = itemView.findViewById(R.id.carName);
            carType = itemView.findViewById(R.id.carType);
            carQuantity = itemView.findViewById(R.id.carQuantity);
        }
    }
}
