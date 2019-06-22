package com.hotel.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class mapPage extends PageObject {
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

    public boolean is_map_iframe_displayed() {
        mapIframe.isDisplayed();
        return true;
    }

    public boolean is_zoom_in_btn_displayed() {
        zooninBtn.isDisplayed();
        return true;
    }

    public String get_zoom_btn_text() {
        return zooninBtn.getText();
    }

    public void click_zoom_btn() {

        //keep clicking it until legends are displayed
        //and whole page is loaded
        zooninBtn.click();
    }

    public boolean is_toggle_legend_btn_displayed() {
        toggleLegendBtn.isDisplayed();
        return true;
    }

    public void click_toggle_legend_button() {
        toggleLegendBtn.click();
    }

    public boolean is_availaibility_filters_displayed() {
        availabilityLegends.isDisplayed();
        return true;
    }

    public void click_does_not_match_criteria_legend_checkbox() {
        doesNotMatchLegend.isDisplayed();
        doesNotMatchLegend.click();
    }

    public void click_not_available_legend_checkbox() {
        notAvailableLegend.isDisplayed();
        notAvailableLegend.click();
    }

    public boolean is_property_detail_card_displayed() {
        propertyDetailCard.isDisplayed();
        return true;
    }

    public String get_hotel_name_from_property_card() {
        return hotelNamePropertyCard.getText();
    }

    public String get_room_price_from_property_card() {
        return roomPricePropertyCard.getText();
    }

    public boolean is_info_box_title() {
        infoBoxTitle.isDisplayed();
        return true;
    }

    public void click_info_box_title() {
        infoBoxTitle.click();
    }
}
