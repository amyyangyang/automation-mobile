package AdminPortal.Carrier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class ViewOnMapePage {
    private WebDriver driver;



    public ViewOnMapePage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//div[@class='in-map-button ng-scope']");
    private By cars = xpath("//div[@class='in-map-button ng-scope']");


    public int getContent() {
        return driver.findElements(content).size();
    }

    public int getCars(){
        return driver.findElements(cars).size();
    }



}
