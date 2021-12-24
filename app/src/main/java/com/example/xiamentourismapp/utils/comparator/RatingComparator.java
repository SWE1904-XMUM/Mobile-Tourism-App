package com.example.xiamentourismapp.utils.comparator;

import com.example.xiamentourismapp.entity.Food;
import com.example.xiamentourismapp.entity.Hotel;

import java.util.Comparator;

public class RatingComparator
{
    public RatingComparator()
    {

    }

    public static Comparator<Hotel> lowestHotel = new Comparator<Hotel>()
    {
        @Override
        public int compare(Hotel r1, Hotel r2)
        {
            return r1.hotelRating.compareTo(r2.hotelRating);
        }
    };

    public static Comparator<Hotel> highestHotel = new Comparator<Hotel>()
    {
        @Override
        public int compare(Hotel r1, Hotel r2)
        {
            return r2.hotelRating.compareTo(r1.hotelRating);
        }
    };

    public static Comparator<Food> lowestFood = new Comparator<Food>()
    {
        @Override
        public int compare(Food f1, Food f2)
        {
            return f1.foodRating.compareTo(f2.foodRating);
        }
    };

    public static Comparator<Food> highestFood = new Comparator<Food>()
    {
        @Override
        public int compare(Food f1, Food f2)
        {
            return f2.foodRating.compareTo(f1.foodRating);
        }
    };
}
