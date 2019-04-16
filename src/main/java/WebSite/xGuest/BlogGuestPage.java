package WebSite.xGuest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class BlogGuestPage {
    private WebDriver driver;



    public BlogGuestPage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//div[@class='post-item']");




    public int getContent(){
        return driver.findElements(content).size();
    }



}
