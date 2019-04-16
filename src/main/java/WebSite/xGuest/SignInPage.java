package WebSite.xGuest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.By.xpath;


public class SignInPage {
    private WebDriver driver;
    JavascriptExecutor jse;

    public SignInPage(WebDriver driver){
        this.driver = driver;
        this.jse = (JavascriptExecutor)driver;
    }
//    public

//    JavascriptExecutor jse = (JavascriptExecutor)driver;
    private By shipperButton = xpath("//div[@class='form-group shipper-signin']//div[@class='scrim']");
    private By ownerOperatorButton = xpath("//div[@class='form-group oo-signin']//div[@class='scrim']");
    private By dispatcherButton = xpath("//div[@class='form-group fleet-signin']//div[@class='scrim']");
    private By singIpTitle = xpath("//h2[@class='title']");


    public SignInAsShipperPage clickShipperButton(){
        jse.executeScript("arguments[0].click();", driver.findElement(shipperButton));
        return new SignInAsShipperPage(driver);
    }

    public SignInAsOwnerOperatorPage clickOwnerOperatorButton(){
        jse.executeScript("arguments[0].click();", driver.findElement(ownerOperatorButton));
        return new SignInAsOwnerOperatorPage(driver);
    }

    public SignInAsDispatcherPage clickDispatcherButton(){
        jse.executeScript("arguments[0].click();", driver.findElement(dispatcherButton));
        return new SignInAsDispatcherPage(driver);
    }

    public String getTitle() {
        return driver.findElement(singIpTitle).getText();
    }






}
