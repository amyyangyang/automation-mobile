package Website.Dispatcher;


import WebSite.Dispatcher.AvailableLoadsPage;
import WebSite.Dispatcher.BillingInfoForDispatcherPage;
import WebSite.Dispatcher.BirdsEyeViewPage;
import WebSite.Dispatcher.CarrierPacketForDispatcherPage;
import WebSite.Dispatcher.ChatPage;
import WebSite.Dispatcher.DriversPage;
import WebSite.Dispatcher.MyAccountForDispatcherPage;
import WebSite.Dispatcher.MyJobsPage;
import WebSite.Dispatcher.NotificationForDispatcherPage;
import WebSite.Dispatcher.PayoutsPage;
import WebSite.Dispatcher.PostTruckPage;
import WebSite.xGuest.SignInAsDispatcherPage;
import zProperty.SetProperty;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AvailablePages extends SetProperty {

    @Before
    public void setUp() {
        setUpWebDriver("Chrome");
        signInAsDispatcherPage = new SignInAsDispatcherPage(driver);
        driversPage = new DriversPage(driver);
        availableLoadsPage = new AvailableLoadsPage(driver);
        birdsEyeViewPage = new BirdsEyeViewPage(driver);
        postTruckPage = new PostTruckPage(driver);
        myJobsPage = new MyJobsPage(driver);
        chatPage = new ChatPage(driver);
        payoutsPage = new PayoutsPage(driver);
        billingInfoPage = new BillingInfoForDispatcherPage(driver);
        carrierPacketPage = new CarrierPacketForDispatcherPage(driver);
        myAccountPage = new MyAccountForDispatcherPage(driver);
        notificationPage = new NotificationForDispatcherPage(driver);

//  LogIn as Dispatcher
        driver.get(getTestData("defaultURLs") + "/signin/dispatcher");
        signInAsDispatcherPage.typeEmail(getTestData("dispatcherEmail"));
        signInAsDispatcherPage.typePassword(getTestData("dispatcherPassword"));
        signInAsDispatcherPage.clickSignIn();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void availableLoadsPageIsAvailable() {
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
        Assert.assertEquals("Available Loads", availableLoadsPage.getTitle());
    }

    @Test
    public void postTruckPageIsAvailable() {
        driver.get(getTestData("defaultURLs") + "/fleet/offer");
        Assert.assertEquals("Post Truck", postTruckPage.getTitle());
    }

    @Test
    public void myJobsPageIsAvailable() {
        driver.get(getTestData("defaultURLs") + "/fleet/job?page=1");
        Assert.assertEquals("Jobs", myJobsPage.getTitle());
    }

    @Test
    public void driversPageIsAvailable() {
        driver.get(getTestData("defaultURLs") + "/fleet/drivers");
        Assert.assertEquals("Driver Management", driversPage.getTitle());
    }

    @Test
    public void birdsEyeViewPageIsAvailable() {
        birdsEyeViewPage.clickNavBirksEyeViewPutton();
        Assert.assertEquals("Fleet Bird's-Eye View", birdsEyeViewPage.getTitle());
    }

//    @Test
//    public void chatPageIsAvailable() {
//        chatPage.clickNavChatButton();
//        for (String tab : driver.getWindowHandles()) {
//            driver.switchTo().window(tab);
//        }
//        Assert.assertTrue(chatPage.isChatVisible() != 0);
//    }

    @Test
    public void payoutsPageIsAvailable() {
        driver.get(getTestData("defaultURLs") + "/fleet/payouts/?page=1&sort=paynum:desc,date:desc,jobnum:desc,amount:desc,stat:desc");
        Assert.assertEquals("Payouts", payoutsPage.getTitle());
    }

    @Test
    public void billingInfoPageIsAvailable() {
        driver.get(getTestData("defaultURLs") + "/fleet/bankinfo");
        Assert.assertEquals("Billing Info", billingInfoPage.getTitle());
    }

    @Test
    public void carrierPacketPageIsAvailable() {
        driver.get(getTestData("defaultURLs") + "/fleet/documents");
        Assert.assertEquals("Carrier Packet", carrierPacketPage.getTitle());
    }

    @Test
    public void notificationPageIsAvailable() {
        driver.get(getTestData("defaultURLs") + "/fleet/notifications");
        Assert.assertEquals("Notifications", notificationPage.getTitle());
    }

    @Test
    public void myAccountPageIsAvailable() {
        driver.get(getTestData("defaultURLs") + "/fleet/manage");
        Assert.assertTrue(myAccountPage.getTitle().contains("Welcome"));
    }
}
