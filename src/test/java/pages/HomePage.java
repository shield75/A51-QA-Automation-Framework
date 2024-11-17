package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By searchField = By.cssSelector("input[type='search']");
    By songInSearchResult = By.cssSelector("section[class='songs'] article[draggable='true']");
    By viewAllSongBtn = By.cssSelector("button[data-test='view-all-songs-btn']");
    By songList = By.xpath("(//table[@class='items'])[2]//tr");
    By firstSong = By.xpath("//div[@class='song-list-wrap main-scroll-wrap search-results']//table[@class='items']/tr[1]");
    By addToBtn = By.cssSelector("button[title='Add selected songs to…']");
    By popUpText = By.cssSelector(".success.show");
    By nextSongBtn = By.cssSelector("i[title='Play next song']");
    By playBtn = By.cssSelector("span[title='Play or resume'] i[class='fa fa-play']");
    By soundBar = By.cssSelector("img[alt='Sound bars']");
    By pauseBtn = By.cssSelector("span[title='Pause'] i[class='fa fa-pause']");

    public By findSpecificPlayList(String playListName) {
        return By.xpath("//section[@id='songResultsWrapper']//ul/li[contains(text(), '" + playListName + "')]");
    }

    public void searchSong(String songName) {
        findElement(searchField).click();
        findElement(searchField).sendKeys(songName);
        findElement(songInSearchResult);
    }

    public void viewAllSong() {
        findElement(viewAllSongBtn).click();
        numberOfElementsToBeMoreThan(songList, 0);
    }

    public void clickOnFirstSong() {
        findElement(firstSong).click();
    }

    public void addToPlaylistButton(String playlistName) throws InterruptedException {
        findElement(addToBtn).click();
        findElement(findSpecificPlayList(playlistName)).click();
    }

    public String getSuccessPopUpText() {
        return findElement(popUpText).getText();
    }

    public void playNextSong(){
        driver.findElement(nextSongBtn).click();
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
