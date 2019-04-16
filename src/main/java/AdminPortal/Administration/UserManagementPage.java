package AdminPortal.Administration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class UserManagementPage {
    private WebDriver driver;



    public UserManagementPage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//tr[@class='hoverColorTr tdVerMid ng-scope']");


    public int getContent() {
        return driver.findElements(content).size();
    }



}
