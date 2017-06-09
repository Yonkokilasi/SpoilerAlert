package com.kenneth.spoileralert.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kenneth.spoileralert.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewUserActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.emailEditText) EditText mEmailEditText;
    @Bind(R.id.passwordEditText) EditText mPasswordEditText;
    @Bind(R.id.confirmPasswordEditText) EditText mConfirmPasswordEditText;
    @Bind(R.id.newUserSubmitButton) Button mNewUserSubmitButton;
    @Bind(R.id.userLoginTextView) TextView mUserLoginTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        ButterKnife.bind(this);

        mNewUserSubmitButton.setOnClickListener(this);
        mUserLoginTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if (v==mNewUserSubmitButton){
            Toast.makeText(this, "Submit User Here", Toast.LENGTH_SHORT).show();
        }
        if (v==mUserLoginTextView){
            Intent intent = new Intent(NewUserActivity.this,LoginActivity.class);
            startActivity(intent);
        }
    }
}
