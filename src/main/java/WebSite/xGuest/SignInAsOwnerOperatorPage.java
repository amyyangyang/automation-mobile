package WebSite.xGuest;

import WebSite.OwnerOperator.JobsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.xpath;


public class SignInAsOwnerOperatorPage {
    private WebDriver driver;

    public SignInAsOwnerOperatorPage(WebDriver driver){
        this.driver = driver;
    }


    private By singIpTitle = xpath("//h3");
    private By emailField = xpath("//input[@id='email']");
    private By passwordField = xpath("//input[@id='password']");
    private By signInButton = xpath("//button[@id='loginTruckerBtn']");
    private String errorByText = "//span[@class='text-danger' and text()=\"%s\"]";


    public String getTitle() {
        return driver.findElement(singIpTitle).getText();
    }

    public SignInAsOwnerOperatorPage typeEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignInAsOwnerOperatorPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public JobsPage clickSignIn() {
        driver.findElement(signInButton).click();
        return new JobsPage(driver);
    }

    public WebElement gerErrorByText(String errorMessage){
        return driver.findElement(By.xpath(String.format(errorByText, errorMessage)));
    }

    public boolean isSignInButtonDisable(){
        return driver.findElement(signInButton).isDisplayed();
    }

    public String getUsernameForOwnerOperator(){
        String getUsernameForOwnerOperator = null;
        String profile = System.getProperty("ENV_VAR");
        switch (profile) {
            case "DevXA2":
                getUsernameForOwnerOperator = "usernameForOwnerOperator_DevXA2";
                break;
            case "Test":
                getUsernameForOwnerOperator = "usernameForOwnerOperator_Test";
                break;
            case "Demo":
                getUsernameForOwnerOperator = "usernameForOwnerOperator_Demo";
                break;
        }
        return getUsernameForOwnerOperator;
    }
}
