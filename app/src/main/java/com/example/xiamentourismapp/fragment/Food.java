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
import android.widget.Spinner;

import com.example.xiamentourismapp.R;
import com.example.xiamentourismapp.adapter.HotelAdapter;
import com.example.xiamentourismapp.entity.Hotel;

import java.util.ArrayList;
import java.util.List;

public class Food extends Fragment
{
    private RecyclerView foodRecyclerView;
    private List<com.example.xiamentourismapp.entity.Food> foodList;
    private Spinner sortRating;
    private String[] foodRating;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        getActivity().setTitle("Food");
        return inflater.inflate(R.layout.fragment_food, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        // set view component
        foodRecyclerView = view.findViewById(R.id.foodRecyclerView);
        sortRating = view.findViewById(R.id.sortFoodRating);

        setRatingSortList();
        storeDataIntoHotelList();
        setUpRecyclerView();
    }

    private void setRatingSortList()
    {
        foodRating = getResources().getStringArray(R.array.exploreRating);
        ArrayAdapter<String> ratingAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, foodRating);
        ratingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sortRating.setAdapter(ratingAdapter);
    }

    private void setUpRecyclerView()
    {
        HotelAdapter hotelAdapter = new HotelAdapter(getActivity(), foodList, (AppCompatActivity) getActivity());
        foodRecyclerView.setAdapter(hotelAdapter);
        foodRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void storeDataIntoHotelList()
    {
        foodList = new ArrayList<>();
    }
}