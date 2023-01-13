package com.example.coordinator;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StudentDetailFragment extends Fragment {

    //link firebase
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users/username");

    private TextView name,id,batch,mark;
    private Button btn,btn_endorse;
    public String student_username;
    public String titlepointer;
    public Integer position;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            titlepointer = getArguments().getString("abc");
            position = getArguments().getInt("position");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_student_detail, container, false);
        name = view.findViewById(R.id.student_name);
        id = view.findViewById(R.id.student_id);
        batch = view.findViewById(R.id.student_batch);
        mark = view.findViewById(R.id.student_mark);
        btn = view.findViewById(R.id.btn);
        btn_endorse = view.findViewById(R.id.btn_endorse);

        //do checking for which user is selected
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {

                    String storeuser = ds.getKey().toString();
                    //check username by full name
                    myRef.child(storeuser).child("name").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot2) {
                            String value = dataSnapshot2.getValue(String.class);
                            if(value == titlepointer){
                                student_username = storeuser;

                                //when username is correct
                                //read id
                                myRef.child(student_username).child("studentID").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        String value = dataSnapshot.getValue(String.class);
                                        id.setText(value);
                                    }

                                    @Override
                                    public void onCancelled(DatabaseError error) {
                                        id.setText("fail to read");
                                    }
                                });

                                //read batch
                                myRef.child(student_username).child("batch").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        String value = dataSnapshot.getValue(String.class);
                                        batch.setText(value);
                                    }

                                    @Override
                                    public void onCancelled(DatabaseError error) {
                                        batch.setText("fail to read");
                                    }
                                });

                                //read mark
                                myRef.child(student_username).child("Project").child("finalmark").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        String value = dataSnapshot.getValue(String.class);
                                        if(value.length() >0){
                                            mark.setText(value);
                                        }else{
                                            mark.setText("Not finished yet");
                                        }
                                    }

                                    @Override
                                    public void onCancelled(DatabaseError error) {
                                        batch.setText("fail to read");
                                    }
                                });

                                //set btn
                                btn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        StudentProgressFragment StudentProgressFragment = new StudentProgressFragment();
                                        Bundle args = new Bundle();
                                        args.putString("abc", student_username);
                                        StudentProgressFragment.setArguments(args);
                                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,StudentProgressFragment).commit();
                                    }
                                });

                                myRef.child(student_username).child("Project").child("endorse").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        String value = dataSnapshot.getValue(String.class);
                                        if(value.equals("true")){
                                            btn_endorse.setBackgroundColor(Color.CYAN);
                                            btn_endorse.setText("Already Endorse");
                                        }else if(value.equals("false")){
                                            btn_endorse.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    myRef.child(student_username).child("Project").child("endorse").setValue("true");
                                                }
                                            });
                                        }else{
                                            btn_endorse.setText("No Marking");
                                        }
                                    }
                                    @Override
                                    public void onCancelled(DatabaseError error) {
                                    }
                                });


                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError error) {}
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });

        //read student name
        name.setText(titlepointer);
        return view;
    }
}