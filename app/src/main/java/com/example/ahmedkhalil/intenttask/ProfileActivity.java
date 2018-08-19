package com.example.ahmedkhalil.intenttask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    TextView tv_name, tv_bio, tv_email, tv_phone;
    String name, bio, email, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tv_name = (TextView) findViewById(R.id.tvname);
        tv_bio = (TextView) findViewById(R.id.tvBio);
        tv_email = (TextView) findViewById(R.id.tvEmail);
        tv_phone = (TextView) findViewById(R.id.tvPhone);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String bio = bundle.getString("bio");
        String email = bundle.getString("email");
        String phone = bundle.getString("phone");

        tv_name.setText(name);
        tv_bio.setText(bio);
        tv_email.setText(email);
        tv_phone.setText(phone);

    }
}
