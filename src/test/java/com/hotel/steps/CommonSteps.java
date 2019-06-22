package com.hotel.steps;

import com.hotel.pages.CommonPageObject;
import com.hotel.pages.HomePage;
import com.hotel.pages.HotelDetailsPage;
import com.hotel.pages.HotelListingPage;
import net.thucydides.core.annotations.Step;

public class CommonSteps {

    HomePage homePage;
    HotelListingPage hotelListingPage;
    HotelDetailsPage hotelDetailsPage;

    @Step
    public void browses_to_the_page(String pageName) {
        getPage(pageName).open();
    }

    @Step
    public void is_on_the_page(String pageName) {
        CommonPageObject page = getPage(pageName);
        page.waitForPageLoad();
        page.assertOnThePage();
    }

    protected CommonPageObject getPage(String pageName) {
        switch (pageName) {

            case "Home": return homePage;
            case "Hotel list": return hotelListingPage;
            case "Hotel Details": return hotelDetailsPage;
            default:
                throw new IllegalArgumentException("Unexpected page: " + pageName);
        }
    }
}
