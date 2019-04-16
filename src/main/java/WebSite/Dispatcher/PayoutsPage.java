package WebSite.Dispatcher;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class PayoutsPage {
    private WebDriver driver;

    public PayoutsPage(WebDriver driver){
        this.driver = driver;
    }

    private By title = xpath("//div[@id='content']/h2");
    private By content = xpath("//div[@class='list-content ng-scope']");


    public int getContent() {
        return driver.findElements(content).size();
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }
}
