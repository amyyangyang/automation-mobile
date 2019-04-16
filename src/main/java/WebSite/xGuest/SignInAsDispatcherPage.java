package WebSite.xGuest;

import WebSite.Dispatcher.AvailableLoadsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.xpath;


public class SignInAsDispatcherPage {
    private WebDriver driver;

    public SignInAsDispatcherPage(WebDriver driver){
        this.driver = driver;
    }

    private By singIpTitle = xpath("//h3");
    private By emailField = xpath("//input[@id='email']");
    private By passwordField = xpath("//input[@id='password']");
    private By signInButton = xpath("//button[@id='loginFleetBtn']");
    private String errorByText = "//span[@class='text-danger' and text()=\"%s\"]";


    public String getTitle() {
        return driver.findElement(singIpTitle).getText();
    }

    public SignInAsDispatcherPage typeEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignInAsDispatcherPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public AvailableLoadsPage clickSignIn() {
        driver.findElement(signInButton).click();
        return new AvailableLoadsPage(driver);
    }

    public WebElement gerErrorByText(String errorMessage){
        return driver.findElement(By.xpath(String.format(errorByText, errorMessage)));
    }

    public boolean isSignInButtonDisable(){
        return driver.findElement(signInButton).isDisplayed();
    }

    public String getUsernameForDispatcher(){
        String getUsernameForDispatcher = null;
        String profile = System.getProperty("ENV_VAR");
        switch (profile) {
            case "DevXA2":
                getUsernameForDispatcher = "usernameForDispatcher_DevXA2";
                break;
            case "Test":
                getUsernameForDispatcher = "usernameForDispatcher_Test";
                break;
            case "Demo":
                getUsernameForDispatcher = "usernameForDispatcher_Demo";
                break;
        }
        return getUsernameForDispatcher;
    }
}
