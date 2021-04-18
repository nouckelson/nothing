package com.nouckelson.carowner;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CarInfo extends Fragment {
    TextView make;
    ImageView logo;

    public CarInfo() {
        // Required empty public constructor
    }

    public static CarInfo newInstance(String param1, String param2) {
        CarInfo fragment = new CarInfo();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_car_info, container, false);
        logo=view.findViewById(R.id.logo);
        make=view.findViewById(R.id.make);
        logo.setImageResource(getArguments().getInt("logo"));
        make.setText(getArguments().getString("make"));
        return view;
    }
}