
package com.example.meditrack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity implements View.OnClickListener{

        private EditText editTextEmail, editTextPassword;
        private Button loginButton;

        private FirebaseAuth mAuth;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            //for changing status bar icon color
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
            super.onCreate(savedInstanceState);
            getWindow().setStatusBarColor(ContextCompat.getColor(Login.this,R.color.mainRed));
            setContentView(R.layout.activity_login);

         loginButton = (Button) findViewById(R.id.cirLoginButton);
            loginButton.setOnClickListener(this);

            editTextEmail = (EditText) findViewById(R.id.editTextEmailLogin);
            editTextPassword = (EditText) findViewById(R.id.editTextPasswordLogin);

            mAuth = FirebaseAuth.getInstance();
        }

        public void onLoginClick(View view) {
            startActivity(new Intent(this, Signup.class));
            overridePendingTransition(R.anim.slide_in_right, R.anim.stay);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.cirLoginButton:
                    userLogin();
                    break;
            }
        }

        private void userLogin() {
            String email = editTextEmail.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();

            if (email.isEmpty()) {
                editTextEmail.setError("Please Enter Your Email");
                editTextEmail.requestFocus();
                return;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                editTextEmail.setError("Please Enter A Valid Email");
                editTextEmail.requestFocus();
                return;
            }
            if (password.isEmpty()) {
                editTextPassword.setError("Please Enter Your Password");
                editTextEmail.requestFocus();
                return;
            }
            if (password.length() < 6) {
                editTextPassword.setError("Password Must Be At Least 6 Characters");
                editTextPassword.requestFocus();
                return;
            }

            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        startActivity(new Intent(Login.this, Navigation.class));
                        finish();
                    } else {
                        Toast.makeText(Login.this, "Login Failed! Please Check Your Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
