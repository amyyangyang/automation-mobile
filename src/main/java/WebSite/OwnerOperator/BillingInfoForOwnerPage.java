package WebSite.OwnerOperator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class BillingInfoForOwnerPage {

    private WebDriver driver;

    public BillingInfoForOwnerPage(WebDriver driver){
        this.driver = driver;
    }

    private By title = xpath("//div[@id='content']//child::*[1]");
    private By content = xpath("//div[@class='row']/label");


    public int getContent() {
        return driver.findElements(content).size();
    }
    public String getTitle() {
        return driver.findElement(title).getText();
    }
}

