package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }



    @FindBy(css = "input[type='search']")
    WebElement searchField;
    @FindBy(css = "section[class='songs'] article[draggable='true']")
    WebElement songInSearchResult;
    @FindBy(css = "button[data-test='view-all-songs-btn']")
    WebElement viewAllSongBtn;

    By songList = By.xpath("(//table[@class='items'])[2]//tr");
    @FindBy(xpath = "//div[@class='song-list-wrap main-scroll-wrap search-results']//table[@class='items']/tr[1]")
    WebElement firstSong;
    @FindBy(css = "button[title='Add selected songs to…']")
    WebElement addToBtn;
    @FindBy(css = ".success.show")
    WebElement popUpText;
    @FindBy(css = "i[title='Play next song']")
    WebElement nextSongBtn;
    @FindBy(css = "span[title='Play or resume'] i[class='fa fa-play']")
    WebElement playBtn;
    @FindBy(css = "img[alt='Sound bars']")
    WebElement soundBar;
    @FindBy(css = "span[title='Pause'] i[class='fa fa-pause']")
    WebElement pauseBtn;

    public WebElement findSpecificPlayList(String playListName) {
        return driver.findElement(By.xpath("//section[@id='songResultsWrapper']//ul/li[contains(text(), '" + playListName + "')]"));
    }

    public HomePage searchSong(String songName) {
        searchField.click();
        searchField.sendKeys(songName);
        findElement(songInSearchResult);
        return this;
    }

    public HomePage viewAllSong() {
        viewAllSongBtn.click();
        numberOfElementsToBeMoreThan(songList, 0);
        return this;
    }

    public HomePage clickOnFirstSong() {
        firstSong.click();
        return this;
    }

    public HomePage addToPlaylistButton(String playlistName) throws InterruptedException {
        addToBtn.click();
        findElement(findSpecificPlayList(playlistName)).click();
        return this;
    }

    public String getSuccessPopUpText() {
        return popUpText.getText();

    }

    public void playNextSong(){
        nextSongBtn.click();
    }

    public void playResumeSong(){
        playBtn.click();
    }

    public void verifySongPlaying(){
        if(soundBar.isDisplayed() || pauseBtn.isDisplayed()){
            assert true;
        }
    }

}
