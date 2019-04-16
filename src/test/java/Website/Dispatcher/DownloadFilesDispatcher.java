package Website.Dispatcher;

import WebSite.Dispatcher.AvailableLoadsPage;
import WebSite.Dispatcher.MyJobsPage;
import WebSite.xGuest.SignInAsDispatcherPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import zProperty.SetProperty;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DownloadFilesDispatcher extends SetProperty {
    

    @Before
    public void setUp() {
        setUpWebDriver("Chrome");
        myJobsPage = new MyJobsPage(driver);
        signInAsDispatcherPage = new SignInAsDispatcherPage(driver);

        driver.get(getTestData("defaultURLs") + "/signin/dispatcher");
        signInAsDispatcherPage.typeEmail(getTestData("dispatcherEmail"));
        signInAsDispatcherPage.typePassword(getTestData("dispatcherPassword"));
        signInAsDispatcherPage.clickSignIn();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void rateConfirmationExport() throws InterruptedException {
        driver.get(getTestData("defaultURLs") + "/fleet/job?page=1&jobType=2");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myJobsPage.clickRateConButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myJobsPage.clickDownloadButton();
        Thread.sleep(25000);


        String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());



        File file = new File(filePath + "Rate_Confirmation_" + myJobsPage.getLoadNumber() + "_" + timeStamp + ".pdf");


        System.out.println(file);


        Assert.assertTrue(file.exists());

        file.delete();
//        Assert.assertTrue(true);
        Assert.assertFalse(file.exists());
    }


}
