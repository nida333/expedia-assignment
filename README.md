# hotels.com UI Automation Tests

## Technology
UI tests with [Serenity](http://thucydides.info/docs/serenity/), which is a wrapper over Cucumber and Selenium

You need:

* Java 1.8+
* Maven
* Latest version of chrome

If you want to use local Chrome / Firefox then you need the drivers for these.  For Mac run:

	brew tap homebrew/cask
	brew cask install chromedriver
	brew install geckodriver

## how to run

* make sure right versions of Java and Maven are installed
* run
	`mvn clean verify`
* Test reports can be accessed by running
    `mvn serenity:aggregate` and then
    `open target/site/serenity/index.html`
