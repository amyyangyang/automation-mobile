package WebSite.OwnerOperator;
import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.By.xpath;

public class PayoutPage {
    private WebDriver driver;

    public PayoutPage(WebDriver driver){
        this.driver = driver;
    }

    private org.openqa.selenium.By title = xpath("//div[@id='content']/h2");
    private org.openqa.selenium.By content = xpath("//div[@class='row list-title']");


    public int getContent() {
        return driver.findElements(content).size();
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }
}

