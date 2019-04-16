package WebSite.Dispatcher;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.xpath;


public class MyJobsPage {

    private WebDriver driver;

    public MyJobsPage(WebDriver driver){
        this.driver = driver;
    }

    private By title = xpath("//h4[@class='page-title']");
    private By content = xpath("//div[@class='row']/div[@class='col-sm-6 col-md-4 ng-scope']");
    private By rateConBtn = xpath("//button[@id='rateConBtn']");
    private By downloadBtn = xpath("//a[@class='secondaryButton']");
    private By loadNumber = xpath("//div[@class='col-sm-6 col-md-4 ng-scope'][1]//label[text()='Job#: ']//following-sibling::*/strong");


    public int getContent() {
        return driver.findElements(content).size();
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }
    public String getLoadNumber() {
        return driver.findElement(loadNumber).getText();
    }
    public void clickRateConButton() {
        driver.findElement(rateConBtn).click();
    }


    public void clickDownloadButton() {
        driver.findElement(downloadBtn).click();
    }


}
