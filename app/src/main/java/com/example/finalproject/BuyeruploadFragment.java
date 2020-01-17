package com.example.finalproject;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BuyeruploadFragment extends Fragment {

    EditText txtplace, txttime, txtnumItems, txtinfo;
    Button upload;
    String place, time,numItems, info, orderNum;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buyerupload, container, false);
        txtplace = (EditText) view.findViewById(R.id.editText);
        txttime = (EditText) view.findViewById(R.id.editText2);
        txtnumItems = (EditText) view.findViewById(R.id.editText3);
        txtinfo = (EditText) view.findViewById(R.id.editText4);

        upload = (Button) view.findViewById(R.id.button);

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTrip();
                txtplace.setText("");
                txttime.setText("");
                txtnumItems.setText("");
                txtinfo.setText("");
            }
        });

        return view;
    }


    public void addTrip() {

        place = txtplace.getText().toString();
        time = txttime.getText().toString();
        numItems = txtnumItems.getText().toString();
        info = txtinfo.getText().toString();

        Trip trip = new Trip(place, time, numItems, info);
        Log.d("bruh", "addTrip");
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        final DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("user").child(FirebaseAuth.getInstance().getCurrentUser().getUid());

//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                if (dataSnapshot.exists()) {
//                    orderNum = dataSnapshot.child("numOrders").getValue().toString();
//                    Log.d("bf", orderNum);
//                }
//            }
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

        FirebaseDatabase.getInstance().getReference("trip").child(userId).setValue(trip);



        Toast.makeText(getActivity(), "Your trip has been submitted!", Toast.LENGTH_SHORT).show();

    }
}
