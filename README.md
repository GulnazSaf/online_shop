# SauceDemo Testing Project

This project contains Selenium tests written in Java to automate the testing of the [SauceDemo](https://www.saucedemo.com/) website. The tests cover various functionalities of the website including login, product page, and shopping cart operations.

## Project Structure
- src
  - main
    - java
      - com.saucedemo
        - base
          - TestBase.java
      - constants
          - TestConstants.java
      - exceptions
          - SaucedemoLoginException.java
      - pages
          - LoginPage.java
          - ProductsPage.java
          - ShoppingCartPage.java
      - utils
          - TestListener.java
          - TestUtils.java
          - WebEventListener.java
      - resources
          - config.properties
  - test
    - java
      - com.saucedemo
        - LoginTest.java
        - ProductPageTest.java
- build.gradle

## Configuration
The config.properties file in the src/main/resources directory contains configuration settings for the tests, such as the URL of the SauceDemo site and browser settings.

Running the Tests
To run the tests, use the following Gradle command:
```bash
  ./gradlew test
```


## Project Components
- Base
  - **TestBase.java**: Contains the setup and teardown methods for the tests, initializing the WebDriver and loading configurations.
- Constants
  - **TestConstants.java**: Contains constant values used across the tests.
- Exceptions
  - ** SaucedemoLoginException.java**: Custom exception for login-related errors.
- Pages
  - **LoginPage.java**: Page Object Model (POM) class for the login page.
  - **ProductsPage.java**: POM class for the products page.
  - **ShoppingCartPage.java**: POM class for the shopping cart page.
- Utils
  - **TestListener.java**: Listener class for logging and capturing screenshots on test failures.
  - **TestUtils.java**: Utility methods used in tests.
  - **WebEventListener.java**: Event listener for logging WebDriver events.
- Tests
  - **LoginTest.java**: Contains tests related to the login functionality.
  - **ProductPageTest.java**: Contains tests related to product page operations.
