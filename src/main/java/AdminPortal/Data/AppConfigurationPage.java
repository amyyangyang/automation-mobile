package AdminPortal.Data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class AppConfigurationPage {
    private WebDriver driver;



    public AppConfigurationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//div[@class='well row ng-scope']");


    public int getContent() {
        return driver.findElements(content).size();
    }



}
