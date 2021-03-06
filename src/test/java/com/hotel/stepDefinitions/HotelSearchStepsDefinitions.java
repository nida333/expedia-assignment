package com.hotel.stepDefinitions;

import com.hotel.models.Hotel;
import com.hotel.steps.HomePageSteps;
import com.hotel.steps.HotelDetailsPageSteps;
import com.hotel.steps.HotelListingPageSteps;
import com.hotel.steps.MapSteps;
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
    @Steps
    MapSteps mapSteps;

    public HotelSearchStepsDefinitions(){
        utils = new DatetimeUtils();
    }

    @And("search form is displayed")
    public void searchFormIsDisplayed() {
        homePageSteps.closeWidgetOverlayIfDisplayed();
        homePageSteps.verifySearchFormIsDisplayed();
        homePageSteps.verifyDestinationFieldIsDisplayed();
        homePageSteps.verifyCheckinDateInputIsDisplayed();
        homePageSteps.verifyCheckoutDateInputIsDisplayed();
        homePageSteps.verifySearchButtonIsDisplayed();
    }

    @And("destination search field has label '(.*)'")
    public void destinationSearchFieldIsDisplayedWithLabel(String expectedDestinationLabel) {
        homePageSteps.compareDestinationLabel(expectedDestinationLabel);
    }

    @And("check in date field has label '(.*)'")
    public void checkInDateFieldIsDisplayed(String expectedCheckinFieldLabel) {
        homePageSteps.compareCheckinDateLabel(expectedCheckinFieldLabel);
    }

    @And("checkout date field has label '(.*)'")
    public void checkoutDateFieldIsDisplayedWithLabelAsCheckoutLabel(String expectedCheckoutFieldLabel) {
        homePageSteps.compareCheckoutDateLabel(expectedCheckoutFieldLabel);
    }

    @And("submit search button has text '(.*)'")
    public void submitSearchButtonHasText(String expectedSearchButtonText) {
        homePageSteps.compareSearchButtonText(expectedSearchButtonText);
    }

    @Then("number of nights should be '(.*)'")
    public void numberOfNightsShouldBeDays(String nights) {
        homePageSteps.verifyNumberOfNights(nights);
    }

    @When("^user enters destination '(.*)'")
    public void userEntersDestination(String destination) {
        homePageSteps.entersDestination(destination);
        homePageSteps.selectsDestinationFromDropdown();
    }

    @And("user selects checkin date '(.*)' months from now and checkout date '(.*)' days from checkin date")
    public void userSelectsCheckinAndCheckoutDates(int months, int days) {
        String checkinDate = utils.addMonths(months);
        String checkoutDate = utils.addMonthAndDays(months, days);
        homePageSteps.entersCheckinDate(checkinDate);
        homePageSteps.entersCheckoutDate(checkoutDate);
        homePageSteps.closesDatePicker();
    }

    @And("user clicks on search button")
    public void tapOnSearchButton() {
        homePageSteps.clicksSubmitButton();
    }


    @Then("hotel listing page is displayed")
    public void hotelListingPageIsDisplayed() {
        hotelListSteps.filterDivIsDisplayed();
        hotelListSteps.sortingDivIsDisplayed();
    }

    @And("view on map button is also displayed")
    public void viewOnMapButtonIsDisplayed() {
        hotelListSteps.verifiesViewOnMapButtonIsDisplayed();
    }

    @When("user taps on view on map button")
    public void userTapsOnViewOnMapButton() {
        hotelListSteps.clicksViewOnMapButton();
    }

    @And("hotel list is displayed")
    public void hotelListIsDisplayed() {
        hotelListSteps.hotelListIsDisplayed();
    }

    @Given("the user performed a hotel search to '(.*)' from '(.*)' for '(.*)'")
    public void theUserPerformedAHotelSearchToDestinationFromMonthsForNights(String destination, int months, int days) {
        searchFormIsDisplayed();
        userEntersDestination(destination);
        userSelectsCheckinAndCheckoutDates(months, days);
        tapOnSearchButton();
    }

    @When("the user selects a hotel from the list")
    public void theUserSelectsAHotelFromTheList() {
       currentHotel = hotelListSteps.selectTheFirstHotel();
    }

    @And("the hotel details is same as the previous page")
    public void theHotelDetailsIsSameAsThePreviousPage() {
        hotelDetailsSteps.compareHotelInfoFromListView(currentHotel);
    }

    @And("the user selects an available hotel from the list")
    public void theUserSelectsAnAvailableHotelFromTheList() {
        currentHotel = mapSteps.selectTheFirstHotel();
    }
}
