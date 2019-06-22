package com.hotel.steps;

import com.hotel.models.Hotel;
import com.hotel.pages.HotelListingPage;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HotelListingPageSteps {
    HotelListingPage hotelListingPage;
    SoftAssertions softAssertion = new SoftAssertions();

    @Step
    public void sortingDivIsDisplayed(){
        softAssertion.assertThat(hotelListingPage.areSortingOptionsDisplayed()).isTrue();
    }

    @Step
    public void filterDivIsDisplayed(){
        softAssertion.assertThat(hotelListingPage.areFiltersDisplayed()).isTrue();
    }

    @Step
    public void hotelListIsDisplayed(){
        boolean displayed = hotelListingPage.isHotelListDisplayed();
        if(!displayed){
            hotelListingPage.waitForHotelListToBeDisplayed();
        }
    }

    @Step
    public void verifiesViewOnMapButtonIsDisplayed(){
        assertThat(hotelListingPage.isViewOnMapDdisplayed(), is(true));
    }

    @Step
    public Hotel selectTheFirstHotel(){
        String hotelId = hotelListingPage.getHotelId();
        String HotelName = hotelListingPage.getHotelName(hotelId);
        String HotelPrice = hotelListingPage.getHotelPrice(hotelId);
        hotelListingPage.clickHotel(hotelId);
        hotelListingPage.switchTab();
        return new Hotel(HotelName, HotelPrice);
    }

    @Step
    public void clicksViewOnMapButton(){

        assertThat(hotelListingPage.clickViewOnMap(), is(true));
    }
}
