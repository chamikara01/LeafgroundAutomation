import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ActionKeyboardExample {

    WebDriver driver;

    @BeforeMethod
    public void keyboardOperationsTestsBrowserOpen(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void KeyBoardActionsTest1(){
        driver.get("https://www.google.com/");
        WebElement googleSearchTextBox = driver.findElement(By.name("q"));
        googleSearchTextBox.sendKeys("Welcome");

        Actions actions = new Actions(driver);
        //Select the text
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

        actions.keyDown(Keys.SHIFT)
                .sendKeys("writing capital sentence")
                .keyUp(Keys.SHIFT)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .keyDown(Keys.CONTROL)
                .sendKeys("x")
                .keyUp(Keys.CONTROL)
                .perform();

//        actions.keyDown(googleSearchTextBox, Keys.SHIFT).sendKeys("learn with chami").perform();
    }

    @Test
    public void KeyBoardActionsTest2(){
        driver.get("https://www.leafground.com/list.xhtml");

        List<WebElement> selectable =  driver.findElements(By.xpath("//ul[@aria-label='From']/li"));
        int size = selectable.size();
        System.out.println("Li count is : " + size);

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                .click(selectable.get(0))
                .click(selectable.get(1))
                .click(selectable.get(2))
                .perform();
    }
}
