import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.login();
        homePage.hoverOnElement(homePage.sideControls);
        homePage.playNextSong();
        homePage.playResumeSong();
        homePage.verifySongPlaying();
    }
}
