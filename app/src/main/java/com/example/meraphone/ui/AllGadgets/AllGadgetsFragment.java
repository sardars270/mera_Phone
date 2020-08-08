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
private Button apple,samsung,redmi,vivo;

    public AllGadgetsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_all_gadgets, container, false);
        apple = view.findViewById(R.id.apple);

        samsung = view.findViewById(R.id.samsung);
        redmi = view.findViewById(R.id.redmi);
        vivo = view.findViewById(R.id.vivo);
      apple.setOnClickListener(new View.OnClickListener() {

          public void onClick(View v) {
             

          }
      });
        samsung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        redmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        vivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }
}
