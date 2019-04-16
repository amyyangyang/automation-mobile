package WebSite.xGuest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.openqa.selenium.By.xpath;


public class SignUpPage {
    private WebDriver driver;

     public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By singUpTitle = xpath("//h2");
    private By logoButton = xpath("//ul[@id='bs-navbar-normal']//img");
    private By iAmShipperRadio = xpath("//form[@name='registerForm']//div[2]//label[1]");
    private By iAmOwnerOperatorRadio = xpath("//form[@name='registerForm']//div[3]//label[1]");
    private By iAmDispatcherRadio = xpath("//form[@name='registerForm']//div[4]//label[1]");
    private By firstNameField = xpath("//input[@id='firstName']");
    private By lastNameField = xpath("//input[@placeholder='Last Name']");
    private By companyNameField = xpath("//input[@id='companyName']");
    private By emailField = xpath("//input[@id='email']");
    private By phoneNumberField = xpath("//input[@id='phone']");
    private By greenTextError = xpath("//span[contains(text(), 'Please choose a more secure password.')]");
    private String errorByText = "//span[@class='text-danger' and text()=\"%s\"]";
    private By submitButton = xpath("//button[@class='primaryButton']");
    private By passwordField = xpath("//input[@id='password']");
    private By checkbox = xpath("//input[@type='checkbox']");


    public String getTitle() {
        return driver.findElement(singUpTitle).getText();
    }


    public HomeWebPage clickLogoButton() {
        driver.findElement(logoButton).click();
        return new HomeWebPage(driver);
    }


    public SignUpPage chooseUser(String userName){
        By user = null;
        if ("Shipper".equals(userName)) {
            user = iAmShipperRadio;
        }else if ("Owner".equals(userName)){
            user = iAmOwnerOperatorRadio;
        }else if ("Dispatcher".equals(userName)){
            user = iAmDispatcherRadio;
        }
        driver.findElement(user).click();
        return this;
    }

    public WebElement gerErrorByText(String errorMessage){
        return driver.findElement(By.xpath(String.format(errorByText, errorMessage)));
    }


    public WebElement gerGreenTextError(){
        return driver.findElement(greenTextError);
    }


    public SignUpPage typeFirstName(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
        return this;
    }


    public void deleteInputValue(String fieldName){
        By field = null;
        switch (fieldName) {
            case "FirstName":
                field = firstNameField;
                break;
            case "LastName":
                field = lastNameField;
                break;
            case "Password":
                field = passwordField;
                break;
            case "CompanyName":
                field = companyNameField;
                break;
        }
        driver.findElement(field).clear();
    }


    public SignUpPage typeLastName(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
        return this;
    }

    public SignUpPage typeCompanyName(String companyName){
        driver.findElement(companyNameField).sendKeys(companyName);
        return this;
    }


    public SignUpPage typePhoneNumber(String phoneNumber){
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        return this;
    }


    public SignUpPage typeEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }


    public SignUpPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }


    public void selectCheckbox(){
        driver.findElement(checkbox).click();
    }


    public void clickSubmit(){
    }


    public boolean isSubmitButtonDisable(){
        return driver.findElement(submitButton).isDisplayed();
    }

}
