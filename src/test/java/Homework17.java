import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String playlistName = "\"Automation.\"";

        provideEmail("rumenul.rimon@testpro.io");
        providePassword("27041575");
        clickSubmit();
        //If I don't give hard wait here, I cant find any songs when searched.
        Thread.sleep(3000);
        searchSong("love");
        viewAllSong();
        //First song click
        driver.findElement(By.xpath("//div[@class='song-list-wrap main-scroll-wrap search-results']//table[@class='items']/tr[1]")).click();
        addToPlaylistButton("Automation");
        WebElement popUp = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".success.show"))));
        Assert.assertEquals(popUp.getText(), "Added 1 song into "+ playlistName, "Notification not found");
    }
}
