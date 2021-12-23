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
import com.example.xiamentourismapp.R;
import com.example.xiamentourismapp.adapter.HotelAdapter;
import com.example.xiamentourismapp.entity.Hotel;
import java.util.ArrayList;
import java.util.List;

public class Explore extends Fragment
{
    private RecyclerView hotelRecyclerView;
    private List<Hotel> hotelList;

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
        hotelRecyclerView = view.findViewById(R.id.hotelRecyclerView);

        storeDataIntoList();
        setUpRecyclerView();
    }

    private void setUpRecyclerView()
    {
        HotelAdapter hotelAdapter = new HotelAdapter(getActivity(), hotelList, (AppCompatActivity) getActivity());
        hotelRecyclerView.setAdapter(hotelAdapter);
        hotelRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void storeDataIntoList()
    {
        hotelList = new ArrayList<>();
        hotelList.add(new Hotel(R.drawable.lohkah_hotel,"Lohkah Hotel", 5.0F,"https://www.tripadvisor.com.my/Hotel_Review-g297407-d15197999-Reviews-Lohkah_Hotel_Spa-Xiamen_Fujian.html","01234"));
        hotelList.add(new Hotel(R.drawable.hampton,"Hampton by Hilton City Plaza",3.0F,"https://www.tripadvisor.com.my/Hotel_Review-g297407-d17387158-Reviews-Hampton_by_Hilton_City_Plaza-Xiamen_Fujian.html","32142"));
        hotelList.add(new Hotel(R.drawable.jingmin,"Jingmin Central Hotel",4.5F,"https://www.tripadvisor.com.my/Hotel_Review-g297407-d504806-Reviews-Jingmin_Central_Hotel-Xiamen_Fujian.html","267534"));
        hotelList.add(new Hotel(R.drawable.xige,"Xige Hotel",4.0F,"https://www.tripadvisor.com.my/Hotel_Review-g297407-d1138523-Reviews-Xige_Hotel-Xiamen_Fujian.html","636565"));
        hotelList.add(new Hotel(R.drawable.mercure,"Grand Mercure Xiamen Downtown",4.0F,"https://www.tripadvisor.com.my/Hotel_Review-g297407-d2327746-Reviews-Grand_Mercure_Xiamen_Downtown-Xiamen_Fujian.html","97875"));
        hotelList.add(new Hotel(R.drawable.hilton,"Hilton Xiamen",4.5F,"https://www.tripadvisor.com.my/Hotel_Review-g297407-d1139860-Reviews-Hilton_Xiamen-Xiamen_Fujian.html","997986"));
        hotelList.add(new Hotel(R.drawable.seaview,"Seaview Resort",5.0F,"https://www.tripadvisor.com.my/Hotel_Review-g297407-d674904-Reviews-Seaview_Resort-Xiamen_Fujian.html","325564"));
        hotelList.add(new Hotel(R.drawable.tiantian,"Tiantian Vacation International Hotel",3.5F,"https://www.tripadvisor.com.my/Hotel_Review-g297407-d4198437-Reviews-Tiantian_Vacation_International_Hotel-Xiamen_Fujian.html","456567"));
        hotelList.add(new Hotel(R.drawable.marriott,"Xiamen Marriott Hotel & Conference Centre",5.0F,"https://www.tripadvisor.com.my/Hotel_Review-g297407-d13480411-Reviews-Xiamen_Marriott_Hotel_Conference_Centre-Xiamen_Fujian.html","466756"));
        hotelList.add(new Hotel(R.drawable.marco_polo,"Marco Polo Xiamen",4.5F,"https://www.tripadvisor.com.my/Hotel_Review-g297407-d300847-Reviews-Marco_Polo_Xiamen-Xiamen_Fujian.html","3245346"));
    }
}