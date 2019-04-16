package AdminPortal.Administration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class AuthorityManagementPage {
    private WebDriver driver;



    public AuthorityManagementPage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//div[@class='col-xs-12 col-sm-6 col-md-4 col-lg-4 col-xl-4 card-wrap ng-scope']");


    public int getContent() {
        return driver.findElements(content).size();
    }



}
