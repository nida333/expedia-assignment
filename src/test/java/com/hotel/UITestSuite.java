package com.hotel;

import org.apache.commons.lang3.StringUtils;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;

import cucumber.api.CucumberOptions;
import net.serenitybdd.core.environment.ConfiguredEnvironment;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.webdriver.Configuration;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = { "pretty" }, features = "src/test/resources/features")
public class UITestSuite {

    private static final Logger LOGGER = LoggerFactory.getLogger(UITestSuite.class);

    @BeforeClass
    public static void beforeClass() {
        setupLogging();
        assertBaseUrl();
    }

    private static void setupLogging() {
        // Remove existing handlers attached to j.u.l root logger
        SLF4JBridgeHandler.removeHandlersForRootLogger(); // (since SLF4J 1.6.5)
        // bridge JUL logging to Slf4j
        SLF4JBridgeHandler.install();
    }

    private static void assertBaseUrl() {
        //There is bug, I think, whereby serenity.properties's
        //  webdriver.base.url
        //is set to null when running within Maven, let's check it...

        Configuration<?> cfg = ConfiguredEnvironment.getConfiguration();
        String baseUrl = cfg.getBaseUrl();
        if(StringUtils.isEmpty(baseUrl)) {
            throw new RuntimeException("\nwebdriver.base.url is not configured correctly,\n"
                    + "even though this may be set in serenity.properties,\n"
                    + "there seems to be a defect, so run maven with a -D switch like this:\n"
                    + "  mvn clean verify -Dwebdriver.base.url=https://www.volkswagen.co.uk\n");
        }
        LOGGER.info("Base URL is: {}", baseUrl);
    }

}
