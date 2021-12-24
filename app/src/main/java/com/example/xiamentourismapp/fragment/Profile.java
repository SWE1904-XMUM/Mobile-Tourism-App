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
import android.widget.ImageView;
import android.widget.TextView;
import com.example.xiamentourismapp.R;
import com.example.xiamentourismapp.activity.Login;
import com.example.xiamentourismapp.constant.GetFragment;
import com.example.xiamentourismapp.db.UserDb;
import com.example.xiamentourismapp.entity.User;
import com.example.xiamentourismapp.manager.FragmentManager;
import com.example.xiamentourismapp.manager.session.SessionManager;

public class Profile extends Fragment
{
    private TextView profileUname,profileEmail,profilePhoneNo;
    private Button editProfileBtn;

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