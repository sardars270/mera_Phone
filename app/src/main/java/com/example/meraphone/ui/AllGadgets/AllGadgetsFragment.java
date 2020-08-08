package com.example.meraphone.ui.AllGadgets;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.meraphone.MeraPhonDrawerActivity;
import com.example.meraphone.R;
import com.example.meraphone.ui.Iphone.IphoneFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllGadgetsFragment extends Fragment {

    public AllGadgetsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_all_gadgets, container, false);

        return view;
    }
}
