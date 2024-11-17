import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;



public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String playlistName = "\"Automation.\"";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        //loginPage.login();
        loginPage.provideEmail("rumenul.rimon@testpro.io")
                .providePassword("27041575")
                .clickSubmit();
        //Here needed to use hard wait as sometimes when I search a song, I couldn't find one.
        Thread.sleep(2000);
        homePage.searchSong("love")
                .viewAllSong()
                //First song click
                .clickOnFirstSong()
                .addToPlaylistButton("Automation");
        Assert.assertEquals(homePage.getSuccessPopUpText(), "Added 1 song into "+ playlistName, "Notification not found");
    }
}
