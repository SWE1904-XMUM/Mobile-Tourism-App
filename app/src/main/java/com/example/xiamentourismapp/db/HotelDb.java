package com.example.xiamentourismapp.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.xiamentourismapp.entity.Hotel;
import java.util.ArrayList;
import java.util.List;

public class HotelDb
{
    private static SQLiteDatabase db = ConnectionProvider.getDatabase(null);
    private static final String TABLE_NAME = "hotels";
    private static final String HOTEL_IMAGE = "hotelImage";
    private static final String HOTEL_NAME = "hotelName";
    private static final String HOTEL_RATING = "hotelRating";
    private static final String HOTEL_LINK = "hotelLink";
    private static final String HOTEL_NO = "hotelNo";

    public static boolean insertHotel(Integer hotelImage,String hotelName,Float hotelRating,String hotelLink,String hotelNo)
    {
        ContentValues cv = new ContentValues();
        cv.put(HOTEL_IMAGE,hotelImage);
        cv.put(HOTEL_NAME,hotelName);
        cv.put(HOTEL_RATING,hotelRating);
        cv.put(HOTEL_LINK,hotelLink);
        cv.put(HOTEL_NO,hotelNo);

        long insert = db.insert(TABLE_NAME,null,cv);
        return insert > 0;
    }

    public static List<Hotel> getHotelList()
    {
        List<Hotel> hotelList = new ArrayList<>();

        Cursor c = db.rawQuery("select * from hotels", null);

        if (c.moveToFirst())
        {
            do
            {
                hotelList.add(new Hotel(c.getInt(0),c.getInt(1),c.getString(2),c.getFloat(3),c.getString(4),c.getString(5)));
            }
            while(c.moveToNext());
        }
        return hotelList;
    }
}
