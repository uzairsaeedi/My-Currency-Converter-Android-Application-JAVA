package com.mycurrencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    EditText edt_email,edt_username,edt_password,edt_re_password,edt_city,edt_country,edt_name,edt_age,edt_phone;
    Button btn_signup,btn_login;
    DatabaseHandler db = new DatabaseHandler(SignUp.this);
    boolean isRegistered;
    boolean valid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edt_email = findViewById(R.id.edt_email);
        edt_password = findViewById(R.id.edt_password);
        edt_phone = findViewById(R.id.edt_phone);
        edt_name = findViewById(R.id.edt_name);
        edt_re_password = findViewById(R.id.edt_re_password);
        btn_signup = findViewById(R.id.btn_signup);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this,Login.class);
                startActivity(intent);
            }
        });
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edt_password.length() < 6){
                    edt_password.setError("Must be equal to or greater than 6 characters");
                    valid = false;
                }
                checkField(edt_name);
                checkField(edt_email);
                checkField(edt_phone);
                checkField(edt_password);
                checkField(edt_re_password);

                String name = edt_name.getText().toString();
                String email = edt_email.getText().toString();
                String phone = edt_phone.getText().toString();
                String password = edt_password.getText().toString();

                if(valid) {
                    isRegistered = db.registerUser(name, email, phone, password);
                    if (isRegistered) {
                        Toast.makeText(SignUp.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
                        edt_name.setText("");
                        edt_email.setText("");
                        edt_phone.setText("");
                        edt_password.setText("");
                        Intent intent = new Intent(SignUp.this,Login.class);
                        startActivity(intent);
                    }
                }
                else{
                    Toast.makeText(SignUp.this, "Something went wrong ! ", Toast.LENGTH_SHORT).show();
                }

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