package Website.OwnerOperator;

import WebSite.OwnerOperator.JobsPage;
import WebSite.xGuest.SignInAsOwnerOperatorPage;
import zProperty.SetProperty;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SignInAsOwnerOperator extends SetProperty {


    @Before
    public void setUp() {
        setUpWebDriver("Chrome");
        jobsPage = new JobsPage(driver);
        signInAsOwnerOperatorPage = new SignInAsOwnerOperatorPage(driver);
    }


    @Test
    public void ownerOperatorSignIn(){
        driver.get(getTestData("defaultURLs") + "/signin/owneroperator");

        signInAsOwnerOperatorPage.typeEmail(getTestData("ownerOperatorEmail"));
        signInAsOwnerOperatorPage.typePassword(getTestData("ownerOperatorPassword"));
        signInAsOwnerOperatorPage.clickSignIn();

        for (String tab : driver.getWindowHandles()){
            driver.switchTo().window(tab);
        }
        Assert.assertEquals("Jobs", jobsPage.getTitle());
    }
}
