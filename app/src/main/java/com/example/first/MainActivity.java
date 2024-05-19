package com.example.first;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    EditText et_phone;
    Button send_otp_btn;
    ProgressBar pb_bar;
    String phoneNumber;
   // FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_main);

        et_phone = findViewById(R.id.et_phone);
        send_otp_btn = findViewById(R.id.send_otp_btn);
        pb_bar = findViewById(R.id.pb_bar);

        pb_bar.setVisibility(View.GONE);

        send_otp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNumber = et_phone.getText().toString();

                if (phoneNumber.isEmpty()) {
                    et_phone.setError("Invalid Phone Number");
                } else {
                    //pb_bar.setVisibility(View.VISIBLE);
                    phoneNumber=et_phone.getText().toString().trim();
                    Toast.makeText(MainActivity.this,phoneNumber,Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this,OtpActivity.class);
                    intent.putExtra("phonenumber",phoneNumber.toString());
                    startActivity(intent);
                   // sendVerificationCode(phoneNumber);
                }
            }
        });
    }


}

