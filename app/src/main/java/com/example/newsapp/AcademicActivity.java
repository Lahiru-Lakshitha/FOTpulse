package com.example.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AcademicActivity extends AppCompatActivity {

    ImageView icHome;
    ImageView icAcademicNews;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_news);

        icHome = findViewById(R.id.home);
        icAcademicNews = findViewById(R.id.academic);

        ImageView menuIcon = findViewById(R.id.menu_icon);  // ID of the hamburger menu
        ImageView profileImage = findViewById(R.id.profilePic);

        icHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AcademicActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        icAcademicNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AcademicActivity.this, AcademicActivity.class);
                startActivity(intent);
            }
        });

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AcademicActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AcademicActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });


    }
}
