package com.example.xiamentourismapp.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.xiamentourismapp.entity.Food;
import java.util.ArrayList;
import java.util.List;

public class FoodDb
{
    private static SQLiteDatabase db = ConnectionProvider.getDatabase(null);
    private static final String TABLE_NAME = "food";
    private static final String FOOD_IMAGE = "foodImage";
    private static final String RESTAURANT = "restaurant";
    private static final String FOOD_RATING = "foodRating";
    private static final String FOOD_LINK = "foodLink";
    private static final String FOOD_NO = "foodNo";

    public static boolean insertFood(Integer foodImage,String restaurant,Float foodRating,String foodLink,String foodNo)
    {
        ContentValues cv = new ContentValues();
        cv.put(FOOD_IMAGE,foodImage);
        cv.put(RESTAURANT,restaurant);
        cv.put(FOOD_RATING,foodRating);
        cv.put(FOOD_LINK,foodLink);
        cv.put(FOOD_NO,foodNo);

        long insert = db.insert(TABLE_NAME,null,cv);
        return insert > 0;
    }

    public static List<Food> getFoodList()
    {
        List<Food> foodList = new ArrayList<>();

        Cursor c = db.rawQuery("select * from food", null);

        if (c.moveToFirst())
        {
            do
            {
                foodList.add(new Food(c.getInt(0),c.getInt(1),c.getString(2),c.getFloat(3),c.getString(4),c.getString(5)));
            }
            while(c.moveToNext());
        }
        return foodList;
    }
}
