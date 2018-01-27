package com.example.alok.chatbot;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class Main2 extends AppCompatActivity {


    Menu  signout,about,profile;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }



    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       // signoutBtn=(Button)findViewById(R.id.signoutBtn);
       // browser=(WebView)findViewById(R.id.browser);
        signout=(Menu)findViewById(R.id.signout);
        about=(Menu)findViewById(R.id.about);
        profile=(Menu)findViewById(R.id.profile);
        mAuth=FirebaseAuth.getInstance();

        /*String ip=getIntent().getStringExtra("input");
        //Toast.makeText(this, ip, Toast.LENGTH_SHORT).show();
        browser.loadUrl(ip);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.setWebViewClient(new WebViewClient());*/

        mAuthListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser()==null)
                {
                    Intent i=new Intent(Main2.this,MainActivity.class);
                    startActivity(i);

                }
            }
        };





        /*signoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();

            }
        });*/
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.signout) {
            mAuth.signOut();
        }
         if (id==R.id.profile)
        {
            FirebaseAuth.getInstance();
            Intent i=new Intent(Main2.this,details.class);
            i.putExtra("inp",mAuth.getCurrentUser().getPhotoUrl().toString());
            startActivity(i);
        }
        if (id==R.id.about)
        {
            Toast.makeText(this, "I am in about section...", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

}
