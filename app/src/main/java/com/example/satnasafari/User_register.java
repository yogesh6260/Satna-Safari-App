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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class User_register extends AppCompatActivity {

    private EditText mName, mUser, mEmail, mPassword;
    private Button mReg;
    private FirebaseAuth mAuth;
    private TextView  loginHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);
        getSupportActionBar().setTitle("Signup Here");
        mName = findViewById(R.id.name_reg);
        mUser = findViewById(R.id.user_reg);
        mEmail = findViewById(R.id.email_reg);
        mPassword = findViewById(R.id.password_reg);
        mReg = findViewById(R.id.reg);
        mAuth = FirebaseAuth.getInstance();
        loginHere = findViewById(R.id.loginHere);

        mReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser();
            }
        });

        loginHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(User_register.this, User_login.class));
            }
        });
    }

    private void createUser(){
        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();

        if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            if(!password.isEmpty())
            {
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(User_register.this, "Registered Successfully!!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(User_register.this, User_login.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(User_register.this, "Registeration Error!!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
            else{
                mPassword.setError("Empty Fields are not Allowed!");
            }
        }
        else if(email.isEmpty()){
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