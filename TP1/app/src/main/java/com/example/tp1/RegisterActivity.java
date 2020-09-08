package com.example.tp1;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    EditText user, password, rePassword, email;
    Button register;
    DatabaseController databaseController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        user = findViewById(R.id.register_user);
        password = findViewById(R.id.register_password);
        rePassword = findViewById(R.id.register_rePassword);
        email = findViewById(R.id.register_email);
        register = findViewById(R.id.register_btnRegister);
        databaseController = new DatabaseController(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userValue = user.getText().toString();
                String passValue = password.getText().toString();
                String rePassValue = rePassword.getText().toString();
                String emailValue = email.getText().toString();

                if(passValue.equals(rePassValue)){
                    if(passValue.length() > 3){
                        if(userValue.length() > 3){
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("user", userValue);
                            contentValues.put("password", passValue);
                            contentValues.put("email", emailValue);

                            databaseController.insertUser(contentValues);
                            finish();
                            Toast.makeText(RegisterActivity.this, "Register Successful!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(RegisterActivity.this, "User to short!", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(RegisterActivity.this, "Password to short!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "password don't match!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
