package AdminPortal.Administration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class LoginHistoryPage {
    private WebDriver driver;



    public LoginHistoryPage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//tr[@class='hoverColorTr ng-scope']");


    public int getContent() {
        return driver.findElements(content).size();
    }



}
