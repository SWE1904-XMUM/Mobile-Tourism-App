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
import com.example.xiamentourismapp.adapter.FoodAdapter;
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
        storeDataIntoFoodList();
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
        FoodAdapter foodAdapter = new FoodAdapter(getActivity(), foodList, (AppCompatActivity) getActivity());
        foodRecyclerView.setAdapter(foodAdapter);
        foodRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void storeDataIntoFoodList()
    {
        foodList = new ArrayList<>();
        foodList.add(new com.example.xiamentourismapp.entity.Food(R.drawable.fragrance,"Fragrance Tea Palace", "https://www.trip.com/travel-guide/xiamen-21-restaurant/fragrance-tea-palace-31532292/","01234"));
    }
}