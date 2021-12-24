package com.example.xiamentourismapp.utils.comparator;

import com.example.xiamentourismapp.entity.Food;
import com.example.xiamentourismapp.entity.Hotel;
import com.example.xiamentourismapp.entity.Transport;

import java.util.Comparator;

public class SortComparator
{
    public SortComparator()
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

    public static Comparator<Transport> descending = new Comparator<Transport>()
    {
        @Override
        public int compare(Transport t1, Transport t2)
        {
            return t1.transportName.compareTo(t2.transportName);
        }
    };

    public static Comparator<Transport> ascending = new Comparator<Transport>()
    {
        @Override
        public int compare(Transport t1, Transport t2)
        {
            return t2.transportName.compareTo(t1.transportName);
        }
    };
}
