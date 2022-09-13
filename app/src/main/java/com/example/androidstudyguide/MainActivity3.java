package com.example.androidstudyguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity3 extends AppCompatActivity {

    private Retrofit retrofit;
//    private RecyclerView recyclerViewActivity3;
//    private RecyclerViewAdapter3 adapter3;
    private JSONPlaceholderAPI jsonPlaceholderAPI;
    private EditText editTextName, editTextBody;
    private Button sendPost;
    private TextView postTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("List with Retrofit");
        retrofit = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.api_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //adapter3 = new RecyclerViewAdapter3(this);
        //initializeRetrofit();
        //recyclerViewActivity3 = findViewById(R.id.recyclerViewActivity3);
        editTextName = findViewById(R.id.editTextTextName);
        editTextBody = findViewById(R.id.editTextBody);
        postTextView = findViewById(R.id.postTextView);

        //recyclerViewActivity3.setLayoutManager(new GridLayoutManager(this, 2));
        //recyclerViewActivity3.setAdapter(adapter3);
        sendPost = findViewById(R.id.sendPost);
        sendPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generatePost();
            }
        });
    }

//    GET METHOD
//    private void initializeRetrofit() {
//        jsonPlaceholderAPI = retrofit.create(JSONPlaceholderAPI.class);
//        Call<List<Photos>> call = jsonPlaceholderAPI.getPhotos();
//        call.enqueue(new Callback<List<Photos>>() {
//            @Override
//            public void onResponse(Call<List<Photos>> call, Response<List<Photos>> response) {
//                if(response.isSuccessful()) {
//                    ArrayList<Photos> photosArrayList = (ArrayList<Photos>) response.body();
//                    if(photosArrayList.size() > 0) {
//                        adapter3.setPhotosList(photosArrayList);
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Photos>> call, Throwable t) {
//
//            }
//        });
//    }

    private void generatePost() {
        jsonPlaceholderAPI = retrofit.create(JSONPlaceholderAPI.class);
        Call<Post> call = jsonPlaceholderAPI.createPost(new Post(1, editTextName.getText().toString(), editTextBody.getText().toString()));
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(response.isSuccessful()) {
                    String content =
                            "Title: " + response.body().getTitle() + "\n" +
                                    "Body: "  + response.body().getBody() + "\n\n";
                    postTextView.setText(content);
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
            }
        });
        View view = getCurrentFocus();
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}