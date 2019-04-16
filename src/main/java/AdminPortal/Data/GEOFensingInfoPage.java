package AdminPortal.Data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class GEOFensingInfoPage {
    private WebDriver driver;



    public GEOFensingInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//table[@class='table oddTbody quoTable']");


    public int getContent() {
        return driver.findElements(content).size();
    }



}
