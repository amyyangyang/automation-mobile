package testcases.common;

import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import property.SetProperty;

import java.net.MalformedURLException;


public class ForgotPasswordTest extends SetProperty {

    @BeforeClass
    public static void setUp() throws InterruptedException, MalformedURLException {
        setUpDriver();
        welcomePage = new WelcomePage(driver, attributeName);
        signInPage = new SignInPage(driver, attributeName);
        welcomePage.getWelcomePage();
    }

    @Test
    public void forgotPassword() throws InterruptedException {
        welcomePage.clickSignInButton();
        signInPage.clickForgotButton();
        signInPage.inputEmailForForgotPassword(getTestData("driverEmail"));
        signInPage.clickSendNewPasswordButton();
        Assert.assertTrue(welcomePage.getTitle("Email Sent").contains("Email Sent"));
        signInPage.clickEmailSentOKButton();
    }

    @Test
    public void getSignIn() {
        Assert.assertTrue(welcomePage.getTitle("Already have an account?").contains("Already"));
        welcomePage.clickSignInButton();
        Assert.assertTrue(welcomePage.getTitle("Welcome Back").contains("Welcome Back"));
    }

    @Test
    public void getSignUp() {
        welcomePage.clickSignUpButton();
        Assert.assertTrue(welcomePage.getTitle("Let's").contains("Let's"));
    }

    @After
    public void goBack() {
        signInPage.clickBackButton();
    }
}
