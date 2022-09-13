package com.example.androidstudyguide;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Fragment2 extends Fragment {

    private RecyclerView recyclerView1;
    private RecyclerViewAdapter adapter;
    private ArrayList<String> arrayList;
    public Fragment2() {
        arrayList= new ArrayList<>();
        populateDataList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        recyclerView1 = view.findViewById(R.id.recyclerView1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(view.getContext()));

        adapter = new RecyclerViewAdapter(arrayList);
        recyclerView1.setAdapter(adapter);
        return view;
    }

    private void populateDataList() {
        for(int i=0; i<6; i++) {
            arrayList.add("Mock " + i);
        }
    }
}