package WebSite.OwnerOperator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class MyAccountForOwnerPage {

    private WebDriver driver;

    public MyAccountForOwnerPage(WebDriver driver){
        this.driver = driver;
    }

    private By title = xpath("//h2[contains(text(),'Welcome')]");
    private By content = xpath("//div[@class='row required']/label");


    public int getContent() {
        return driver.findElements(content).size();
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }
}

