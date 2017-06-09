package com.kenneth.spoileralert.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.kenneth.spoileralert.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.emailEditText) EditText mEmailEditText;
    @Bind(R.id.passwordEditText) EditText mPasswordEditText;
    @Bind(R.id.loginButton) Button mLoginButton;
    @Bind(R.id.newUserTextView) TextView mNewUserTextView;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();

        mLoginButton.setOnClickListener(this);
        mNewUserTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if (v==mLoginButton){
           existingUserLogin();
        }
        if (v==mNewUserTextView){
            Intent intent = new Intent(LoginActivity.this,NewUserActivity.class);
            startActivity(intent);
        }
    }

    private void existingUserLogin(){
        String email = mEmailEditText.getText().toString().trim();
        String password = mPasswordEditText.getText().toString().trim();
        if (email.equals("")){
            mEmailEditText.setError("Please enter a valid email address");
            return;
        }
        if (password.equals("")){
            mPasswordEditText.setError("Password field is empty. Please fill it in");
        }
    }
}
