package com.example.meditrack;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsFragment extends Fragment implements View.OnClickListener{
    private FirebaseUser user;
    private DatabaseReference reference;


    private String userID;

    private ImageView settingsButton;

    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().getWindow().setStatusBarColor(getActivity().getColor(R.color.settings_page));


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.settingsButton:
                startActivity(new Intent(getActivity(), SettingsPage.class));
                break;
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        settingsButton = (ImageView) view.findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(this);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();


        final TextView nameTextView = (TextView) view.findViewById(R.id.nameInputText);
        final TextView emailTextView = (TextView) view.findViewById(R.id.emailInputText);
        final TextView passwordTextView = (TextView) view.findViewById(R.id.passwordInputText);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue((User.class));
                if(userProfile != null){
                    String fullName = userProfile.fullName;
                    String email = userProfile.email;
                    String password = userProfile.password;


                    nameTextView.setText(fullName);
                    emailTextView.setText(email);
                    passwordTextView.setText(password);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), "Something Went Wrong!", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}