package WebSite.Dispatcher;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class NotificationForDispatcherPage {
    private WebDriver driver;

    public NotificationForDispatcherPage(WebDriver driver){
        this.driver = driver;
    }

    private By title = xpath("//h2");
    private By content = xpath("//div[@class='row']/label");


    public List<WebElement> getContent() {
        return driver.findElements(content);
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }
}
