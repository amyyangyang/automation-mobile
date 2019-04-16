package WebSite.Dispatcher;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;


public class PostTruckPage {

    private WebDriver driver;

    public PostTruckPage(WebDriver driver){
        this.driver = driver;
    }

    private By title = xpath("//h4[@class='page-title']");
    private By content = xpath("//div[@class='card-box-add']");


    public int getContent() {
        return driver.findElements(content).size();
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }
}

