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
public class ForgotPasswordFragment extends Fragment {
    EditText edit_email;
    Button recoverybtn;
    public ForgotPasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view= inflater.inflate(R.layout.fragment_forgot_password, container, false);

        edit_email=(EditText)view.findViewById(R.id.edit_email);
        recoverybtn=(Button)view.findViewById(R.id.recoverybtn);


        recoverybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recoverPass(v);

            }
        });
        return view;
    }

    public void recoverPass(View view) {
        // Toast.makeText(getApplicationContext(),"login called",Toast.LENGTH_SHORT).show();
        MainActivity.fm.beginTransaction().replace(R.id.frag_cont_page, new LoginFragment(), null).commit();
    }
}
