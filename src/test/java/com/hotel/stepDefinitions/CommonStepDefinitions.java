package com.hotel.stepDefinitions;

import com.hotel.steps.CommonSteps;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class CommonStepDefinitions {

    @Steps
    CommonSteps user;

    @Given("the user opens '(.*)' page$")
    public void the_user_opens_website(String pageName) {
        user.browsesToThePage(pageName);
    }

    @Given("the user is on the '(.*)' page$")
    public void the_user_is_on_the_page(String pageName) {
        user.isOnThePage(pageName);
    }
}
