import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class Homework16 extends BaseTest {

    @Test
    public void registrationNavigation() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickOnRegistrationLink();

        String registrationUrl = "https://qa.koel.app/registration";
        wait.until(ExpectedConditions.urlToBe(registrationUrl));
        Assert.assertEquals(driver.getCurrentUrl(), registrationUrl, "URL does not match");

    }
}
