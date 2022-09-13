package com.example.androidstudyguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button nextGuide, dataChange, nextGuide2;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Data Change");

        nextGuide = findViewById(R.id.nextGuide);
        dataChange = findViewById(R.id.dataChange);
        textView = findViewById(R.id.textView);

        nextGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextActivity(MainActivity2.class);
            }
        });

        dataChange.setOnClickListener(new View.OnClickListener() {
            boolean flag = true;
            @Override
            public void onClick(View view) {
                if(flag) {
                    textView.setText("Hello World");
                } else {
                    textView.setText("Hello World again");
                }
                flag = !flag;
            }
        });

        nextGuide2 = findViewById(R.id.nextGuide2);
        nextGuide2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextActivity(MainActivity3.class);
            }
        });
    }

    private void nextActivity(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        intent.putExtra("passedData", "DATA PASSED");
        startActivity(intent);
    }
}