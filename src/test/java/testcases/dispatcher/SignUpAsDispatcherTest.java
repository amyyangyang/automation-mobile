package testcases.dispatcher;

import com.nexttrucking.automation.mobile.aguest.SignUpPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import org.junit.*;
import property.SetProperty;

import java.net.MalformedURLException;


public class SignUpAsDispatcherTest extends SetProperty {

    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException {
        setUpDriver();
        welcomePage = new WelcomePage(driver, attributeName);
        signUpPage = new SignUpPage(driver, attributeName);
        allowLocationPage = new AllowLocationPage(driver, attributeName);
        availableLoadsAllPage = new AvailableLoadsAllPage(driver, attributeName);
        welcomePage.getWelcomePage();
    }

    @Test
    public void signUpAsDispatcher() throws InterruptedException{
        welcomePage.clickSignUpButton();
        signUpPage.typeEmail(getTestData("emailForGuestDispatcher"));
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
        Thread.sleep(5000);
        allowLocationPage.clickOkAllowLocationButton();
        allowLocationPage.clickAllowLocationButton();
        signUpPage.clickCloseButton();

        //here some build should be added to delete created account from AdminPortal

    }


}
