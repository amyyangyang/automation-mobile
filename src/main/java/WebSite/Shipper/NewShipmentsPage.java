package WebSite.Shipper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class NewShipmentsPage {

    private WebDriver driver;
    public NewShipmentsPage(WebDriver driver){
        this.driver = driver;
    }

    private By title = xpath("//h2");
    private By content = xpath("//p[@class='text-uppercase addressInfo ng-binding']");


    public int getContent() {
        return driver.findElements(content).size();
    }


    public String getTitle() {
        return driver.findElement(title).getText();
    }
}
