package AdminPortal.Shipment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class NewShipmentPage {
    private WebDriver driver;



    public NewShipmentPage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//form[@role='form']/div[contains(@class, 'panel')]");


    public int getContent() {
        return driver.findElements(content).size();
    }



}
