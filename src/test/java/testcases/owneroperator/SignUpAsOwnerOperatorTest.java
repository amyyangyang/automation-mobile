package testcases.owneroperator;

import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.xguest.SignUpPage;
import com.nexttrucking.automation.mobile.xguest.WelcomePage;
import org.junit.BeforeClass;
import property.SetProperty;

import java.net.MalformedURLException;

public class SignUpAsOwnerOperatorTest extends SetProperty {


    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException {
        setUpDriver();
        welcomePage = new WelcomePage(driver);
        signUpPage = new SignUpPage(driver);
        allowLocationPage = new AllowLocationPage(driver);
    }

//    @Test
    public void signInAsOwnerOperator() {
        welcomePage.clickSaveButton();
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
        allowLocationPage.clickOkAllowLocationButton();
        allowLocationPage.clickAllowLocationButton();
        signUpPage.clickCloseButton();

        //here some build should be added to delete created account from AdminPortal

    }

}
