package com.example.satnasafari;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class User_login extends AppCompatActivity {

    private EditText mEmail, mPassword;
    private Button mLogin;
    private TextView signupHere;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        getSupportActionBar().setTitle("Login Here");
        mEmail = findViewById(R.id.email_login);
        mPassword = findViewById(R.id.password_login);
        mLogin = findViewById(R.id.login);
        signupHere = findViewById(R.id.signupHere);
        mAuth = FirebaseAuth.getInstance();

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });
        signupHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(User_login.this, User_register.class));
            }
        });
    }

    private void loginUser(){
        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();

        if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            if(!password.isEmpty())
            {
                mAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(User_login.this, "Login Successfully!!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(User_login.this, home.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(User_login.this, "Login Failed!!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
            else{
                mPassword.setError("Empty Fields are not Allowed!");
            }
        }
        else if(email.isEmpty())
        {
            mEmail.setError("Empty Fields are not Allowed!");
        }
        else{
            mEmail.setError("Please enter correct email");
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finishAffinity();
    }
}