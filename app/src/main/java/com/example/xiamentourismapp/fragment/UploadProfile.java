package com.example.xiamentourismapp.fragment;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.xiamentourismapp.R;
import com.example.xiamentourismapp.constant.GetFragment;
import com.example.xiamentourismapp.constant.RequestCode;
import com.example.xiamentourismapp.manager.FragmentManager;
import com.example.xiamentourismapp.utils.Permissions;

public class UploadProfile extends Fragment
{
    private ImageView uploadBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        getActivity().setTitle("Upload Profile");
        setHasOptionsMenu(true);
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
                selectImgOptions();
            }
        });
    }

    private void selectImgOptions()
    {
        final CharSequence[] options = {"Snap photo", "Choose from gallery", "Cancel"};
        AlertDialog.Builder ad = new AlertDialog.Builder(getActivity());
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
                    getActivity().startActivityForResult(snapPhoto, RequestCode.SNAP_PHOTO);
                }

                else if (options[i].equals("Choose from gallery"))
                {
                    Intent chooseFromGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    getActivity().startActivityForResult(chooseFromGallery, RequestCode.CHOOSE_FROM_GALLERY);
                }

                else if (options[i].equals("Cancel"))
                {
                    dialogInterface.dismiss();
                }
            }
        });

        ad.show();
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
                        Bitmap capturedImg = (Bitmap) data.getExtras().get("data");
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

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater)
    {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.back_menu,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.backBtn)
        {
            FragmentManager.beginNewFragment((AppCompatActivity) getActivity(), GetFragment.getProfileFragment());
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}