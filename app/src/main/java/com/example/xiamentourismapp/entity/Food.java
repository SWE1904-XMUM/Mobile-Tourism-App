package com.example.xiamentourismapp.entity;

import androidx.annotation.Nullable;

public class Food
{
    public Integer foodId;
    public Integer foodImg;
    public String foodRestaurant;
    public Float foodRating;
    public String foodLink;
    public String foodNo;

    public Food(@Nullable Integer foodId, Integer foodImg, String foodRestaurant, Float foodRating, String foodLink, String foodNo)
    {
        this.foodId = foodId;
        this.foodImg = foodImg;
        this.foodRestaurant = foodRestaurant;
        this.foodRating = foodRating;
        this.foodLink = foodLink;
        this.foodNo = foodNo;
    }
}
