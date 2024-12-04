package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import static testCases.BaseTest.getDriver;

public class PlayListPage extends BasePage{
    public PlayListPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = "section#playlists > ul > li:nth-of-type(3) > a")
    public WebElement firstPlaylistSong;

    @FindBy(css = "button[title='Delete this playlist']")
    public WebElement deleteButton;

    @FindBy(css = ".success.show")
    public WebElement alertSuccessText;

    public void deleteAPlaylist(){
        WebElement firstPlaylist = wait.until(ExpectedConditions.visibilityOf(firstPlaylistSong));
        String playlistName = firstPlaylist.getText();
        firstPlaylist.click();
        WebElement deletePlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        deletePlaylistButton.click();
        WebElement alert = wait.until(ExpectedConditions.visibilityOf(alertSuccessText));
        String alertText = alert.getText();
        String finalAlertText = "Deleted playlist " + '"'+ playlistName + '.'+ '"';
        Assert.assertEquals(alertText, finalAlertText);
    }

    @FindBy(css = "section#playlists > ul > li:nth-of-type(3) > a")
    public WebElement nameAPlaylist;

    @FindBy(css = "input[name='name']")
    public WebElement inputFieldName;

    @FindBy(css = ".success.show")
    public WebElement alertTextMessage;

    public void renamePlayList() throws InterruptedException {
        String namePlayList = "Rename PLayList";
        WebElement playlist = findElement(nameAPlaylist);
        actions.doubleClick(playlist).perform();
        WebElement inputField = findElement(inputFieldName);
        inputField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        inputField.sendKeys(namePlayList);
        inputField.sendKeys(Keys.ENTER);
        WebElement alert = findElement(alertTextMessage);
        String alertText = alert.getText();
        String finalAlertText = "Updated playlist " + '"'+ namePlayList + '.' + '"';
        Assert.assertEquals(alertText, finalAlertText);
    }
}
