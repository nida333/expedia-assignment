package com.hotel.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class HotelMapPage extends CommonPageObject {

    protected final static String EXPECTED_PAGE_TITLE = "Hotels.com - hotels";


    @FindBy(xpath = "//*[@id='map']/div[1]/div/iframe")
    private WebElementFacade mapIframe;

    @FindBy(className = "messaging-content")
    private WebElementFacade zooninBtn;

    @FindBy(css = ".gm-style > div > div:nth-child(3)")
    private WebElementFacade hotelLegends;

    @FindBy(css = "button[class='toggle']")
    private WebElementFacade toggleLegendBtn;

    @FindBy(className = "availability")
    private WebElementFacade availabilityLegends;

    @FindBy(id = "map-legend-filtered-hotels-0")
    private WebElementFacade doesNotMatchLegend;

    @FindBy(id = "map-legend-unavailable-hotels-0")
    private WebElementFacade notAvailableLegend;

    @FindBy(className = "map-infobox")
    private WebElementFacade propertyDetailCard;

    @FindBy(className = "map-infobox-title")
    private WebElementFacade hotelNamePropertyCard;

    @FindBy(className = "current-price")
    private WebElementFacade roomPricePropertyCard;

    @FindBy(className = "map-infobox-title")
    private WebElementFacade infoBoxTitle;

    public HotelMapPage() {
        super(EXPECTED_PAGE_TITLE);
    }


    public boolean isMapIframeDisplayed() {
        waitFor(mapIframe);
        return mapIframe.isDisplayed();
    }

    public boolean isZoomInButtonDisplayed() {
        waitFor(zooninBtn);
        return zooninBtn.isDisplayed();
    }

    public String getZoomInButtonText() {
        return zooninBtn.getText();
    }

    public void clickZoomButton() {

        //keep clicking it until legends are displayed
        //and whole page is loaded
        zooninBtn.click();
    }

    public boolean isToggleLegendBtnDisplayed() {
        return toggleLegendBtn.isDisplayed();
    }

    public void clickToggleLegendButton() {
        toggleLegendBtn.click();
    }

    public boolean isAvailaibilityFiltersDisplayed() {
        waitFor(availabilityLegends);
        return availabilityLegends.isDisplayed();
    }

    public void clickDoesNotMatchCriteriaLegendCheckbox() {
        doesNotMatchLegend.isDisplayed();
        doesNotMatchLegend.click();
    }

    public void clickNotAvailableLegendCheckbox() {
        notAvailableLegend.isDisplayed();
        notAvailableLegend.click();
    }

    public boolean isPropertyDetailCardDisplayed() {
        waitFor(propertyDetailCard);
        return propertyDetailCard.isDisplayed();
    }

    public String getHotelNameFromPropertyCard() {
        return hotelNamePropertyCard.getText();
    }

    public String getRoomPriceFromPropertyCard() {
        return roomPricePropertyCard.getText();
    }

    public boolean isInfoBoxTitle() {
        waitFor(infoBoxTitle);
        return infoBoxTitle.isDisplayed();
    }

    public void clickInfoBoxTitle() {
        infoBoxTitle.click();
    }
}
