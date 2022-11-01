package com.example.meditrack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.meditrack.activities.MainNotes;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class Navigation extends AppCompatActivity {

    private FloatingActionButton fab;

BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);



        fab =   findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainNotes();
            }
        });

        bottomNavigationView = findViewById(R.id.btnNav);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);


        fragmentRepl(new HomeFragment());
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.home:
                        fragmentRepl(new HomeFragment());
                        break;
                    case R.id.settings:

                        fragmentRepl(new SettingsFragment());
                        break;

                    case R.id.health:
                        fragmentRepl(new UserFragment());
                        break;
                    case R.id.medication:
                        fragmentRepl(new SearchFragment());
                        break;

                }
                return true;
            }
        });

    }

    public void openMainNotes() {
        Intent intent = new Intent(this, MainNotes.class);
        startActivity(intent);
    }

    private void fragmentRepl(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();


    }

}