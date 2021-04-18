package com.nouckelson.carowner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView listFrag;
    myAdapter adapter;
    Button car_info,owner_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        if (intent != null) {
                    OwnerInfo ownerInfo = new OwnerInfo();
                    Bundle bundle = new Bundle();

                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    bundle.putString("owner",getIntent().getStringExtra("owner"));
                    bundle.putString("id",getIntent().getStringExtra("id"));
                    ownerInfo.setArguments(bundle);
                    transaction.addToBackStack(null);
                    transaction.replace(R.id.showResult,ownerInfo);
                    transaction.commit();
        }
        car_info=findViewById(R.id.car_info);
        owner_info=findViewById(R.id.owner_info);
        owner_info.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                OwnerInfo ownerInfo = new OwnerInfo();
                Bundle bundle = new Bundle();

                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                bundle.putString("owner",getIntent().getStringExtra("owner"));
                bundle.putString("id",getIntent().getStringExtra("id"));
                ownerInfo.setArguments(bundle);
                transaction.addToBackStack(null);
                transaction.replace(R.id.showResult,ownerInfo);
                transaction.commit();
            }
        });
        car_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarInfo carInfo = new CarInfo();
                Bundle bundle = new Bundle();

                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                bundle.putInt("logo", getIntent().getIntExtra("logo",1));
                bundle.putString("make",getIntent().getStringExtra("make"));
                carInfo.setArguments(bundle);
                transaction.addToBackStack(null);
                transaction.replace(R.id.showResult,carInfo);
                transaction.commit();
            }
        });
        listFrag=(RecyclerView) findViewById(R.id.listFrag);
        listFrag.setLayoutManager(new LinearLayoutManager(this));
        FragmentManager manager = getSupportFragmentManager();
        adapter=new myAdapter(dataqueue(),getApplicationContext(),manager);
        listFrag.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        listFrag.setLayoutManager(layoutManager);
    }
    public ArrayList<Model> dataqueue(){
        ArrayList<Model> holder=new ArrayList<>();

        //OB1
        Model ob1=new Model();
        ob1.setId("0123456789");
        ob1.setMake("Polo");
        ob1.setOwner("Chuck norris");
        ob1.setLogo(R.drawable.car);
        holder.add(ob1);
        //
        // OB2
        Model ob2=new Model();
        ob2.setId("0223456789");
        ob2.setMake("E200");
        ob2.setOwner("Peter Pollock");
        ob2.setLogo(R.drawable.mercedes);
        holder.add(ob2);
        //
        // OB3
        Model ob3=new Model();
        ob3.setId("0323456789");
        ob3.setMake("Almera");
        ob3.setOwner("Christ Jeams");
        ob3.setLogo(R.drawable.nissance);
        holder.add(ob3);
        //
        // OB4
        Model ob4=new Model();
        ob4.setId("0423456789");
        ob4.setMake("E180");
        ob4.setOwner("Jhon Rambo");
        ob4.setLogo(R.drawable.mercedes);
        holder.add(ob4);
        //
        return  holder;
    }
}