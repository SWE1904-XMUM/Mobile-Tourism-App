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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.xiamentourismapp.R;
import com.example.xiamentourismapp.adapter.HotelAdapter;
import com.example.xiamentourismapp.db.HotelDb;
import com.example.xiamentourismapp.utils.comparator.SortComparator;

import java.util.ArrayList;
import java.util.List;

public class Hotel extends Fragment
{
    private RecyclerView hotelRecyclerView;
    private HotelAdapter hotelAdapter;
    private List<com.example.xiamentourismapp.entity.Hotel> hotelList;
    private Spinner sortRating;
    private String[] hotelRating;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        getActivity().setTitle("Hotel");
        return inflater.inflate(R.layout.fragment_hotel, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        // set view component
        hotelRecyclerView = view.findViewById(R.id.hotelRecyclerView);
        sortRating = view.findViewById(R.id.sortRating);

        setRatingSortList();
        storeDataIntoHotelList();
        setUpRecyclerView();

        // button click
        sortRating.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                int index = adapterView.getSelectedItemPosition();

                switch (index)
                {
                    case 0:
                        hotelList.sort(SortComparator.highestHotel);
                        hotelAdapter.notifyDataSetChanged();
                        break;

                    case 1:
                        hotelList.sort(SortComparator.lowestHotel);
                        hotelAdapter.notifyDataSetChanged();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });
    }

    private void setRatingSortList()
    {
        hotelRating = getResources().getStringArray(R.array.exploreRating);
        ArrayAdapter<String> ratingAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, hotelRating);
        ratingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sortRating.setAdapter(ratingAdapter);
    }

    private void setUpRecyclerView()
    {
        hotelAdapter = new HotelAdapter(getActivity(), hotelList, (AppCompatActivity) getActivity());
        hotelRecyclerView.setAdapter(hotelAdapter);
        hotelRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void storeDataIntoHotelList()
    {
        hotelList = new ArrayList<>();
        hotelList.add(new com.example.xiamentourismapp.entity.Hotel(null,R.drawable.lohkah_hotel,"Lohkah Hotel", 5.0F,"https://www.tripadvisor.com.my/Hotel_Review-g297407-d15197999-Reviews-Lohkah_Hotel_Spa-Xiamen_Fujian.html","01234"));
        hotelList.add(new com.example.xiamentourismapp.entity.Hotel(null,R.drawable.hampton,"Hampton by Hilton City Plaza",3.0F,"https://www.tripadvisor.com.my/Hotel_Review-g297407-d17387158-Reviews-Hampton_by_Hilton_City_Plaza-Xiamen_Fujian.html","32142"));
        hotelList.add(new com.example.xiamentourismapp.entity.Hotel(null,R.drawable.jingmin,"Jingmin Central Hotel",4.5F,"https://www.tripadvisor.com.my/Hotel_Review-g297407-d504806-Reviews-Jingmin_Central_Hotel-Xiamen_Fujian.html","267534"));
        hotelList.add(new com.example.xiamentourismapp.entity.Hotel(null,R.drawable.xige,"Xige Hotel",4.0F,"https://www.tripadvisor.com.my/Hotel_Review-g297407-d1138523-Reviews-Xige_Hotel-Xiamen_Fujian.html","636565"));
        hotelList.add(new com.example.xiamentourismapp.entity.Hotel(null,R.drawable.mercure,"Grand Mercure Xiamen Downtown",4.0F,"https://www.tripadvisor.com.my/Hotel_Review-g297407-d2327746-Reviews-Grand_Mercure_Xiamen_Downtown-Xiamen_Fujian.html","97875"));
        hotelList.add(new com.example.xiamentourismapp.entity.Hotel(null,R.drawable.hilton,"Hilton Xiamen",4.5F,"https://www.tripadvisor.com.my/Hotel_Review-g297407-d1139860-Reviews-Hilton_Xiamen-Xiamen_Fujian.html","997986"));
        hotelList.add(new com.example.xiamentourismapp.entity.Hotel(null,R.drawable.seaview,"Seaview Resort",5.0F,"https://www.tripadvisor.com.my/Hotel_Review-g297407-d674904-Reviews-Seaview_Resort-Xiamen_Fujian.html","325564"));
        hotelList.add(new com.example.xiamentourismapp.entity.Hotel(null,R.drawable.tiantian,"Tiantian Vacation International Hotel",3.5F,"https://www.tripadvisor.com.my/Hotel_Review-g297407-d4198437-Reviews-Tiantian_Vacation_International_Hotel-Xiamen_Fujian.html","456567"));
        hotelList.add(new com.example.xiamentourismapp.entity.Hotel(null,R.drawable.marriott,"Xiamen Marriott Hotel & Conference Centre",5.0F,"https://www.tripadvisor.com.my/Hotel_Review-g297407-d13480411-Reviews-Xiamen_Marriott_Hotel_Conference_Centre-Xiamen_Fujian.html","466756"));
        hotelList.add(new com.example.xiamentourismapp.entity.Hotel(null,R.drawable.marco_polo,"Marco Polo Xiamen",4.5F,"https://www.tripadvisor.com.my/Hotel_Review-g297407-d300847-Reviews-Marco_Polo_Xiamen-Xiamen_Fujian.html","3245346"));
    }
}