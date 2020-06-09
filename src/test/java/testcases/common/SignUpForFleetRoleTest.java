package testcases.common;

import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.aguest.SignUpPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import com.nexttrucking.automation.mobile.dispatcher.MyDriversPage;
import com.nexttrucking.automation.mobile.property.PageProperty;
import com.nexttrucking.automation.mobile.property.Utils;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import property.SetProperty;

import javax.xml.parsers.ParserConfigurationException;
import java.net.MalformedURLException;


public class SignUpForFleetRoleTest extends SetProperty {

    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException {
        setUpDriver();
        welcomePage = new WelcomePage(driver, attributeName);
        allowLocationPage = new AllowLocationPage(driver, attributeName);
        pageProperty = new PageProperty(driver, attributeName) {
        };
        signUpPage = new SignUpPage(driver, attributeName);
        allowLocationPage = new AllowLocationPage(driver, attributeName);
        availableLoadsAllPage = new AvailableLoadsAllPage(driver, attributeName);
        myDriversPage = new MyDriversPage(driver, attributeName);
        signInPage = new SignInPage(driver, attributeName);
        welcomePage.getWelcomePage();
    }

    @Test
    public void signUpAsDispatcher() throws InterruptedException, ParserConfigurationException {
            welcomePage.clickSignUpButton();
            signUpPage.typeCompanyInformation(getTestData("usDocket"), getTestData("companyName"));
            signUpPage.clickContinueButton();
            signUpPage.chooseUserRole("Dispatcher");
            signUpPage.clickContinueButton();
            signUpPage.typeFirstName(getTestData("firstName"));
            signUpPage.typeLastName(getTestData("lastName"));
            signUpPage.typePhoneNumber(getTestData("phoneNumber"));
            signUpPage.clickContinueButton();
            signUpPage.chooseCity(getTestData("cityName"));
            signUpPage.clickContinueButton();
            Thread.sleep(3000);
            signUpPage.chooseMode(getTestData("mode"));
            signUpPage.clickContinueButton();
            signUpPage.typeEmail(getTestData("emailForGuestDispatcher"));
            signUpPage.typePassword(getTestData("passwordForGuest"));
            signUpPage.hideKeyboard();
            signUpPage.clickSignUpButton();
            Thread.sleep(5000);
            boolean isPageTitlePresent = signUpPage.isElementPresent("path", signUpPage.pageTitle);
            if (isPageTitlePresent) {
                signUpPage.clickSignInButton();
                Thread.sleep(5000);
                signUpPage.typePassword(getTestData("passwordForGuest"));
                signInPage.clickSignInButton();
                Thread.sleep(5000);
                allowLocationPage.clickOkAllowLocationButton();
                allowLocationPage.clickAllowLocationButton();
                Thread.sleep(3000);
                boolean isAlertPresent = signUpPage.isElementPresent("path", signUpPage.promptMessage);
                if (isAlertPresent) {
                    signUpPage.clickAlert();
                }
                Assert.assertTrue(availableLoadsAllPage.getTitle("Available").contains("Available"));
            } else {
                allowLocationPage.clickOkAllowLocationButton();
                Thread.sleep(3000);
                Assert.assertEquals(Utils.removeSpace(signUpPage.getElementText("path", signUpPage.followingMessageAfterSigningUp)), Utils.removeSpace(signUpPage.followingMessageAfterSigningUpText));
                Assert.assertEquals(Utils.removeSpace(signUpPage.getElementText("path", signUpPage.messageAfterSigningUp)), Utils.removeSpace(signUpPage.messageAfterSigningUpText));
            }
    }

    //@Test
    public void signUpDriver() throws InterruptedException, ParserConfigurationException {
        String driverEmail = "rftest+newd" + Utils.getRandomString(2) + "@nexttrucking.com";
        signInPage.signIn(getTestData("dispatcherEmail"), getTestData("dispatcherPassword"));
        availableLoadsAllPage.clickMenuButtonFirstLevel("My Drivers");
        myDriversPage.clickAddDriverButton();
        myDriversPage.typeEmail(driverEmail);
        myDriversPage.typePassword(getTestData("driverAddPassword"));
        myDriversPage.clickContinueButton();
        boolean isSignInButtonPresent = signUpPage.isElementPresent("path", signUpPage.equipmentTitle);
        if (!isSignInButtonPresent) {
            pageProperty.clickAnyElementByName("OK");
            signUpPage.clickCloseButton();
        } else {
            myDriversPage.selectDriverType("Power Only");
            myDriversPage.clickContinueButton();
            myDriversPage.selectDriverSize("3");
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
            availableLoadsAllPage.clickMenuButtonFirstLevel("Account");
            availableLoadsAllPage.clickMenuButtonSecondLevel("Logout");
            availableLoadsAllPage.confirmLogout();
    }
}
