package com.example.xiamentourismapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import com.example.xiamentourismapp.R;
import com.example.xiamentourismapp.constant.GetFragment;
import com.example.xiamentourismapp.manager.FragmentManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FragmentContainer extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);

        BottomNavigationView btmNav = findViewById(R.id.btmNav);
        btmNav.setOnNavigationItemSelectedListener(navListener);

        FragmentManager.beginNewFragment(this, GetFragment.getHomeFragment());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener()
    {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item)
        {
            switch (item.getItemId())
            {
                case R.id.home:
                    item.setChecked(true);
                    FragmentManager.beginNewFragment(FragmentContainer.this, GetFragment.getHomeFragment());
                    break;

                case R.id.explore:
                    item.setChecked(true);
                    FragmentManager.beginNewFragment(FragmentContainer.this, GetFragment.getExploreFragment());
                    break;

                case R.id.bookmarks:
                    item.setChecked(true);
                    FragmentManager.beginNewFragment(FragmentContainer.this, GetFragment.getBookmarksFragment());
                    break;

                case R.id.profile:
                    item.setChecked(true);
                    FragmentManager.beginNewFragment(FragmentContainer.this, GetFragment.getProfileFragment());
                    break;
            }
            return false;
        }
    };
}