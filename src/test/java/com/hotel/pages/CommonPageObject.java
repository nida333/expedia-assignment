package com.hotel.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;

public abstract class CommonPageObject extends PageObject {

    protected final String expectedPageTitle;

    public CommonPageObject(String expectedPageTitle) {
        this.expectedPageTitle = expectedPageTitle;
    }


    protected void scrollToElement(WebElementFacade element) {
        WebDriver driver = getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

    }

    public void switchTab() {
        WebDriver driver = getDriver();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    protected void selectDate(WebElementFacade element, String value) {
        WebDriver driver = getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + value + "'", element);
        js.executeScript("arguments[0].dispatchEvent(new Event('change'));", element);

    }


    public void waitForPageLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState")
                        .equals("complete");
            }
        };
        Duration duration = Duration.of(10, ChronoUnit.SECONDS);
        withTimeoutOf(duration).waitFor(pageLoadCondition);
    }

    public void assertOnThePage() {
        assertOnThePage(expectedPageTitle);
    }

    public void assertOnThePage(String expectedTitle) {
        String actualTitle = getTitle();
        assertTrue(actualTitle.contains(expectedTitle));
    }
}
