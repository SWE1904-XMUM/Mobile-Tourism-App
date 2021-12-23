package com.example.xiamentourismapp.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.xiamentourismapp.constant.RequestCode;

import java.io.File;

public class SelectImg
{
    public SelectImg()
    {

    }

    public static void selectImgOptions(Context context, AppCompatActivity activity)
    {
        final CharSequence[] options = {"Snap photo", "Choose from gallery", "Cancel"};
        AlertDialog.Builder ad = new AlertDialog.Builder(context);
        ad.setTitle("Upload photo");

        ad.setItems(options, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                if (options[i].equals("Snap photo"))
                {
                    Intent snapPhoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    /*File f = new File(Environment.getExternalStorageDirectory(),"DCIM/Camera/img.jpg");
                    snapPhoto.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));*/
                    activity.startActivityForResult(snapPhoto, RequestCode.SNAP_PHOTO);
                }

                else if (options[i].equals("Choose from gallery"))
                {
                    Intent chooseFromGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    activity.startActivityForResult(chooseFromGallery, RequestCode.CHOOSE_FROM_GALLERY);
                }

                else if (options[i].equals("Cancel"))
                {
                    dialogInterface.dismiss();
                }
            }
        });

        ad.show();
    }
}
