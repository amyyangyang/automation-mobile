package Website.OwnerOperator;
import WebSite.OwnerOperator.BillingInfoForOwnerPage;
import WebSite.OwnerOperator.CarrierPacketForOwnerPage;
import WebSite.OwnerOperator.JobsPage;
import WebSite.OwnerOperator.MyAccountForOwnerPage;
import WebSite.OwnerOperator.OffersPage;
import WebSite.OwnerOperator.PayoutPage;
import WebSite.OwnerOperator.NotificationForOwnerPage;

import WebSite.xGuest.SignInAsOwnerOperatorPage;
import zProperty.SetProperty;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AvailablePagesContent extends SetProperty {

    @Before
    public void setUp() {
        setUpWebDriver("Chrome");
        signInAsOwnerOperatorPage = new SignInAsOwnerOperatorPage(driver);
        jobsPage = new JobsPage(driver);
        offersPage = new OffersPage(driver);
        payoutPage = new PayoutPage(driver);
        billingInfoForOwnerPage = new BillingInfoForOwnerPage(driver);
        notificationForOwnerPage = new NotificationForOwnerPage(driver);
        carrierPacketForOwnerPage = new CarrierPacketForOwnerPage(driver);
        myAccountForOwnerPage = new MyAccountForOwnerPage(driver);



//  LogIn as Dispatcher

        driver.get(getTestData("defaultURLs") + "/signin/owneroperator");
        signInAsOwnerOperatorPage.typeEmail(getTestData("ownerOperatorEmail"));
        signInAsOwnerOperatorPage.typePassword(getTestData("ownerOperatorPassword"));
        signInAsOwnerOperatorPage.clickSignIn();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void jobsPageContentIsAvailable() {
        Assert.assertTrue(jobsPage.getContent() > 0);
    }

    @Test
    public void offersPageContentIsAvailable() {
        driver.get(getTestData("defaultURLs") + "/trucker/offers/1");
        Assert.assertTrue(offersPage.getContent() > 0);
    }

    @Test
    public void payoutPageContentIsAvailable() {
        driver.get(getTestData("defaultURLs") + "/trucker/payouts/?page=1&sort=paynum:desc,date:desc,jobnum:desc,amount:desc,stat:desc");
        Assert.assertTrue(payoutPage.getContent() > 0);
    }

    @Test
    public void billingInfoPageContentIsAvailable() {
        driver.get(getTestData("defaultURLs") + "/trucker/bankinfo");
        Assert.assertTrue(billingInfoForOwnerPage.getContent() > 0);
    }

    @Test
    public void carrierPacketPageContentIsAvailable() {
        driver.get(getTestData("defaultURLs") + "/trucker/documents");
        Assert.assertTrue(carrierPacketForOwnerPage.getContent() > 0);
    }

    @Test
    public void notificationPageContentIsAvailable() {
        driver.get(getTestData("defaultURLs") + "/trucker/notifications");
        Assert.assertTrue(notificationForOwnerPage.getContent().size() > 0);
    }

    @Test
    public void myAccountPageContentIsAvailable() {
        driver.get(getTestData("defaultURLs") + "/trucker/manage");
        Assert.assertTrue(myAccountForOwnerPage.getContent() > 0);
    }
}
