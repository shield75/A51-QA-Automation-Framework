import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        homePage.playNextSong();
        homePage.playResumeSong();
        homePage.verifySongPlaying();
    }
}
