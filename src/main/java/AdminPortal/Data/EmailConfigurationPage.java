package AdminPortal.Data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class EmailConfigurationPage {
    private WebDriver driver;



    public EmailConfigurationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//div[@class='panel-body']");


    public int getContent() {
        return driver.findElements(content).size();
    }



}
