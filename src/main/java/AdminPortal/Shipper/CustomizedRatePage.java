package AdminPortal.Shipper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class CustomizedRatePage {
    private WebDriver driver;



    public CustomizedRatePage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//button[contains(@class, 'btn btn-default ng-scope')]");


    public int getContent() {
        return driver.findElements(content).size();
    }



}
