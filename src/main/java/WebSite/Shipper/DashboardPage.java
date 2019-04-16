package WebSite.Shipper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.By.xpath;

public class DashboardPage {

    private WebDriver driver;
    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    private By title = xpath("//h2");
    private org.openqa.selenium.By content = xpath("//div[@class='text-ship']");


    public int getContent() {
        return driver.findElements(content).size();
    }


    public String getTitle() {
        return driver.findElement(title).getText();
    }
}
