package AdminPortal.Acccounting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class InvoiceManagementPage {
    private WebDriver driver;



    public InvoiceManagementPage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//tbody[@class='hoverColor borderTop ng-scope']");
    private By shipmentNumber = xpath("//a[@id='invoice_a_orderNumber_0']");
    private By shipmentSearchField = xpath("//input[@name='orderNumber']");
    private By searchButton = xpath("//button[@id='invoice_btn_search']");
    private By downloadPaperworkButton = xpath("//a[@id='invoice_btn_download']//button[1]");
    private By showPageNumber = xpath("//div[@class='col-sm-5']//select/option");



    public int getShowEntries() {
        return driver.findElements(showPageNumber).size();
    }

    public int getContent() {
        return driver.findElements(content).size();
    }

    public String getShipmentNumber(){
        return driver.findElement(shipmentNumber).getText();
    }

    public void sendShipmentNumberToSearch(){
        driver.findElement(shipmentSearchField).sendKeys(getShipmentNumber());
    }

    public InvoiceManagementPage clickSearchButton(){
        driver.findElement(searchButton).click();
        return this;
    }

    public InvoiceManagementPage clickDownloadPaperworkButton(){
        driver.findElement(downloadPaperworkButton).click();
        return this;
    }



}
