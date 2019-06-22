package com.hotel.steps;

import com.hotel.pages.mapPage;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class mapSteps {
    mapPage MapPage;
    SoftAssertions softAssertion = new SoftAssertions();

    @Step
    public void verifies_map_is_displayed() {
        assertThat(MapPage.is_map_iframe_displayed(), is(true));
    }

    @Step
    public void verifies_zoom_in_btn_is_displayed() {
        assertThat(MapPage.is_zoom_in_btn_displayed(), is(true));
    }

    @Step
    public void compares_zoom_in_btn_text(String expectedBtnText) {
        softAssertion.assertThat(MapPage.get_zoom_btn_text()).isEqualTo(expectedBtnText);
    }

    @Step
    public void clicks_zoom_btn_until_displayed() {
        MapPage.click_zoom_btn();
    }

    @Step
    public void verifies_toggle_btn_displayed() {
        assertThat(MapPage.is_toggle_legend_btn_displayed(), is(true));
    }

    @Step
    public void clicks_toggle_button() {
        MapPage.click_toggle_legend_button();
    }

    @Step
    public void verifies_availability_filter_displayed(){
        MapPage.is_availaibility_filters_displayed();
    }

    @Step
    public void unchecks_does_not_match_criteria_checkbox(){
        MapPage.click_does_not_match_criteria_legend_checkbox();
    }

    @Step
    public void unchecks_not_available_legend_checkbox(){
        MapPage.click_not_available_legend_checkbox();
    }

    @Step
    public void verifes_property_detail_card_displayed(){
        MapPage.is_property_detail_card_displayed();
    }

    @Step
    public void clicks_info_box_title(){
        assertThat(MapPage.is_info_box_title(), is(true));
        MapPage.click_info_box_title();
    }
}
