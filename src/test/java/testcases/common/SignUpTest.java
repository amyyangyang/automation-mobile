package testcases.common;

import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.aguest.SignUpPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import com.nexttrucking.automation.mobile.dispatcher.MyDriversPage;
import org.junit.*;
import org.junit.jupiter.api.Tag;
import property.SetProperty;

import java.net.MalformedURLException;


public class SignUpTest extends SetProperty {

    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException {
        if (attributeName.equals("text")) {
            setUpDriver();
            welcomePage = new WelcomePage(driver, attributeName);
            signUpPage = new SignUpPage(driver, attributeName);
            allowLocationPage = new AllowLocationPage(driver, attributeName);
            availableLoadsAllPage = new AvailableLoadsAllPage(driver, attributeName);
            myDriversPage = new MyDriversPage(driver, attributeName);
            signInPage = new SignInPage(driver, attributeName);
            welcomePage.getWelcomePage();
        }
    }

    @Test
    @Tag("write")
    public void signUpAsDispatcher() throws InterruptedException{
        if (attributeName.equals("text")) {
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
            Thread.sleep(3000);
            Assert.assertTrue(availableLoadsAllPage.getTitle("Add").contains("Add"));
        }
    }

    @Test
    @Tag("write")
    public void signUpAsOwnerOperator() throws InterruptedException{
        if (attributeName.equals("text")) {
            welcomePage.clickSignUpButton();
            signUpPage.typeEmail(getTestData("emailForGuestOO"));
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
            signUpPage.clickCloseButton();
            Thread.sleep(3000);
            Assert.assertTrue(availableLoadsAllPage.getTitle("Add").contains("Add"));
        }
    }

    @Test
    @Tag("write")
    public void signUpDriver() throws InterruptedException {
        if (attributeName.equals("text")) {
            signInPage.signIn(getTestData("dispatcherEmail"), getTestData("dispatcherPassword"));
            availableLoadsAllPage.clickMenuButtonFirstLevel("My Drivers");
            myDriversPage.clickAddDriverButton();
            myDriversPage.typeEmail(getTestData("driverAddEmail"));
            myDriversPage.typePassword(getTestData("driverAddPassword"));
            myDriversPage.clickContinueButton();
            myDriversPage.selectDriverType("Reefer");
            myDriversPage.clickContinueButton();
            myDriversPage.selectDriverSize("48");
            myDriversPage.clickContinueButton();
            myDriversPage.typeFirstName(getTestData("driveFirstName"));
            myDriversPage.typeLastName(getTestData("driveLastName"));
            signUpPage.typePhoneNumber(getTestData("drivePhoneNumber"));
            myDriversPage.clickSignUpButton();
            Assert.assertTrue(myDriversPage.getFirstDriverName("TestFirst").contains("Test"));
        }
    }


    @After
    public void logOut() throws InterruptedException {
        if (attributeName.equals("text")) {
            availableLoadsAllPage.clickMenuButtonFirstLevel("Account");
            availableLoadsAllPage.clickMenuButtonSecondLevel("Logout");
            availableLoadsAllPage.confirmLogout();
        }
    }


}
