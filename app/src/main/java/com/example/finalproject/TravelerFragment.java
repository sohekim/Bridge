package com.example.finalproject;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class TravelerFragment extends Fragment {
private RelativeLayout relLayout;
Button btn1, btn2, btn3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_traveler, container, false);
        View rootView = inflater.inflate(R.layout.fragment_traveler, container, false);

        btn1 = (Button) view.findViewById(R.id.confirm1);
        btn2 = view.findViewById(R.id.confirm2);
        btn3 = view.findViewById(R.id.confirm3);

        relLayout = (RelativeLayout) view.findViewById(R.id.relLayout);
        relLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new BuyeruploadFragment());
                fragmentTransaction.commit();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "You've approved the order request", Toast.LENGTH_SHORT).show();
                btn1.setText("confirmed");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "You've approved the order request", Toast.LENGTH_SHORT).show();
                btn2.setText("confirmed");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "You've approved the order request", Toast.LENGTH_SHORT).show();
                btn3.setText("confirmed");
            }
        });


        return view;
    }






}
