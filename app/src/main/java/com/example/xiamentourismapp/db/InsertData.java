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

    /*public static void insertFoodData()
    {
        foodList.add(new com.example.xiamentourismapp.entity.Food(R.drawable.fragrance,"Fragrance Tea Palace",4.9F, "https://www.trip.com/travel-guide/xiamen-21-restaurant/fragrance-tea-palace-31532292/","0592-5023333"));
        foodList.add(new com.example.xiamentourismapp.entity.Food(R.drawable.di_zhong_hai,"Seaview Resort Xiamen Di Zhong Hai Cafe",4.4F, "https://www.trip.com/travel-guide/xiamen-21-restaurant/seaview-resort-xiamendi-zhong-hai-cafe-25661457/","0592-5023333-7771"));
        foodList.add(new com.example.xiamentourismapp.entity.Food(R.drawable.yuehua,"Yue Hua Hotel Restaurant",4.6F, "https://www.trip.com/travel-guide/xiamen-21-restaurant/xiamenyuehuajiudianlvtingzhutizizhu-restaurant-11308623/","0592-6028888"));
        foodList.add(new com.example.xiamentourismapp.entity.Food(R.drawable.haomatou,"38Haomatou Restaurant", 4.7F,"https://www.trip.com/travel-guide/xiamen-21-restaurant/38haomatou-restaurant-31217438/","0592-2562256"));
        foodList.add(new com.example.xiamentourismapp.entity.Food(R.drawable.little_dew,"LittleDew Coffee Bar",4.0F, "https://www.trip.com/travel-guide/xiamen-21-restaurant/littledew-coffee-bar-57249374/","1855902611018650161894"));
        foodList.add(new com.example.xiamentourismapp.entity.Food(R.drawable.latest,"Latest Recipe Restaurant", 4.6F,"https://www.trip.com/travel-guide/xiamen-21-restaurant/latest-recipe-restaurant-11309455/","0592-7709179"));
        foodList.add(new com.example.xiamentourismapp.entity.Food(R.drawable.shang_shan,"Shang Shan Restaurant",4.7F, "https://www.trip.com/travel-guide/xiamen-21-restaurant/shang-shan-zhong-guo-chu-fang-33533165/","0592-5159698"));
        foodList.add(new com.example.xiamentourismapp.entity.Food(R.drawable.shang_qing,"Shang Qing Ben Gang Seafood", 4.7F,"https://www.trip.com/travel-guide/xiamen-21-restaurant/shang-qing-ben-gang-seafood-11315853/","0592-2082008"));
        foodList.add(new com.example.xiamentourismapp.entity.Food(R.drawable.yuefu,"Yue Fu Restaurant", 4.4F,"https://www.trip.com/travel-guide/xiamen-21-restaurant/yue-fu-11312059/", "0592-2351673"));
        foodList.add(new com.example.xiamentourismapp.entity.Food(R.drawable.tianyuan,"Tian Yuan Hotel Restaurant",4.8F, "https://www.trip.com/travel-guide/xiamen-21-restaurant/tianyuanjiudianzizhu-restaurant-57275361/", "0592-5663999"));
    }*/

    /*public static void insertTransportData()
    {
        transportList.add(new com.example.xiamentourismapp.entity.Transport(R.drawable.railway,"Xiamen Railway Station", "https://www.topchinatravel.com/xiamen/xiamen-railway-station.htm","97988758"));
        transportList.add(new com.example.xiamentourismapp.entity.Transport(R.drawable.bus,"FTBCI Bus", "http://ftbcibus.com/","0086-592-6880895"));
        transportList.add(new com.example.xiamentourismapp.entity.Transport(R.drawable.airport,"Xiamen Gaoqi International Airport", "https://www.flightradar24.com/data/airports/xmn","+865925736975"));
        transportList.add(new com.example.xiamentourismapp.entity.Transport(R.drawable.ferry,"Xiamen Ferry to Gulangyu Island", "https://www.chinadiscovery.com/xiamen-tours/transportation/get-to-gulangyu-island.html","35476575"));
        transportList.add(new com.example.xiamentourismapp.entity.Transport(R.drawable.cable,"Zhonggu Cableway", "https://www.trip.com/travel-guide/attraction/xiamen/zhonggu-cableway-10521056/","9979652"));
    }*/
}
