package com.example.xiamentourismapp.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.xiamentourismapp.R;
import com.example.xiamentourismapp.adapter.HotelAdapter;
import com.example.xiamentourismapp.constant.GetFragment;
import com.example.xiamentourismapp.entity.Hotel;
import com.example.xiamentourismapp.manager.FragmentManager;

import java.util.ArrayList;
import java.util.List;

public class Explore extends Fragment
{
    private ImageView hotelBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        getActivity().setTitle("Explore");
        return inflater.inflate(R.layout.fragment_explore, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        // set view component
        hotelBtn = view.findViewById(R.id.hotelBtn);

        // button click
        hotelBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                FragmentManager.beginNewFragment((AppCompatActivity) getActivity(), GetFragment.getHotelFragment());
            }
        });
    }
}