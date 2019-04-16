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

public class AvailablePagesContent extends SetProperty {

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
    public void availableLoadsPageContentIsAvailable() {
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
        Assert.assertTrue(availableLoadsPage.getContent() > 0);
    }

    @Test
    public void postTruckPageContentIsAvailable() {
        driver.get(getTestData("defaultURLs") + "/fleet/offer");
        Assert.assertTrue(postTruckPage.getContent() > 0);
    }

    @Test
    public void myJobsPageContentIsAvailable() {
        driver.get(getTestData("defaultURLs") + "/fleet/job?page=1");
        Assert.assertTrue(myJobsPage.getContent() > 0);
    }

    @Test
    public void driversPageContentIsAvailable() {
        driver.get(getTestData("defaultURLs") + "/fleet/drivers");
        Assert.assertTrue(driversPage.getContent().size() > 0);
    }

    @Test
    public void birdsEyeViewPageContentIsAvailable() {
        birdsEyeViewPage.clickNavBirksEyeViewPutton();
        Assert.assertTrue(birdsEyeViewPage.getContent() > 0);
    }

//    @Test
//    public void chatPageContentIsAvailable() {
//        chatPage.clickNavChatButton();
//        for (String tab : driver.getWindowHandles()) {
//            driver.switchTo().window(tab);
//        }
//        Assert.assertTrue(chatPage.getContent() != 0);
//    }

    @Test
    public void payoutsPageContentIsAvailable() {
        driver.get(getTestData("defaultURLs") + "/fleet/payouts/?page=1&sort=paynum:desc,date:desc,jobnum:desc,amount:desc,stat:desc");
        Assert.assertTrue(payoutsPage.getContent() > 0);
    }

    @Test
    public void billingInfoPageContentIsAvailable() {
        driver.get(getTestData("defaultURLs") + "/fleet/bankinfo");
        Assert.assertTrue(billingInfoPage.getContent() > 0);
    }

    @Test
    public void carrierPacketPageContentIsAvailable() {
        driver.get(getTestData("defaultURLs") + "/fleet/documents");
        Assert.assertTrue(carrierPacketPage.getContent() > 0);
    }

    @Test
    public void notificationPageContentIsAvailable() {
        driver.get(getTestData("defaultURLs") + "/fleet/notifications");
        Assert.assertTrue(notificationPage.getContent().size() > 0);
    }

    @Test
    public void myAccountPageContentIsAvailable() {
        driver.get(getTestData("defaultURLs") + "/fleet/manage");
        Assert.assertTrue(myAccountPage.getContent() > 0);
    }
}
