import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;
import java.time.Duration;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException, IOException {
        String playlistName = "\"Automation.\"";

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.login();
        Thread.sleep(2000);

        homePage.searchSong("love");
        homePage.viewAllSong();
        //First song click
        homePage.clickOnFirstSong();
        homePage.addToPlaylistButton("Automation");
        Assert.assertEquals(homePage.getSuccessPopUpText(), "Added 1 song into "+ playlistName, "Notification not found");
    }
}
