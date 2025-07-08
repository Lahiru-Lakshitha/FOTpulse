package com.example.newsapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_section);

        TextView backButton = findViewById(R.id.back_button);
        Button signOutButton = findViewById(R.id.sign_out_button);
        Button btnEditInfo = findViewById(R.id.edit_info_btn);

        btnEditInfo.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, EditUserInfoActivity.class);
            startActivity(intent);
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });

        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(ProfileActivity.this)
                        .setTitle("Sign Out")
                        .setMessage("Really want to sign out?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Redirect to MainActivity
                                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Redirect back to ProfileActivity
                                Intent intent = new Intent(ProfileActivity.this, ProfileActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .setCancelable(false)
                        .show();
            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = getSharedPreferences("user_profile", MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "John Doe");
        String email = sharedPreferences.getString("email", "2020t00888@stu.cmb.ac.lk");

        TextView tvName = findViewById(R.id.name_text);
        TextView tvEmail = findViewById(R.id.email_text);

        tvName.setText(name);
        tvEmail.setText(email);
    }
}
