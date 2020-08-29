package com.example.meraphone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Admin_Tasks_activity extends AppCompatActivity {
    public static FragmentManager fm;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__tasks_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        faltu_context.context = getApplicationContext();


        mAuth = FirebaseAuth.getInstance();


        if (mAuth.getCurrentUser() == null) {
            this.finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

        FirebaseUser user = mAuth.getCurrentUser();


        fm = getSupportFragmentManager();
        if (findViewById(R.id.frag_cont_page_adm) != null) {
            if (savedInstanceState != null) {
                return;
            }

            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            dashboardFragment lg = new dashboardFragment();
            fragmentTransaction.add(R.id.frag_cont_page_adm, lg, null);
            fragmentTransaction.commit();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menuadmin, menu);

        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.home:
                Admin_Tasks_activity.fm.beginTransaction().replace(R.id.frag_cont_page_adm, new dashboardFragment(), null).commit();

                return true;



            case R.id.add_phone:
                Admin_Tasks_activity.fm.beginTransaction().replace(R.id.frag_cont_page_adm, new Admin_add_phones(), null).commit();

                return true;
            case R.id.add_access:
                Admin_Tasks_activity.fm.beginTransaction().replace(R.id.frag_cont_page_adm, new Admin_add_access(), null).commit();

                return true;

            case R.id.phones:
                Admin_Tasks_activity.fm.beginTransaction().replace(R.id.frag_cont_page_adm, new fragmentPhone(), null).commit();

                return true;

            case R.id.access:
                Admin_Tasks_activity.fm.beginTransaction().replace(R.id.frag_cont_page_adm, new fragmentAdminAccessoriesList(), null).commit();

                return true;

            case R.id.Logout:
                mAuth.signOut();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}

