package com.example.xiamentourismapp.entity;

import androidx.annotation.Nullable;

public class Hotel
{
    public Integer hotelId;
    public Integer hotelImage;
    public String hotelName;
    public Float hotelRating;
    public String hotelLink;
    public String hotelNo;

    public Hotel(@Nullable Integer hotelId, Integer hotelImage, String hotelName, Float hotelRating, String hotelLink, String hotelNo)
    {
        this.hotelId = hotelId;
        this.hotelImage = hotelImage;
        this.hotelName = hotelName;
        this.hotelRating = hotelRating;
        this.hotelLink = hotelLink;
        this.hotelNo = hotelNo;
    }
}
