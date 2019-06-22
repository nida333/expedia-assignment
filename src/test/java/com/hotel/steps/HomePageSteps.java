package com.hotel.steps;

import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class HomePageSteps {
    com.hotel.pages.HomePage HomePage;

    SoftAssertions softAssertion = new SoftAssertions();

   @Step
   public void close_widget_overlay_if_displayed(){
       if(HomePage.isWidgetDisplayed() == true){
           HomePage.clickWidgetCloseButton();
       }
   }

    @Step
    public void verify_search_form_is_displayed() {
       assertThat(HomePage.isSearchFormDisplayed(), is(true));
    }

    @Step
    public void compare_search_button_text(String expectedSearchButtonText) {
        softAssertion.assertThat(HomePage.searchButtonText()).isEqualTo(expectedSearchButtonText);
    }

    @Step
    public void verify_search_button_is_displayed() {

       assertThat(HomePage.isSearchButtonDisplayed(), is(true));
    }

    @Step
    public void compare_destination_label(String expectedDestinationLabel) {
        softAssertion.assertThat(HomePage.destinationLabelText()).isEqualTo(expectedDestinationLabel);
    }

    @Step
    public void verify_destination_field_is_displayed() {
        assertThat(HomePage.isDestinationTextFieldDisplayed(), is(true));
    }

    @Step
    public void compare_checkin_date_label(String expectedCheckinLabel) {
        softAssertion.assertThat(HomePage.checkinDateLabelText()).isEqualTo(expectedCheckinLabel);
    }

    @Step
    public void verify_checkin_date_input_is_displayed() {
        assertThat(HomePage.isCheckinDateFieldDisplayed(), is(true));
    }

    @Step
    public void compare_checkout_date_label(String expectedCheckoutLabel) {
        softAssertion.assertThat(HomePage.checkoutDateLabelText()).isEqualTo(expectedCheckoutLabel);
    }

    @Step
    public void verify_checkout_date_input_is_displayed() {
        assertThat(HomePage.isCheckoutDateFieldDisplayed(), is(true));
    }

    @Step
    public void enters_destination(String destination) {

       HomePage.enter_destination(destination);
    }

    @Step
    public void selects_destination_from_dropdown() {

       HomePage.click_destination_from_drop_down();
    }

    @Step
    public void enters_checkin_date(String checkinDate){
        HomePage.enterCheckinDate(checkinDate);
    }

    @Step
    public void enters_checkout_date(String checkoutDate) {
        HomePage.enterCheckoutDate(checkoutDate);
    }

    @Step
    public void closes_date_picker(){
        HomePage.closeDatePicker();
    }

    @Step
    public void verify_number_of_nights(String expectedNights) {
        assertThat(HomePage.numberOfNightsText(), is(expectedNights));
    }

    @Step
    public void clicks_submit_button(){
        HomePage.clickSubmitSearch();

    }
}
