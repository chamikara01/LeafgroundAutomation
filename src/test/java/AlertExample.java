import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertExample {

    WebDriver driver;

    @BeforeMethod
    public void alertTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml");
    }

    @Test
    public void alertTests(){
        //1)Alert (Simple Dialog)
        WebElement alertBox = driver.findElement(By.id("j_idt88:j_idt91"));
        alertBox.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //2)Alert (Confirm Dialog)
        WebElement confirmBox = driver.findElement(By.id("j_idt88:j_idt93"));
        confirmBox.click();
        Alert alert1 = driver.switchTo().alert();
        alert1.dismiss();

        //3)Alert (Prompt Dialog)
        WebElement promptBox = driver.findElement(By.id("j_idt88:j_idt104"));
        promptBox.click();
        Alert alert2 = driver.switchTo().alert();
        String alertText = alert2.getText();
        System.out.println("Alert text is : " + alertText);
        alert2.sendKeys("My name is Chamikara");
        alert2.accept();
    }
}
