package com.example.xiamentourismapp.entity;

public class TopTenTourism
{
    public Integer tourismImg;
    public String tourismName;
    public String tourismDescriptions;
    public String tourismLink;

    public TopTenTourism(Integer tourismImg,String tourismName, String tourismDescriptions, String tourismLink)
    {
        this.tourismImg = tourismImg;
        this.tourismName = tourismName;
        this.tourismDescriptions = tourismDescriptions;
        this.tourismLink = tourismLink;
    }
}
