package com.example.androidstudyguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView textView2;
    private Bundle extras;
    private ViewPager2 viewPagerContainer;
    private FragmentAdapter adapter;
    private Button fragment1, fragment2, fragment3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("Activity Change");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textView2 = findViewById(R.id.textView2);
        extras = getIntent().getExtras();
        if(extras != null) {
            textView2.setText(extras.getString("passedData"));
        }

        adapter = new FragmentAdapter(this);
        setupFragments();
        viewPagerContainer = findViewById(R.id.viewPagerContainer);
        viewPagerContainer.setAdapter(adapter);

        fragment1 = findViewById(R.id.fragment1);
        fragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPagerContainer.setCurrentItem(0);
            }
        });

        fragment2 = findViewById(R.id.fragment2);
        fragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPagerContainer.setCurrentItem(1);
            }
        });

        fragment3 = findViewById(R.id.fragment3);
        fragment3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPagerContainer.setCurrentItem(2);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupFragments() {
        adapter.addFragment(new Fragment1());
        adapter.addFragment(new Fragment2());
        adapter.addFragment(new Fragment3());
    }
}