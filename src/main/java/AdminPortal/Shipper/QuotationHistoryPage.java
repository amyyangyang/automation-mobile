package AdminPortal.Shipper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class QuotationHistoryPage {
    private WebDriver driver;



    public QuotationHistoryPage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//table[@class='table oddTbody']");
    private By showPagesumber = xpath("//div[@class='col-sm-5']//select/option");

    public int getShowEntries() {
        return driver.findElements(showPagesumber).size();
    }


    public int getContent() {
        return driver.findElements(content).size();
    }



}
