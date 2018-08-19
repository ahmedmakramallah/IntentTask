package com.example.ahmedkhalil.intenttask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;

public class RegisterActivity extends AppCompatActivity {

    EditText et_name, et_email, et_password, et_cfPassword, et_phone, et_bio;
    String name, email, phone, password, cfPassword, bio;
    Button reg_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_name = (EditText) findViewById(R.id.etName);
        et_email = (EditText) findViewById(R.id.etEmail);
        et_password = (EditText) findViewById(R.id.etPassword);
        et_cfPassword = (EditText) findViewById(R.id.etConfirmPassword);
        et_phone = (EditText) findViewById(R.id.etPhone);
        et_bio = (EditText) findViewById(R.id.etBio);
        reg_btn = (Button) findViewById(R.id.regBtn);

        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();

            }
        });
    }
    
    public void register(){
        intialize();
        if(!validate()){
            Toast.makeText(this, "SignUp has failed :(", Toast.LENGTH_SHORT).show();
        }else{
            onSignUpProcess();
        }
        
    }

    // Intialize the input to string variables
    public void intialize(){
        name = et_name.getText().toString().trim();
        email = et_email.getText().toString().trim();
        phone = et_phone.getText().toString().trim();
        password =et_password.getText().toString().trim();
        cfPassword = et_cfPassword.getText().toString().trim();
        bio = et_bio.getText().toString().trim();
    }

    public boolean validate(){
        boolean valid = true;
        if(name.isEmpty()||name.length()>32){
            et_name.setError("Please enter valid name");
            valid = false;
        }
        if(email.isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            et_email.setError("Please enter valid email address");
            valid = false;
        }
        if (password.isEmpty()){
            et_password.setError("Please enter password");
            valid = false;
        }
        if(cfPassword.isEmpty()){
            et_cfPassword.setError("Please enter password");
            valid = false;
        }
        if (phone.isEmpty()){
            et_phone.setError("Please eneter phone number");
            valid = false;
        }
        if (bio.isEmpty()){
            et_bio.setError("Please enter your bio");
            valid = false;
        }
        return valid;

    }

    //TODO what will go after the valid input
    public void onSignUpProcess(){

        Intent intent =  new Intent(this, ProfileActivity.class);
        Bundle b = new Bundle();
        b.putString("name", name);
        b.putString("bio", bio);
        b.putString("email", email);
        b.putString("phone", phone);
        intent.putExtras(b);
        startActivity(intent);



    }


}
