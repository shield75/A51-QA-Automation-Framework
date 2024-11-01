import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.UUID;

public class BaseTest {

    public WebDriver driver = null;
    public String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void launchBrowser() {
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public void navigateToPage() {
        driver.get(url);
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSubmit() throws InterruptedException {
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
        Thread.sleep(2000);
    }

    public void clickAvatarIcon() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();
    }

    public void provideCurrentPassword(String password) {
        WebElement currentPassword = driver.findElement(By.cssSelector("[name='current_password']"));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }

    public void clickSaveButton() {
        WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
        saveButton.click();
    }

    public void provideProfileName(String randomName) {
        WebElement profileName = driver.findElement(By.cssSelector("[name='name']"));
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
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.click();
        searchField.clear();
        searchField.sendKeys(songName);
        Thread.sleep(3000);
    }

    public void viewAllSong() throws InterruptedException {
        WebElement viewAllButton = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAllButton.click();
        Thread.sleep(1000);
    }

    public void clickAddToButton() throws InterruptedException {
        WebElement addToButton = driver.findElement(By.cssSelector("button[title='Add selected songs to…']"));
        addToButton.click();
        Thread.sleep(3000);
    }
    
    public void createNewPlaylist(String playlistName) throws InterruptedException {
        WebElement playlistNameField = driver.findElement(By.cssSelector("section[id='songResultsWrapper'] input[placeholder='Playlist name']"));
        playlistNameField.click();
        playlistNameField.clear();
        playlistNameField.sendKeys(playlistName);
        WebElement saveButton = driver.findElement(By.cssSelector("section[id='songResultsWrapper'] button[title='Save']"));
        saveButton.click();
        Thread.sleep(500);
    }
    public void deletePlaylist() throws InterruptedException{
        WebElement firstPlaylist = driver.findElement(By.cssSelector("section#playlists > ul > li:nth-of-type(3) > a"));
        String playlistName = firstPlaylist.getText();
        firstPlaylist.click();
        Thread.sleep(3000);
        WebElement deletePlaylistButton = driver.findElement(By.cssSelector("button[title='Delete this playlist']"));
        deletePlaylistButton.click();
        Thread.sleep(3000);
        WebElement alert = driver.findElement(By.xpath("/html/body/div[2]"));
        String alertText = alert.getText();
        String finalAlertText = "Deleted playlist " + '"'+ playlistName + '.'+ '"';
        Assert.assertEquals(alertText, finalAlertText);
    }

}