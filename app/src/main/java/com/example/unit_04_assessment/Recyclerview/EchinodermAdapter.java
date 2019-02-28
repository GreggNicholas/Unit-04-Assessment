package com.example.unit_04_assessment.Recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.unit_04_assessment.Model.EchinodermModel;
import com.example.unit_04_assessment.Network.EchinodermsService;
import com.example.unit_04_assessment.R;

import java.util.List;

import retrofit2.Call;

public class EchinodermAdapter extends RecyclerView.Adapter<EchinodermViewHolder> {
    private List<EchinodermModel> echinodermList;

    public EchinodermAdapter(List<EchinodermModel> echinodermList) {
        this.echinodermList = echinodermList;
    }



    @NonNull
    @Override
    public EchinodermViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view, viewGroup, false);
        return new EchinodermViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull EchinodermViewHolder echinodermViewHolder, int position) {
        EchinodermViewHolder.onBind(echinodermList.get(position));


    }

    @Override
    public int getItemCount() {
        return echinodermList.size();
    }
}
