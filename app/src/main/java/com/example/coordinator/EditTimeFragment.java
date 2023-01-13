package com.example.coordinator;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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