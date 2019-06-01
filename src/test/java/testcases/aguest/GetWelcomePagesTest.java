package testcases.aguest;

import com.nexttrucking.automation.mobile.xguest.SignInPage;
import org.junit.*;
import com.nexttrucking.automation.mobile.xguest.WelcomePage;
import property.SetProperty;


public class GetWelcomePagesTest extends SetProperty {


    @BeforeClass
    public static void setUp() throws InterruptedException {
        welcomePage = new WelcomePage(driver, attributeName);
        signInPage = new SignInPage(driver, attributeName);
        welcomePage.getWelcomePage();
    }

    @Test
    public void getWelcomePage() {
        Assert.assertTrue(welcomePage.getTitle("Already have an account?").contains("Already"));
    }

    @Test
    public void getSignIn() {
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
