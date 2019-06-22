package com.hotel.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import static java.time.temporal.ChronoUnit.SECONDS;

@DefaultUrl("https://uk.hotels.com/")
public class HomePage extends CommonPageObject {

    protected final static String EXPECTED_PAGE_TITLE = "Hotels.com - Deals & Discounts for Hotel Reservations from Luxury Hotels to Budget Accommodations";

    @FindBy(className = "widget-overlay-bd")
    private WebElementFacade widgetOverlay;

    @FindBy(css = "button[aria-label='Close overlay']")
    private WebElementFacade widgetcloseBtn;

    @FindBy(className = "logo-cont")
    private WebElementFacade logoImage;

    @FindBy(tagName = "h1")
    private WebElementFacade formHeading;

    @FindBy(css = "form.cont-bd")
    private WebElementFacade searchForm;

    @FindBy(css = "form.cont-bd button[type=\"submit\"]")
    private WebElementFacade searchButton;

    @FindBy(className = "widget-query-sub-title")
    private WebElementFacade destinationLabel;

    @FindBy(id = "qf-0q-destination")
    private WebElementFacade destinationSearchInput;

    @FindBy(id = "widget-query-label-2")
    private WebElementFacade checkinFieldLabel;

    @FindBy(id = "qf-0q-localised-check-in")
    private WebElementFacade checkinDateInput;

    @FindBy(id = "widget-query-label-4")
    private WebElementFacade checkoutFieldLabel;

    @FindBy(id = "qf-0q-localised-check-out")
    private WebElementFacade checkoutDateInput;

    @FindBy(id = "citysqm-asi0-s0")
    private WebElementFacade destinationDropDownvalue;

    @FindBy(className = "widget-overlay-close")
    private WebElementFacade datePickerCloseButton;

    @FindBy(className = "widget-query-num-nights")
    private WebElementFacade numberOfNightsLabel;

    @FindBy(css = ".widget-daterange-start .widget-datepicker-next:first")
    private WebElementFacade calenderNextButton;


    public HomePage() {
        super(EXPECTED_PAGE_TITLE);
    }

    public boolean isWidgetDisplayed() {
        return widgetOverlay.isVisible();
    }

    public void clickWidgetCloseButton() {
        if(widgetcloseBtn.isVisible()){
            widgetcloseBtn.click();
        }
    }

    public boolean isSearchFormDisplayed() {
        waitFor(searchForm);
        return searchForm.isDisplayed();
    }

    public boolean isSearchButtonDisplayed() {
        waitFor(searchButton);
        return searchButton.isDisplayed();
    }

    public boolean isDestinationTextFieldDisplayed() {
        waitFor(destinationSearchInput);
        return destinationSearchInput.isDisplayed();
    }

    public boolean isCheckinDateFieldDisplayed() {
        waitFor(checkinDateInput);
        return checkinDateInput.isDisplayed();
    }

    public boolean isCheckoutDateFieldDisplayed() {
        waitFor(checkoutDateInput);
        return checkoutDateInput.isDisplayed();
    }

    public String searchButtonText() {
        return searchButton.getText();
    }

    public String destinationLabelText() {
        return destinationLabel.getText();
    }

    public String checkinDateLabelText() {
        return checkinFieldLabel.getText();
    }

    public String checkoutDateLabelText() {
        return checkoutFieldLabel.getText();
    }


    public void enter_destination(String destination) {
        destinationSearchInput.clear();
        destinationSearchInput.sendKeys(destination);
    }

    public void click_destination_from_drop_down() {

        withTimeoutOf(5, SECONDS).waitFor(destinationDropDownvalue).click();
    }

    public String numberOfNightsText() {
        return numberOfNightsLabel.getText();
    }

    public void closeDatePicker() {
        Boolean visible = datePickerCloseButton.isVisible();
        if (visible) {
            datePickerCloseButton.click();
            checkoutDateInput.click();
            datePickerCloseButton.click();
        }
    }

    public void enterCheckinDate(String checkinDate) {
        checkinDateInput.clear();
        selectDate(checkinDateInput, checkinDate);
    }

    public void enterCheckoutDate(String checkoutDate) {
        checkoutDateInput.clear();
        selectDate(checkoutDateInput, checkoutDate);
    }

    public void clickSubmitSearch() {
        searchButton.click();
    }

}
