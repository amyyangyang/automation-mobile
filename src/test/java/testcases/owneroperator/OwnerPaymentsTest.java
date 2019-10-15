package testcases.owneroperator;

import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import com.nexttrucking.automation.mobile.dispatcher.PaymentsPage;
import com.nexttrucking.automation.mobile.property.PageProperty;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import property.SetProperty;
import javax.xml.parsers.ParserConfigurationException;
import java.net.MalformedURLException;


public class OwnerPaymentsTest extends SetProperty {

    public static PaymentsPage paymentsPage;

    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException, ParserConfigurationException {
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
    public void checkPaymentsListPage() throws InterruptedException {
        Assert.assertTrue(pageProperty.getTextByName("Payments").contains("Payments"));
        boolean isPresentPayments = pageProperty.isElementPresent("path", paymentsPage.paymentList.get("firstPayment"));
        if (isPresentPayments) {
            int num=driver.findElementsByXPath(paymentsPage.paymentList.get("paymentNumber")).size();
            String status=paymentsPage.getElementText("path",paymentsPage.paymentList.get("paymentStatus"));
            if((num!=1)||(!(status.equals("CANCELED")))) {
                Assert.assertTrue(pageProperty.isTextPresent("THIS MONTH"));
                Assert.assertTrue(pageProperty.isTextPresent("THIS YEAR"));
            }
            Assert.assertTrue(paymentsPage.isPaymentStatusCorrect());
            Assert.assertTrue(pageProperty.getElementText("path", paymentsPage.paymentList.get("paymentPrice")).contains("$"));
        } else {
            Assert.assertEquals(pageProperty.getTextByName("Book"), "Book a load below so we can start paying you tons of money!");
        }
    }

    @Test
    public void checkPaymentDetailsPage() throws InterruptedException {
        Assert.assertTrue(pageProperty.getTextByName("Payments").contains("Payments"));
        boolean isPresentPayments = pageProperty.isElementPresent("path", paymentsPage.paymentList.get("firstPayment"));
        if (isPresentPayments) {
            pageProperty.clickElement(paymentsPage.paymentList.get("firstPayment"));
            Assert.assertTrue(pageProperty.isTextPresent("Locations"));
            Assert.assertTrue(pageProperty.isTextPresent("Details for"));
            pageProperty.clickAnyElementByName("Details");
            Assert.assertTrue(pageProperty.isTextPresent("You'll Make"));
            Assert.assertTrue(pageProperty.isTextPresent("Rate Contract"));
            Assert.assertTrue(pageProperty.isTextPresent("Equipment"));
            signInPage.clickBackButton();
        } else {
            Assert.assertEquals(pageProperty.getTextByName("Book"), "Book a load below so we can start paying you tons of money!");
        }
    }

}
