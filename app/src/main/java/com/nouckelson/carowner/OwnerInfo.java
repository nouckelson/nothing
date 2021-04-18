package com.nouckelson.carowner;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class OwnerInfo extends Fragment {
    TextView owner,id;
    public OwnerInfo() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view=inflater.inflate(R.layout.fragment_owner_info, container, false);
        owner=view.findViewById(R.id.owner);
        id=view.findViewById(R.id.id);
        id.setText(getArguments().getString("id"));
        owner.setText(getArguments().getString("owner"));
        return view;
    }
}