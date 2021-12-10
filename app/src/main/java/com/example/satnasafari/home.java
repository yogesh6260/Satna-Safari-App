package com.example.satnasafari;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class home extends AppCompatActivity {

    private long backPressedTime;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mAuth = FirebaseAuth.getInstance();
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.item1:
                Intent a = new Intent(home.this,MainActivity2.class);
                startActivity(a);
                return true;

            case R.id.item2:
                Intent b = new Intent(home.this, MainActivity.class);
                startActivity(b);
                return true;


            case R.id.item3:
                Intent c = new Intent(home.this, MapActivity.class);
                startActivity(c);
                return true;

            case R.id.item4:
                mAuth.signOut();
                startActivity(new Intent(home.this, User_login.class));
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed(){
        if (backPressedTime+2000>System.currentTimeMillis()){
            super.onBackPressed();
            return;
        }else{
            Toast.makeText(getBaseContext(),"press back again to exit",Toast.LENGTH_SHORT).show();
        }
        backPressedTime=System.currentTimeMillis();
    }

}

