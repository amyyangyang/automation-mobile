package AdminPortal.Shipper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class QuotationReportPage {
    private WebDriver driver;



    public QuotationReportPage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//div[@class='panel-body']");
    private By downloadButton = xpath("//tbody[1]//tr[1]//td[8]//a[1]");


    public int getContent() {
        return driver.findElements(content).size();
    }

    public QuotationReportPage clickDownloadButton(){
        driver.findElement(downloadButton).click();
        return this;
    }





}
