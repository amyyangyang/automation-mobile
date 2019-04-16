package AdminPortal.Administration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class AppUpgradePage {
    private WebDriver driver;



    public AppUpgradePage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//div[@class='panel panel-nextCustom']");


    public int getContent() {
        return driver.findElements(content).size();
    }



}
