package com.hotel.steps;

import com.hotel.pages.HotelMapPage;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class MapSteps {
    HotelMapPage MapPage;
    SoftAssertions softAssertion = new SoftAssertions();

    @Step
    public void verifiesMapIsDisplayed() {
        assertThat(MapPage.isMapIframeDisplayed(), is(true));
    }

    @Step
    public void verifiesZoomInBtnIsDisplayed() {
        assertThat(MapPage.isZoomInButtonDisplayed(), is(true));
    }

    @Step
    public void comparesZoomInBtnText(String expectedBtnText) {
        softAssertion.assertThat(MapPage.getZoomInButtonText()).isEqualTo(expectedBtnText);
    }

    @Step
    public void clicksZoomBtnUntilDisplayed() {
        MapPage.clickZoomButton();
    }

    @Step
    public void verifiesToggleBtnDisplayed() {
        assertThat(MapPage.isToggleLegendBtnDisplayed(), is(true));
    }

    @Step
    public void clicksToggleButton() {
        MapPage.clickToggleLegendButton();
    }

    @Step
    public void verifiesAvailabilityFilterDisplayed(){
        MapPage.isAvailaibilityFiltersDisplayed();
    }

    @Step
    public void unchecksDoesNotMatchCriteriaCheckbox(){
        MapPage.clickDoesNotMatchCriteriaLegendCheckbox();
    }

    @Step
    public void unchecksNotAvailableLegendCheckbox(){
        MapPage.clickNotAvailableLegendCheckbox();
    }

    @Step
    public void verifesPropertyDetailCardDisplayed(){
        MapPage.isPropertyDetailCardDisplayed();
    }

    @Step
    public void clicksInfoBoxTitle(){
        assertThat(MapPage.isInfoBoxTitle(), is(true));
        MapPage.clickInfoBoxTitle();
    }
}
