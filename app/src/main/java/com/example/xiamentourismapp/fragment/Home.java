package com.example.xiamentourismapp.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.example.xiamentourismapp.R;
import com.example.xiamentourismapp.adapter.TopTenAdapter;
import com.example.xiamentourismapp.entity.TopTenTourism;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

public class Home extends Fragment
{
    private RecyclerView top10RecyclerView;
    private List<TopTenTourism> tourismList;
    private VideoView aboutXiamenVideo;
    private Uri uri;
    private MediaController mc;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        getActivity().setTitle("Home");
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        top10RecyclerView = view.findViewById(R.id.top10RecyclerView);
        aboutXiamenVideo = view.findViewById(R.id.aboutXiamenVideo);

        setUpVideo();
        storeDataIntoList();
        setUpRecyclerView();
    }

    private void setUpRecyclerView()
    {
        TopTenAdapter topTenAdapter = new TopTenAdapter(getActivity(),tourismList);
        top10RecyclerView.setAdapter(topTenAdapter);
        top10RecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void setUpVideo()
    {
        String path = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.about_xiamen;
        uri = Uri.parse(path);
        aboutXiamenVideo.setVideoURI(uri);

        mc = new MediaController(getActivity());
        aboutXiamenVideo.setMediaController(mc);
        mc.setAnchorView(aboutXiamenVideo);
    }

    private void storeDataIntoList()
    {
        tourismList = new ArrayList<>();
        tourismList.add(new TopTenTourism(R.drawable.gulangyu_island,"Top 1","Gulangyu Island","https://www.tripadvisor.com.my/Attraction_Review-g297407-d1131761-Reviews-Gulangyu_Island-Xiamen_Fujian.html"));
        tourismList.add(new TopTenTourism(R.drawable.zeng_cuo_an_village,"Top 2","Zeng Cuo An Village","https://www.inspirock.com/china/xiamen/zeng-cuo-an-village-a5102487141"));
        tourismList.add(new TopTenTourism(R.drawable.zhongshan_road_pedestrian_street,"Top 3","Zangshan Road Pedestrian Street","http://www.travelandlifestylediaries.com/2017/04/xiamen-china-zhongshan-lu-pedestrian.html?m=1"));
        tourismList.add(new TopTenTourism(R.drawable.xiamen_university,"Top 4","Xiamen University","https://www.china-admissions.com/xiamen-university/"));
        tourismList.add(new TopTenTourism(R.drawable.huandao_road,"Top 5","Huandao Road","https://www.shoreexcursions.asia/huandao-road-xiamen-ring-road/"));
        tourismList.add(new TopTenTourism(R.drawable.south_putuo_temple,"Top 6","South Putuo Temple","https://www.chinadiscovery.com/fujian/xiamen/south-putuo-temple.html"));
        tourismList.add(new TopTenTourism(R.drawable.shapowei_wind_shelter,"Top 7","Shapowei Wind Shelter","https://www.trip.com/travel-guide/attraction/xiamen/shapowei-wind-shelter-13765341/"));
        tourismList.add(new TopTenTourism(R.drawable.baicheng_beach,"Top 8","Baicheng Beach","https://www.triphobo.com/places/xiamen-china/baicheng-beach"));
        tourismList.add(new TopTenTourism(R.drawable.uncommon_place_art_space,"Top 9","Uncommon Place Art Space","https://www.trip.com/travel-guide/attraction/xiamen/uncommonplace-art-space-79439093/"));
        tourismList.add(new TopTenTourism(R.drawable.xiamen_botanical_garden,"Top 10","Xiamen Botanical Garden","https://www.triphobo.com/places/xiamen-china/xiamen-botanical-garden"));
    }
}