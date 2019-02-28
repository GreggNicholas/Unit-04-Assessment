package com.example.unit_04_assessment.Recyclerview;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.unit_04_assessment.Model.EchinodermModel;
import com.example.unit_04_assessment.R;
import com.example.unit_04_assessment.SecondActivity;
import com.squareup.picasso.Picasso;

public class EchinodermViewHolder extends RecyclerView.ViewHolder {
    private static final String ANIMAL = "animal";
    private static final String IMAGE = "image";
    private static final String WIKI = "wiki";
    private TextView textView;
    private ImageView echinodermImage;


    public EchinodermViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.text_itemview);
        echinodermImage = itemView.findViewById(R.id.image_itemview);

    }

    public void onBind(final EchinodermModel echinodermModel) {
        textView.setText(echinodermModel.getAnimal());
        Picasso.get().load(echinodermModel.getImage()).into(echinodermImage);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String echinoImage = echinodermModel.getImage();
                String echinoAnimal = echinodermModel.getAnimal();
                String echinoWiki = echinodermModel.getWiki();
                Intent intent = new Intent(v.getContext(), SecondActivity.class);
                intent.putExtra(IMAGE, echinoImage);
                intent.putExtra(ANIMAL, echinoAnimal);
                intent.putExtra(WIKI, echinoWiki);
                v.getContext().startActivity(intent);

            }
        });
    }

}
