package WebSite.Dispatcher;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class AvailableLoadsPage {
    private WebDriver driver;

    public AvailableLoadsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By title = xpath("//li[@id='nav_bookitloads']/a[contains(text(),'Available Loads')]");
    private By content = xpath("//div[@class='loadlist-box']/div");


    public int getContent() {
        return driver.findElements(content).size();
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

}

