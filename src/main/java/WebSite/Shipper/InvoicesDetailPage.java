package WebSite.Shipper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class InvoicesDetailPage {

    private WebDriver driver;
    public InvoicesDetailPage(WebDriver driver){
        this.driver = driver;
    }

    private By title = xpath("//h2");
    private By content = xpath("//table[@class='table invoiceListTable']");
    private By invoiceNumber = xpath("//a[@class='ng-binding']");
    private By viewDownloadButton = xpath("//a[@title='Download Invoice as PDF']");


    public int getContent() {
        return driver.findElements(content).size();
    }


    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public String getInvoiceNumber() {
        return driver.findElement(invoiceNumber).getText();
    }

    public InvoicesDetailPage clickDownloadButton() {
        driver.findElement(viewDownloadButton).click();
        return this;
    }
}
