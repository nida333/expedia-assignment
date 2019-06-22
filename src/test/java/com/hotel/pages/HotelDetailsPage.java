package com.hotel.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class HotelDetailsPage extends CommonPageObject {

    protected final static String EXPECTED_PAGE_TITLE = "Info, Photos, Reviews | Book at Hotels.com";

    @FindBy(tagName = "h1")
    private WebElementFacade hotelName;

    @FindBy(css = ".featured-price .current-price")
    private WebElementFacade pricePerNight;


    public HotelDetailsPage() {
        super(EXPECTED_PAGE_TITLE);
    }

    public String getHotelName(){
        return hotelName.getText();
    }

    public String getHotelPrice(){
        return pricePerNight.getText().replace("£","");
    }

}
