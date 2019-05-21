package testcases.xguest;

import com.nexttrucking.automation.mobile.xguest.SignInPage;
import com.nexttrucking.automation.mobile.xguest.SignUpPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.net.MalformedURLException;
import com.nexttrucking.automation.mobile.xguest.WelcomePage;
import property.SetProperty;


public class GetWelcomePagesTest extends SetProperty {


    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException {
        setUpDriver();
        welcomePage = new WelcomePage(driver);
        signInPage = new SignInPage(driver);
        signUpPage = new SignUpPage(driver);
        welcomePage.clickSaveButton();
    }

    @Test
    public void getWelcomePage() {
        Assert.assertTrue(welcomePage.getTitle("Own your").contains("Own your"));
    }

    @Test
    public void getSignIn() {
        welcomePage.clickSignInButton();
        Assert.assertTrue(welcomePage.getTitle("Welcome").contains("Welcome Back"));
        signInPage.clickBackButton();

    }

    @Test
    public void getSignUp() {
        welcomePage.clickSignUpButton();
        Assert.assertTrue(welcomePage.getTitle("Let's").contains("Let's"));
        signUpPage.clickBackButton();
    }

}
