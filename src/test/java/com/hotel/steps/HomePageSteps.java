package com.hotel.steps;

import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class HomePageSteps {
    com.hotel.pages.HomePage homePage;

    SoftAssertions softAssertion = new SoftAssertions();

   @Step
   public void closeWidgetOverlayIfDisplayed(){
       if(homePage.isWidgetDisplayed() == true){
           homePage.clickWidgetCloseButton();
       }
   }

    @Step
    public void verifySearchFormIsDisplayed() {
       assertThat(homePage.isSearchFormDisplayed(), is(true));
    }

    @Step
    public void compareSearchButtonText(String expectedSearchButtonText) {
        softAssertion.assertThat(homePage.searchButtonText()).isEqualTo(expectedSearchButtonText);
    }

    @Step
    public void verifySearchButtonIsDisplayed() {

       assertThat(homePage.isSearchButtonDisplayed(), is(true));
    }

    @Step
    public void compareDestinationLabel(String expectedDestinationLabel) {
        softAssertion.assertThat(homePage.destinationLabelText()).isEqualTo(expectedDestinationLabel);
    }

    @Step
    public void verifyDestinationFieldIsDisplayed() {
        assertThat(homePage.isDestinationTextFieldDisplayed(), is(true));
    }

    @Step
    public void compareCheckinDateLabel(String expectedCheckinLabel) {
        softAssertion.assertThat(homePage.checkinDateLabelText()).isEqualTo(expectedCheckinLabel);
    }

    @Step
    public void verifyCheckinDateInputIsDisplayed() {
        assertThat(homePage.isCheckinDateFieldDisplayed(), is(true));
    }

    @Step
    public void compareCheckoutDateLabel(String expectedCheckoutLabel) {
        softAssertion.assertThat(homePage.checkoutDateLabelText()).isEqualTo(expectedCheckoutLabel);
    }

    @Step
    public void verifyCheckoutDateInputIsDisplayed() {
        assertThat(homePage.isCheckoutDateFieldDisplayed(), is(true));
    }

    @Step
    public void entersDestination(String destination) {

        homePage.enterDestination(destination);
    }

    @Step
    public void selectsDestinationFromDropdown() {

        homePage.clickDestinationFromDropDown();
    }

    @Step
    public void entersCheckinDate(String checkinDate){
        homePage.enterCheckinDate(checkinDate);
    }

    @Step
    public void entersCheckoutDate(String checkoutDate) {
        homePage.enterCheckoutDate(checkoutDate);
    }

    @Step
    public void closesDatePicker(){
        homePage.closeDatePicker();
    }

    @Step
    public void verifyNumberOfNights(String expectedNights) {
        assertThat(homePage.numberOfNightsText(), is(expectedNights));
    }

    @Step
    public void clicksSubmitButton(){
        homePage.clickSubmitSearch();

    }
}
