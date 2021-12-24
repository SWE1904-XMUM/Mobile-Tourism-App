package com.example.xiamentourismapp.entity;

public class Food
{
    public Integer foodImg;
    public String foodRestaurant;
    public String foodLink;
    public String foodNo;

    public Food(Integer foodImg, String foodRestaurant, String foodLink, String foodNo)
    {
        this.foodImg = foodImg;
        this.foodRestaurant = foodRestaurant;
        this.foodLink = foodLink;
        this.foodNo = foodNo;
    }
}
