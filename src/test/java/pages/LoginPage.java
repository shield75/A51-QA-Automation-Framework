package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitBtn = By.cssSelector("button[type='submit']");
    By registrationLink = By.cssSelector("a[href='registration']");

    public void provideEmail(String email) {
        findElement(emailField).sendKeys(email);
    }

    public void providePassword(String password) {
        findElement(passwordField).sendKeys(password);
    }

    public void clickSubmit() {
        findElement(submitBtn).click();
    }

    public void login() {
        provideEmail("rumenul.rimon@testpro.io");
        providePassword("27041575");
        clickSubmit();
    }

    public void clickOnRegistrationLink() {
        findElement(registrationLink).click();
    }
}