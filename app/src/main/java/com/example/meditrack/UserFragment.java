package com.example.meditrack;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserFragment extends Fragment implements View.OnClickListener {


    private Button headButton,armsButton,skinButton, heartButton,lungsButton,liverButton,stomachButton,anrecButton,intestinesButton,legsButton;
    public UserFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().getWindow().setStatusBarColor(getActivity().getColor(R.color.disease_color));
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.headButton:
                startActivity(new Intent(getActivity(), HeadPage.class));
                break;
            case R.id.armButton:
                startActivity(new Intent(getActivity(), ArmsPage.class));
                break;
            case R.id.skinButton:
                startActivity(new Intent(getActivity(), SkinPage.class));
                break;

            case R.id.heartButton:
                startActivity(new Intent(getActivity(), HeartPage.class));
                break;

            case R.id.lungButton:
                startActivity(new Intent(getActivity(), LungsPage.class));
                break;

            case R.id.liverButton:
                startActivity(new Intent(getActivity(), LiverPage.class));
                break;
            case R.id.stomachButton:
                startActivity(new Intent(getActivity(), StomachPage.class));
                break;
            case R.id.anrecButton:
                startActivity(new Intent(getActivity(), AnRecPage.class));
                break;
            case R.id.intestineButton:
                startActivity(new Intent(getActivity(), IntestinesPage.class));
                break;
            case R.id.legsButton:
                startActivity(new Intent(getActivity(), LegsPage.class));
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.disease_activity_main, container, false);

        headButton = (Button) view.findViewById(R.id.headButton);
        headButton.setOnClickListener((View.OnClickListener) this);

        armsButton = (Button) view.findViewById(R.id.armButton);
        armsButton.setOnClickListener((View.OnClickListener) this);

        skinButton = (Button) view.findViewById(R.id.skinButton);
        skinButton.setOnClickListener((View.OnClickListener) this);

        heartButton = (Button) view.findViewById(R.id.heartButton);
        heartButton.setOnClickListener((View.OnClickListener) this);

        lungsButton = (Button) view.findViewById(R.id.lungButton);
        lungsButton.setOnClickListener((View.OnClickListener) this);

        liverButton= (Button) view.findViewById(R.id.liverButton);
        liverButton.setOnClickListener((View.OnClickListener) this);

        stomachButton = (Button) view.findViewById(R.id.stomachButton);
        stomachButton.setOnClickListener((View.OnClickListener) this);

        anrecButton = (Button) view.findViewById(R.id.anrecButton);
        anrecButton.setOnClickListener((View.OnClickListener) this);

        intestinesButton = (Button) view.findViewById(R.id.intestineButton);
        intestinesButton.setOnClickListener((View.OnClickListener) this);

        legsButton = (Button) view.findViewById(R.id.legsButton);
        legsButton.setOnClickListener((View.OnClickListener) this);


        return view;
    }
}