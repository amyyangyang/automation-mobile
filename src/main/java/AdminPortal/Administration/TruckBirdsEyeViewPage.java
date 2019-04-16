package AdminPortal.Administration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class TruckBirdsEyeViewPage {
    private WebDriver driver;



    public TruckBirdsEyeViewPage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//div[@class='in-map-button ng-scope']");
    private By cars = xpath("//div[@class='in-map-button ng-scope']");




    public int getCars(){
        return driver.findElements(cars).size();
    }

    public int getContent() {
        return driver.findElements(content).size();
    }



}
