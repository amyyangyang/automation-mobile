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
//        Thread.sleep(40000);
        availableLoadsAllPage.clickMenuButtonFirstLevel("Payments");
    }

    @Test
    public void checkPaymentsListPage() throws InterruptedException {
        Assert.assertTrue(pageProperty.getTextByName("Payments").contains("Payments"));
        boolean isPresentPayments = pageProperty.isElementPresent("path", paymentsPage.paymentList.get("firstPayment"));
        if (isPresentPayments) {
            Assert.assertTrue(paymentsPage.isPaymentStatusCorrect());
            Assert.assertTrue(pageProperty.isTextPresent("THIS MONTH"));
            Assert.assertTrue(pageProperty.isTextPresent("THIS YEAR"));
            Assert.assertTrue(pageProperty.getElementText("path", paymentsPage.paymentList.get("paymentPrice")).contains("$"));
        } else {
            Assert.assertEquals(pageProperty.getTextByName("Book"), "Book a load below so we can start paying you tons of money!");
        }
    }

}
