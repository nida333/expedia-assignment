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
    public void sorting_div_is_displayed(){
        softAssertion.assertThat(hotelListingPage.areSortingOptionsDisplayed()).isTrue();
    }

    @Step
    public void filter_div_is_displayed(){
        softAssertion.assertThat(hotelListingPage.areFiltersDisplayed()).isTrue();
    }

    @Step
    public void hotel_list_is_displayed(){
        boolean displayed = hotelListingPage.isHotelListDisplayed();
        if(!displayed){
            hotelListingPage.waitForHotelListToBeDisplayed();
        }
    }

    @Step
    public void verifies_view_on_map_button_is_displayed(){
        assertThat(hotelListingPage.isViewOnMapDdisplayed(), is(true));
    }

    @Step
    public Hotel select_the_first_hotel(){
        String hotelId = hotelListingPage.getHotelId();
        String HotelName = hotelListingPage.getHotelName(hotelId);
        String HotelPrice = hotelListingPage.getHotelPrice(hotelId);
        hotelListingPage.clickHotel(hotelId);
        hotelListingPage.switchTab();
        return new Hotel(HotelName, HotelPrice);
    }

    @Step
    public void clicks_view_on_map_button(){

        assertThat(hotelListingPage.clickViewOnMap(), is(true));
    }
}
