package testcases.xguest;

import org.junit.BeforeClass;
import org.junit.Test;
import java.net.MalformedURLException;
import com.nexttrucking.automation.mobile.xguest.StartPage;
import property.SetProperty;


public class GetGuestPages extends SetProperty {


    @BeforeClass
    public static void setUp() throws MalformedURLException {
        setUpWebDriver();
        startPage = new StartPage(driver);
    }

    @Test
    public void getStartPage() {
        startPage.clickSaveButton();
    }

    @Test
    public void getSignUp() {
        startPage.clickSignUpButton();

    }

}
