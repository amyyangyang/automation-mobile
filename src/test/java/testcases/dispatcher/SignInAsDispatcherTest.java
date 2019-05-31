package testcases.dispatcher;

import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import com.nexttrucking.automation.mobile.xguest.SignInPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import property.SetProperty;
import com.microsoft.appcenter.appium.Factory;
import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import org.junit.rules.TestWatcher;
import org.junit.Rule;

import java.net.MalformedURLException;

public class SignInAsDispatcherTest extends SetProperty {
//
    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException {
        setUpDriver();
        System.out.println(11);
        signInPage = new SignInPage(driver);
        allowLocationPage = new AllowLocationPage(driver);
        availableLoadsAllPage = new AvailableLoadsAllPage(driver);
        System.out.println(22);
        signInPage.signIn(getTestData("ownerOperatorEmail"), getTestData("ownerOperatorPassword"));
        System.out.println(33);
        Thread.sleep(10000);
        allowLocationPage.clickOkAllowLocationButton();
        Thread.sleep(7000);
        allowLocationPage.clickAllowLocationButton();
        Thread.sleep(7000);
    }

    @Test
    public void dispatcherSignIn() throws MalformedURLException, InterruptedException {

        availableLoadsAllPage.clickLocalButton();
        Assert.assertTrue(availableLoadsAllPage.getTitle("All").contains("All"));
    }

}
