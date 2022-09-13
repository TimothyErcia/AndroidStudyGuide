package com.example.androidstudyguide;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Fragment3 extends Fragment {

    private ArrayList<Car> carList = new ArrayList<Car>();

    private RecyclerView recyclerView2;
    private RecyclerViewAdapter2 recyclerViewAdapter2;
    public Fragment3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        populateCarlist();
        View view = inflater.inflate(R.layout.fragment_3, container, false);
        recyclerView2 = view.findViewById(R.id.recyclerView2);
        recyclerViewAdapter2 = new RecyclerViewAdapter2();
        recyclerViewAdapter2.setCarList(carList);

        recyclerView2.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView2.setAdapter(recyclerViewAdapter2);
        // Inflate the layout for this fragment
        return view;
    }

    private void populateCarlist() {
        carList.add(new Car("Honda", "Small", 100));
        carList.add(new Car("Honda 2", "Small", 40));
        carList.add(new Car("Honda 3", "Big", 30));
        carList.add(new Car("Honda 4", "Large", 20));
        carList.add(new Car("Honda 5", "small", 1));
    }
}