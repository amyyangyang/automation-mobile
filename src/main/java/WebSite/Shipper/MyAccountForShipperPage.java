package WebSite.Shipper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class MyAccountForShipperPage {

    private WebDriver driver;

    public MyAccountForShipperPage(WebDriver driver){
        this.driver = driver;
    }

    private By title = xpath("//h2");
    private By content = xpath("//div[@class='row required']");


    public int getContent() {
        return driver.findElements(content).size();
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }
}

