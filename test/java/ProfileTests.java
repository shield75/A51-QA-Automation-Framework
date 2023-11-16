import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;
import pagefactory.ProfilePage;

public class ProfileTests extends BaseTest {

    @Test
    public void changeCurrentTheme()   {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        loginPage.provideEmail("demo@class.com")
                 .providePassword("te$t$tudent")
                 .clickSubmit();

        homePage.clickProfileIcon();

        profilePage.chooseVioletTheme();

        Assert.assertTrue(profilePage.isVioletThemeSelected());

    }
}
