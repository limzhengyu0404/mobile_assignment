package com.example.supervisor.Title;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.supervisor.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class TitleRemark extends Fragment {

    //link firebase
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users").child("username");

    public String username,value,value2;
    public EditText edit_remark;
    private Button btn_save, btn_discard;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            username = getArguments().getString("abc");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_title_remark, container, false);

        edit_remark = view.findViewById(R.id.edit_remark);
        btn_save = view.findViewById(R.id.btn_save);
        btn_discard = view.findViewById(R.id.btn_discard);

        RadioGroup titlechoose = (RadioGroup) view.findViewById(R.id.titlechoose);
        RadioGroup statuschoose = (RadioGroup) view.findViewById(R.id.statuschoose);

        //save titlechoose
        titlechoose.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                value = "";
                switch(checkedId)
                {
                    case R.id.title1:
                        value="title 1";
                        break;
                    case R.id.title2:
                        value="title 2";
                        break;
                    case R.id.title3:
                        value="title 3";
                        break;
                }
            }
        });

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

        //button save
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child(username).child("Project").child("title").child("approvetitle").setValue(value);
                myRef.child(username).child("Project").child("title").child("status").setValue(value2);
                myRef.child(username).child("Project").child("title").child("remark").setValue(edit_remark.getText().toString());
                TitlePage TitlePage = new TitlePage();
                Bundle args = new Bundle();
                args.putString("abc", username);
                TitlePage.setArguments(args);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,TitlePage).commit();
            }
        });

        //back to title page
        btn_discard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TitlePage TitlePage = new TitlePage();
                Bundle args = new Bundle();
                args.putString("abc", username);
                TitlePage.setArguments(args);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,TitlePage).commit();
            }
        });

        return view;
    }
}