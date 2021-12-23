package com.example.xiamentourismapp.utils.ui;

import android.content.Context;
import android.content.DialogInterface;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

public class AlertDialogCreator
{
    public static AlertDialog createAlertDialog(Context context, @Nullable String title,
                                                @Nullable String message,
                                                @Nullable String positiveButtonText,
                                                @Nullable DialogInterface.OnClickListener positive_onClickListener,
                                                @Nullable String negativeButtonText,
                                                @Nullable DialogInterface.OnClickListener negative_onClickListener)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title).setMessage(message).setPositiveButton(positiveButtonText, positive_onClickListener).setNegativeButton(negativeButtonText, negative_onClickListener);

        return builder.create();
    }
}
