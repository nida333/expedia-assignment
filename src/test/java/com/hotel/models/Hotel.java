package com.hotel.models;

public class Hotel {

    String name;
    String price;

    public Hotel(String name, String price)
    {
        this.name = name;
        this.price = price;
    }


    public String getName()
    {
        return name;
    }

    public String getPrice()
    {
        return price;
    }
}
