import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class OpenGoogleTest {

    @Test
    public void googleTest () {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--headless");
        WebDriver driver  = new ChromeDriver(chromeOptions);
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("colombo" + Keys.ENTER);
//        driver.quit();
    }
}