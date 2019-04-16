package AdminPortal;

import AdminPortal.Acccounting.InvoiceManagementPage;
import AdminPortal.Acccounting.PayoutManagementPage;
import AdminPortal.Carrier.FleetManagementPage;
import AdminPortal.Carrier.OfferManagementPage;
import AdminPortal.Carrier.TruckerManagementPage;
import AdminPortal.Home.LogInPage;
import AdminPortal.Shipment.ShipmentManagementPage;
import AdminPortal.Shipper.QuotationHistoryPage;
import AdminPortal.Shipper.QuotationReportPage;
import AdminPortal.Shipper.QuotationUsersPage;
import AdminPortal.Shipper.ShipperManagementPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import zProperty.RetryRule;
import zProperty.SetProperty;

public class ShowEntrisAdminPortal extends SetProperty {

    @Before
    public void setUp() {
        setUpWebDriver("Chrome");
        logInPage = new LogInPage(driver);

        driver.get(getTestData("defaultURL") + "/#/login");
        logInPage.typePassword(getTestData("passwordAdminPortal"))
                .typeUsername(getTestData("usernameAdminPortal"))
                .clickAuthenticateButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shipperManagementShowEntries() throws InterruptedException {
        shipperManagementPage = new ShipperManagementPage(driver);
        driver.get(getTestData("defaultURL") + "/#/shipper");
        Thread.sleep(2000);
        Assert.assertTrue(shipperManagementPage.getShowEntries() == 4);
    }

    @Test
    public void quotationManagementShowEntries() throws InterruptedException {
        quotationHistoryPage = new QuotationHistoryPage(driver);
        driver.get(getTestData("defaultURL") + "/#/quotationHistory");
        Thread.sleep(2000);
        Assert.assertTrue(quotationHistoryPage.getShowEntries() == 4);
    }

    @Test
    public void quotationUserShowEntries() throws InterruptedException {
        quotationUsersPage = new QuotationUsersPage(driver);
        driver.get(getTestData("defaultURL") + "/#/quotationUser");
        Thread.sleep(2000);
        Assert.assertTrue(quotationUsersPage.getShowEntries() == 4);
    }

    @Test
    public void truckManagementShowEntries() throws InterruptedException {
        truckerManagementPage = new TruckerManagementPage(driver);
        driver.get(getTestData("defaultURL") + "/#/trucker/?mock=false");
        Thread.sleep(2000);
        Assert.assertTrue(truckerManagementPage.getShowEntries() == 4);
    }

    @Test
    public void fleetManagementShowEntries() throws InterruptedException {
        fleetManagementPage = new FleetManagementPage(driver);
        driver.get(getTestData("defaultURL") + "/#/fleetAccount");
        Thread.sleep(2000);
        Assert.assertTrue(fleetManagementPage.getShowEntries() == 4);
    }

    @Test
    public void offerManagementShowEntries() throws InterruptedException {
        offerManagementPage = new OfferManagementPage(driver);
        driver.get(getTestData("defaultURL") + "/#/offer?mock=false");
        Thread.sleep(2000);
        Assert.assertTrue(offerManagementPage.getShowEntries() == 4);
    }

    @Test
    public void shipmentManagementShowEntries() throws InterruptedException {
        shipmentManagementPage = new ShipmentManagementPage(driver);
        driver.get(getTestData("defaultURL") + "/#/order");
        Thread.sleep(2000);
        Assert.assertTrue(shipmentManagementPage.getShowEntries() == 4);
    }

    @Test
    public void invoiceManagementShowEntries() throws InterruptedException {
        invoiceManagementPage = new InvoiceManagementPage(driver);
        driver.get(getTestData("defaultURL") + "/#/invoice");
        Thread.sleep(2000);
        Assert.assertTrue(invoiceManagementPage.getShowEntries() == 4);
    }

    @Test
    public void payoutManagementShowEntries() throws InterruptedException {
        payoutManagementPage = new PayoutManagementPage(driver);
        driver.get(getTestData("defaultURL") + "/#/payout");
        Thread.sleep(2000);
        Assert.assertTrue(payoutManagementPage.getShowEntries() == 4);
    }

}
