package AdminPortal.Carrier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class OfferManagementPage {
    private WebDriver driver;



    public OfferManagementPage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//tbody[contains(@class, 'hoverColor borderTop ng-scope')]");
    private By showPageNumber = xpath("//div[@class='col-sm-5']//select/option");



    public int getShowEntries() {
        return driver.findElements(showPageNumber).size();
    }

    public int getContent() {
        return driver.findElements(content).size();
    }



}
