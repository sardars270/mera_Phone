package com.example.meraphone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.meraphone.Adapters.DetailsAdapter;
import com.example.meraphone.Adapters.ShowCartAdapter;
import com.example.meraphone.database.Db_frall;
import com.example.meraphone.model.CartItem;
import com.example.meraphone.model.Product;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowCartActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Db_frall databaseHandler;
    private ShowCartAdapter rvAdapter;
    public String nm, price, rtng;
    public Button generateorder;


    FirebaseFirestore db;
    ArrayList<CartItem> list11 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cart);
        recyclerView=findViewById(R.id.recyclerView);
        generateorder = findViewById(R.id.generateorder);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvAdapter =new ShowCartAdapter(list11, getApplicationContext());

        recyclerView.setAdapter(rvAdapter);

        db = FirebaseFirestore.getInstance();


        db.collection("Cart").whereEqualTo("userid", ((global_vars) this.getApplication()).getLoginUserID()).whereEqualTo("status", "Received").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                        if (!queryDocumentSnapshots.isEmpty()) {

                            List<DocumentSnapshot> list1 = queryDocumentSnapshots.getDocuments();

                            for (DocumentSnapshot d : list1) {


                                CartItem p = d.toObject(CartItem.class);
                                p.setBookingdt(d.getString("bookingdt"));
                                p.setImageName(d.getString("imageName"));
                                p.setPrice(d.getString("price"));
                                p.setItemName(d.getString("itemName"));
                                p.setId(d.getId());



                                list11.add(p);
                            }
                            rvAdapter.notifyDataSetChanged();
                        }
                    }
                });



        generateorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });}}


