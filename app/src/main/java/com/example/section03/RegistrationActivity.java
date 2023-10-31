package com.example.section03;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    EditText emailEditText;
    EditText passwordEditText;
    Button registerButton;

    //Create required variables
    private SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "MyPrefs";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        emailEditText = findViewById(R.id.email_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        registerButton = findViewById(R.id.register_button);

        //Initialize SharedPreferences
        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                //Check that all Fields are filled
                if (!email.isEmpty() && !password.isEmpty()) {

                    //Create editor to be able to write in SharedPreferences file
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    //Add email and password retrieved from EditText
                    editor.putString(KEY_EMAIL, email);
                    editor.putString(KEY_PASSWORD, password);

                    //at the end use editor.apply() or editor.commit() to save changes
                    editor.apply();

                    Toast.makeText(RegistrationActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegistrationActivity.this, HomeActivity.class));
                } else {
                    Toast.makeText(RegistrationActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}