package com.example.xiamentourismapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.xiamentourismapp.R;
import com.example.xiamentourismapp.db.UserDb;
import com.example.xiamentourismapp.utils.ValidateEditText;
import com.example.xiamentourismapp.utils.ValidationUtil;
import com.example.xiamentourismapp.utils.ui.SnackbarCreator;
import com.example.xiamentourismapp.utils.ui.ToastCreator;

public class Signup extends AppCompatActivity
{
    private EditText signupUname,signupEmail,signupPhoneNo,signupPwd;
    private Button signupBtn;
    private String unameTxt,emailTxt,phoneNoTxt,pwdTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        setViewComponent();

        signupBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                updateTextView();

                if (!validateField(view))
                {
                    return;
                }

                if(UserDb.checkExistingUsername(unameTxt))
                {
                    ValidateEditText.setErrorBackgroundAndMessage(view,signupUname,"Username already exist, please try another.",getApplicationContext());
                    return;
                }

                if(UserDb.checkExistingEmail(emailTxt))
                {
                    ValidateEditText.setErrorBackgroundAndMessage(view,signupUname,"Email already exist, please try another.",getApplicationContext());
                    return;
                }

                boolean insertUser = UserDb.insertUser(unameTxt,emailTxt,phoneNoTxt,pwdTxt);

                if (insertUser == true)
                {
                    ToastCreator.createToast(getApplicationContext(),"Successfully signup!");
                    new Handler().postDelayed(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            startActivity(new Intent(Signup.this, Login.class));
                        }
                    }, 1000);
                }

                else
                {
                    ToastCreator.createToast(getApplicationContext(),"Fail to signup");
                }
            }
        });
    }

    private void setViewComponent()
    {
        signupUname = findViewById(R.id.signupUname);
        signupEmail = findViewById(R.id.signupEmail);
        signupPhoneNo = findViewById(R.id.signupPhoneNo);
        signupPwd = findViewById(R.id.signupPwd);
        signupBtn = findViewById(R.id.signupBtn);
    }

    private void updateTextView()
    {
        unameTxt = signupUname.getText().toString();
        emailTxt = signupEmail.getText().toString();
        phoneNoTxt = signupPhoneNo.getText().toString();
        pwdTxt = signupPwd.getText().toString();
    }

    private boolean validateField(View view)
    {
        if (!ValidateEditText.validateUnameField(getApplicationContext(),view,signupUname,unameTxt))
        {
            return false;
        }

        if (!ValidateEditText.validateEmailField(getApplicationContext(),view,signupEmail,emailTxt))
        {
            return false;
        }

        if (!ValidateEditText.validatePhoneNoField(getApplicationContext(),view,signupPhoneNo,phoneNoTxt))
        {
            return false;
        }

        if (!ValidateEditText.validatePasswordField(getApplicationContext(),view,signupPwd,pwdTxt))
        {
            return false;
        }

        else
        {
            return true;
        }
    }
}