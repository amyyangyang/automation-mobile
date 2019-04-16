package WebSite.OwnerOperator;

import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class OffersPage {
    private WebDriver driver;

    public OffersPage(WebDriver driver){
        this.driver = driver;
    }

    private org.openqa.selenium.By title = xpath("//h2");
    private org.openqa.selenium.By content = xpath("//h6");


    public int getContent() {
        return driver.findElements(content).size();
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }
}
