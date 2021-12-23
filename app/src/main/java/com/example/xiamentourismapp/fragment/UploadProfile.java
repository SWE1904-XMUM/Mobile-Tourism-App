package com.example.xiamentourismapp.fragment;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.xiamentourismapp.R;
import com.example.xiamentourismapp.constant.RequestCode;
import com.example.xiamentourismapp.utils.Permissions;
import com.example.xiamentourismapp.utils.SelectImg;

public class UploadProfile extends Fragment
{
    private ImageView uploadBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        getActivity().setTitle("Upload Profile");
        return inflater.inflate(R.layout.fragment_upload_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        // set view component
        uploadBtn = view.findViewById(R.id.uploadBtn);

        uploadBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
                {
                    Permissions.grantPhotoPermission(getActivity());
                }
                SelectImg.selectImgOptions(getActivity(), (AppCompatActivity) getActivity());
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != RESULT_CANCELED)
        {
            switch (requestCode)
            {
                case RequestCode.SNAP_PHOTO:
                    if (resultCode == RESULT_OK && data != null)
                    {
                        Bitmap capturedImg = (Bitmap) data.getExtras().get(String.valueOf(data));
                        uploadBtn.setImageBitmap(capturedImg);
                        //items.get(clickedItem).image = ImageUtil.bitmapToByteArray(capturedImg);
                    }
                    break;

                case RequestCode.CHOOSE_FROM_GALLERY:
                    if (resultCode == RESULT_OK && data != null)
                    {
                        Uri selectedImage = data.getData();
                        String[] filePath = {MediaStore.Images.Media.DATA};

                        if (selectedImage != null)
                        {
                            Cursor cursor = getActivity().getContentResolver().query(selectedImage,filePath,null,null,null);

                            if (cursor != null)
                            {
                                cursor.moveToFirst();

                                int colInd = cursor.getColumnIndex(filePath[0]);
                                String imgPath = cursor.getString(colInd);
                                uploadBtn.setImageBitmap(BitmapFactory.decodeFile(imgPath));
                                cursor.close();
                            }
                        }

                        /*if (selectedImage != null)
                        {
                            Cursor cursor = getContentResolver().query(selectedImage, filePath, null, null, null);

                            if (cursor != null)
                            {
                                cursor.moveToFirst();

                                int colInd = cursor.getColumnIndex(filePath[0]);
                                String imgPath = cursor.getString(colInd);

                                try
                                {
                                    //items.get(clickedItem).image = ImageUtil.bitmapToByteArray(MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage));
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                cursor.close();
                            }
                        }*/
                    }
                    break;
            }
        }
    }
}