package com.example.govconnect;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.govconnect.R;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private Button LoginButton;
    private ImageView googleSignInButton;
    private EditText UserEmail, UserPassword;
    private TextView NeedNewAccountLink;
    private ProgressDialog loadingBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth=FirebaseAuth.getInstance();

        NeedNewAccountLink = (TextView) findViewById(R.id.register_account);
        UserEmail = (EditText) findViewById(R.id.login_email);
        UserPassword = (EditText) findViewById(R.id.login_password);
        LoginButton = (Button) findViewById(R.id.login_button);
        //googleSignInButton = (ImageView) findViewById(R.id.google_signin_button);
        loadingBar = new ProgressDialog(this);

        NeedNewAccountLink.setOnClickListener(new View.OnClickListener() {
                                                  @Override
                                                  public void onClick(View view) {
                                                      SendUserToRegisterActivity();
                                                  }
                                              });
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Allowlogin();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
           sendusertomainactivity();
        }
    }



    private void Allowlogin(){
        String email=UserEmail.getText().toString();
        String password=UserPassword.getText().toString();
        if (TextUtils.isEmpty(email))
        {
       Toast.makeText(this,"Please enter your email....",Toast.LENGTH_SHORT).show();
        }
        else  if (TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter your password....",Toast.LENGTH_SHORT).show();
        }
        else
        {

            loadingBar.setTitle("Login");
            loadingBar.setMessage("Please wait, while we are logging into your Account...");
            loadingBar.show();
            loadingBar.setCanceledOnTouchOutside(true);

         mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                                                                    @Override
                                                                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                                                                    if(task.isSuccessful()){
                                                                                        sendusertomainactivity();
                                                                                        Toast.makeText(LoginActivity.this,"You are logged in succesfully...",Toast.LENGTH_SHORT).show();
                                                                                        loadingBar.dismiss();
                                                                                    }
                                                                                    else {
                                                                                        String message=task.getException().getMessage();
                                                                                        Toast.makeText(LoginActivity.this,"Error occured : "+message,Toast.LENGTH_SHORT).show();
                                                                                        loadingBar.dismiss();
                                                                                    }
                                                                                    }
                                                                                }
         );
        }
    }

    private void sendusertomainactivity() {
        Intent mainIntent = new Intent(LoginActivity.this,MainActivity.class);
        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |  Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(mainIntent);
        finish();

    }

    private void SendUserToRegisterActivity() {
        Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(registerIntent);
    }

}
