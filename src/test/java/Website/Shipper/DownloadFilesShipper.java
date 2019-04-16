package Website.Shipper;

import WebSite.Dispatcher.MyJobsPage;
import WebSite.Shipper.InvoicesDetailPage;
import WebSite.Shipper.InvoicesPage;
import WebSite.xGuest.SignInAsDispatcherPage;
import WebSite.xGuest.SignInAsShipperPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import zProperty.SetProperty;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DownloadFilesShipper extends SetProperty {
 

    @Before
    public void setUp() {
        setUpWebDriver("Chrome");
        invoicesPage = new InvoicesPage(driver);
        invoicesDetailPage = new InvoicesDetailPage(driver);
        signInAsShipperPage = new SignInAsShipperPage(driver);

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


    @Test
    public void invoicePDFExport() throws InterruptedException {
        driver.get(getTestData("defaultURLs") + "/shipper/invoices/1");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        invoicesPage.clickAdvancesearchButton();
        Thread.sleep(2000);
        invoicesPage.clickSelectAllButton();
        Thread.sleep(2000);

        invoicesPage.clickSearchButton();
        Thread.sleep(2000);
        invoicesPage.clickViewDetailButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        File file = new File(filePath + invoicesDetailPage.getInvoiceNumber() + "_Invoice.pdf");
        System.out.println(file);

        invoicesDetailPage.clickDownloadButton();
        Thread.sleep(20000);

        Assert.assertTrue(file.exists());
        file.delete();
        Assert.assertFalse(file.exists());
    }
}
