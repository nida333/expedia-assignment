package com.hotel.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

import static java.time.temporal.ChronoUnit.SECONDS;


public class HotelListingPage extends CommonPageObject {

    protected final static String EXPECTED_PAGE_TITLE = "Hotels.com - hotels in";


    @FindBy(id = "sort")
    private WebElementFacade sortingDiv;

    @FindBy(id = "filters")
    private WebElementFacade filterDiv;

    @FindBy(id = "listings")
    private WebElementFacade hotelListing;

    @FindBy(css = ".listings .hotel")
    private List<WebElementFacade> hotels;

    @FindBy(id = "search-map-link")
    private WebElementFacade viewOnMapBtn;

    private By hotelName = By.className("property-name-link");
    private By hotelPrice = By.className("price-link");
    private By hotelPriceIfSpecialOffer = By.cssSelector("ins.special-deal-animation");
    private By choseHotelButton = By.className("cta");



    public HotelListingPage() {
        super(EXPECTED_PAGE_TITLE);
    }


    public boolean areSortingOptionsDisplayed(){
        waitFor(sortingDiv);
        return sortingDiv.isDisplayed();
    }

    public boolean areFiltersDisplayed(){
        waitFor(filterDiv);
        return filterDiv.isDisplayed();
    }

    public boolean isHotelListDisplayed(){
        return hotelListing.isDisplayed();
    }

    public void waitForHotelListToBeDisplayed(){
        withTimeoutOf(10, SECONDS).waitFor(hotelListing);
    }

    public boolean isViewOnMapDdisplayed(){
        return viewOnMapBtn.isDisplayed();
    }

    public String getHotelId(){
        WebElementFacade hotel = hotels.get(0);
        return hotel.getAttribute("data-hotel-id");
    }

    public String getHotelName(String hotelId){
        WebElementFacade hotel = hotelListing.findBy("[data-hotel-id='"+ hotelId +"']");
        return hotel.findElement(hotelName).getText();
    }

    public String getHotelPrice(String hotelId){
        WebElementFacade hotel = hotelListing.findBy("[data-hotel-id='"+ hotelId +"']");
        if(hotel.findElements(hotelPriceIfSpecialOffer).size() != 0){
            return hotel.findElement(hotelPriceIfSpecialOffer).getText().replace("£", "");
        }
        return hotel.findElement(hotelPrice).getText().replace("£", "");
    }

    public void clickHotel(String hotelId){
        WebElementFacade hotel = hotelListing.findBy("[data-hotel-id='"+ hotelId +"']");
        hotel.findElement(choseHotelButton).click();
    }

    public boolean clickViewOnMap(){
        viewOnMapBtn.isClickable();
        viewOnMapBtn.click();
        return true;
    }
}
