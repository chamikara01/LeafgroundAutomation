import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class windowExample {

    WebDriver driver;

    @BeforeMethod
    public void windowTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/window.xhtml");
    }

    @Test
    public void windowTests(){
        //1) Click and Confirm new Window Opens

        String oldWindow = driver.getWindowHandle();
        System.out.println("Parent window : " + oldWindow);

        WebElement openButton = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
        openButton.click();

        Set<String> handles = driver.getWindowHandles();
        System.out.println("handles size : " + handles.size());

        //First method - using forEach loop
//        for(String newWindow:handles){
//            System.out.println(newWindow);
//            driver.switchTo().window(newWindow);
//            System.out.println("page title is " + driver.getTitle());
//        }
//
//        driver.close();
//
//        driver.switchTo().window(oldWindow);
//
//        WebElement openButton1 = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
//        boolean openbuttonVisibilty = openButton1.isDisplayed();
//        System.out.println("Open button Visibility " + openbuttonVisibilty);


        //Second method - using List
        List<String> list = new ArrayList<String>(handles); //converting set to list
        if(list.size()>1){
            driver.switchTo().window(list.get(1));
            System.out.println("child tab title is " + driver.getTitle());
            driver.close();
            driver.switchTo().window(oldWindow);
        }
        WebElement openButton1 = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
        boolean openbuttonVisibilty = openButton1.isDisplayed();
        System.out.println("Open button Visibility " + openbuttonVisibilty);

        //2) Find the number of opened tabs
        WebElement multiWindowButton = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt91']/span"));
        multiWindowButton.click();

        Set<String> multiWindows = driver.getWindowHandles();
        System.out.println("No of windows opened :" + multiWindows.size());


        //3) Close all windows except primary
        WebElement dontclosemeButton = driver.findElement(By.id("j_idt88:j_idt93"));
        dontclosemeButton.click();

        Set<String> newWindowsHandles = driver.getWindowHandles();
        for(String allwindows:newWindowsHandles){
            if(!allwindows.equals(oldWindow)){
                driver.switchTo().window(allwindows);
                driver.close();
            }
        }

        driver.switchTo().window(oldWindow);
        driver.close();
    }
}
