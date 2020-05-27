package testcases.dispatcher;

import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import com.nexttrucking.automation.mobile.dispatcher.PaymentsPage;
import com.nexttrucking.automation.mobile.dispatcher.PaymentDetailPage;
import com.nexttrucking.automation.mobile.property.PageProperty;
import com.nexttrucking.automation.mobile.property.Utils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import property.SetProperty;

import javax.xml.parsers.ParserConfigurationException;
import java.net.MalformedURLException;

import static org.hamcrest.CoreMatchers.hasItem;

public class DispatcherPaymentsTest extends SetProperty {

    public static PaymentsPage paymentsPage;
    public static PaymentDetailPage paymentDetailPage;

    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException, ParserConfigurationException {
        setUpDriver();
        pageProperty = new PageProperty(driver, attributeName) {
        };
        availableLoadsAllPage = new AvailableLoadsAllPage(driver, attributeName);
        signInPage = new SignInPage(driver, attributeName);
        paymentsPage = new PaymentsPage(driver, attributeName);
        paymentDetailPage = new PaymentDetailPage(driver, attributeName);
        // SignIn as OwnerOperator
        signInPage.signIn(getTestData("dispatcherEmail"), getTestData("dispatcherPassword"));
        availableLoadsAllPage.clickMenuButtonFirstLevel("Payments");
    }

    //@Test
    public void checkPaymentsListPage() {
        Assert.assertTrue(pageProperty.getTextByName("Payments").contains("Payments"));
        boolean isPresentPayments = pageProperty.isElementPresent("id", paymentsPage.paymentStatus);
        if (isPresentPayments) {
            Assert.assertThat(Utils.paymentStatusList, hasItem(driver.findElementByAccessibilityId(paymentsPage.paymentStatus).getText()));
            Assert.assertNotNull(driver.findElementByAccessibilityId(paymentsPage.paymentJobNumber).getText());
            Assert.assertTrue(driver.findElementByAccessibilityId(paymentsPage.paymentJobPrice).getText().startsWith("$"));
            Assert.assertNotNull(driver.findElementByAccessibilityId(paymentsPage.paymentAddressAndTimeInfo).getText());
        } else {
            Assert.assertEquals(pageProperty.getTextByName("Book"), "Book a load below so we can start paying you tons of money!");
        }
    }

    //@Test
    public void checkPaymentDetailsPage() throws InterruptedException {
        Assert.assertTrue(pageProperty.getTextByName("Payments").contains("Payments"));
        boolean isPresentPayments = pageProperty.isElementPresent("id", paymentsPage.paymentJobNumber);
        if (isPresentPayments) {
            pageProperty.clickElementByLocator("id",paymentsPage.paymentJobNumber);
            Assert.assertTrue(pageProperty.isTextPresent("Locations"));
            Assert.assertTrue(pageProperty.isTextPresent("Details for"));

            paymentDetailPage.clickElementByLocator("path", paymentDetailPage.locationPanel);
            boolean isTerminalJob = paymentDetailPage.isTerminalJob(paymentDetailPage.addressText);
            paymentDetailPage.clickElementByLocator("path", paymentDetailPage.locationPanel);

            pageProperty.clickAnyElementByName("Details");
            Assert.assertTrue(pageProperty.isTextPresent("You'll Make"));
            Assert.assertTrue(pageProperty.isTextPresent("Equipment"));
            Assert.assertTrue(pageProperty.isTextPresent("Uploaded Documents"));
            Assert.assertTrue(pageProperty.isTextPresent("Commodity"));
            Assert.assertTrue(pageProperty.isTextPresent("Goods Value"));
            Assert.assertTrue(pageProperty.isTextPresent("Weight"));

            if (isTerminalJob) {
                Assert.assertFalse(pageProperty.isTextPresent("Rate Contract"));
            } else {
                Assert.assertTrue(pageProperty.isTextPresent("Rate Contract"));
            }
            signInPage.clickBackButton();
        } else {
            Assert.assertEquals(pageProperty.getTextByName("Book"), "Book a load below so we can start paying you tons of money!");
        }
    }

}
