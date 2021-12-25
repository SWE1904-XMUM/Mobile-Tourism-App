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
import com.example.xiamentourismapp.adapter.TransportAdapter;
import com.example.xiamentourismapp.utils.comparator.SortComparator;

import java.util.ArrayList;
import java.util.List;

public class Transport extends Fragment
{
    private RecyclerView transportRecyclerView;
    private TransportAdapter transportAdapter;
    private List<com.example.xiamentourismapp.entity.Transport> transportList;
    private Spinner sort;
    private String[] transportSort;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        getActivity().setTitle("Transport");
        return inflater.inflate(R.layout.fragment_transport, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        // set view component
        transportRecyclerView = view.findViewById(R.id.transportRecyclerView);
        sort = view.findViewById(R.id.sortTransport);

        setRatingSortList();
        storeDataIntoList();
        setUpRecyclerView();

        // button click
        sort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                int index = adapterView.getSelectedItemPosition();

                switch (index)
                {
                    case 0:
                        transportList.sort(SortComparator.descending);
                        transportAdapter.notifyDataSetChanged();
                        break;

                    case 1:
                        transportList.sort(SortComparator.ascending);
                        transportAdapter.notifyDataSetChanged();
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
        transportSort = getResources().getStringArray(R.array.sort);
        ArrayAdapter<String> ratingAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, transportSort);
        ratingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sort.setAdapter(ratingAdapter);
    }

    private void setUpRecyclerView()
    {
        transportAdapter = new TransportAdapter(getActivity(), transportList, (AppCompatActivity) getActivity());
        transportRecyclerView.setAdapter(transportAdapter);
        transportRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void storeDataIntoList()
    {
        transportList = new ArrayList<>();
        transportList.add(new com.example.xiamentourismapp.entity.Transport(null,R.drawable.railway,"Xiamen Railway Station", "https://www.topchinatravel.com/xiamen/xiamen-railway-station.htm","97988758"));
        transportList.add(new com.example.xiamentourismapp.entity.Transport(null,R.drawable.bus,"FTBCI Bus", "http://ftbcibus.com/","0086-592-6880895"));
        transportList.add(new com.example.xiamentourismapp.entity.Transport(null,R.drawable.airport,"Xiamen Gaoqi International Airport", "https://www.flightradar24.com/data/airports/xmn","+865925736975"));
        transportList.add(new com.example.xiamentourismapp.entity.Transport(null,R.drawable.ferry,"Xiamen Ferry to Gulangyu Island", "https://www.chinadiscovery.com/xiamen-tours/transportation/get-to-gulangyu-island.html","35476575"));
        transportList.add(new com.example.xiamentourismapp.entity.Transport(null,R.drawable.cable,"Zhonggu Cableway", "https://www.trip.com/travel-guide/attraction/xiamen/zhonggu-cableway-10521056/","9979652"));
    }
}