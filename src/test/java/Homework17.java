import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;



public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String playlistName = "\"Automation.\"";
5
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.login();

        homePage.searchSong("love");
        homePage.viewAllSong();
        //First song click
        homePage.clickOnFirstSong();
        homePage.addToPlaylistButton("Automation");
        Assert.assertEquals(homePage.getSuccessPopUpText(), "Added 1 song into "+ playlistName, "Notification not found");
    }
}
