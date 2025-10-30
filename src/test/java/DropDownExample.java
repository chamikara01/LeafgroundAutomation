import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownExample {
    WebDriver driver;

    @BeforeMethod
    public void dropDownTestPage(){
        driver  = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void dropDownTests(){

        driver.get("https://www.leafground.com/select.xhtml");
        //1.1) Ways to select values in basic dropdown
        WebElement dropDown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropDown);
        select.selectByIndex(1);
        select.selectByVisibleText("Playwright");

        //1.2) Get the number of options
        List<WebElement> listOfOptions =  select.getOptions();
        int size = listOfOptions.size();
        System.out.println("Number of elements in dropDown: " + size);

        for (WebElement element:listOfOptions){
            System.out.println(element.getText());
        }

        //1.3) Using sendkeys select dropDown value
        dropDown.sendKeys("Puppeteer");

        //1.4) Selecting value in a Bootstrap dropdown
        WebElement dropDown2 = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        dropDown2.click();
        List<WebElement> listofdropdown2values = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));
        for (WebElement element : listofdropdown2values){
            String dropDownValue = element.getText();
            if(dropDownValue.equals("USA")){
                element.click();
                break;
            }
        }
    }

    //02) Google Search - pick a value from suggestions

    @Test
    public void googleSearchDropDown(){
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("palitha");
        List<WebElement> googlesearchList = driver.findElements(By.xpath("//ul[@role='listbox']/li//div[@class='wM6W7d']"));
        System.out.println(googlesearchList.size());

        for (WebElement element:googlesearchList){
            System.out.println(element.getText());
//            String searchValue = element.getText();
//            if(searchValue.equals("Palitha Thewarapperuma")){
//                element.click();
//                break;
//            }
        }
    }


}

