package com.example.supervisor.Title;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.supervisor.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TitleEdit extends Fragment {

    private String username;
    private String titlepointer;

    //link firebase
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users").child("username");

    private TextView toptitle,title_name, title_abstract;
    private Button btn_remark;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            username = getArguments().getString("abc");
            titlepointer = getArguments().getString("title_num");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_title_edit, container, false);

        toptitle = view.findViewById(R.id.text1);
        title_name = view.findViewById(R.id.title_name);
        title_abstract = view.findViewById(R.id.title_abstract);
        btn_remark = view.findViewById(R.id.btn_remark);

        toptitle.setText(titlepointer);
        switch (titlepointer){
            case "Title 1":
                // Read title 1
                myRef.child(username).child("Project").child("title").child("title1").child("title").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String titledb = dataSnapshot.getValue(String.class);
                        if(titledb.length() > 0){
                            title_name.setText(titledb);
                        }else{
                            title_name.setText("Title 1 not set yet");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        title_name.setText("Fail to read from database");
                    }
                });
                //read abstract 1
                myRef.child(username).child("Project").child("title").child("title1").child("abstract").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String abstractdb = dataSnapshot.getValue(String.class);
                        if(abstractdb.length() > 0){
                            title_abstract.setText(abstractdb);
                        }else{
                            title_abstract.setText("Abstract of Title 1 not set yet");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        title_abstract.setText("Fail to read from database");
                    }
                });
                break;
            case "Title 2":
                // Read title 2
                myRef.child(username).child("Project").child("title").child("title2").child("title").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String titledb = dataSnapshot.getValue(String.class);
                        if(titledb.length() > 0){
                            title_name.setText(titledb);
                        }else{
                            title_name.setText("Title 1 not set yet");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        title_name.setText("Fail to read from database");
                    }
                });
                //read abstract 2
                myRef.child(username).child("Project").child("title").child("title2").child("abstract").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String abstractdb = dataSnapshot.getValue(String.class);
                        if(abstractdb.length() > 0){
                            title_abstract.setText(abstractdb);
                        }else{
                            title_abstract.setText("Abstract of Title 1 not set yet");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        title_abstract.setText("Fail to read from database");
                    }
                });
                break;
            case "Title 3":
                // Read title 1
                myRef.child(username).child("Project").child("title").child("title3").child("title").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String titledb = dataSnapshot.getValue(String.class);
                        if(titledb.length() > 0){
                            title_name.setText(titledb);
                        }else{
                            title_name.setText("Title 1 not set yet");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        title_name.setText("Fail to read from database");
                    }
                });
                //read abstract 1
                myRef.child(username).child("Project").child("title").child("title3").child("abstract").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String abstractdb = dataSnapshot.getValue(String.class);
                        if(abstractdb.length() > 0){
                            title_abstract.setText(abstractdb);
                        }else{
                            title_abstract.setText("Abstract of Title 1 not set yet");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        title_abstract.setText("Fail to read from database");
                    }
                });
                break;
        }

        btn_remark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TitleRemark TitleRemark = new TitleRemark();
                Bundle args = new Bundle();
                args.putString("abc", username);
                TitleRemark.setArguments(args);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,TitleRemark).commit();
            }
        });


        return view;
    }
}