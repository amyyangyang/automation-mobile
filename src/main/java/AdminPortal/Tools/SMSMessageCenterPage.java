package AdminPortal.Tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class SMSMessageCenterPage {
    private WebDriver driver;



    public SMSMessageCenterPage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//div[@class='panel panel-nextCustom  next-msg-container']");


    public int getContent() {
        return driver.findElements(content).size();
    }



}
