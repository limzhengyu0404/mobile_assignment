package com.example.supervisor.Share;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.supervisor.R;
import com.example.supervisor.Title.TitlePage;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ShareRemark extends Fragment {

    //link firebase
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users").child("username");

    private TextView toptitle;
    public String username,value2;
    public EditText edit_remark;
    private Button btn_save, btn_discard;
    private String titlepointer;

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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_share_remark, container, false);

        edit_remark = view.findViewById(R.id.edit_remark);
        btn_save = view.findViewById(R.id.btn_save);
        btn_discard = view.findViewById(R.id.btn_discard);
        toptitle = view.findViewById(R.id.toptitle);

        RadioGroup statuschoose = (RadioGroup) view.findViewById(R.id.statuschoose);



        //save status
        statuschoose.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                value2 = "";
                switch(checkedId)
                {
                    case R.id.status_pending:
                        value2="pending";
                        break;
                    case R.id.status_approve:
                        value2="approve";
                        break;
                    case R.id.status_KIV:
                        value2="KIV";
                        break;
                    case R.id.status_reject:
                        value2="reject";
                        break;
                }
            }
        });

        switch(titlepointer){
            case "proposal":
                toptitle.setText("Proposal");
                btn_save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myRef.child(username).child("Project").child("proposal").child("status").setValue(value2);
                        myRef.child(username).child("Project").child("proposal").child("remark").setValue(edit_remark.getText().toString());
                        SharePage SharePage = new SharePage();
                        Bundle args = new Bundle();
                        args.putString("abc", username);
                        args.putString("def", titlepointer);
                        SharePage.setArguments(args);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,SharePage).commit();
                    }
                });
                break;
            case "thesis":
                toptitle.setText("Thesis");
                btn_save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myRef.child(username).child("Project").child("thesis").child("status").setValue(value2);
                        myRef.child(username).child("Project").child("thesis").child("remark").setValue(edit_remark.getText().toString());
                        SharePage SharePage = new SharePage();
                        Bundle args = new Bundle();
                        args.putString("abc", username);
                        args.putString("def", titlepointer);
                        SharePage.setArguments(args);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,SharePage).commit();
                    }
                });
                break;
            case "proposalpresentslide":
                toptitle.setText("Proposal Present Slide");
                btn_save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myRef.child(username).child("Project").child("proposalpresentslide").child("status").setValue(value2);
                        myRef.child(username).child("Project").child("proposalpresentslide").child("remark").setValue(edit_remark.getText().toString());
                        SharePage SharePage = new SharePage();
                        Bundle args = new Bundle();
                        args.putString("abc", username);
                        args.putString("def", titlepointer);
                        SharePage.setArguments(args);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,SharePage).commit();
                    }
                });
                break;
            case "finalpresentslide":
                toptitle.setText("Final Present Slide");
                btn_save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myRef.child(username).child("Project").child("finalpresentslide").child("status").setValue(value2);
                        myRef.child(username).child("Project").child("finalpresentslide").child("remark").setValue(edit_remark.getText().toString());
                        SharePage SharePage = new SharePage();
                        Bundle args = new Bundle();
                        args.putString("abc", username);
                        args.putString("def", titlepointer);
                        SharePage.setArguments(args);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,SharePage).commit();
                    }
                });
                break;
            case "poster":
                toptitle.setText("Poster");
                btn_save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myRef.child(username).child("Project").child("poster").child("status").setValue(value2);
                        myRef.child(username).child("Project").child("poster").child("remark").setValue(edit_remark.getText().toString());
                        SharePage SharePage = new SharePage();
                        Bundle args = new Bundle();
                        args.putString("abc", username);
                        args.putString("def", titlepointer);
                        SharePage.setArguments(args);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,SharePage).commit();
                    }
                });
                break;
        }


        //back to title page
        btn_discard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharePage SharePage = new SharePage();
                Bundle args = new Bundle();
                args.putString("abc", username);
                args.putString("def", titlepointer);
                SharePage.setArguments(args);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,SharePage).commit();
            }
        });

        return view;
    }
}