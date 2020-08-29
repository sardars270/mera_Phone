package com.example.meraphone.ui.MyProfile;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meraphone.MeraPhonDrawerActivity;
import com.example.meraphone.R;
import com.example.meraphone.database.Db_frall;
import com.example.meraphone.faltu_context;
import com.example.meraphone.global_vars;
import com.example.meraphone.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyProfileFragment extends Fragment {
    public TextView email;

    public EditText fname, lname, mobile,pass,confirmPass;

    public Button updfateInfo, changePass;
    //Db_frall db;
    FirebaseFirestore db;
    public MyProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_profile, container, false);
        email=view.findViewById(R.id.email);
        fname=view.findViewById(R.id.fname);
        lname=view.findViewById(R.id.lname);
        mobile=view.findViewById(R.id.mobile);
        pass=view.findViewById(R.id.pass);
        confirmPass=view.findViewById(R.id.confirmPass);
        updfateInfo=view.findViewById(R.id.updfateInfo);
        changePass=view.findViewById(R.id.changePass);
        db = FirebaseFirestore.getInstance();

          //getdata from db


        DocumentReference docRef = db.collection("users").document(((global_vars) getActivity().getApplication()).getLoginUserID().toString());
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                       // Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        User user = document.toObject(User.class);
                        fname.setText(user.getFirstName());
                        lname.setText(user.getLastName());
                        mobile.setText(user.getNumber());
                    } else {
                       // Log.d(TAG, "No such document");
                    }
                } else {
                   // Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });


      /* Cursor res2 = db.getAllData(String.valueOf(((global_vars) getActivity().getApplication()).getLoginUserID()));
        if (res2.moveToFirst()) {
            fname.setText(res2.getString(1).toString());
           lname.setText(res2.getString(2).toString());
            email.setText(res2.getString(3).toString());
            mobile.setText(res2.getString(4).toString());
            //fname.setText(res2.getString(1).toString());
        } else {

            Toast.makeText(faltu_context.context, "Error While getting user data", Toast.LENGTH_SHORT).show();
        }

     */

updfateInfo.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //going to update


        DocumentReference docRef = db.collection("users").document(((global_vars) getActivity().getApplication()).getLoginUserID().toString());

// Update the timestamp field with the value from the server
        Map<String,Object> updates = new HashMap<>();
        updates.put("firstName", "new");
        updates.put("lastName", "updated");
        updates.put("number", "111111");

        docRef.update(updates)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(getContext(),"Data Updated...",Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getContext(),"Data Not Updated. Try Again..,",Toast.LENGTH_SHORT).show();

                    }
                });


    }
});
/*        changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = db.checkLogin(email.getText().toString(), pass.getText().toString());

                if (res.moveToFirst()) {
                    // Toast.makeText(faltu_context.context, "Work ", Toast.LENGTH_SHORT).show();
                    boolean ab = db.updatePassInfo( confirmPass.getText().toString(), String.valueOf(((global_vars) getActivity().getApplication()).getLoginUserID()));
                    if(ab==true)
                    {
                        Toast.makeText(faltu_context.context, "Your Password Updated Successfully", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(faltu_context.context, "Error While update user data", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(faltu_context.context, "Please enter correct current password", Toast.LENGTH_SHORT).show();
                }
            }
        });
*/
        return view;
    }
}
