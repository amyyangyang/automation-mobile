package testcases.aguest;

import com.nexttrucking.automation.mobile.aguest.SignInPage;
import org.junit.*;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import property.SetProperty;

import java.net.MalformedURLException;


public class GetWelcomePagesTest extends SetProperty {

    @BeforeClass
    public static void setUp() throws InterruptedException, MalformedURLException {

//        setUpDriver();
        welcomePage = new WelcomePage(driver, attributeName);
        signInPage = new SignInPage(driver, attributeName);
        welcomePage.getWelcomePage();
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
