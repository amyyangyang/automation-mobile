package pages.xGuest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.By.xpath;


public class StartPage {
    private WebDriver driver;

    public StartPage(WebDriver driver){
        this.driver = driver;
    }


    private By saveButton = xpath("//*[contains(@text, 'Save')]");
    private By signUpButton = xpath("//*[contains(@text, 'Sign Up')]");

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

    public SignUpPage clickSignUpButton() {
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }



}
