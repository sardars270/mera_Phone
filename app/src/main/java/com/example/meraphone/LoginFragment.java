package com.example.meraphone;

import android.content.Intent;
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
public class LoginFragment extends Fragment {
    public EditText email, pass;
    public Button bt_login_login, bt_login_signup, bt_forgotpass;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login, container, false);
        bt_login_login = view.findViewById(R.id.bt_login_login);
        bt_login_signup = view.findViewById(R.id.bt_login_signup);
        bt_forgotpass = view.findViewById(R.id.bt_forgotpass);
        email = view.findViewById(R.id.email);
        pass = view.findViewById(R.id.pass);

        bt_login_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fm.beginTransaction().replace(R.id.frag_cont_page, new SignUpFragment(), null).commit();
            }
        });
        bt_login_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }
        });
        bt_forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fm.beginTransaction().replace(R.id.frag_cont_page, new ForgotPasswordFragment(), null).commit();
            }
        });
        return view;
    }
}
