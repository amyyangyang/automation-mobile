package AdminPortal.Tools;

import WebSite.Dispatcher.BirdsEyeViewPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class LaneHistoryPage {
    private WebDriver driver;



    public LaneHistoryPage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//table[contains(@class, '_1feKNGpFTK')]");


    public int getContent() {
        return driver.findElements(content).size();
    }





}
