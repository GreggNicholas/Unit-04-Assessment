package com.example.unit_04_assessment;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.unit_04_assessment.Fragments.DetailFragment;
import com.example.unit_04_assessment.Model.EchinodermModel;
import com.example.unit_04_assessment.Recyclerview.EchinodermViewHolder;

public class SecondActivity extends AppCompatActivity implements OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String animalName = intent.getStringExtra(EchinodermViewHolder.Anim);
        String animalImage = intent.getStringExtra(EchinodermViewHolder.IMAGE);
        String website = intent.getStringExtra(EchinodermViewHolder.WIKI);

        DetailFragment detailFragment = DetailFragment.newInstance(animalName,animalImage,website);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_secondActivity, detailFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onFragmentInteraction(String website) {

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
        startActivity(intent);
    }
}
