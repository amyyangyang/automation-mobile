package WebSite.xGuest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class CareersGuestPage {
    private WebDriver driver;



    public CareersGuestPage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//span[@class='arrow-icon']");




    public int getContent(){
        return driver.findElements(content).size();
    }



}
