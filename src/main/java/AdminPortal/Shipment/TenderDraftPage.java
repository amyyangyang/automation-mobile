package AdminPortal.Shipment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class TenderDraftPage {
    private WebDriver driver;



    public TenderDraftPage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//tbody[@class='hoverColor borderTop ng-scope']");


    public int getContent() {
        return driver.findElements(content).size();
    }



}
