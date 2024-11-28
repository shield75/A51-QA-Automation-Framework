package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public By sideControls = By.xpath("//div[@class='side player-controls']");
    By searchField = By.cssSelector("input[type='search']");
    By songInSearchResult = By.cssSelector("section[class='songs'] article[draggable='true']");
    By viewAllSongBtn = By.cssSelector("button[data-test='view-all-songs-btn']");
    By songList = By.xpath("(//table[@class='items'])[2]//tr");
    By firstSong = By.xpath("//div[@class='song-list-wrap main-scroll-wrap search-results']//table[@class='items']/tr[1]");
    By addToBtn = By.cssSelector("button[title='Add selected songs to…']");
    By popUpText = By.cssSelector(".success.show");
    public By nextSongBtn = By.xpath("/html/body/div/div/footer/div[1]/i[2]");
    By playBtn = By.cssSelector("span[title='Play or resume'] i[class='fa fa-play']");
    By soundBar = By.cssSelector("img[alt='Sound bars']");
    By pauseBtn = By.cssSelector("span[title='Pause'] i[class='fa fa-pause']");

    public By findSpecificPlayList(String playListName) {
        return (By.xpath("//section[@id='songResultsWrapper']//ul/li[contains(text(), '" + playListName + "')]"));
    }

    public HomePage searchSong(String songName) {
        findElement((searchField)).click();
        findElement(searchField).sendKeys(songName);
        findElement(songInSearchResult);
        return this;
    }

    public HomePage viewAllSong() {
/*        hoverOnElement(viewAllSongBtn);
        findElement(viewAllSongBtn).click();
        numberOfElementsToBeMoreThan(songList, 0);*/
        WebElement button = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        button.click();
        return this;
    }

    public HomePage clickOnFirstSong() {
        findElement(firstSong).click();
        return this;
    }

    public HomePage addToPlaylistButton(String playlistName) throws InterruptedException {
        findElement(addToBtn).click();
        findElement(findSpecificPlayList(playlistName)).click();
        return this;
    }

    public String getSuccessPopUpText() {
        return findElement(popUpText).getText();

    }

    public void playNextSong(){
        wait.until(ExpectedConditions.elementToBeClickable(nextSongBtn)).click();
    }

    public void playResumeSong(){
        findElement(playBtn).click();
    }

    public void verifySongPlaying(){
        if(findElement(soundBar).isDisplayed() || findElement(pauseBtn).isDisplayed()){
            assert true;
        }
    }


}
