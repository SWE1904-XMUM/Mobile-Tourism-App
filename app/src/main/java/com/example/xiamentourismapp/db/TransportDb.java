package com.example.xiamentourismapp.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.xiamentourismapp.entity.Food;
import com.example.xiamentourismapp.entity.Transport;

import java.util.ArrayList;
import java.util.List;

public class TransportDb
{
    private static SQLiteDatabase db = ConnectionProvider.getDatabase(null);
    private static final String TABLE_NAME = "transports";
    private static final String TRANSPORT_IMAGE = "transportImage";
    private static final String TRANSPORT_NAME = "transportName";
    private static final String TRANSPORT_LINK = "transportLink";
    private static final String TRANSPORT_NO = "transportNo";

    public static boolean insertTransport(Integer transportImage,String transportName,String transportLink,String transportNo)
    {
        ContentValues cv = new ContentValues();
        cv.put(TRANSPORT_IMAGE,transportImage);
        cv.put(TRANSPORT_NAME,transportName);
        cv.put(TRANSPORT_LINK,transportLink);
        cv.put(TRANSPORT_NO,transportNo);

        long insert = db.insert(TABLE_NAME,null,cv);
        return insert > 0;
    }

    public static List<Transport> getTransportList()
    {
        List<Transport> transportList = new ArrayList<>();

        Cursor c = db.rawQuery("select * from transports", null);

        if (c.moveToFirst())
        {
            do
            {
                transportList.add(new Transport(c.getInt(0),c.getInt(1),c.getString(2),c.getString(4),c.getString(5)));
            }
            while(c.moveToNext());
        }
        return transportList;
    }
}
