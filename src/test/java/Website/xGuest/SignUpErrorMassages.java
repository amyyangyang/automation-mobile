package Website.xGuest;

import WebSite.xGuest.HomeWebPage;
import WebSite.xGuest.SignUpPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import zProperty.SetProperty;

import static org.hamcrest.CoreMatchers.containsString;



public class SignUpErrorMassages extends SetProperty {

    @Before
    public void setUp() {
        setUpWebDriver("Chrome");
        signUpPage = new SignUpPage(driver);
        homeWebPage = new HomeWebPage(driver);
    }

// get page
    @Test
    public void getSingUpPage(){
        driver.get(getTestData("defaultURLsGuest"));
        homeWebPage.clickSingUpButton();
        for (String tab : driver.getWindowHandles()){
            driver.switchTo().window(tab);
        }
        Assert.assertEquals("Sign up", signUpPage.getTitle());
        Assert.assertTrue(signUpPage.isSubmitButtonDisable());
    }

// First Name field
    @Test
    public void invalidFirstNameError() {
        driver.get(getTestData("defaultURLs") + "/register/");
        signUpPage.chooseUser("Shipper")
                .typeFirstName(getTestData("invalidFirstName"))
                .typeLastName(getTestData("invalidLastName"));
        Assert.assertEquals("Are you sure you entered your name correctly?", signUpPage.gerErrorByText(" Are you sure you entered your name correctly? ").getText());
        Assert.assertTrue(signUpPage.isSubmitButtonDisable());
    }

    @Test
    public void emptyFirstNameError(){
        driver.get(getTestData("defaultURLs") + "/register/");
        signUpPage.chooseUser("Shipper")
                .typeFirstName(getTestData("invalidFirstName"))
                .typeLastName(getTestData("invalidLastName"));
        signUpPage.deleteInputValue("FirstName");
        signUpPage.typeEmail(getTestData("invalidEmail"));
        Assert.assertEquals("This field is required.", signUpPage.gerErrorByText(" This field is required. ").getText());
        Assert.assertTrue(signUpPage.isSubmitButtonDisable());
    }

// Last Name field
    @Test
    public void invalidLastNameError(){
        driver.get(getTestData("defaultURLs") + "/register/");
        signUpPage.chooseUser("Shipper")
                .typeLastName(getTestData("invalidLastName"))
                .typeFirstName(getTestData("invalidFirstName"));
        Assert.assertEquals("Are you sure you entered your name correctly?", signUpPage.gerErrorByText(" Are you sure you entered your name correctly? ").getText());
        Assert.assertTrue(signUpPage.isSubmitButtonDisable());
    }

    @Test
    public void emptyLastNameError(){
        driver.get(getTestData("defaultURLs") + "/register/");
        signUpPage.chooseUser("Shipper")
                .typeFirstName(getTestData("invalidFirstName"))
                .typeLastName(getTestData("invalidLastName"))
                .deleteInputValue("LastName");
        signUpPage.typeEmail(getTestData("invalidEmail"));
        Assert.assertEquals("This field is required.", signUpPage.gerErrorByText(" This field is required. ").getText());
        Assert.assertTrue(signUpPage.isSubmitButtonDisable());
    }
// Company Name field
    @Test
    public void emptyCompanyNameError(){
        driver.get(getTestData("defaultURLs") + "/register/");
        signUpPage.chooseUser("Shipper")
                .typeFirstName(getTestData("invalidFirstName"))
                .typeCompanyName(getTestData("companyName"))
                .deleteInputValue("CompanyName");
        signUpPage.typeLastName(getTestData("invalidLastName"));
        Assert.assertEquals("This field is required.", signUpPage.gerErrorByText(" This field is required. ").getText());
        Assert.assertTrue(signUpPage.isSubmitButtonDisable());
    }

// Phone Number field
    @Test
    public void invalidPhoneError(){
        driver.get(getTestData("defaultURLs") + "/register/");
        signUpPage.chooseUser("Shipper")
                .typeLastName(getTestData("invalidLastName"))
                .typeFirstName(getTestData("invalidFirstName"))
                .typePhoneNumber(getTestData("invalidPhoneNumber"))
                .typeEmail(getTestData("emailForGest"));
        Assert.assertEquals("Your phone number is invalid.", signUpPage.gerErrorByText(" Your phone number is invalid. ").getText());
        Assert.assertTrue(signUpPage.isSubmitButtonDisable());
    }

// Email field
    @Test
    public void invalidEmailError() {
        driver.get(getTestData("defaultURLs") + "/register/");
        signUpPage.typeFirstName(getTestData("firstName"))
                .typePhoneNumber(getTestData("invalidPhoneNumber"))
                .typeEmail(getTestData("invalidEmail"))
                .typeLastName(getTestData("lastName"));
        Assert.assertEquals("Your email is invalid.", signUpPage.gerErrorByText(" Your email is invalid. ").getText());
        Assert.assertTrue(signUpPage.isSubmitButtonDisable());
    }

// Password field
    @Test
    public void shortPasswordError(){
        driver.get(getTestData("defaultURLs") + "/register/");
        signUpPage.typePassword(getTestData("shortPassword"))
                .typeEmail(getTestData("invalidEmail"));
        Assert.assertEquals("Password must be at least 6 characters.", signUpPage.gerErrorByText(" Password must be at least 6 characters. ").getText());
        Assert.assertTrue(signUpPage.isSubmitButtonDisable());
    }

    @Test
    public void emptyPasswordError(){
        driver.get(getTestData("defaultURLs") + "/register/");
        signUpPage.typePassword(getTestData("password6_1"))
                .deleteInputValue("Password");
        signUpPage.typeEmail(getTestData("invalidEmail"));
        signUpPage.typeFirstName(getTestData("firstName"));
        Assert.assertEquals(" This field is required. ", signUpPage.gerErrorByText(" This field is required. ").getAttribute("innerText"));
        Assert.assertTrue(signUpPage.isSubmitButtonDisable());
    }

    @Test
    public void notSecurePasswordError(){
        driver.get(getTestData("defaultURLs") + "/register/");
        signUpPage.typePassword(getTestData("password6_1"))
                .typeEmail(getTestData("invalidEmail"));
        Assert.assertThat(signUpPage.gerGreenTextError().getText(), containsString("Please choose a more secure password."));
        Assert.assertTrue(signUpPage.isSubmitButtonDisable());
    }

}
