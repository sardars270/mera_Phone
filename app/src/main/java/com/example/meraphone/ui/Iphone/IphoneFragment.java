package com.example.meraphone.ui.Iphone;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.meraphone.Adapters.DetailsAdapter;
import com.example.meraphone.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class IphoneFragment extends Fragment {

    public IphoneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_iphone, container, false);

        return view;
    }

}


