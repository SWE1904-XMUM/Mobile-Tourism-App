package com.example.xiamentourismapp.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;

import androidx.core.app.ActivityCompat;

import com.example.xiamentourismapp.constant.RequestCode;

public class Permissions
{
    public Permissions()
    {

    }

    public static void grantPhotoPermission(Context context)
    {
        ActivityCompat.requestPermissions((Activity) context, new String[]{ Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE }, RequestCode.PHOTO_PERMISSION);
    }
}
