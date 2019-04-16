package AdminPortal.Shipper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class ShipperManagementPage {

    private WebDriver driver;
    public ShipperManagementPage(WebDriver driver) {
        this.driver = driver;
    }


    private By lastEmail = xpath("//tbody[@class='hoverColor borderTop ng-scope'][1]//div[@ng-style='setWidthContact']/a[1]");
    private By deleteLastAccountButton = xpath("//table[@class='table oddTbody']//tbody[1]//td[11]/button[2]");
    private By deleteSubmitButton = xpath("//form[@name='deleteForm']//button[@type='submit']");
    private By content = xpath("//tbody[@class='hoverColor borderTop ng-scope']");
    private By exportAsExcelButton = xpath("//div[@id='originThead']//thead//button[1]");
    private By showPagesumber = xpath("//div[@class='col-sm-5']//select/option");

    public int getShowEntries() {
        return driver.findElements(showPagesumber).size();
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

    public ShipperManagementPage clickExportButton(){
        driver.findElement(exportAsExcelButton).click();
        return this;
    }

}
