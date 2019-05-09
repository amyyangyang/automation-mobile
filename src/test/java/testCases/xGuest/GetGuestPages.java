package testCases.xGuest;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.net.MalformedURLException;
import pages.xGuest.StartPage;
import zProperty.SetProperty;


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
