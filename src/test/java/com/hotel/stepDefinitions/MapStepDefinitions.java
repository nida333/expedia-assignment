package com.hotel.stepDefinitions;

import com.hotel.steps.MapSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MapStepDefinitions {

    MapSteps mapPageUser;

    @Then("map view is displayed")
    public void map_View_Is_Displayed() {
        mapPageUser.verifiesMapIsDisplayed();

    }

    @And("button '(.*)' to zoom in to see the properties is also displayed")
    public void button_To_zoom_in_to_see_properties_is_also_displayed(String expectedZoominBtnLabel) {
        mapPageUser.verifiesZoomInBtnIsDisplayed();
        mapPageUser.comparesZoomInBtnText(expectedZoominBtnLabel);

    }

    @When("user taps on it")
    public void user_Taps_On_It() {
        mapPageUser.clicksZoomBtnUntilDisplayed();

    }

    //ToDo
    @Then("hotel pins are displayed")
    public void hotel_Pins_Are_Displayed() {

    }


    @And("legend filter tab is displayed")
    public void legend_Filter_Tab_Is_Displayed() {
        mapPageUser.verifiesToggleBtnDisplayed();
    }

    @When("user expands legend filter tab")
    public void user_Expands_Legend_Filter_Tab() {
        mapPageUser.clicksToggleButton();
    }

    @Then("availability legend filters are displayed")
    public void legend_Filters_Are_Displayed() {
        mapPageUser.verifiesAvailabilityFilterDisplayed();
    }

    @And("user unchecks the unavaible legend filter")
    public void user_Unchecks_The_Unavaible_Legend_Filter() {
        mapPageUser.unchecksNotAvailableLegendCheckbox();
    }

    @And("user unchecks the doesn't match your criteria legend filter")
    public void user_Unchecks_Doesn_TMatch_Your_Criteria_Legend_Filter() {
        mapPageUser.unchecksDoesNotMatchCriteriaCheckbox();

    }

    //ToDo
    @When("^user taps on green pin$")
    public void userTapsOnGreenPin() {
    }

    @Then("^property card is displayed$")
    public void property_Card_Is_Displayed() {
        mapPageUser.verifesPropertyDetailCardDisplayed();
    }

    @When("user taps on property card")
    public void user_Taps_On_Property_Card() {
        mapPageUser.clicksInfoBoxTitle();

    }
}
