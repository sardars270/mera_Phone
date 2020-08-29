package com.example.meraphone.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meraphone.Adapters.Adapter_home;
import com.example.meraphone.Adapters.DetailsAdapter;
import com.example.meraphone.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private RecyclerView rec_topsales,rec_newarrivals,rec_Recommendations;
    private ArrayList<String> nNames=new ArrayList<>();
    private ArrayList<String> mImagesURLs=new ArrayList<>();
    private ArrayList<String> ncost=new ArrayList<>();
    public HomeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        rec_topsales=view.findViewById(R.id.rec_topsales);
        rec_newarrivals=view.findViewById(R.id.rec_newarrivals);
        rec_Recommendations=view.findViewById(R.id.rec_Recommendations);
        initImageBitmaps();

        return view;
    }
    private void initImageBitmaps() {


        mImagesURLs.add("https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/iphone-xr-coral-select-201809?wid=940&hei=1112&fmt=png-alpha&qlt=80&.v=1551226036571");
        nNames.add("iPhone XR 128GB - Midnight Green - Monthly Finance - Limited Offer Deal");
        ncost.add("869");

        mImagesURLs.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR0xg0G4LK9bHBjNOWFY79FxEaWtyElhv8lhVqsUyGAd_UwyQL-8oAHKoIieGfXKsRk3Ef8az0&usqp=CAc");
        nNames.add("iPhone SE 256GB");
        ncost.add("809");

        mImagesURLs.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQmzTS4a0P40EBmTwoYKAtmHPYHxYPOWWG9AOu576nKnKEsVPFXpDx_XS3mN2ucfi1HT2tjvC4&usqp=CAc");
        nNames.add("iPhone 11 Pro 64gb");
        ncost.add("1379");


        mImagesURLs.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcS9Fw59qIcKAR0nXPTHe2iD7LvVGxTTuplTPhWMSc5-aUhsx6HTLONgXMSzYt_AE025MYqEWh6P&usqp=CAc");
        nNames.add("iPhone 11 64GB");
        ncost.add("979");
        mImagesURLs.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR0xg0G4LK9bHBjNOWFY79FxEaWtyElhv8lhVqsUyGAd_UwyQL-8oAHKoIieGfXKsRk3Ef8az0&usqp=CAc");
        nNames.add("iPhone SE 256GB");
        ncost.add("809");

        mImagesURLs.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQmzTS4a0P40EBmTwoYKAtmHPYHxYPOWWG9AOu576nKnKEsVPFXpDx_XS3mN2ucfi1HT2tjvC4&usqp=CAc");
        nNames.add("iPhone 11 Pro 64gb");
        ncost.add("1379");

        mImagesURLs.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR0xg0G4LK9bHBjNOWFY79FxEaWtyElhv8lhVqsUyGAd_UwyQL-8oAHKoIieGfXKsRk3Ef8az0&usqp=CAc");
        nNames.add("iPhone SE 256GB");
        ncost.add("809");

        mImagesURLs.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQmzTS4a0P40EBmTwoYKAtmHPYHxYPOWWG9AOu576nKnKEsVPFXpDx_XS3mN2ucfi1HT2tjvC4&usqp=CAc");
        nNames.add("iPhone 11 Pro 64gb");
        ncost.add("1379");

        initRecylerView();

    }
    private void initRecylerView(){

        Adapter_home adapter=new Adapter_home(nNames,mImagesURLs,ncost,getContext());
        rec_topsales.setAdapter(adapter);
        rec_topsales.setLayoutManager(new LinearLayoutManager(getContext()));
        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rec_topsales.setLayoutManager(horizontalLayoutManagaer);
        //////for 2
        rec_newarrivals.setAdapter(adapter);
        rec_newarrivals.setLayoutManager(new LinearLayoutManager(getContext()));
        LinearLayoutManager horizontalLayoutManagaer1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rec_newarrivals.setLayoutManager(horizontalLayoutManagaer1);
    //for 3
        rec_Recommendations.setAdapter(adapter);
        rec_Recommendations.setLayoutManager(new LinearLayoutManager(getContext()));
        LinearLayoutManager horizontalLayoutManagaer2 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rec_Recommendations.setLayoutManager(horizontalLayoutManagaer2);
    }

}
