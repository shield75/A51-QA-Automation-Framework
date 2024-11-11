import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.UUID;

public class BaseTest {

    public WebDriver driver = null;
    public String url = null;
    public WebDriverWait wait = null;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"baseUrl"})
    public void launchBrowser(String baseUrl) {
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        url = baseUrl;
        navigateToPage();
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public void navigateToPage() {
        driver.get(url);
    }

    public void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSubmit() throws InterruptedException {
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submit.click();
    }


    public void clickAvatarIcon() {
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        avatarIcon.click();
    }

    public void provideCurrentPassword(String password) {
        WebElement currentPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='current_password']")));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }

    public void clickSaveButton() {
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-submit")));
        saveButton.click();
    }

    public void provideProfileName(String randomName) {
        WebElement profileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        profileName.clear();
        profileName.sendKeys(randomName);
    }

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public void isAvatarDisplayed() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    public void searchSong(String songName) throws InterruptedException {
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("input[type='search']"))));
        //WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.click();
        searchField.clear();
        searchField.sendKeys(songName);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("section[class='songs'] article[draggable='true']"))));
    }

    public void viewAllSong() throws InterruptedException {
        WebElement viewAllButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"))));
        viewAllButton.click();
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("(//table[@class='items'])[2]//tr"), 0));
    }

    public void addToPlaylistButton(String playlistName) throws InterruptedException {
        WebElement addToButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[title='Add selected songs to…']")));
        addToButton.click();
        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//section[@id='songResultsWrapper']//ul/li[contains(text(), '" + playlistName + "')]")
        ));
        playlist.click();
    }

    public void deleteAPlaylist() throws InterruptedException{
        WebElement firstPlaylist = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("section#playlists > ul > li:nth-of-type(3) > a"))));
        String playlistName = firstPlaylist.getText();
        firstPlaylist.click();
        WebElement deletePlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("button[title='Delete this playlist']"))));
        deletePlaylistButton.click();
        WebElement alert = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".success.show"))));
        String alertText = alert.getText();
        String finalAlertText = "Deleted playlist " + '"'+ playlistName + '.'+ '"';
        Assert.assertEquals(alertText, finalAlertText);
    }

    public void playNextSong(){
        WebElement nextSongButton = driver.findElement(By.cssSelector("i[title='Play next song']"));
        nextSongButton.click();
    }

    public void playResumeSong(){
        WebElement playButton = driver.findElement(By.cssSelector("span[title='Play or resume'] i[class='fa fa-play']"));
        playButton.click();
    }

    public void verifySongPlaying(){
        WebElement soundBar = driver.findElement(By.cssSelector("img[alt='Sound bars']"));
        WebElement pauseButton = driver.findElement(By.cssSelector("span[title='Pause'] i[class='fa fa-pause']"));
        if(soundBar.isDisplayed() || pauseButton.isDisplayed()){
            assert true;
        }
    }
}