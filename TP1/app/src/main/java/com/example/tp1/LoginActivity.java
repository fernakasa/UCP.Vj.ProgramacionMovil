package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
        EditText user, password;
        Button register;
        Button login;
        DatabaseController databaseController;

        @SuppressLint("MissingSuperCall")
        @Override
        public void onBackPressed()
        {
            // super.onBackPressed(); // Comment this super call to avoid calling finish() or fragmentmanager's backstack pop operation.
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            user = findViewById(R.id.login_user);
            password = findViewById(R.id.login_password);
            register = findViewById(R.id.login_btnRegister);
            login = findViewById(R.id.login_btnLogin);
            databaseController = new DatabaseController(this);

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String userValue = user.getText().toString();
                    String passValue = password.getText().toString();

                    if(databaseController.isLoginValid(userValue, passValue)){
                        finish();
                    }

                }
            });

            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                    startActivity(intent);
                }
            });


        }
}








