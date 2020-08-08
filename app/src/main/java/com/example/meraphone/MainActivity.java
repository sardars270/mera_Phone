package com.example.meraphone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    public static FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fm =  getSupportFragmentManager();
        if (findViewById(R.id.frag_cont_page)!=null)
        {
            if(savedInstanceState != null)
            { return;
            }
            //////////default fragment///////////////////
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            LoginFragment lg = new LoginFragment();
            //  Upload_Car_Frag2 lg= new Upload_Car_Frag2();
            fragmentTransaction.add(R.id.frag_cont_page, lg, null);
            fragmentTransaction.commit();
        }
    }




}
