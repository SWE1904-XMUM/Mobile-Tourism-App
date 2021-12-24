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
        foodList.add(new com.example.xiamentourismapp.entity.Food(R.drawable.fragrance,"Fragrance Tea Palace",4.9F, "https://www.trip.com/travel-guide/xiamen-21-restaurant/fragrance-tea-palace-31532292/","0592-5023333"));
        foodList.add(new com.example.xiamentourismapp.entity.Food(R.drawable.di_zhong_hai,"Seaview Resort Xiamen Di Zhong Hai Cafe",4.4F, "https://www.trip.com/travel-guide/xiamen-21-restaurant/seaview-resort-xiamendi-zhong-hai-cafe-25661457/","0592-5023333-7771"));
        foodList.add(new com.example.xiamentourismapp.entity.Food(R.drawable.yuehua,"Yue Hua Hotel Restaurant",4.6F, "https://www.trip.com/travel-guide/xiamen-21-restaurant/xiamenyuehuajiudianlvtingzhutizizhu-restaurant-11308623/","0592-6028888"));
        foodList.add(new com.example.xiamentourismapp.entity.Food(R.drawable.haomatou,"38Haomatou Restaurant", 4.7F,"https://www.trip.com/travel-guide/xiamen-21-restaurant/38haomatou-restaurant-31217438/","0592-2562256"));
        foodList.add(new com.example.xiamentourismapp.entity.Food(R.drawable.little_dew,"LittleDew Coffee Bar",4.0F, "https://www.trip.com/travel-guide/xiamen-21-restaurant/littledew-coffee-bar-57249374/","1855902611018650161894"));
        foodList.add(new com.example.xiamentourismapp.entity.Food(R.drawable.latest,"Latest Recipe Restaurant", 4.6F,"https://www.trip.com/travel-guide/xiamen-21-restaurant/latest-recipe-restaurant-11309455/","0592-7709179"));
        foodList.add(new com.example.xiamentourismapp.entity.Food(R.drawable.shang_shan,"Shang Shan Restaurant",4.7F, "https://www.trip.com/travel-guide/xiamen-21-restaurant/shang-shan-zhong-guo-chu-fang-33533165/","0592-5159698"));
        foodList.add(new com.example.xiamentourismapp.entity.Food(R.drawable.shang_qing,"Shang Qing Ben Gang Seafood", 4.7F,"https://www.trip.com/travel-guide/xiamen-21-restaurant/shang-qing-ben-gang-seafood-11315853/","0592-2082008"));
        foodList.add(new com.example.xiamentourismapp.entity.Food(R.drawable.yuefu,"Yue Fu Restaurant", 4.4F,"https://www.trip.com/travel-guide/xiamen-21-restaurant/yue-fu-11312059/", "0592-2351673"));
        foodList.add(new com.example.xiamentourismapp.entity.Food(R.drawable.tianyuan,"Tian Yuan Hotel Restaurant",4.8F, "https://www.trip.com/travel-guide/xiamen-21-restaurant/tianyuanjiudianzizhu-restaurant-57275361/", "0592-5663999"));
    }
}