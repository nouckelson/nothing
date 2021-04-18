package com.nouckelson.carowner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myviewholder> {
    ArrayList<Model> data;
    Context context;
    private FragmentManager manager;
    public myAdapter(ArrayList<Model> data, Context context,FragmentManager manager){
        this.data=data;
        this.context=context;
        this.manager=manager;
    }
    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       LayoutInflater inflater=LayoutInflater.from(parent.getContext());
       View view=inflater.inflate(R.layout.singlerow,parent,false);
       return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        final Model temp=data.get(position);

           holder.t1.setText(data.get(position).getMake());
           holder.t2.setText(data.get(position).getOwner());
           holder.img.setImageResource(data.get(position).getLogo());
           holder.img.setOnClickListener(new View.OnClickListener() {


               @Override
               public void onClick(View v) {
                   Intent intent=new Intent(context,MainActivity.class);
                   intent.putExtra("logo",temp.getLogo());
                   intent.putExtra("make",temp.getMake());
                   intent.putExtra("owner",temp.getOwner());
                   intent.putExtra("id",temp.getId());
                   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                   context.startActivity(intent);

               }
           });
    }



    @Override
    public int getItemCount() {
        return data.size();
    }
}
