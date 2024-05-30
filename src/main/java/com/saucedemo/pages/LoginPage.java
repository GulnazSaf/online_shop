package com.saucedemo.pages;

import com.saucedemo.base.TestBase;
import com.saucedemo.exceptions.SaucedemoLoginException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(id = "user-name")
    WebElement userNameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(xpath = "//button[@class = 'error-button']")
    WebElement invalidLoginErrorMsg;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public ProductsPage performLogin (String user, String password) throws SaucedemoLoginException {
        if (userNameInput.isDisplayed() && passwordInput.isDisplayed()) {
            userNameInput.clear();
            userNameInput.sendKeys(user);
            passwordInput.clear();
            passwordInput.sendKeys(password);
            loginButton.click();
            return new ProductsPage();
        } else {
            throw new SaucedemoLoginException("Unable to perform login");
        }
    }

    public boolean isInvalidLoginErrorMessageDisplayed() {
        return invalidLoginErrorMsg.isDisplayed();
    }


}
