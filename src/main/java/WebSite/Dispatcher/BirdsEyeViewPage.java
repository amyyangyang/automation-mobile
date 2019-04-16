package WebSite.Dispatcher;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class BirdsEyeViewPage {
    private WebDriver driver;

    public BirdsEyeViewPage(WebDriver driver){
        this.driver = driver;
    }

    private By title = xpath("//h4[@class='page-title']");
    private By content = xpath("//button[@title='Zoom in']");
    private By navBirdsEyeViewButton = xpath("//li[@id='nav_birdview']//a[@ui-sref='fleet.birdview']");


    public int getContent() {
        return driver.findElements(content).size();
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public BirdsEyeViewPage clickNavBirksEyeViewPutton(){
        driver.findElement(navBirdsEyeViewButton).click();
        return new BirdsEyeViewPage(driver);
    }
}
