package com.example.xiamentourismapp.utils.ui;

import android.content.Context;
import android.widget.Toast;

public class ToastCreator
{
    public static void createToast(Context context, String message)
    {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
