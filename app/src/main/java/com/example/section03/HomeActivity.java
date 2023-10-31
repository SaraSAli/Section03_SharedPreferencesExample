package com.example.section03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {


    /**
     * This Activity retrieves the email value from sharedPreferences
     * and Display it in a TextView
     *
     * There is a button to Logout and Navigate to Login Activity
     **/

    TextView tv;
    Button button;

    private SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "MyPrefs";
    private static final String KEY_EMAIL = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tv = findViewById(R.id.text_view);
        button = findViewById(R.id.logout_button);

        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        tv.setText(sharedPreferences.getString(KEY_EMAIL, ""));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }
}