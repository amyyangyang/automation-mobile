package WebSite.OwnerOperator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class JobsPage {
    private WebDriver driver;

    public JobsPage(WebDriver driver){
        this.driver = driver;
    }

    private By title = xpath("//h2[contains(text(),'Jobs')]");
    private By content = xpath("//div[@class='row']");


    public int getContent() {
        return driver.findElements(content).size();
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }
}
