package com.hotel.steps;

import com.hotel.pages.*;
import net.thucydides.core.annotations.Step;

public class CommonSteps {

    HomePage homePage;
    HotelListingPage hotelListingPage;
    HotelDetailsPage hotelDetailsPage;
    HotelMapPage hotelMapPage;

    @Step
    public void browsesToThePage(String pageName) {
        getPage(pageName).open();
    }

    @Step
    public void isOnThePage(String pageName) {
        CommonPageObject page = getPage(pageName);
        page.waitForPageLoad();
        page.assertOnThePage();
    }

    protected CommonPageObject getPage(String pageName) {
        switch (pageName) {

            case "Home": return homePage;
            case "Hotel list": return hotelListingPage;
            case "Hotel Details": return hotelDetailsPage;
            case "Hotel Map": return  hotelMapPage;
            default:
                throw new IllegalArgumentException("Unexpected page: " + pageName);
        }
    }
}
