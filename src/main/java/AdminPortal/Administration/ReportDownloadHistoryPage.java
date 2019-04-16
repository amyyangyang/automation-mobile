package AdminPortal.Administration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class ReportDownloadHistoryPage {
    private WebDriver driver;



    public ReportDownloadHistoryPage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//div[@class='well']");


    public int getContent() {
        return driver.findElements(content).size();
    }



}
