package com.example.loginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class login extends AppCompatActivity {

    Button signout;
    GoogleSignInClient mGoogleSignInClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        signout=findViewById(R.id.sign_out);

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });

    }

    public void openFacebook(View v)
    {
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"));
        startActivity(intent);
    }
    public void openInstagram(View v1)
    {
        Intent instaintent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com"));
        startActivity(instaintent);
    }
    public void openLinkedin(View v2)
    {
        Intent linkedintent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com"));
        startActivity(linkedintent);
    }
    public void openTwitter(View v3)
    {
        Intent twitterintent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.twitter.com"));
        startActivity(twitterintent);
    }
    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // ...
                        Toast.makeText(login.this,"signout",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
    }

}
