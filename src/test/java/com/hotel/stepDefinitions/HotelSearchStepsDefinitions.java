package com.hotel.stepDefinitions;

import com.hotel.models.Hotel;
import com.hotel.steps.HomePageSteps;
import com.hotel.steps.HotelDetailsPageSteps;
import com.hotel.steps.HotelListingPageSteps;
import com.hotel.utils.DatetimeUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;


public class HotelSearchStepsDefinitions {

    private DatetimeUtils utils;

    Hotel currentHotel;

    @Steps
    HotelListingPageSteps hotelListSteps;
    @Steps
    HotelDetailsPageSteps hotelDetailsSteps;
    @Steps
    HomePageSteps homePageSteps;

    public HotelSearchStepsDefinitions(){
        utils = new DatetimeUtils();
    }

    @And("^search form is displayed$")
    public void search_Form_Is_Displayed() {
        homePageSteps.close_widget_overlay_if_displayed();
        homePageSteps.verify_search_form_is_displayed();
        homePageSteps.verify_destination_field_is_displayed();
        homePageSteps.verify_checkin_date_input_is_displayed();
        homePageSteps.verify_checkout_date_input_is_displayed();
        homePageSteps.verify_search_button_is_displayed();
    }

    @And("destination search field has label '(.*)'")
    public void destination_SearchField_Is_Displayed_With_Label(String expectedDestinationLabel) {
        homePageSteps.compare_destination_label(expectedDestinationLabel);
    }

    @And("check in date field has label '(.*)'")
    public void checkIn_Date_Field_Is_Displayed_l(String expectedCheckinFieldLabel) {
        homePageSteps.compare_checkin_date_label(expectedCheckinFieldLabel);
    }

    @And("checkout date field has label '(.*)'")
    public void checkoutDateFieldIsDisplayedWithLabelAsCheckoutLabel(String expectedCheckoutFieldLabel) {
        homePageSteps.compare_checkout_date_label(expectedCheckoutFieldLabel);
    }

    @And("submit search button has text '(.*)'")
    public void submitSearchButtonHasText(String expectedSearchButtonText) {
        homePageSteps.compare_search_button_text(expectedSearchButtonText);
    }

    @Then("number of nights should be '(.*)'")
    public void numberOfNightsShouldBeDays(String nights) {
        homePageSteps.verify_number_of_nights(nights);
    }

    @When("^user enters destination '(.*)'")
    public void user_Enters_Destination(String destination) {
        homePageSteps.enters_destination(destination);
        homePageSteps.selects_destination_from_dropdown();
    }

    @And("user selects checkin date '(.*)' months from now and checkout date '(.*)' days from checkin date")
    public void userSelectsCheckinAndCheckoutDates(int months, int days) {
        String checkinDate = utils.addMonths(months);
        String checkoutDate = utils.addMonthAndDays(months, days);
        homePageSteps.enters_checkin_date(checkinDate);
        homePageSteps.enters_checkout_date(checkoutDate);
        homePageSteps.closes_date_picker();
    }

    @And("user clicks on search button")
    public void tapOnSearchButton() {
        homePageSteps.clicks_submit_button();
    }


    @Then("hotel listing page is displayed")
    public void hotel_Listing_Page_Is_Displayed() {
        hotelListSteps.filter_div_is_displayed();
        hotelListSteps.sorting_div_is_displayed();
    }

    @And("view on map button is also displayed")
    public void view_On_Map_Button_Is_Displayed() {
        hotelListSteps.verifies_view_on_map_button_is_displayed();
    }

    @When("user taps on view on map button")
    public void user_Taps_On_View_On_Map_Button() {
        hotelListSteps.clicks_view_on_map_button();
    }

    @And("hotel list is displayed")
    public void hotelListIsDisplayed() {
        hotelListSteps.hotel_list_is_displayed();
    }

    @Given("the user performed a hotel search to '(.*)' from '(.*)' for '(.*)'")
    public void theUserPerformedAHotelSearchToDestinationFromMonthsForNights(String destination, int months, int days) {
        search_Form_Is_Displayed();
        user_Enters_Destination(destination);
        userSelectsCheckinAndCheckoutDates(months, days);
        tapOnSearchButton();
    }

    @When("the user selects a hotel from the list")
    public void theUserSelectsAHotelFromTheList() {
       currentHotel = hotelListSteps.select_the_first_hotel();
    }

    @And("the hotel details is same as the listing page")
    public void theHotelDetailsIsSameAsTheListingPage() {
        hotelDetailsSteps.compare_hotel_info_from_list_view(currentHotel);

    }
}
