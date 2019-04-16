package AdminPortal.Home;

import AdminPortal.Tools.LaneHistoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class HomeAdminPage {
    private WebDriver driver;



    public HomeAdminPage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//a[@class='list-group-item']");
    private By toolsMenu = xpath("//a[@id='nav_tools']");
    private By laneHistoryDrop = xpath("//a[@id='nav_laneHistory']");


    public int getContent() {
        return driver.findElements(content).size();
    }

    public HomeAdminPage clickToolButton() {
        driver.findElement(toolsMenu).click();
        return this;
    }

    public LaneHistoryPage clickLaneHistoryDrop() {
        driver.findElement(laneHistoryDrop).click();
        return new LaneHistoryPage(driver);
    }
}
