import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.login();
        Thread.sleep(2000);
        homePage.playNextSong();
        homePage.playResumeSong();
        homePage.verifySongPlaying();
    }
}
