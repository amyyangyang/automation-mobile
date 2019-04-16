package WebSite.xGuest;

import WebSite.Shipper.DashboardPage;
import WebSite.Shipper.ShipmentsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.xpath;



public class SignInAsShipperPage {
    private WebDriver driver;

    public SignInAsShipperPage(WebDriver driver){
        this.driver = driver;
    }

    private By singIpTitle = xpath("//h3");
    private By emailField = xpath("//input[@id='email']");
    private By passwordField = xpath("//input[@id='password']");
    private By signInButton = xpath("//button[@id='loginShipperBtn']");
    private String errorByText = "//span[@class='text-danger' and text()=\"%s\"]";


    public String getTitle() {
        return driver.findElement(singIpTitle).getText();
    }

    public SignInAsShipperPage typeEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignInAsShipperPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public ShipmentsPage clickSignIn() {
        driver.findElement(signInButton).click();
        return new ShipmentsPage(driver);
    }

    public WebElement gerErrorByText(String errorMessage){
        return driver.findElement(By.xpath(String.format(errorByText, errorMessage)));
    }

    public boolean isSignInButtonDisable(){
        return driver.findElement(signInButton).isDisplayed();
    }


    public String getUsernameForShipper(){
        String getUsernameForShipper = null;
        String profile = System.getProperty("ENV_VAR");
        switch (profile) {
            case "DevXA2":
                getUsernameForShipper = "usernameForShipper_DevXA2";
                break;
            case "Test":
                getUsernameForShipper = "usernameForShipper_Test";
                break;
            case "Demo":
                getUsernameForShipper = "usernameForShipper_Demo";
                break;
        }
        return getUsernameForShipper;
    }
}
