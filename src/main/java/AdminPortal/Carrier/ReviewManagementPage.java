package AdminPortal.Carrier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class ReviewManagementPage {
    private WebDriver driver;



    public ReviewManagementPage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//tr[@class='ng-scope']");


    public int getContent() {
        return driver.findElements(content).size();
    }



}
