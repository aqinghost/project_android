package com.example.kuliah;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText editUsername,editPassword;
    Button btnLogin;
    SharedPreferences SharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SharedPreferences = Login.this.getSharedPreferences("username", Context.MODE_PRIVATE);
        editUsername = findViewById(R.id.username);
        editPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = editUsername.getText().toString();
                String password = editPassword.getText().toString();
                if(uname.equals("admin")&&password.equals("admin")){
                    SharedPreferences.Editor edit = SharedPreferences.edit();
                    edit.putString("uname",uname);
                    edit.apply();
                    startActivity(new Intent(Login.this,MainActivity.class));
                    finish();
                    Toast.makeText(Login.this,"Selamat datang"+editUsername.getText().toString(),Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(Login.this,"gagal"+editUsername.getText().toString(),Toast.LENGTH_LONG).show();
                }
            }
        });



    }

    public void Resetdata(View view) {
        editUsername.setText("");
        editPassword.setText("");
    }
}