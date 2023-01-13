package com.example.supervisor.Share;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.supervisor.R;
import com.example.supervisor.Title.TitleRemark;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ShareEdit extends Fragment {

    private String username;
    private String titlepointer;

    //link firebase
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users").child("username");

    private TextView toptitle,submission, upload,comment;
    private Button btn_remark;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            username = getArguments().getString("abc");
            titlepointer = getArguments().getString("def");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_share_edit, container, false);
        toptitle = view.findViewById(R.id.text1);
        submission = view.findViewById(R.id.read_date);
        upload = view.findViewById(R.id.read_upload);
        comment = view.findViewById(R.id.title_abstract);
        btn_remark = view.findViewById(R.id.btn_remark);

        switch (titlepointer){
            case "proposal":
                // Read upload
                toptitle.setText("Proposal");
                myRef.child(username).child("Project").child("proposal").child("upload").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String titledb = dataSnapshot.getValue(String.class);
                        if(titledb.length() > 0){
                            upload.setText(titledb);
                        }else{
                            upload.setText("Nothing had been uploaded");
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError error) {
                        upload.setText("Fail to read from database");
                    }
                });
                // Read submission date
                myRef.child(username).child("Project").child("proposal").child("submission").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String titledb = dataSnapshot.getValue(String.class);
                        if(titledb.length() > 0){
                            submission.setText(titledb);
                        }else{
                            submission.setText("1/12/2023");
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError error) {
                        submission.setText("Fail to read from database");
                    }
                });
                // Read comment
                myRef.child(username).child("Project").child("proposal").child("comment").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String titledb = dataSnapshot.getValue(String.class);
                        if(titledb.length() > 0){
                            comment.setText(titledb);
                        }else{
                            comment.setText("");
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError error) {
                        comment.setText("Fail to read from database");
                    }
                });
                break;
            case "thesis":
                // Read upload
                toptitle.setText("Thesis");
                myRef.child(username).child("Project").child("thesis").child("upload").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String titledb = dataSnapshot.getValue(String.class);
                        if(titledb.length() > 0){
                            upload.setText(titledb);
                        }else{
                            upload.setText("Nothing had been uploaded");
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError error) {
                        upload.setText("Fail to read from database");
                    }
                });
                // Read submission date
                myRef.child(username).child("Project").child("thesis").child("submission").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String titledb = dataSnapshot.getValue(String.class);
                        if(titledb.length() > 0){
                            submission.setText(titledb);
                        }else{
                            submission.setText("1/12/2023");
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError error) {
                        submission.setText("Fail to read from database");
                    }
                });
                // Read comment
                myRef.child(username).child("Project").child("thesis").child("comment").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String titledb = dataSnapshot.getValue(String.class);
                        if(titledb.length() > 0){
                            comment.setText(titledb);
                        }else{
                            comment.setText("");
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError error) {
                        comment.setText("Fail to read from database");
                    }
                });
                break;
            case "proposalpresentslide":
                // Read upload
                toptitle.setText("Proposal Present Slide");
                myRef.child(username).child("Project").child("proposalpresentslide").child("upload").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String titledb = dataSnapshot.getValue(String.class);
                        if(titledb.length() > 0){
                            upload.setText(titledb);
                        }else{
                            upload.setText("Nothing had been uploaded");
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError error) {
                        upload.setText("Fail to read from database");
                    }
                });
                // Read submission date
                myRef.child(username).child("Project").child("proposalpresentslide").child("submission").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String titledb = dataSnapshot.getValue(String.class);
                        if(titledb.length() > 0){
                            submission.setText(titledb);
                        }else{
                            submission.setText("1/12/2023");
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError error) {
                        submission.setText("Fail to read from database");
                    }
                });
                // Read comment
                myRef.child(username).child("Project").child("proposalpresentslide").child("comment").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String titledb = dataSnapshot.getValue(String.class);
                        if(titledb.length() > 0){
                            comment.setText(titledb);
                        }else{
                            comment.setText("");
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError error) {
                        comment.setText("Fail to read from database");
                    }
                });
                break;
            case "finalpresentslide":
                // Read upload
                toptitle.setText("Final Present Slide");
                myRef.child(username).child("Project").child("finalpresentslide").child("upload").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String titledb = dataSnapshot.getValue(String.class);
                        if(titledb.length() > 0){
                            upload.setText(titledb);
                        }else{
                            upload.setText("Nothing had been uploaded");
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError error) {
                        upload.setText("Fail to read from database");
                    }
                });
                // Read submission date
                myRef.child(username).child("Project").child("finalpresentslide").child("submission").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String titledb = dataSnapshot.getValue(String.class);
                        if(titledb.length() > 0){
                            submission.setText(titledb);
                        }else{
                            submission.setText("1/12/2023");
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError error) {
                        submission.setText("Fail to read from database");
                    }
                });
                // Read comment
                myRef.child(username).child("Project").child("finalpresentslide").child("comment").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String titledb = dataSnapshot.getValue(String.class);
                        if(titledb.length() > 0){
                            comment.setText(titledb);
                        }else{
                            comment.setText("");
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError error) {
                        comment.setText("Fail to read from database");
                    }
                });
                break;
            case "poster":
                // Read upload
                toptitle.setText("Poster");
                myRef.child(username).child("Project").child("poster").child("upload").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String titledb = dataSnapshot.getValue(String.class);
                        if(titledb.length() > 0){
                            upload.setText(titledb);
                        }else{
                            upload.setText("Nothing had been uploaded");
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError error) {
                        upload.setText("Fail to read from database");
                    }
                });
                // Read submission date
                myRef.child(username).child("Project").child("poster").child("submission").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String titledb = dataSnapshot.getValue(String.class);
                        if(titledb.length() > 0){
                            submission.setText(titledb);
                        }else{
                            submission.setText("1/12/2023");
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError error) {
                        submission.setText("Fail to read from database");
                    }
                });
                // Read comment
                myRef.child(username).child("Project").child("poster").child("comment").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String titledb = dataSnapshot.getValue(String.class);
                        if(titledb.length() > 0){
                            comment.setText(titledb);
                        }else{
                            comment.setText("");
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError error) {
                        comment.setText("Fail to read from database");
                    }
                });
                break;
        }

        btn_remark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareRemark ShareRemark = new ShareRemark();
                Bundle args = new Bundle();
                args.putString("abc", username);
                args.putString("def", titlepointer);
                ShareRemark.setArguments(args);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,ShareRemark).commit();
            }
        });


        return view;
    }
}