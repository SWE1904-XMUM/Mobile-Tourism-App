package com.example.xiamentourismapp.utils.ui;

import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class SnackbarCreator
{
    public static void createSnackbar(View view, String message)
    {
        Snackbar sb = Snackbar.make(view,message,Snackbar.LENGTH_LONG);
        sb.show();
    }
}
