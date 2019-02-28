package com.example.unit_04_assessment.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.unit_04_assessment.OnFragmentInteractionListener;
import com.example.unit_04_assessment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {
    private OnFragmentInteractionListener mListener;
    private static final String ANIMAL = "animal";
    private static final String IMAGE = "image";
    private static final String WIKI = "wiki";
    private TextView animalText;
    private TextView imageText;
    private TextView wikiText;

    public static DetailFragment newInstance(String animal, String image, String website) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ANIMAL, animal);
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

        animalText = getArguments().getString();
        imageText = getArguments().getString();
        wikiText = getArguments().getString();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
