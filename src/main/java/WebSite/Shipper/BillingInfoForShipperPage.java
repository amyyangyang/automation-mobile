package WebSite.Shipper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class BillingInfoForShipperPage {

    private WebDriver driver;

    public BillingInfoForShipperPage(WebDriver driver){
        this.driver = driver;
    }

    private By title = xpath("//h3");
    private By content = xpath("//div[contains(@class, 'row')]//input");


    public int getContent() {
        return driver.findElements(content).size();
    }
    public String getTitle() {
        return driver.findElement(title).getText();
    }
}

