package WebSite.xGuest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class OwnerOperatorGuestPage {
    private WebDriver driver;



    public OwnerOperatorGuestPage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//a[contains(@class, 'button')]");


    public boolean getContent() {
        return driver.findElement(content).isDisplayed();
    }
}
