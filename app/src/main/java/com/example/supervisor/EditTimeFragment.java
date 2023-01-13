package com.example.supervisor;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class EditTimeFragment extends Fragment {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users/ProjectBatch");

    private EditText batch,deadline;
    private Button btn_save;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_edit_time, container, false);

        batch = view.findViewById(R.id.batch);
        deadline = view.findViewById(R.id.deadline);
        btn_save = view.findViewById(R.id.btn_save);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check = true;
                if(batch.getText().toString() == ""){
                    check = false;
                }
                if(deadline.getText().toString() == ""){
                    check = false;
                }

                if(check == true){
                    myRef.child(batch.getText().toString()).child("deadline").setValue(deadline.getText().toString());
                }
            }
        });

        return view;
    }
}