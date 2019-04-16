package WebSite.Shipper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class ShipmentsPage {

    private WebDriver driver;
    public ShipmentsPage(WebDriver driver){
        this.driver = driver;
    }

    private By title = xpath("//h2");
    private By content = xpath("//div[contains(@ng-repeat, 'group in groups')]");


    public int getContent() {
        return driver.findElements(content).size();
    }


    public String getTitle() {
        return driver.findElement(title).getText();
    }
}
