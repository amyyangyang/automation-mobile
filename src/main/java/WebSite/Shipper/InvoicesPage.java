package WebSite.Shipper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class InvoicesPage {

    private WebDriver driver;
    public InvoicesPage(WebDriver driver){
        this.driver = driver;
    }

    private By title = xpath("//h2");
    private By content = xpath("//table[@class='table invoiceListTable']");
    private By viewDetailButton = xpath("//tr[@class='table-hover ng-scope'][1]//a[@class='tertiaryButton']");
    private By advanceSearchButton = xpath("//a[@class='tertiaryButton']");
    private By selectButton = xpath("//select[@id='status']");
    private By selectAllButton = xpath("//option[contains(text(), 'All')]");
    private By searchButton = xpath("//button[@id='searchBtn']");


    public int getContent() {
        return driver.findElements(content).size();
    }


    public String getTitle() {
        return driver.findElement(title).getText();
    }


    public InvoicesDetailPage clickViewDetailButton() {
        driver.findElement(viewDetailButton).click();
        return new InvoicesDetailPage(driver);
    }

    public InvoicesPage clickAdvancesearchButton() {
        driver.findElement(advanceSearchButton).click();
        return this;
    }

    public InvoicesPage clickSelectAllButton() throws InterruptedException {
        driver.findElement(selectButton).click();
        Thread.sleep(1000);
        driver.findElement(selectAllButton).click();
        return this;
    }

    public InvoicesPage clickSearchButton() throws InterruptedException {
        driver.findElement(searchButton).click();
        return this;
    }
}
