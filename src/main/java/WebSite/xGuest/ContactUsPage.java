package WebSite.xGuest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class ContactUsPage {
    private WebDriver driver;



    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//div[contains(@class, 'fusion-fullwidth')]");



    public int getContent(){
        return driver.findElements(content).size();

    }
}
