package testcases.owneroperator;

import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import com.nexttrucking.automation.mobile.dispatcher.MyDriversPage;
import com.nexttrucking.automation.mobile.dispatcher.NavigationPage;
import com.nexttrucking.automation.mobile.property.PageProperty;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import property.SetProperty;

import javax.xml.parsers.ParserConfigurationException;
import java.net.MalformedURLException;

import static org.hamcrest.CoreMatchers.containsString;

public class OwnerNavigationTest extends SetProperty {
    public static NavigationPage navigationPage;


    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException, ParserConfigurationException {
        setUpDriver();
        pageProperty = new PageProperty(driver, attributeName) {
        };
        availableLoadsAllPage = new AvailableLoadsAllPage(driver, attributeName);
        allowLocationPage = new AllowLocationPage(driver, attributeName);
        welcomePage = new WelcomePage(driver, attributeName);
        signInPage = new SignInPage(driver, attributeName);
        myDriversPage = new MyDriversPage(driver, attributeName);
        navigationPage = new NavigationPage(driver, attributeName);
        // SignIn as OwnerOperator
        signInPage.signIn(getTestData("ownerOperatorEmail"), getTestData("ownerOperatorPassword"));
        availableLoadsAllPage.clickMenuButtonFirstLevel("Help");
    }

    @Test
    public void checkHelpAndNotification() {
        Assert.assertThat(navigationPage.getElementText("path", navigationPage.canHelpTitle), containsString("How can we help?"));
        Assert.assertThat(navigationPage.getElementText("path", navigationPage.canHelpBodyText), containsString("Find the answer to your question in our FAQs or chat with our support team."));
        Assert.assertThat(navigationPage.getElementText("path", navigationPage.chatButton), containsString("Chat"));
        Assert.assertThat(navigationPage.getElementText("path", navigationPage.FAQs), containsString("FAQs"));
    }

}
