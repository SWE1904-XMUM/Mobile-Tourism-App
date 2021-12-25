package com.example.xiamentourismapp.db;

import com.example.xiamentourismapp.R;

public class InsertData
{
    public InsertData()
    {

    }

    public static void insertHotelData()
    {
        HotelDb.insertHotel(R.drawable.lohkah_hotel,"Lohkah Hotel", 5.0F,"https://www.tripadvisor.com.my/Hotel_Review-g297407-d15197999-Reviews-Lohkah_Hotel_Spa-Xiamen_Fujian.html","01234");
        HotelDb.insertHotel(R.drawable.hampton,"Hampton by Hilton City Plaza",3.0F,"https://www.tripadvisor.com.my/Hotel_Review-g297407-d17387158-Reviews-Hampton_by_Hilton_City_Plaza-Xiamen_Fujian.html","32142");
        HotelDb.insertHotel(R.drawable.jingmin,"Jingmin Central Hotel",4.5F,"https://www.tripadvisor.com.my/Hotel_Review-g297407-d504806-Reviews-Jingmin_Central_Hotel-Xiamen_Fujian.html","267534");
        HotelDb.insertHotel(R.drawable.xige,"Xige Hotel",4.0F,"https://www.tripadvisor.com.my/Hotel_Review-g297407-d1138523-Reviews-Xige_Hotel-Xiamen_Fujian.html","636565");
        HotelDb.insertHotel(R.drawable.mercure,"Grand Mercure Xiamen Downtown",4.0F,"https://www.tripadvisor.com.my/Hotel_Review-g297407-d2327746-Reviews-Grand_Mercure_Xiamen_Downtown-Xiamen_Fujian.html","97875");
        HotelDb.insertHotel(R.drawable.hilton,"Hilton Xiamen",4.5F,"https://www.tripadvisor.com.my/Hotel_Review-g297407-d1139860-Reviews-Hilton_Xiamen-Xiamen_Fujian.html","997986");
        HotelDb.insertHotel(R.drawable.seaview,"Seaview Resort",5.0F,"https://www.tripadvisor.com.my/Hotel_Review-g297407-d674904-Reviews-Seaview_Resort-Xiamen_Fujian.html","325564");
        HotelDb.insertHotel(R.drawable.tiantian,"Tiantian Vacation International Hotel",3.5F,"https://www.tripadvisor.com.my/Hotel_Review-g297407-d4198437-Reviews-Tiantian_Vacation_International_Hotel-Xiamen_Fujian.html","456567");
        HotelDb.insertHotel(R.drawable.marriott,"Xiamen Marriott Hotel & Conference Centre",5.0F,"https://www.tripadvisor.com.my/Hotel_Review-g297407-d13480411-Reviews-Xiamen_Marriott_Hotel_Conference_Centre-Xiamen_Fujian.html","979867");
        HotelDb.insertHotel(R.drawable.marco_polo,"Marco Polo Xiamen",4.5F,"https://www.tripadvisor.com.my/Hotel_Review-g297407-d300847-Reviews-Marco_Polo_Xiamen-Xiamen_Fujian.html","3245346");
    }
}
