package com.shafi.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Context;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Context contex;
    Custom adapter;
    RecyclerView.LayoutManager layoutManager;
    Model[] modelList;
    GetEmployeeDataService userInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        userInterface = RetrofitInstance.getRetrofitInstance().create(GetEmployeeDataService.class);

        Call<List<Model>> call = userInterface.getEmployeeData();

        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {

                modelList = response.body().toArray(new Model[0]);
                adapter = new Custom(MainActivity.this , modelList);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }
        });
    }
}
