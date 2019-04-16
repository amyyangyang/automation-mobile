package AdminPortal.Data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class TaskStatisticsPage {
    private WebDriver driver;



    public TaskStatisticsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//div[@id='taskRealtime']");


    public int getContent() {
        return driver.findElements(content).size();
    }



}
