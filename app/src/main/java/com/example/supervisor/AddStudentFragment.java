package com.example.supervisor;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.supervisor.adduser.UserHelper;
import com.example.supervisor.adduser.projecthelper;
import com.example.supervisor.adduser.subjecthelper;
import com.example.supervisor.adduser.titlehelper;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.ref.Reference;

public class AddStudentFragment extends Fragment {

    private FirebaseDatabase rootNode;
    private DatabaseReference reference;

    private EditText name1,username1,id1,password1,batch1;
    private Button btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_add_student, container, false);
        name1 = view.findViewById(R.id.add_name);
        username1 = view.findViewById(R.id.add_username);
        id1 = view.findViewById(R.id.add_id);
        password1 = view.findViewById(R.id.add_password);
        batch1 = view.findViewById(R.id.add_batch);
        btn = view.findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users/username");

                String name = name1.getText().toString();
                String username = username1.getText().toString();
                String studentID = id1.getText().toString();
                String password = password1.getText().toString();
                String batch = batch1.getText().toString();
                String project = "Project";

                UserHelper userHelper = new UserHelper(name, studentID, password, batch);
                projecthelper projecthelper = new projecthelper("title","","");
                titlehelper titlehelper = new titlehelper("","","","pending","");
                subjecthelper subjecthelper = new subjecthelper("","","","pending","","");

                reference.child(username).setValue(userHelper);
                reference.child(username).child("Project").setValue(projecthelper);
                reference.child(username).child("Project").child("title").setValue(titlehelper);
                reference.child(username).child("Project").child("title").child("title1").child("title").setValue("");
                reference.child(username).child("Project").child("title").child("title1").child("abstract").setValue("");
                reference.child(username).child("Project").child("title").child("title2").child("title").setValue("");
                reference.child(username).child("Project").child("title").child("title2").child("abstract").setValue("");
                reference.child(username).child("Project").child("title").child("title3").child("title").setValue("");
                reference.child(username).child("Project").child("title").child("title3").child("abstract").setValue("");

                reference.child(username).child("Project").child("finalpresentslide").setValue(subjecthelper);
                reference.child(username).child("Project").child("poster").setValue(subjecthelper);
                reference.child(username).child("Project").child("proposal").setValue(subjecthelper);

                reference.child(username).child("Project").child("proposalpresentslide").setValue(subjecthelper);
                reference.child(username).child("Project").child("thesis").setValue(subjecthelper);

            }
        });


        return view;
    }
}