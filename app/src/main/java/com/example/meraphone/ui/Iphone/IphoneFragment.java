package com.example.meraphone.ui.Iphone;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.meraphone.Adapters.DetailsAdapter;
import com.example.meraphone.R;
import com.example.meraphone.database.Db_frall;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class IphoneFragment extends Fragment {
    private RecyclerView recyclerView;
    private Db_frall databaseHandler;
        private DetailsAdapter rvAdapter;
       public IphoneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_iphone, container, false);
        recyclerView=view.findViewById(R.id.recycle_iphone);
        databaseHandler = new Db_frall(getContext());
        //  rating=view.findViewById(R.id.rating);
       /* rvAdapter =new DetailsAdapter(databaseHandler.getAllImagesData("I-Phone","Active") );
        if(rvAdapter.getItemCount()==0){
            Toast.makeText(getContext(), "No data found please contact to admin", Toast.LENGTH_SHORT).show();
            return view;
        }
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(rvAdapter);*/
        return view;
    }



}


