package AdminPortal.Data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class UserUpdateLogPage {
    private WebDriver driver;



    public UserUpdateLogPage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//tbody[@class='ng-scope']");


    public int getContent() {
        return driver.findElements(content).size();
    }



}
