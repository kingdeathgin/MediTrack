
package com.example.meditrack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth mAuth;
    private Button registerButton;
    private EditText editTextName, editTextEmail,editTextPassword,editTextPasswordConfirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(ContextCompat.getColor(Signup.this,R.color.mainYellow));
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();

        registerButton = (Button)findViewById(R.id.cirRegisterButton);
        registerButton.setOnClickListener(this);

        editTextName = (EditText)findViewById(R.id.editTextName);
        editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);
        editTextPasswordConfirm = (EditText)findViewById(R.id.editTextPasswordConfirm);





        changeStatusBarColor();
    }

    public void changeStatusBarColor(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){

            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.register_bk_color));

        }
    }

    public void onLoginClick(View view){

        startActivity(new Intent(this, Login.class));
        overridePendingTransition(R.anim.slide_in_left,android.R.anim.slide_out_right);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cirRegisterButton:
                registerUser();
                break;
        }
    }

    private void registerUser() {
        String name = editTextName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String passwordConfirm = editTextPasswordConfirm.getText().toString().trim();
        if(name.isEmpty()){
            editTextName.setError("Please Enter Your Name!");
            editTextName.requestFocus();
            return;
        }

        if(email.isEmpty()){
            editTextEmail.setError("Please Enter Your Email Address!");
            editTextEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Please Enter A Valid Email!");
            editTextEmail.requestFocus();
            return;
        }

        if(password.isEmpty()){
            editTextPassword.setError("Please Enter Your Password!");
            editTextPassword.requestFocus();
            return;
        }

        if(password.length() < 6){
            editTextPassword.setError("Password Must Be At Least 6 Characters!");
            editTextPassword.requestFocus();
            return;
        }

        if(passwordConfirm.isEmpty()){
            editTextPasswordConfirm.setError("Please Confirm Your Password!");
            editTextPasswordConfirm.requestFocus();
            return;
        }

        if(!password.equals(passwordConfirm)){
            editTextPasswordConfirm.setError("Passwords Do Not Match!");
            editTextPasswordConfirm.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    User user = new User(name, email, password);

                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        startActivity(new Intent(Signup.this, Login.class));
                                        Toast.makeText(Signup.this, "Registration Successful", Toast.LENGTH_SHORT).show();

                                    }else{
                                        Toast.makeText(Signup.this, "Registration Failed! Try Again!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }else{
                    Toast.makeText(Signup.this, "Registration Failed! Try Again!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


}