import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FrameExample {

    WebDriver driver;

    @BeforeMethod
    public  void frameTestsPAge(){
        driver  = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/frame.xhtml");
    }

    @Test
    public void frameTests(){
        //1) Click me (Inside frame)

        driver.switchTo().frame(0);
        WebElement button1 = driver.findElement(By.xpath("//button[@id='Click']"));
        button1.click();

        String afterClickButtonText = button1.getText();
        System.out.println("After click Inside frame button Text " + afterClickButtonText);


        //2) Click me (Inside Nested frame)

        driver.switchTo().defaultContent();

        driver.switchTo().frame(2);
        driver.switchTo().frame("frame2");

        WebElement button3 = driver.findElement(By.id("Click"));
        button3.click();

        String afterClickNestedButtonText = button3.getText();
        System.out.println("After click Inside frame button Text " + afterClickNestedButtonText);


        //3) How many frames in this page
        driver.switchTo().defaultContent();

        List<WebElement> getIframeTagCount = driver.findElements(By.tagName("iframe"));
        int size = getIframeTagCount.size();
        System.out.println("Iframe tag count : " + size);

//        driver.switchTo().frame(2);
//        List<WebElement> getIframeTagCount2 = driver.findElements(By.tagName("iframe"));
//        int size2 = getIframeTagCount2.size();
//
//        int totalSize = size + size2;
//        System.out.println("Iframe total tag count : " + totalSize);
    }
}
