package testcases.owneroperator;

import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.aguest.SignUpPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import org.junit.BeforeClass;
import org.junit.Test;
import property.SetProperty;
import java.net.MalformedURLException;


public class SignUpAsOwnerOperatorTest extends SetProperty {


    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException {
        welcomePage = new WelcomePage(driver, attributeName);
        signUpPage = new SignUpPage(driver, attributeName);
        allowLocationPage = new AllowLocationPage(driver, attributeName);
        welcomePage.getWelcomePage();
    }

//    @Test
//    All method from this test should be modified according new way for create xPath locators for both (Android and iOS) systems
    public void signInAsOwnerOperator() throws InterruptedException{
        welcomePage.clickSignUpButton();
        signUpPage.typeEmail(getTestData("emailForGuest"));
        signUpPage.typePassword(getTestData("passwordForGuest"));
        signUpPage.clickContinueButton();
        signUpPage.chooseUserRole("OwnerOperator");
        signUpPage.clickContinueButton();
        signUpPage.chooseCity(getTestData("cityName"));
        signUpPage.clickSaveHomeButton();
        signUpPage.typeFirstName(getTestData("firstName"));
        signUpPage.typeLastName(getTestData("lastName"));
        signUpPage.typePhoneNumber(getTestData("phoneNumber"));
        signUpPage.clickSignUpButton();
        Thread.sleep(5000);
        allowLocationPage.clickOkAllowLocationButton();
        allowLocationPage.clickAllowLocationButton();
        signUpPage.clickCloseButton(); //you should fix this method to use it fot iOS testing

        //here some build should be added to delete created account from AdminPortal

    }

}
