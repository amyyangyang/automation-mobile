package testcases.common;

import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.aguest.SignUpPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import com.nexttrucking.automation.mobile.dispatcher.MyDriversPage;
import com.nexttrucking.automation.mobile.property.PageProperty;

import javax.xml.parsers.ParserConfigurationException;

import com.nexttrucking.automation.mobile.property.Utils;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.*;
import property.SetProperty;

import java.net.MalformedURLException;


public class SignUpTest extends SetProperty {

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
    public void signUpAsOwnerOperator() throws InterruptedException, ParserConfigurationException {
            welcomePage.clickSignUpButton();
            signUpPage.typeCompanyInformation(getTestData("usDocket"), getTestData("companyName"));
            signUpPage.clickContinueButton();
            signUpPage.chooseUserRole("OwnerOperator");
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
            signUpPage.typeEmail(getTestData("emailForGuestOO"));
            signUpPage.typePassword(getTestData("passwordForGuest"));
            signUpPage.clickSignUpButton();
            Thread.sleep(5000);
            boolean isRoleTitlePresent = signUpPage.isElementPresent("path", signUpPage.pageTitle);
            if (isRoleTitlePresent) {
                signUpPage.clickSignInButton();
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
                allowLocationPage.clickAllowLocationButton();
                myDriversPage.selectDriverType("Power Only");
                myDriversPage.clickContinueButton();
                myDriversPage.selectDriverSize("3 axle Power Only");
                signUpPage.submitInformation();
                Thread.sleep(5000);
                Assert.assertEquals(Utils.removeSpace(signUpPage.getElementText("path", signUpPage.followingMessageAfterSigningUp)), Utils.removeSpace(signUpPage.followingMessageAfterSigningUpText));
                Assert.assertEquals(Utils.removeSpace(signUpPage.getElementText("path", signUpPage.messageAfterSigningUp)), Utils.removeSpace(signUpPage.messageAfterSigningUpText));
            }
    }

    @After
    public void logOut() throws InterruptedException {
            availableLoadsAllPage.clickMenuButtonFirstLevel("Account");
            availableLoadsAllPage.clickMenuButtonSecondLevel("Logout");
            availableLoadsAllPage.confirmLogout();
    }
}
