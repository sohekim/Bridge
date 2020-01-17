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

public class ProfileFragment extends Fragment {

    EditText txtName, txtContact, txtBio, txtVenmo;
    Button save;

    boolean data;
    String name, contact, bio, venmo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        txtName = (EditText) view.findViewById(R.id.editText);
        txtBio = (EditText) view.findViewById(R.id.editText2);
        txtContact = (EditText) view.findViewById(R.id.editText3);
        txtVenmo = (EditText) view.findViewById(R.id.editText4);
        save = (Button) view.findViewById(R.id.button);


        txtName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtName.setText("");

            }
        });
        txtBio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtName.setText("");

            }
        });
        txtContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtName.setText("");

            }
        });
        txtVenmo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtName.setText("");

            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
                Toast.makeText(getActivity(), "Your account info is saved!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("user").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String name1 = dataSnapshot.child("name").getValue().toString();
                    String bio1 = dataSnapshot.child("bio").getValue().toString();
                    String contact1 = dataSnapshot.child("contact").getValue().toString();
                    String venmo1 = dataSnapshot.child("venmoID").getValue().toString();

                    txtName.setText(name1);
                    txtBio.setText(bio1);
                    txtContact.setText(contact1);
                    txtVenmo.setText(venmo1);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }

        });

    }

    public void addUser() {
        name = txtName.getText().toString();
        bio = txtBio.getText().toString();
        contact = txtContact.getText().toString();
        venmo = txtVenmo.getText().toString();

        User user = new User(name, bio, venmo, contact, 1);

        FirebaseDatabase.getInstance().getReference("user").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user);

    }
}
