package com.example.newsapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditUserInfoActivity extends AppCompatActivity {

    EditText etName, etEmail;
    Button btnOK, btnCancel;

    SharedPreferences sharedPreferences;
    public static final String USER_PREF = "user_profile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_info);

        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        btnOK = findViewById(R.id.btn_ok);
        btnCancel = findViewById(R.id.btn_cancel);

        sharedPreferences = getSharedPreferences(USER_PREF, Context.MODE_PRIVATE);

        // Pre-fill with saved data if available
        etName.setText(sharedPreferences.getString("name", "John Doe"));
        etEmail.setText(sharedPreferences.getString("email", "2020t00888@stu.cmb.ac.lk"));

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();

                if (name.isEmpty() || email.isEmpty()) {
                    Toast.makeText(EditUserInfoActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(EditUserInfoActivity.this, "Invalid email format", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Save to SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", name);
                editor.putString("email", email);
                editor.apply();

                Toast.makeText(EditUserInfoActivity.this, "Details updated!", Toast.LENGTH_SHORT).show();

                // Redirect back to profile page
                Intent intent = new Intent(EditUserInfoActivity.this, ProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnCancel.setOnClickListener(v -> {
            Intent intent = new Intent(EditUserInfoActivity.this, ProfileActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
