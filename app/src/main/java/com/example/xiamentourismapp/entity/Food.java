package com.example.xiamentourismapp.entity;

public class Food
{
    public Integer foodImg;
    public String foodName;
    public String foodRestaurant;
    public String foodLink;
    public String foodNo;

    public Food(Integer foodImg, String foodName, String foodRestaurant, String foodLink, String foodNo)
    {
        this.foodImg = foodImg;
        this.foodName = foodName;
        this.foodRestaurant = foodRestaurant;
        this.foodLink = foodLink;
        this.foodNo = foodNo;
    }
}
