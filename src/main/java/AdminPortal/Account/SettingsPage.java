package AdminPortal.Account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class SettingsPage {
    private WebDriver driver;



    public SettingsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//div[@class='form-group']");


    public int getContent() {
        return driver.findElements(content).size();
    }



}
