package WebSite.xGuest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class ShippersGuestPage {
    private WebDriver driver;



    public ShippersGuestPage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//a[contains(@class, 'button')]");
    private By pictures = xpath("//img[contains(@class, 'img-responsive wp-image-3')]");


    public boolean getContent() {
        return driver.findElement(content).isDisplayed();
//        return driver.findElements(content).size();
    }

    public int getPictures(){
        return driver.findElements(pictures).size();
    }



}
