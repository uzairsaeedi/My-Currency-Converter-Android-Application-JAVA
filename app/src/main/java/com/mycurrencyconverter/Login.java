package com.mycurrencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText edt_email, edt_password;
    Button btn_login,btn_signup;
    boolean isloggedIn;
    boolean valid;
    DatabaseHandler db = new DatabaseHandler(Login.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_email = findViewById(R.id.edt_email);
        edt_password = findViewById(R.id.edt_password);
        btn_signup = findViewById(R.id.btn_signup);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                checkField(edt_email);
                checkField(edt_password);
                String email = edt_email.getText().toString();
                String password = edt_password.getText().toString();
                if(valid){
                    isloggedIn = db.loginUser(email, password);
                    if(isloggedIn){
                        SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("email", email); // Store the user's ID
                        editor.apply();
                        startActivity(new Intent(Login.this, MainActivity.class));
                        finish();
                    }
                    else{
                        Toast.makeText(Login.this, "Invalid Credentials :(", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
            }
        });

    }
    public boolean checkField(EditText textfield){
        if(textfield.getText().toString().isEmpty()){
            textfield.setError("Empty");
            valid = false;
        }
        else {
            valid = true;
        }
        return valid;
    }
}