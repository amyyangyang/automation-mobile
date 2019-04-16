package WebSite.Dispatcher;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class DriversPage {
    private WebDriver driver;

    public DriversPage(WebDriver driver){
        this.driver = driver;
    }

    private By title = xpath("//h4[@class='page-title']");
    private By content = xpath("//div[contains(@class, 'col-lg-3')]");


    public List<WebElement> getContent() {
        return driver.findElements(content);
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }
}
