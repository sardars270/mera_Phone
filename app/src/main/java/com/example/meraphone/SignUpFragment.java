package com.example.meraphone;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {
    EditText fname,lname,email,pass,mobile;
    Button login,signup;
    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sign_up, container, false);
        fname=view.findViewById(R.id.fname);
        lname=(EditText)view.findViewById(R.id.lname);
        email=(EditText)view.findViewById(R.id.email);
        pass=(EditText)view.findViewById(R.id.pass);
        mobile=(EditText)view.findViewById(R.id.mobile);
        login=(Button) view.findViewById(R.id.login);
        signup=(Button)view.findViewById(R.id.signup);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fm.beginTransaction().replace(R.id.frag_cont_page,new LoginFragment(), null).commit();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /////check validity///////
                MainActivity.fm.beginTransaction().replace(R.id.frag_cont_page, new LoginFragment(), null).commit();
            }


        });
        return view;
    }
}
