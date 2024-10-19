import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework16 {

    @Test
    public void registrationNavigation() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.navigate().to("https://qa.koel.app/");
        driver.findElement(By.cssSelector("a[href='registration']")).click();

        Thread.sleep(1500);
        String registrationUrl = "https://qa.koel.app/registration";
        Assert.assertEquals(driver.getCurrentUrl(), registrationUrl, "URL does not match");

        driver.quit();
    }
}
