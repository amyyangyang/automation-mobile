package testcases.owneroperator;

import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import com.nexttrucking.automation.mobile.xguest.SignInPage;
import com.nexttrucking.automation.mobile.xguest.SignUpPage;
import com.nexttrucking.automation.mobile.xguest.WelcomePage;
import org.junit.BeforeClass;
import org.junit.Test;
import property.SetProperty;

import java.net.MalformedURLException;

public class SignUpAsOwnerOperatorTest extends SetProperty {

    private String email = "neeck@gmail.com";
    private String password = "111111";


    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException {
        setUpWebDriver();
        welcomePage = new WelcomePage(driver);
        signUpPage = new SignUpPage(driver);
    }

//    @Test
    public void signInAsOwnerOperator() {
        welcomePage.clickSaveButton();
        welcomePage.clickSignUpButton();
        signUpPage.typeEmail(getTestData("emailForGuest"));
        signUpPage.typePassword(getTestData("passwordForGuest"));
        signUpPage.clickContinueButton();
        signUpPage.chooseUserRole("Dispatcher");
        signUpPage.clickContinueButton();
        signUpPage.chooseCity(getTestData("cityName"));
        signUpPage.clickSaveHomeButton();
        signUpPage.typeFirstName(getTestData("firstName"));
        signUpPage.typeLastName(getTestData("lastName"));
        signUpPage.typePhoneNumber(getTestData("phoneNumber"));
        signUpPage.clickSignUpButton();
    }

}
