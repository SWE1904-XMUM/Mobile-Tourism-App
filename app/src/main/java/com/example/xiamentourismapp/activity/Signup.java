package com.example.xiamentourismapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.xiamentourismapp.R;
import com.example.xiamentourismapp.db.UserDb;
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
                boolean insertUser = UserDb.insertUser(unameTxt,emailTxt,phoneNoTxt,pwdTxt);

                if (insertUser == true)
                {
                    ToastCreator.createToast(getApplicationContext(),"Successfully signup!");
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
}