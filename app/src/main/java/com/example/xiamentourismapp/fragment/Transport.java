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
import com.example.xiamentourismapp.adapter.TransportAdapter;
import java.util.ArrayList;
import java.util.List;

public class Transport extends Fragment
{
    private RecyclerView transportRecyclerView;
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
        TransportAdapter transportAdapter = new TransportAdapter(getActivity(), transportList, (AppCompatActivity) getActivity());
        transportRecyclerView.setAdapter(transportAdapter);
        transportRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void storeDataIntoList()
    {
        transportList = new ArrayList<>();
        transportList.add(new com.example.xiamentourismapp.entity.Transport(R.drawable.railway,"Xiamen Railway Station", "https://www.topchinatravel.com/xiamen/xiamen-railway-station.htm","01234"));
    }
}