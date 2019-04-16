package WebSite.xGuest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class AboutUsGuestPage {
    private WebDriver driver;



    public AboutUsGuestPage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//div[contains(@class, 'fusion-person')]");


    public boolean getContent() {
        return driver.findElement(content).isDisplayed();
    }
}
