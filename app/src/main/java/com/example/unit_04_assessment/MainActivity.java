package com.example.unit_04_assessment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.unit_04_assessment.Fragments.DetailFragment;
import com.example.unit_04_assessment.Model.EchinodermArrayList;
import com.example.unit_04_assessment.Model.EchinodermModel;
import com.example.unit_04_assessment.Network.EchinodermsService;
import com.example.unit_04_assessment.Network.RetrofitSingleton;
import com.example.unit_04_assessment.Recyclerview.EchinodermAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private final String TAG = "tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = RetrofitSingleton.getInstance();
        EchinodermsService getService = retrofit.create(EchinodermsService.class);
        Call<EchinodermArrayList> echinodermCall = getService.getEchinodermsList();
        echinodermCall.enqueue(new Callback<EchinodermArrayList>() {
            @Override
            public void onResponse(Call<EchinodermArrayList> call, Response<EchinodermArrayList> response) {
                Log.d(TAG, "onResponse: " + response.body().getMessage().get(0).getImage());
                final List<EchinodermModel> echinodermLists = response.body().getMessage();
                EchinodermAdapter adapter = new EchinodermAdapter(echinodermLists);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


            }

            @Override
            public void onFailure(Call<EchinodermArrayList> call, Throwable t) {
                Log.d("TAG", "onResponse: " + t.toString());
            }
        });


    }


}
