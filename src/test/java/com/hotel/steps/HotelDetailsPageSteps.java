package com.hotel.steps;

import com.hotel.models.Hotel;
import com.hotel.pages.HotelDetailsPage;
import org.assertj.core.api.SoftAssertions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HotelDetailsPageSteps {
    HotelDetailsPage hotelDetailsPage;
    SoftAssertions softAssertion = new SoftAssertions();

    public void compare_hotel_info_from_list_view(Hotel expectedHotel){
        String hotelName = hotelDetailsPage.getHotelName();
        String hotelPrice = hotelDetailsPage.getHotelPrice();
        assertThat(hotelName, is(expectedHotel.getName()));
        assertThat(hotelPrice, is(expectedHotel.getPrice()));
    }
}
