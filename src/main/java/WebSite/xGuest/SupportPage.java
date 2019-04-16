package WebSite.xGuest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.By.xpath;


public class SupportPage {
    private WebDriver driver;
//    private Actions actions;

    public SupportPage(WebDriver driver){
        this.driver = driver;
    }


    private By content = xpath("//div[@class='g__space']");


    public int getContent() {
        return driver.findElements(content).size();
    }





}
