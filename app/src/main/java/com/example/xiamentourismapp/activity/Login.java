package com.example.xiamentourismapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.xiamentourismapp.R;
import com.example.xiamentourismapp.db.UserDb;
import com.example.xiamentourismapp.manager.session.SessionManager;
import com.example.xiamentourismapp.utils.ValidateUserProfile;
import com.example.xiamentourismapp.utils.ui.SnackbarCreator;

public class Login extends AppCompatActivity
{
    private Button loginBtn,signUpBtn;
    private EditText loginUname,loginPwd;
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

                String loginUname = "";

                try
                {
                    loginUname = SessionManager.getUsername();
                }

                catch (Exception e)
                {
                    e.printStackTrace();
                }

                if (!loginUname.equals(""))
                {
                    loginUser();
                    finish();
                }

                if (!validateUser(view))
                {
                    return;
                }

                else
                {
                    boolean checkUserExistence = UserDb.checkExistingUsername(loginUnameTxt);

                    if (checkUserExistence == false)
                    {
                        SnackbarCreator.createSnackbar(view,"Not an existing user, please sign up.");

                        new Handler().postDelayed(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                Intent signUp = new Intent(Login.this,Signup.class);
                                startActivity(signUp);
                            }
                        },1000);
                    }

                    else
                    {
                        boolean verify = UserDb.verifyUser(loginUnameTxt,loginPwdTxt);

                        if (verify)
                        {
                            loginUser();
                        }

                        else
                        {
                            SnackbarCreator.createSnackbar(view,"Invalid username or password!");
                        }
                    }
                }
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

    private void loginUser()
    {
        SessionManager.setSession(loginUnameTxt,getApplicationContext());
        SessionManager.setUsername(loginUnameTxt);
        Intent home = new Intent(Login.this, FragmentContainer.class);
        startActivity(home);
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

    private boolean validateUser(View view)
    {
        if (loginUnameTxt.equals(""))
        {
            ValidateUserProfile.setErrorBackgroundAndMessage(view,loginUname,"Please fill in username.",getApplicationContext());
            return false;
        }

        if (loginPwdTxt.equals(""))
        {
            ValidateUserProfile.setErrorBackgroundAndMessage(view,loginPwd,"Please fill in password.",getApplicationContext());
            return false;
        }

        else
        {
            return true;
        }
    }
}