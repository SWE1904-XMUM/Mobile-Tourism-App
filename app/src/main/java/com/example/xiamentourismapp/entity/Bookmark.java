package com.example.xiamentourismapp.entity;

import androidx.annotation.Nullable;

public class Bookmark
{
    public Integer bookmarkId;
    public String username;
    public String bookmarkName;
    public String bookmarkLink;
    public String bookmarkPhone;
    public byte[] bookmarkImage;

    public Bookmark()
    {

    }

    public Bookmark(@Nullable Integer bookmarkId,String username, String bookmarkName, String bookmarkLink, String bookmarkPhone, byte[] bookmarkImage)
    {
        this.bookmarkId = bookmarkId;
        this.username = username;
        this.bookmarkName = bookmarkName;
        this.bookmarkLink = bookmarkLink;
        this.bookmarkPhone = bookmarkPhone;
        this.bookmarkImage = bookmarkImage;
    }
}
