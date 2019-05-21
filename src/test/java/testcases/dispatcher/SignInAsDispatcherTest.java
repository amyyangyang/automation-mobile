package testcases.dispatcher;

import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import com.nexttrucking.automation.mobile.xguest.SignInPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import property.SetProperty;

import java.net.MalformedURLException;

public class SignInAsDispatcherTest extends SetProperty {

    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException {
        setUpDriver();
        signInPage = new SignInPage(driver);
        allowLocationPage = new AllowLocationPage(driver);
        availableLoadsAllPage = new AvailableLoadsAllPage(driver);
        signInPage.signIn(getTestData("dispatcherEmail"), getTestData("dispatcherPassword"));
        allowLocationPage.clickOkAllowLocationButton();
        allowLocationPage.clickAllowLocationButton();

    }

    @Test
    public void dispatcherSignIn() {
        availableLoadsAllPage.clickLocalButton();
        Assert.assertTrue(availableLoadsAllPage.getTitle("All").contains("All"));
    }

}
