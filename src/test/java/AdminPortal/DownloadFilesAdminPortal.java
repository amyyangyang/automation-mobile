package AdminPortal;

import AdminPortal.Acccounting.InvoiceManagementPage;
import AdminPortal.Carrier.FleetManagementPage;
import AdminPortal.Carrier.TruckerManagementPage;
import AdminPortal.Home.LogInPage;
import AdminPortal.Shipment.ShipmentManagementPage;
import AdminPortal.Shipper.QuotationReportPage;
import AdminPortal.Shipper.ShipperManagementPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.util.CollectionUtils;
import zProperty.RetryRule;
import zProperty.SetProperty;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DownloadFilesAdminPortal extends SetProperty {



    @Before
    public void setUp() {
        setUpWebDriver("Chrome");
        logInPage = new LogInPage(driver);
        shipperManagementPage = new ShipperManagementPage(driver);
        fleetManagementPage = new FleetManagementPage(driver);
        truckerManagementPage = new TruckerManagementPage(driver);
        shipmentManagementPage = new ShipmentManagementPage(driver);
        invoiceManagementPage = new InvoiceManagementPage(driver);
        quotationReportPage = new QuotationReportPage(driver);

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
    public void shipperManagementExport() throws InterruptedException {
        driver.get(getTestData("defaultURL") + "/#/shipper");
        Thread.sleep(2000);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmm").format(Calendar.getInstance().getTime());
        shipperManagementPage.clickExportButton();
        Thread.sleep(10000);
        File file = new File(filePath + "next_shipper_" + timeStamp + ".xlsx");
        System.out.println(file);
        Assert.assertTrue(file.exists());
        file.delete();
        Assert.assertFalse(file.exists());
    }


    @Test
    public void truckerManagementExport() throws InterruptedException {
        driver.get(getTestData("defaultURL") + "/#/trucker/?mock=false");
        Thread.sleep(3000);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmm").format(Calendar.getInstance().getTime());
        truckerManagementPage.clickExportButton();
        Thread.sleep(15000);
        File file = new File(filePath + "next_trucker_" + timeStamp + ".xlsx");
        Assert.assertTrue(file.exists());
        file.delete();
        Assert.assertFalse(file.exists());
    }


    @Test
    public void fleetManagementExport() throws InterruptedException {
        driver.get(getTestData("defaultURL") + "/#/fleetAccount");
        Thread.sleep(3000);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmm").format(Calendar.getInstance().getTime());
        fleetManagementPage.clickExportButton();
        Thread.sleep(15000);
        File file = new File(filePath + "next_fleet_" + timeStamp + ".xlsx");
        System.out.println(file);
        Assert.assertTrue(file.exists());
        file.delete();
        Assert.assertFalse(file.exists());
    }


    @Test
    public void shipmentManagementExport() throws InterruptedException {
        driver.get(getTestData("defaultURL") + "/#/order");
        Thread.sleep(5000);
        shipmentManagementPage.chooseDedicateYes();
        shipmentManagementPage.clickSearchButton();
        Thread.sleep(3000);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmm").format(Calendar.getInstance().getTime());
        shipmentManagementPage.clickExportButton();
        Thread.sleep(10000);
        File file = new File(filePath + "next_shipment_" + timeStamp + ".xlsx");
        Assert.assertTrue(file.exists());
        file.delete();
        Assert.assertFalse(file.exists());
    }

    @Test
    public void invoiceManagementExport() throws InterruptedException {
        driver.get(getTestData("defaultURL") + "/#/invoice");
        Thread.sleep(5000);
        invoiceManagementPage.sendShipmentNumberToSearch();
        invoiceManagementPage.clickSearchButton();
        Thread.sleep(3000);
        String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        invoiceManagementPage.clickDownloadPaperworkButton();
        Thread.sleep(10000);
        File file = new File(filePath + "paperwork_zip_" + timeStamp + ".zip");
        Assert.assertTrue(file.exists());
        file.delete();
        Assert.assertFalse(file.exists());
    }

    @Test
    public void quotationReportExport() throws InterruptedException {
        driver.get(getTestData("defaultURL") + "/#/quotationReport");
        Thread.sleep(5000);
        quotationReportPage.clickDownloadButton();
        Thread.sleep(10000);

        String fileNameLast = null;
        File folder = new File(filePath);
        if(folder.exists()){
            File[] files = folder.listFiles();
            if(files != null && files.length > 0){
                for(File file : files){
                    String fileName = file.getName();
                    if(fileName.contains("QUOTATION_REPORT")){
                        fileNameLast = fileName;
                        break;
                    }
                }
            }
        }
        File file = new File(filePath + fileNameLast);
        Assert.assertTrue(file.exists());
        file.delete();
        Assert.assertFalse(file.exists());
    }
}
