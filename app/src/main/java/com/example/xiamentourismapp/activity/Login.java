package com.example.xiamentourismapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.xiamentourismapp.R;
import com.example.xiamentourismapp.manager.session.SessionManager;

public class Login extends AppCompatActivity
{
    private Button loginBtn,signUpBtn;
    private TextView loginUname,loginPwd;
    private String loginUnameTxt,loginPwdTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        setViewComponent();

        loginBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                updateTextView();
                SessionManager.setSession(loginUnameTxt,getApplicationContext());
                SessionManager.setLogin(true);
                SessionManager.setUsername(loginUnameTxt);
                Intent home = new Intent(Login.this, FragmentContainer.class);
                startActivity(home);
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent signup = new Intent(Login.this, Signup.class);
                startActivity(signup);
            }
        });
    }

    private void setViewComponent()
    {
        signUpBtn = findViewById(R.id.signUpBtn);
        loginBtn = findViewById(R.id.loginBtn);
        loginUname = findViewById(R.id.loginUname);
        loginPwd = findViewById(R.id.loginPwd);
    }

    private void updateTextView()
    {
        loginUnameTxt = loginUname.getText().toString();
        loginPwdTxt = loginPwd.getText().toString();
    }
}