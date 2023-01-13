package com.example.supervisor;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MarkingFragment extends Fragment {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users/username");

    private String username;
    private EditText input1,input2,input3,input4,input5,input6,input7,input8,input9,input10,input11,input12,input13,input14;
    private TextView finalmark;
    private Button btn_save,btn_discard,btn_getmark;
    public int fm=0;

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
        View view=inflater.inflate(R.layout.fragment_marking, container, false);

        input1 = view.findViewById(R.id.input_1);
        input2 = view.findViewById(R.id.input_2);
        input3 = view.findViewById(R.id.input_3);
        input4 = view.findViewById(R.id.input_4);
        input5 = view.findViewById(R.id.input_5);
        input6 = view.findViewById(R.id.input_6);
        input7 = view.findViewById(R.id.input_7);
        input8 = view.findViewById(R.id.input_8);
        input9 = view.findViewById(R.id.input_9);
        input10 = view.findViewById(R.id.input_10);
        input11 = view.findViewById(R.id.input_11);
        input12 = view.findViewById(R.id.input_12);
        input13 = view.findViewById(R.id.input_13);
        input14 = view.findViewById(R.id.input_14);
        finalmark = view.findViewById(R.id.final_mark);
        btn_save = view.findViewById(R.id.btn_save);
        btn_discard = view.findViewById(R.id.btn_discard);
        btn_getmark = view.findViewById(R.id.btn_getmark);

        btn_getmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check throught all the mark
                boolean check = true;
                int mark1=0,mark2=0,mark3=0,mark4=0,mark5=0,mark6=0,mark7=0,mark8=0,mark9=0,mark10=0,mark11=0,mark12=0,mark13=0,mark14=0;

                if(input1.getText().length() > 0){
                    mark1 = Integer.parseInt(input1.getText().toString());
                    if (mark1 > 5) {
                        input1.setBackgroundColor(Color.parseColor("#FF0000"));
                        check = false;
                    }else{
                        check = true;
                        input1.setBackgroundColor(Color.parseColor("#ffffff"));
                    }
                }else{
                    input1.setBackgroundColor(Color.parseColor("#FF0000"));
                    check = false;
                }

                if(input2.getText().length() > 0){
                    mark2 = Integer.parseInt(input2.getText().toString());
                    if (mark2 > 5) {
                        input2.setBackgroundColor(Color.parseColor("#FF0000"));
                        check = false;
                    }else{
                        check = true;
                        input2.setBackgroundColor(Color.parseColor("#ffffff"));
                    }
                }else{
                    input2.setBackgroundColor(Color.parseColor("#FF0000"));
                    check = false;
                }

                if(input3.getText().length() > 0){
                    mark3 = Integer.parseInt(input3.getText().toString());
                    if (mark3 > 5) {
                        input3.setBackgroundColor(Color.parseColor("#FF0000"));
                        check = false;
                    }else{
                        check = true;
                        input3.setBackgroundColor(Color.parseColor("#ffffff"));
                    }
                }else{
                    input3.setBackgroundColor(Color.parseColor("#FF0000"));
                    check = false;
                }

                if(input4.getText().length() > 0){
                    mark4 = Integer.parseInt(input4.getText().toString());
                    if (mark4 > 5) {
                        input4.setBackgroundColor(Color.parseColor("#FF0000"));
                        check = false;
                    }else{
                        check = true;
                        input4.setBackgroundColor(Color.parseColor("#ffffff"));
                    }
                }else{
                    input4.setBackgroundColor(Color.parseColor("#FF0000"));
                    check = false;
                }

                if(input5.getText().length() > 0){
                    mark5 = Integer.parseInt(input5.getText().toString());
                    if (mark5 > 3) {
                        input5.setBackgroundColor(Color.parseColor("#FF0000"));
                        check = false;
                    }else{
                        check = true;
                        input5.setBackgroundColor(Color.parseColor("#ffffff"));
                    }
                }else{
                    input5.setBackgroundColor(Color.parseColor("#FF0000"));
                    check = false;
                }

                if(input6.getText().length() > 0){
                    mark6 = Integer.parseInt(input6.getText().toString());
                    if (mark6 > 4) {
                        input6.setBackgroundColor(Color.parseColor("#FF0000"));
                        check = false;
                    }else{
                        check = true;
                        input6.setBackgroundColor(Color.parseColor("#ffffff"));
                    }
                }else{
                    input6.setBackgroundColor(Color.parseColor("#FF0000"));
                    check = false;
                }

                if(input7.getText().length() > 0){
                    mark7 = Integer.parseInt(input7.getText().toString());
                    if (mark7 > 5) {
                        input7.setBackgroundColor(Color.parseColor("#FF0000"));
                        check = false;
                    }else{
                        check = true;
                        input7.setBackgroundColor(Color.parseColor("#ffffff"));
                    }
                }else{
                    input7.setBackgroundColor(Color.parseColor("#FF0000"));
                    check = false;
                }

                if(input8.getText().length() > 0){
                    mark8 = Integer.parseInt(input8.getText().toString());
                    if (mark8 > 5) {
                        input8.setBackgroundColor(Color.parseColor("#FF0000"));
                        check = false;
                    }else{
                        check = true;
                        input8.setBackgroundColor(Color.parseColor("#ffffff"));
                    }
                }else{
                    input8.setBackgroundColor(Color.parseColor("#FF0000"));
                    check = false;
                }

                if(input9.getText().length() > 0){
                    mark9 = Integer.parseInt(input9.getText().toString());
                    if (mark9 > 5) {
                        input9.setBackgroundColor(Color.parseColor("#FF0000"));
                        check = false;
                    }else{
                        check = true;
                        input9.setBackgroundColor(Color.parseColor("#ffffff"));
                    }
                }else{
                    input9.setBackgroundColor(Color.parseColor("#FF0000"));
                    check = false;
                }

                if(input10.getText().length() > 0){
                    mark10 = Integer.parseInt(input10.getText().toString());
                    if (mark10 > 5) {
                        input10.setBackgroundColor(Color.parseColor("#FF0000"));
                        check = false;
                    }else{
                        check = true;
                        input10.setBackgroundColor(Color.parseColor("#ffffff"));
                    }
                }else{
                    input10.setBackgroundColor(Color.parseColor("#FF0000"));
                    check = false;
                }

                if(input11.getText().length() > 0){
                    mark11 = Integer.parseInt(input11.getText().toString());
                    if (mark11 > 5) {
                        input11.setBackgroundColor(Color.parseColor("#FF0000"));
                        check = false;
                    }else{
                        check = true;
                        input11.setBackgroundColor(Color.parseColor("#ffffff"));
                    }
                }else{
                    input11.setBackgroundColor(Color.parseColor("#FF0000"));
                    check = false;
                }

                if(input12.getText().length() > 0){
                    mark12 = Integer.parseInt(input12.getText().toString());
                    if (mark12 > 3) {
                        input12.setBackgroundColor(Color.parseColor("#FF0000"));
                        check = false;
                    }else{
                        check = true;
                        input12.setBackgroundColor(Color.parseColor("#ffffff"));
                    }
                }else{
                    input12.setBackgroundColor(Color.parseColor("#FF0000"));
                    check = false;
                }

                if(input13.getText().length() > 0){
                    mark13 = Integer.parseInt(input13.getText().toString());
                    if (mark13 > 2) {
                        input13.setBackgroundColor(Color.parseColor("#FF0000"));
                        check = false;
                    }else{
                        check = true;
                        input13.setBackgroundColor(Color.parseColor("#ffffff"));
                    }
                }else{
                    input13.setBackgroundColor(Color.parseColor("#FF0000"));
                    check = false;
                }

                if(input14.getText().length() > 0){
                    mark14 = Integer.parseInt(input14.getText().toString());
                    if (mark14 > 3) {
                        input14.setBackgroundColor(Color.parseColor("#FF0000"));
                        check = false;
                    }else{
                        check = true;
                        input14.setBackgroundColor(Color.parseColor("#ffffff"));
                    }
                }else{
                    input14.setBackgroundColor(Color.parseColor("#FF0000"));
                    check = false;
                }

                if(check == true){
                    fm = mark1+mark2+mark3+mark4+mark5+mark6+mark7+mark8+mark9+mark10+mark11+mark12+mark13+mark14;
                    finalmark.setText(""+fm);
                }
            }
        });

        if(finalmark.getText().toString() != ""){
            btn_save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myRef.child(username).child("Project").child("endorse").setValue("false");
                    myRef.child(username).child("Project").child("finalmark").setValue(finalmark.getText().toString());

                    myRef.child(username).child("name").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String value = dataSnapshot.getValue(String.class);
                            StudentDetailFragment StudentDetailFragment = new StudentDetailFragment();
                            Bundle args = new Bundle();
                            args.putString("abc", value);
                            StudentDetailFragment.setArguments(args);
                            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,StudentDetailFragment).commit();
                        }

                        @Override
                        public void onCancelled(DatabaseError error) {
                        }
                    });

                }
            });
        }

        btn_discard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child(username).child("name").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String value = dataSnapshot.getValue(String.class);
                        StudentDetailFragment StudentDetailFragment = new StudentDetailFragment();
                        Bundle args = new Bundle();
                        args.putString("abc", value);
                        StudentDetailFragment.setArguments(args);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,StudentDetailFragment).commit();
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                    }
                });
            }
        });


        return view;
    }
}