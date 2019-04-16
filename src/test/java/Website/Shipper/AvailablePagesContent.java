package Website.Shipper;

import WebSite.Shipper.BillingInfoForShipperPage;
import WebSite.Shipper.DashboardPage;
import WebSite.Shipper.InvoicesPage;
import WebSite.Shipper.MyAccountForShipperPage;
import WebSite.Shipper.NewShipmentsPage;
import WebSite.Shipper.NotificationForSipperPage;
import WebSite.Shipper.ShipmentsPage;
import WebSite.xGuest.SignInAsShipperPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import zProperty.SetProperty;


public class AvailablePagesContent extends SetProperty {

    @Before
    public void setUp() {
        setUpWebDriver("Chrome");
        signInAsShipperPage = new SignInAsShipperPage(driver);
    //  LogIn as Dispatcher
        driver.get(getTestData("defaultURLs") + "/signin/shipper");
        signInAsShipperPage.typeEmail(getTestData("shipperEmail"));
        signInAsShipperPage.typePassword(getTestData("shipperPassword"));
        signInAsShipperPage.clickSignIn();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    @Test
    public void signInAsShipperPageContentIsAvailable() {
        dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.getContent() > 0);
    }

    @Test
    public void newShipmentsPageContentIsAvailable() {
        newShipmentsPage = new NewShipmentsPage(driver);
        driver.get(getTestData("defaultURLs") + "/shipper/shipment/new/");
        Assert.assertTrue(newShipmentsPage.getContent() > 0);
    }

    @Test
    public void shipmentsPageContentIsAvailable() {
        shipmentsPage = new ShipmentsPage(driver);
        driver.get(getTestData("defaultURLs") + "/shipper/shipperList/shipments/1/days/?page=1");
        Assert.assertTrue(shipmentsPage.getContent() > 0);
    }

    @Test
    public void invoicesPageContentIsAvailable() {
        invoicesPage = new InvoicesPage(driver);
        driver.get(getTestData("defaultURLs") + "/shipper/invoices/1");
        Assert.assertTrue(invoicesPage.getContent() > 0);
    }

    @Test
    public void billingInfoForShipperPageContentIsAvailable() {
        billingInfoForShipperPage = new BillingInfoForShipperPage(driver);
        driver.get(getTestData("defaultURLs") + "/shipper/billinginfo//");
        Assert.assertTrue(billingInfoForShipperPage.getContent() > 0);
    }

    @Test
    public void notificationForSipperPageContentIsAvailable() {
        notificationForSipperPage = new NotificationForSipperPage(driver);
        driver.get(getTestData("defaultURLs") + "/shipper/notifications");
        Assert.assertTrue(notificationForSipperPage.getContent().size() > 0);
    }

    @Test
    public void myAccountForShipperPageContentIsAvailable() {
        myAccountForShipperPage = new MyAccountForShipperPage(driver);
        driver.get(getTestData("defaultURLs") + "/shipper/manage");
        Assert.assertTrue(myAccountForShipperPage.getContent() > 0);
    }


}
