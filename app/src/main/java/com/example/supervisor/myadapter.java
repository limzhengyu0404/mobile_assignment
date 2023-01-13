package com.example.supervisor;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder>
{
    ArrayList<datamodel> dataholder;

    public myadapter(ArrayList<datamodel> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_design,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, @SuppressLint("RecyclerView") int position)
    {
        holder.name.setText(dataholder.get(position).getHeader());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity LoginActivity = (LoginActivity) v.getContext();
                StudentDetailFragment StudentDetailFragment = new StudentDetailFragment();
                Bundle args = new Bundle();
                args.putString("abc", dataholder.get(position).getHeader());
                args.putInt("position", position);
                StudentDetailFragment.setArguments(args);
                LoginActivity.getSupportFragmentManager().beginTransaction().replace(R.id.container,StudentDetailFragment).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView name,password;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            name=itemView.findViewById(R.id.t1);
        }
    }
}