import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String playlistName = "\"Automation.\"";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();

        homePage.searchSong("love");
        homePage.viewAllSong();
        //First song click
        homePage.clickOnFirstSong();
        homePage.addToPlaylistButton("Automation");
        Assert.assertEquals(homePage.getSuccessPopUpText(), "Added 1 song into "+ playlistName, "Notification not found");
    }
}
