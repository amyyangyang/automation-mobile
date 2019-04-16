package AdminPortal.Tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class FeedbacksPage {
    private WebDriver driver;



    public FeedbacksPage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//table[@class='table table-striped']");


    public int getContent() {
        return driver.findElements(content).size();
    }



}
