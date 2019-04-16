package AdminPortal.Home;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.By.xpath;



public class LogInPage{
    private WebDriver driver;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    private By authenticateLink = xpath("//a[contains(text(),'authenticate')]");
    private By usernameField = xpath("//input[@id='username']");
    private By passwordField = xpath("//input[@id='password']");
    private By authenticateButton = xpath("//button[@type='submit']");


    public LogInPage typeUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }


    public LogInPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }


    public HomeAdminPage clickAuthenticateButton(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", driver.findElement(authenticateButton));
        return new HomeAdminPage(driver);
    }


    public void deletePassword(){
        driver.findElement(passwordField).clear();
    }

}
