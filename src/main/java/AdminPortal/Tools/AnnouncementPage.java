package AdminPortal.Tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class AnnouncementPage {
    private WebDriver driver;



    public AnnouncementPage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//tbody[@class='hoverColor tdVerMid ng-scope']");


    public int getContent() {
        return driver.findElements(content).size();
    }



}
