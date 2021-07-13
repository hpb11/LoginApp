package com.example.loginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class enter_otp extends AppCompatActivity {
EditText inputno1,inputno2,inputno3,inputno4,inputno5,inputno6;
String getotpbackend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_otp);
        Button verifyclick=findViewById(R.id.buttongetotp);
        inputno1=findViewById(R.id.inputotp1);
        inputno2=findViewById(R.id.inputotp2);
        inputno3=findViewById(R.id.inputotp3);
        inputno4=findViewById(R.id.inputotp4);
        inputno5=findViewById(R.id.inputotp5);
        inputno6=findViewById(R.id.inputotp6);
        TextView textView=findViewById(R.id.shownumber);
      textView.setText(String.format(
              "+91-%s",getIntent().getStringExtra("mobile")
              ) );
      getotpbackend= getIntent().getStringExtra("backendotp");

       final ProgressBar verifyotp=findViewById(R.id.progress_bar_otpsent);

        verifyclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!inputno1.getText().toString().trim().isEmpty() && !inputno2.getText().toString().trim().isEmpty() && !inputno3.getText().toString().trim().isEmpty() &&!inputno4.getText().toString().trim().isEmpty() && !inputno5.getText().toString().trim().isEmpty() && !inputno6.getText().toString().trim().isEmpty()){
                      String entercodeotp=inputno1.getText().toString()+
                              inputno2.getText().toString()+
                              inputno3.getText().toString()+
                              inputno4.getText().toString()+
                              inputno5.getText().toString()+
                              inputno6.getText().toString();
                      if(getotpbackend!=null){
                        verifyotp.setVisibility(View.VISIBLE);
                        verifyclick.setVisibility(View.INVISIBLE);

                          PhoneAuthCredential phoneauthcredential=PhoneAuthProvider.getCredential(
                                  getotpbackend,entercodeotp
                          );
                        FirebaseAuth.getInstance().signInWithCredential(phoneauthcredential)
                                  .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                      @Override
                                      public void onComplete(@NonNull Task<AuthResult> task) {
                                          verifyotp.setVisibility(View.INVISIBLE);
                                          verifyclick.setVisibility(View.VISIBLE);
                                          if (task.isSuccessful()) {
                                              Intent intent = new Intent(getApplicationContext(), login.class);
                                              startActivity(intent);
                                              intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                          } else {
                                              Toast.makeText(enter_otp.this, "Enter thr correct OTP", Toast.LENGTH_SHORT).show();
                                          }
                                      }
                                  });
                      }else{
                          Toast.makeText(enter_otp.this,"Please check again",Toast.LENGTH_SHORT).show();
                      }
//                   Toast.makeText(enter_otp.this,"otp verify",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(enter_otp.this,"Please enter all numbers",Toast.LENGTH_SHORT).show();
                }
            }
        });
        numberotpmove();



    }

    private void numberotpmove() {
        inputno1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    inputno2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        inputno2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    inputno3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        inputno3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    inputno4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        inputno4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    inputno5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        inputno5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    inputno6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}