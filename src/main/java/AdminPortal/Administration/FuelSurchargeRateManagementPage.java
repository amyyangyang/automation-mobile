package AdminPortal.Administration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class FuelSurchargeRateManagementPage {
    private WebDriver driver;



    public FuelSurchargeRateManagementPage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//form");


    public int getContent() {
        return driver.findElements(content).size();
    }



}
