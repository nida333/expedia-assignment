package com.hotel.steps;

import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class HomePageSteps {
    com.hotel.pages.HomePage HomePage;

    SoftAssertions softAssertion = new SoftAssertions();

   @Step
   public void closeWidgetOverlayIfDisplayed(){
       if(HomePage.isWidgetDisplayed() == true){
           HomePage.clickWidgetCloseButton();
       }
   }

    @Step
    public void verifySearchFormIsDisplayed() {
       assertThat(HomePage.isSearchFormDisplayed(), is(true));
    }

    @Step
    public void compareSearchButtonText(String expectedSearchButtonText) {
        softAssertion.assertThat(HomePage.searchButtonText()).isEqualTo(expectedSearchButtonText);
    }

    @Step
    public void verifySearchButtonIsDisplayed() {

       assertThat(HomePage.isSearchButtonDisplayed(), is(true));
    }

    @Step
    public void compareDestinationLabel(String expectedDestinationLabel) {
        softAssertion.assertThat(HomePage.destinationLabelText()).isEqualTo(expectedDestinationLabel);
    }

    @Step
    public void verifyDestinationFieldIsDisplayed() {
        assertThat(HomePage.isDestinationTextFieldDisplayed(), is(true));
    }

    @Step
    public void compareCheckinDateLabel(String expectedCheckinLabel) {
        softAssertion.assertThat(HomePage.checkinDateLabelText()).isEqualTo(expectedCheckinLabel);
    }

    @Step
    public void verifyCheckinDateInputIsDisplayed() {
        assertThat(HomePage.isCheckinDateFieldDisplayed(), is(true));
    }

    @Step
    public void compareCheckoutDateLabel(String expectedCheckoutLabel) {
        softAssertion.assertThat(HomePage.checkoutDateLabelText()).isEqualTo(expectedCheckoutLabel);
    }

    @Step
    public void verifyCheckoutDateInputIsDisplayed() {
        assertThat(HomePage.isCheckoutDateFieldDisplayed(), is(true));
    }

    @Step
    public void entersDestination(String destination) {

       HomePage.enterDestination(destination);
    }

    @Step
    public void selectsDestinationFromDropdown() {

       HomePage.clickDestinationFromDropDown();
    }

    @Step
    public void entersCheckinDate(String checkinDate){
        HomePage.enterCheckinDate(checkinDate);
    }

    @Step
    public void entersCheckoutDate(String checkoutDate) {
        HomePage.enterCheckoutDate(checkoutDate);
    }

    @Step
    public void closesDatePicker(){
        HomePage.closeDatePicker();
    }

    @Step
    public void verifyNumberOfNights(String expectedNights) {
        assertThat(HomePage.numberOfNightsText(), is(expectedNights));
    }

    @Step
    public void clicksSubmitButton(){
        HomePage.clickSubmitSearch();

    }
}
