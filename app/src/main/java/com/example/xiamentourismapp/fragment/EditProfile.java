package com.example.xiamentourismapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.xiamentourismapp.R;
import com.example.xiamentourismapp.activity.FragmentContainer;
import com.example.xiamentourismapp.activity.Login;
import com.example.xiamentourismapp.constant.GetFragment;
import com.example.xiamentourismapp.db.UserDb;
import com.example.xiamentourismapp.entity.User;
import com.example.xiamentourismapp.manager.FragmentManager;
import com.example.xiamentourismapp.manager.session.SessionManager;
import com.example.xiamentourismapp.utils.ui.ToastCreator;

public class EditProfile extends Fragment
{
    private TextView editUname,editEmail,editPhoneNo,editPwd;
    private String editEmailTxt,editPhoneNoTxt,editPwdTxt;
    private Button updateProfileBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        getActivity().setTitle("Edit Profile");
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_edit_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        // set view component
        editUname = view.findViewById(R.id.editUname);
        editEmail = view.findViewById(R.id.editEmail);
        editPhoneNo = view.findViewById(R.id.editPhoneNo);
        editPwd = view.findViewById(R.id.editPwd);
        updateProfileBtn = view.findViewById(R.id.updateProfileBtn);

        // display profile from db
        String uname = SessionManager.getUsername();
        User user = UserDb.getUserInfoByUsername(uname);
        editUname.setText(uname);
        editUname.setEnabled(false);
        editEmail.setText(user.email);
        editPhoneNo.setText(user.phoneNo);
        editPwd.setText(user.password);

        // button click
        updateProfileBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                updateTextView();
                String uname = SessionManager.getUsername();
                boolean updateProfile = UserDb.updateUserProfile(uname,editEmailTxt,editPhoneNoTxt,editPwdTxt);

                if (updateProfile)
                {
                    ToastCreator.createToast(getActivity(),"Successfully updated!");
                    FragmentManager.beginNewFragment((FragmentContainer) getActivity(), GetFragment.getProfileFragment());
                }
            }
        });
    }

    private void updateTextView()
    {
        editEmailTxt = editEmail.getText().toString();
        editPhoneNoTxt = editPhoneNo.getText().toString();
        editPwdTxt = editPwd.getText().toString();
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