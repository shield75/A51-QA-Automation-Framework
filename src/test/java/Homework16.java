import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework16 extends BaseTest {

    @Test
    public void registrationNavigation() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.navigate().to("https://qa.koel.app/");
        driver.findElement(By.cssSelector("a[href='registration']")).click();


        String registrationUrl = "https://qa.koel.app/registration";
        wait.until(ExpectedConditions.titleIs(registrationUrl));
        Assert.assertEquals(driver.getCurrentUrl(), registrationUrl, "URL does not match");

        driver.quit();
    }
}
