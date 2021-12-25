package com.example.xiamentourismapp.entity;

import androidx.annotation.Nullable;

public class Transport
{
    public Integer transportId;
    public Integer transportImg;
    public String transportName;
    public String transportLink;
    public String transportNo;

    public Transport(@Nullable Integer transportId, Integer transportImg, String transportName, String transportLink, String transportNo)
    {
        this.transportId = transportId;
        this.transportImg = transportImg;
        this.transportName = transportName;
        this.transportLink = transportLink;
        this.transportNo = transportNo;
    }
}
