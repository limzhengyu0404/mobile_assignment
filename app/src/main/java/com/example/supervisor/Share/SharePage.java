package com.example.supervisor.Share;

import androidx.fragment.app.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.supervisor.R;
import com.example.supervisor.Title.TitleEdit;
import com.example.supervisor.Title.TitleRemark;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SharePage extends Fragment {

    //link firebase
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users").child("username");

    private TextView remark,deadline,subjectname2,toptitle;
    private Button btn1,btn_remark;
    private String username,subjecttopic;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            username = getArguments().getString("abc");
            subjecttopic = getArguments().getString("def");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_share_page, container, false);

        toptitle = view.findViewById(R.id.subject_name);
        deadline = view.findViewById(R.id.deadline);
        subjectname2 = view.findViewById(R.id.subject_name2);
        remark = view.findViewById(R.id.remark);
        btn1 = view.findViewById(R.id.btn_1);
        btn_remark = view.findViewById(R.id.btn_remark);

        //set topic
        subjectname2.setText(subjecttopic);
        switch (subjecttopic){
            case "proposal":
                toptitle.setText("Proposal");
                myRef.child(username).child("Project").child("proposal").child("deadline").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String deadlinedb = dataSnapshot.getValue(String.class);
                        if(deadlinedb.length() > 0){
                            deadline.setText(deadlinedb);
                        }else{
                            deadline.setText("deadline not set yet");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        deadline.setText("Fail to read from db");
                    }
                });

                //read remark
                myRef.child(username).child("Project").child("proposal").child("remark").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String remarkdb = dataSnapshot.getValue(String.class);
                        if(remarkdb.length() > 0){
                            remark.setText(remarkdb);
                        }else{
                            remark.setText("Doesn't have any remark yet");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        remark.setText("Fail to read from db");
                    }
                });

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ShareEdit ShareEdit = new ShareEdit();
                        Bundle args = new Bundle();
                        args.putString("abc", username);
                        args.putString("def", "proposal");
                        ShareEdit.setArguments(args);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,ShareEdit).commit();
                    }
                });

                btn_remark.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ShareRemark ShareRemark  = new ShareRemark();
                        Bundle args = new Bundle();
                        args.putString("abc", username);
                        args.putString("def", "proposal");
                        ShareRemark.setArguments(args);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,ShareRemark).commit();
                    }
                });
                break;
            case "thesis": // thesis -----------------------------------------------------------------------------------------------------------
                toptitle.setText("Thesis");
                myRef.child(username).child("Project").child("thesis").child("deadline").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String deadlinedb = dataSnapshot.getValue(String.class);
                        if(deadlinedb.length() > 0){
                            deadline.setText(deadlinedb);
                        }else{
                            deadline.setText("deadline not set yet");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        deadline.setText("Fail to read from db");
                    }
                });

                //read remark
                myRef.child(username).child("Project").child("thesis").child("remark").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String remarkdb = dataSnapshot.getValue(String.class);
                        if(remarkdb.length() > 0){
                            remark.setText(remarkdb);
                        }else{
                            remark.setText("Doesn't have any remark yet");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        remark.setText("Fail to read from db");
                    }
                });

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ShareEdit ShareEdit = new ShareEdit();
                        Bundle args = new Bundle();
                        args.putString("abc", username);
                        args.putString("def", "thesis");
                        ShareEdit.setArguments(args);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,ShareEdit).commit();
                    }
                });

                btn_remark.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ShareRemark ShareRemark  = new ShareRemark();
                        Bundle args = new Bundle();
                        args.putString("abc", username);
                        args.putString("def", "thesis");
                        ShareRemark.setArguments(args);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,ShareRemark).commit();
                    }
                });
                break;
            case "proposalpresentslide": // Proposal Presentation Slide -----------------------------------------------------------------------------------------------------------
                toptitle.setText("Proposal Presentation Slide");
                myRef.child(username).child("Project").child("proposalpresentslide").child("deadline").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String deadlinedb = dataSnapshot.getValue(String.class);
                        if(deadlinedb.length() > 0){
                            deadline.setText(deadlinedb);
                        }else{
                            deadline.setText("deadline not set yet");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        deadline.setText("Fail to read from db");
                    }
                });

                //read remark
                myRef.child(username).child("Project").child("proposalpresentslide").child("remark").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String proposalpresentslidedb = dataSnapshot.getValue(String.class);
                        if(proposalpresentslidedb.length() > 0){
                            remark.setText(proposalpresentslidedb);
                        }else{
                            remark.setText("Doesn't have any remark yet");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        remark.setText("Fail to read from db");
                    }
                });

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ShareEdit ShareEdit = new ShareEdit();
                        Bundle args = new Bundle();
                        args.putString("abc", username);
                        args.putString("def", "proposalpresentslide");
                        ShareEdit.setArguments(args);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,ShareEdit).commit();
                    }
                });

                btn_remark.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ShareRemark ShareRemark = new ShareRemark();
                        Bundle args = new Bundle();
                        args.putString("abc", username);
                        args.putString("def", "proposalpresentslide");
                        ShareRemark.setArguments(args);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,ShareRemark).commit();
                    }
                });
                break;
            case "finalpresentslide": // Final Presentation Slide -----------------------------------------------------------------------------------------------------------
                toptitle.setText("Final Presentation Slide");
                myRef.child(username).child("Project").child("finalpresentslide").child("deadline").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String finalpresentslidedb = dataSnapshot.getValue(String.class);
                        if(finalpresentslidedb.length() > 0){
                            deadline.setText(finalpresentslidedb);
                        }else{
                            deadline.setText("deadline not set yet");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        deadline.setText("Fail to read from db");
                    }
                });

                //read remark
                myRef.child(username).child("Project").child("finalpresentslide").child("remark").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String finalpresentslidedb = dataSnapshot.getValue(String.class);
                        if(finalpresentslidedb.length() > 0){
                            remark.setText(finalpresentslidedb);
                        }else{
                            remark.setText("Doesn't have any remark yet");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        remark.setText("Fail to read from db");
                    }
                });

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ShareEdit ShareEdit = new ShareEdit();
                        Bundle args = new Bundle();
                        args.putString("abc", username);
                        args.putString("def", "finalpresentslide");
                        ShareEdit.setArguments(args);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,ShareEdit).commit();
                    }
                });

                btn_remark.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ShareRemark ShareRemark = new ShareRemark();
                        Bundle args = new Bundle();
                        args.putString("abc", username);
                        args.putString("def", "finalpresentslide");
                        ShareRemark.setArguments(args);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,ShareRemark).commit();
                    }
                });
                break;
            case "poster": // poster Slide -----------------------------------------------------------------------------------------------------------
                toptitle.setText("Poster");
                myRef.child(username).child("Project").child("poster").child("deadline").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String posterdb = dataSnapshot.getValue(String.class);
                        if(posterdb.length() > 0){
                            deadline.setText(posterdb);
                        }else{
                            deadline.setText("deadline not set yet");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        deadline.setText("Fail to read from db");
                    }
                });

                //read remark
                myRef.child(username).child("Project").child("poster").child("remark").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String posterdb = dataSnapshot.getValue(String.class);
                        if(posterdb.length() > 0){
                            remark.setText(posterdb);
                        }else{
                            remark.setText("Doesn't have any remark yet");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        remark.setText("Fail to read from db");
                    }
                });

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ShareEdit ShareEdit = new ShareEdit();
                        Bundle args = new Bundle();
                        args.putString("abc", username);
                        args.putString("def", "poster");
                        ShareEdit.setArguments(args);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,ShareEdit).commit();
                    }
                });

                btn_remark.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ShareRemark ShareRemark = new ShareRemark();
                        Bundle args = new Bundle();
                        args.putString("abc", username);
                        args.putString("def", "poster");
                        ShareRemark.setArguments(args);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,ShareRemark).commit();
                    }
                });
                break;
        }
        return view;
    }
}