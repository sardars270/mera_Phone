package com.example.meraphone.ui.Samsung;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.meraphone.Adapters.DetailsAdapter;
import com.example.meraphone.R;
import com.example.meraphone.database.Db_frall;
import com.example.meraphone.model.Product;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SamsungFragment extends Fragment {
    private RecyclerView recyclerView;
    private Db_frall databaseHandler;
    private DetailsAdapter rvAdapter;


    FirebaseFirestore db;
    ArrayList<Product> list = new ArrayList<>();

    public SamsungFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view=  inflater.inflate(R.layout.fragment_samsung, container, false);
        recyclerView=view.findViewById(R.id.recycle_samsung);
        //recyclerView=view.findViewById(R.id.recycle_iphone);
        databaseHandler = new Db_frall(getContext());
        //  rating=view.findViewById(R.id.rating);

        db = FirebaseFirestore.getInstance();


        db.collection("Product")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Product p = document.toObject(Product.class);
                                Toast.makeText(getContext(), p.getItemName(),Toast.LENGTH_SHORT).show();

                                list.add(p);
                            }
                        } else {

                        }
                    }
                });


Product p1 = new Product();
p1.setItemName("name New");
list.add(p1);
        list.add(new Product("nhjdhjf","hgjggj","hgjggj","hgjggj","hgjggj","hgjggj","hgjggj","hgjggj","hgjggj","hgjggj","hgjggj","hgjggj","hgjggj","hgjggj"));



        rvAdapter =new DetailsAdapter(list);
        if(rvAdapter.getItemCount()==0){
            Toast.makeText(getContext(), "No data found please contact to admin", Toast.LENGTH_SHORT).show();
            return view;
        }
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(rvAdapter);
        return view;
    }



}


