package com.hotel.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import static java.time.temporal.ChronoUnit.SECONDS;

public class HotelMapPage extends CommonPageObject {

    protected final static String EXPECTED_PAGE_TITLE = "Hotels.com - hotels";


    @FindBy(xpath = "//*[@id='map']/div[1]/div/iframe")
    private WebElementFacade mapIframe;

    @FindBy(className = "cta-map-zoom")
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

    @FindBy(css = ".map-infobox-cta a")
    private WebElementFacade selectHotelBtn;

    public HotelMapPage() {
        super(EXPECTED_PAGE_TITLE);
    }

    public void clickZoomButton() {

        if(zooninBtn.isVisible()){
            zooninBtn.click();
        }

    }


    public void clickToggleLegendButton() {
        withTimeoutOf(15, SECONDS).waitFor(toggleLegendBtn).click();
    }

    public boolean isAvailaibilityFiltersDisplayed() {
        waitFor(availabilityLegends);
        return availabilityLegends.isDisplayed();
    }

    public void clickDoesNotMatchCriteriaLegendCheckbox() {
        if(isAvailaibilityFiltersDisplayed()){
            doesNotMatchLegend.isDisplayed();
            doesNotMatchLegend.click();
        }
    }

    public void clickNotAvailableLegendCheckbox() {
        if(isAvailaibilityFiltersDisplayed()) {
            notAvailableLegend.isDisplayed();
            notAvailableLegend.click();
        }
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

    public void clickFirstHotelMarker(){
        try{
            Screen s = new Screen();
            Pattern setting=new Pattern("src/test/resources/hotel.available.svg");
            s.wait( setting,5000 );
            s.click();
        }catch (Exception ex){

        }
    }

    public void clickSelectHotelbtn(){
        selectHotelBtn.click();
    }

}
