package com.example.xiamentourismapp.entity;

public class Food
{
    public Integer foodImg;
    public String foodRestaurant;
    public Float foodRating;
    public String foodLink;
    public String foodNo;

    public Food(Integer foodImg, String foodRestaurant,Float foodRating, String foodLink, String foodNo)
    {
        this.foodImg = foodImg;
        this.foodRestaurant = foodRestaurant;
        this.foodRating = foodRating;
        this.foodLink = foodLink;
        this.foodNo = foodNo;
    }
}
