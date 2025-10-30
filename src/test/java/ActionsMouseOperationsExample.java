import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsMouseOperationsExample {

    WebDriver driver;

    @BeforeMethod
    public void mouseOperationsTestsBrowserOpen(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void mouseOperationsTest1(){
        driver.get("https://www.leafground.com/drag.xhtml");
        System.out.println("1) <<<<<<<<<<<<<<<<<<<<<Move to an element operation>>>>>>>>>>>>>>>>>>>>");

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt37"))).perform();
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt38"))).perform();
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt39"))).perform();

//        actions.moveToElement(driver.findElement(By.id("menuform:j_idt37")))
//                .moveToElement(driver.findElement(By.id("menuform:j_idt38")))
//                .moveToElement(driver.findElement(By.id("menuform:j_idt39"))).perform();


        System.out.println("2) <<<<<<<<<<<<<<<<<<<<<Drag and Drop operation>>>>>>>>>>>>>>>>>>>>");

        WebElement from = driver.findElement(By.id("form:drag"));
        WebElement to = driver.findElement(By.id("form:drop"));

        actions.clickAndHold(from).moveToElement(to).release(to).perform(); //1st way
//        actions.dragAndDrop(from, to).perform(); //2nd way


        System.out.println("3) <<<<<<<<<<<<<<<<<<<<<Slider operation>>>>>>>>>>>>>>>>>>>>");

        WebElement sliderpoint1 = driver.findElement(By.xpath("//div[@id='form:j_idt125']//span[1]"));
        System.out.println("Location on sliderpoint1 before moving " + sliderpoint1.getLocation());
        actions.dragAndDropBy(sliderpoint1, 50, 0).perform();
        System.out.println("Location on sliderpoint1 after moving " + sliderpoint1.getLocation());
    }

    @Test
    public void mouseOperationsTest2(){
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        System.out.println("4)<<<<<<<<<<<<<<<Right click>>>>>>>>>>>>>>>");
        WebElement rightClickButtonElement = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

        Actions actions = new Actions(driver);
        actions.contextClick(rightClickButtonElement).perform();
        driver.findElement(By.xpath("//span[text()='Edit']")).click();
        Alert alertPop = driver.switchTo().alert();
        System.out.println("Alert shows the text as : " + alertPop.getText());
        alertPop.accept();
    }
}
