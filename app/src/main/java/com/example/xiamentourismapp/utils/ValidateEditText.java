package com.example.xiamentourismapp.utils;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import com.example.xiamentourismapp.R;
import com.example.xiamentourismapp.utils.ui.SnackbarCreator;

public class ValidateEditText
{
    public ValidateEditText()
    {

    }

    public static boolean validateUnameField(Context context, View view, EditText uname, String unameTxt)
    {
        if (unameTxt.equals(""))
        {
            setErrorBackgroundAndMessage(view,uname,"Please fill in username.",context);
            return false;
        }

        else if (!ValidationUtil.validateUsername(unameTxt))
        {
            setErrorBackgroundAndMessage(view,uname,"Invalid username.",context);
            return false;
        }

        else
        {
            resetBackground(uname,context);
            return true;
        }
    }

    public static boolean validateEmailField(Context context,View view,EditText email,String emailTxt)
    {
        if (emailTxt.equals(""))
        {
            setErrorBackgroundAndMessage(view,email,"Please fill in email.",context);
            return false;
        }

        else if (!ValidationUtil.validateEmail(emailTxt))
        {
            setErrorBackgroundAndMessage(view,email,"Invalid email.",context);
            return false;
        }

        else
        {
            resetBackground(email,context);
            return true;
        }
    }

    public static boolean validatePhoneNoField(Context context,View view,EditText phoneNo,String phoneNoTxt)
    {
        if (phoneNoTxt.equals(""))
        {
            setErrorBackgroundAndMessage(view,phoneNo,"Please fill in phone number.",context);
            return false;
        }

        else if (!ValidationUtil.validatePhoneNumber(phoneNoTxt))
        {
            setErrorBackgroundAndMessage(view,phoneNo,"Invalid phone number.",context);
            return false;
        }

        else
        {
            resetBackground(phoneNo,context);
            return true;
        }
    }

    public static boolean validatePasswordField(Context context,View view,EditText pwd,String pwdTxt)
    {
        if (pwdTxt.equals(""))
        {
            setErrorBackgroundAndMessage(view,pwd,"Please fill in password.",context);
            return false;
        }

        else if (!ValidationUtil.validatePassword(pwdTxt))
        {
            setErrorBackgroundAndMessage(view,pwd,"Invalid password.",context);
            return false;
        }

        else
        {
            resetBackground(pwd,context);
            return true;
        }
    }

    public static void setErrorBackgroundAndMessage(View view,EditText editText,String message,Context context)
    {
        editText.setBackgroundColor(context.getResources().getColor(R.color.error_background));
        SnackbarCreator.createSnackbar(view,message);
    }

    public static void resetBackground(EditText editText,Context context)
    {
        editText.setBackgroundColor(context.getResources().getColor(R.color.grey));
    }
}
