package AdminPortal;

import AdminPortal.Acccounting.InvoiceManagementPage;
import AdminPortal.Carrier.FleetManagementPage;
import AdminPortal.Carrier.TruckerManagementPage;
import AdminPortal.Home.LogInPage;
import AdminPortal.Shipment.ShipmentManagementPage;
import AdminPortal.Shipper.ShipperManagementPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import zProperty.RetryRule;
import zProperty.SetProperty;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ShipmentManagementAdminPortal extends SetProperty {

    @Before
    public void setUp() {
        setUpWebDriver("Chrome");
        logInPage = new LogInPage(driver);
        shipmentManagementPage = new ShipmentManagementPage(driver);

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
    public void auditHistoryContentIsAvailable() throws InterruptedException {
        driver.get(getTestData("defaultURL") + "/#/order");
        Thread.sleep(10000);
        shipmentManagementPage.clickAuditHistoryButton();
        Thread.sleep(7000);
        Assert.assertTrue(shipmentManagementPage.getAuditHistoryContent() > 0);
    }

    @Test
    public void shipmentStatusContentIsAvailable() throws InterruptedException {
        driver.get(getTestData("defaultURL") + "/#/order");
        Thread.sleep(5000);
        shipmentManagementPage.clickShipmentStatusButton();
        Thread.sleep(3000);
        Assert.assertTrue(shipmentManagementPage.getShipmentStatusContent() > 0);
    }

    @Test
    public void shipmentTimelineContentIsAvailable() throws InterruptedException {
        driver.get(getTestData("defaultURL") + "/#/order");
        Thread.sleep(5000);
        shipmentManagementPage.clickShipmentStatusButton();
        Thread.sleep(3000);
        shipmentManagementPage.clickShipmentTimelineButton();
        Thread.sleep(3000);
        Assert.assertTrue(shipmentManagementPage.getShipmentTimelineContent() > 0);
    }

    @Test
    public void shipmentExceptionContentIsAvailable() throws InterruptedException {
        driver.get(getTestData("defaultURL") + "/#/order");
        Thread.sleep(5000);
        shipmentManagementPage.clickShipmentStatusButton();
        Thread.sleep(3000);
        shipmentManagementPage.clickExceptionsButton();
        Thread.sleep(3000);
        Assert.assertTrue(shipmentManagementPage.getExceptionContent() > 0);
    }

    @Test
    public void shipmentTruckingMapContentIsAvailable() throws InterruptedException {
        driver.get(getTestData("defaultURL") + "/#/order");
        Thread.sleep(5000);
        shipmentManagementPage.clickTruckingButton();
        Thread.sleep(3000);
        Assert.assertTrue(shipmentManagementPage.getTruckingContent() > 0);
    }

    @Test
    public void shipmentTruckingHistoryContentIsAvailable() throws InterruptedException {
        driver.get(getTestData("defaultURL") + "/#/order");
        Thread.sleep(5000);
        shipmentManagementPage.clickTruckingButton();
        Thread.sleep(3000);
        shipmentManagementPage.clickTruckingHistoryButton();
        Thread.sleep(3000);
        Assert.assertTrue(shipmentManagementPage.getTruckingHistoryContent() > 0);
    }

    @Test
    public void shipmentManualPointContentIsAvailable() throws InterruptedException {
        driver.get(getTestData("defaultURL") + "/#/order");
        Thread.sleep(5000);
        shipmentManagementPage.clickTruckingButton();
        Thread.sleep(3000);
        shipmentManagementPage.clickMacroPointButton();
        Thread.sleep(3000);
        Assert.assertTrue(shipmentManagementPage.getMacroPointContent() > 0);
    }

    @Test
    public void shipmentManualUpdateContentIsAvailable() throws InterruptedException {
        driver.get(getTestData("defaultURL") + "/#/order");
        Thread.sleep(5000);
        shipmentManagementPage.clickTruckingButton();
        Thread.sleep(3000);
        shipmentManagementPage.clickManualUpdateButton();
        Thread.sleep(3000);
        Assert.assertTrue(shipmentManagementPage.getManualUpdateContent() > 0);
    }

}
