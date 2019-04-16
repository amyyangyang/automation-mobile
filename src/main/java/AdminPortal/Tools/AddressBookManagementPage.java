package AdminPortal.Tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class AddressBookManagementPage {
    private WebDriver driver;



    public AddressBookManagementPage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//tr[@class='hoverColorTr ng-scope']");


    public int getContent() {
        return driver.findElements(content).size();
    }



}
