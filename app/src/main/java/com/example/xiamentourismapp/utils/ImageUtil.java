package com.example.xiamentourismapp.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

public class ImageUtil
{
    public static Bitmap imagePathToBitmap(String imagePath)
    {
        if(imagePath.equals(""))
        {
            return null;
        }
        return BitmapFactory.decodeFile(imagePath);
    }

    public static ByteArrayOutputStream getJpegBitmapOutputStream(Bitmap bitmap)
    {
        if(bitmap == null)
        {
            return null;
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
        return out;
    }

    public static byte[] outputStreamToByteArray(ByteArrayOutputStream out)
    {
        if(out == null)
        {
            return null;
        }
        return out.toByteArray();
    }

    public static byte[] imagePathToByteArray(String imagePath)
    {
        if(imagePath.equals(""))
        {
            return null;
        }
        return bitmapToByteArray(imagePathToBitmap(imagePath));
    }

    public static byte[] bitmapToByteArray(Bitmap bitmap)
    {
        if(bitmap == null)
        {
            return null;
        }
        ByteArrayOutputStream out = getJpegBitmapOutputStream(bitmap);
        return outputStreamToByteArray(out);
    }

    public static Bitmap byteArrayToBitmap(byte[] bytes)
    {
        if(bytes == null)
        {
            return null;
        }
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }
}
