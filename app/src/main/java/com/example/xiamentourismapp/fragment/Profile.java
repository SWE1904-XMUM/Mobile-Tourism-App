package com.example.xiamentourismapp.fragment;

import static android.Manifest.permission.CALL_PHONE;
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
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.xiamentourismapp.R;
import com.example.xiamentourismapp.activity.FragmentContainer;
import com.example.xiamentourismapp.activity.Login;
import com.example.xiamentourismapp.constant.GetFragment;
import com.example.xiamentourismapp.constant.RequestCode;
import com.example.xiamentourismapp.db.UserDb;
import com.example.xiamentourismapp.entity.User;
import com.example.xiamentourismapp.entity.UserProfile;
import com.example.xiamentourismapp.manager.FragmentManager;
import com.example.xiamentourismapp.manager.session.SessionManager;
import com.example.xiamentourismapp.utils.ImageUtil;
import com.example.xiamentourismapp.utils.Permissions;
import com.example.xiamentourismapp.utils.SelectImg;

import java.io.IOException;

public class Profile extends Fragment
{
    private TextView profileUname,profileEmail,profilePhoneNo;
    private Button editProfileBtn;
    private ImageView uploadProfileBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        getActivity().setTitle("Profile");
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        // set view component
        profileUname = view.findViewById(R.id.profileUname);
        profileEmail = view.findViewById(R.id.profileEmail);
        profilePhoneNo = view.findViewById(R.id.profilePhoneNo);
        editProfileBtn = view.findViewById(R.id.editProfileBtn);
        uploadProfileBtn = view.findViewById(R.id.uploadProfileBtn);

        // set profile text
        String uname = SessionManager.getUsername();
        User user = UserDb.getUserInfoByUsername(uname);
        profileUname.setText(uname);
        profileEmail.setText(user.email);
        profilePhoneNo.setText(user.phoneNo);

        // button click
        editProfileBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                FragmentManager.beginNewFragment((AppCompatActivity) getActivity(), GetFragment.getEditProfileFragment());
            }
        });

        uploadProfileBtn.setOnClickListener(new View.OnClickListener()
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
                        uploadProfileBtn.setImageBitmap(capturedImg);
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
                                uploadProfileBtn.setImageBitmap(BitmapFactory.decodeFile(imgPath));
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
        inflater.inflate(R.menu.profile_menu,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.logoutBtn)
        {
            SessionManager.setLogin(false);
            Intent loginPage = new Intent(getActivity(), Login.class);
            startActivity(loginPage);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}