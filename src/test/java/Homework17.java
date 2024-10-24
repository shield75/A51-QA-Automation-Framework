import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String playlistName = "\"Automation.\"";

        navigateToPage();
        provideEmail("rumenul.rimon@testpro.io");
        providePassword("27041575");
        clickSubmit();
        searchSong("love");
        viewAllSong();
        //First song click
        driver.findElement(By.xpath("//div[@class='song-list-wrap main-scroll-wrap search-results']//table[@class='items']/tr[1]")).click();
        clickAddToButton();
        driver.findElement(By.xpath("//section[@id='songResultsWrapper']//ul/li[5]")).click();
        Thread.sleep(1500);
        Assert.assertEquals(driver.findElement(By.cssSelector(".success.show")).getText(), "Added 1 song into "+ playlistName, "Notification not found");
    }
}
