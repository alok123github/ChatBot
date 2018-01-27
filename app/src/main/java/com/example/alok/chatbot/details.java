package com.example.alok.chatbot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class details extends AppCompatActivity {
    WebView browser;
    TextView email,name,phone;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        browser=(WebView)findViewById(R.id.browser);
        email=(TextView)findViewById(R.id.email);
        name=(TextView)findViewById(R.id.name);
        phone=(TextView)findViewById(R.id.phone);
        mAuth=FirebaseAuth.getInstance();

        email.setText(mAuth.getCurrentUser().getEmail().toString());
        phone.setText("+91"+mAuth.getCurrentUser().getPhoneNumber().toString());
        name.setText(mAuth.getCurrentUser().getDisplayName().toString());

        String ip=getIntent().getStringExtra("inp");
        browser.loadUrl(ip);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.setWebViewClient(new WebViewClient());



    }
}
