package WebSite.xGuest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class DispatcherGuestPage {
    private WebDriver driver;



    public DispatcherGuestPage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//a[contains(@class, 'button')]");




    public int getContent(){
        return driver.findElements(content).size();
    }



}
