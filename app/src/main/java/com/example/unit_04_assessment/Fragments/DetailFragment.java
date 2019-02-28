package com.example.unit_04_assessment.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.unit_04_assessment.OnFragmentInteractionListener;
import com.example.unit_04_assessment.R;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {
    private OnFragmentInteractionListener mListener;
    private static final String ANIMAL = "param1";
    private static final String IMAGE = "param2";
    private static final String WIKI = "param3";
    private Button button;
    private String animalText;
    private String imageString;
    private ImageView imageView;
    private TextView textView;
    private View rootView;
    private String website;

    public static DetailFragment newInstance(String animalName, String image, String website) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ANIMAL, animalName);
        args.putString(IMAGE, image);
        args.putString(WIKI, website);
        detailFragment.setArguments(args);
        return detailFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            animalText = getArguments().getString(ANIMAL);
            imageString = getArguments().getString(IMAGE);
            website = getArguments().getString(WIKI);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        imageView = rootView.findViewById(R.id.animalimage_detailfrag);
        textView = rootView.findViewById(R.id.text_itemview);
        button = rootView.findViewById(R.id.button_detailfrag);
        return rootView;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Picasso.get().load(imageString).into(imageView);
        textView.setText(animalText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onFragmentInteraction(website);
            }
        });
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
