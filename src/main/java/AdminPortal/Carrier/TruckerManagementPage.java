package AdminPortal.Carrier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class TruckerManagementPage {
    private WebDriver driver;
    public TruckerManagementPage(WebDriver driver) {
        this.driver = driver;
    }


    private By lastEmail = xpath("//tbody[@class='hoverColor ng-scope'][1]//div[@class='text-over']/a[1]");
    private By deleteLastAccountButton = xpath("//table[@class='table table-striped']//tbody[1]//tr[1]//td[12]//button[2]");
    private By deleteSubmitButton = xpath("//form[@name='deleteForm']//button[@type='submit']");
    private By content = xpath("//tbody[contains(@class, 'hoverColor ng-scope')]");
    private By exportAsExcelButton = xpath("//div[@id='originThead']//thead//button[1]");
    private By showPageNumber = xpath("//div[@class='col-sm-5']//select/option");

    public int getShowEntries() {
        return driver.findElements(showPageNumber).size();
    }

    public int getContent() {
        return driver.findElements(content).size();
    }

    public String findLastEmail(){
        return driver.findElement(lastEmail).getText();
    }


    public void clickDeleteLastShipperAccount(){
        driver.findElement(deleteLastAccountButton).click();
    }

    public void clickDeleteSubmitButton(){
        driver.findElement(deleteSubmitButton).click();
    }

    public String isLastUserVisible(){
        return driver.findElement(lastEmail).getText();
    }

    public TruckerManagementPage clickExportButton(){
        driver.findElement(exportAsExcelButton).click();;
        return this;
    }
}
