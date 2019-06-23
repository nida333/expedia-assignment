package com.hotel.steps;

import com.hotel.models.Hotel;
import com.hotel.pages.HotelMapPage;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;


public class MapSteps {
    HotelMapPage mapPage;
    SoftAssertions softAssertion = new SoftAssertions();

    @Step
    public Hotel selectTheFirstHotel() {
        mapPage.clickZoomButton();
        mapPage.clickToggleLegendButton();

        mapPage.clickDoesNotMatchCriteriaLegendCheckbox();
        mapPage.clickNotAvailableLegendCheckbox();


        mapPage.clickFirstHotelMarker();
        //if(MapPage.isPropertyDetailCardDisplayed()){
        String HotelName = mapPage.getHotelNameFromPropertyCard();
        String HotelPrice = mapPage.getRoomPriceFromPropertyCard();
        mapPage.clickSelectHotelbtn();
        mapPage.switchTab();
        //}

        return new Hotel(HotelName, HotelPrice);
    }

}
