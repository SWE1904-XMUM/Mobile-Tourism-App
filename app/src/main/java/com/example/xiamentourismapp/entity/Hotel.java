package com.example.xiamentourismapp.entity;

public class Hotel
{
    public Integer hotelImage;
    public String hotelName;
    public Float hotelRating;
    public String hotelLink;
    public String hotelNo;

    public Hotel(Integer hotelImage, String hotelName, Float hotelRating, String hotelLink, String hotelNo)
    {
        this.hotelImage = hotelImage;
        this.hotelName = hotelName;
        this.hotelRating = hotelRating;
        this.hotelLink = hotelLink;
        this.hotelNo = hotelNo;
    }
}
