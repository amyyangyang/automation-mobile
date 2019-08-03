package testcases.owneroperator;

import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import com.nexttrucking.automation.mobile.dispatcher.MyDriversPage;
import com.nexttrucking.automation.mobile.owneroperator.PaymentsPage;
import com.nexttrucking.automation.mobile.property.PageProperty;
import com.nexttrucking.automation.mobile.property.Utils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import property.SetProperty;

import java.net.MalformedURLException;

import static org.hamcrest.core.IsCollectionContaining.hasItem;

public class PaymentsTest extends SetProperty {

    public static PaymentsPage paymentsPage;

    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException {
        setUpDriver();
        pageProperty = new PageProperty(driver, attributeName) {};
        availableLoadsAllPage = new AvailableLoadsAllPage(driver, attributeName);
        signInPage = new SignInPage(driver, attributeName);
        paymentsPage = new PaymentsPage(driver, attributeName);
        // SignIn as OwnerOperator
        signInPage.signIn(getTestData("ownerOperatorEmail"), getTestData("ownerOperatorPassword"));
        availableLoadsAllPage.clickMenuButtonFirstLevel("Payments");
    }

    @Test
    public void checkAvailableLoadPage() throws InterruptedException {
        Assert.assertTrue(pageProperty.getTextByName("Payments").contains("Payments"));
        boolean isPresentPayments = pageProperty.isElementPresent("path", paymentsPage.paymentList.get("firstPayment"));
        if (isPresentPayments) {
            Assert.assertThat(Utils.paymentsStatusList, hasItem(pageProperty.getElementText("path", paymentsPage.paymentList.get("paymentStatus"))));
        } else {
            Assert.assertEquals(pageProperty.getTextByName("Book"), "Book a load below so we can start paying you tons of money!");
        }
    }

}
