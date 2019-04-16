package Website.Shipper;

import WebSite.Shipper.DashboardPage;
import WebSite.Shipper.ShipmentsPage;
import WebSite.xGuest.SignInAsShipperPage;
import zProperty.SetProperty;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SignInAsShipper extends SetProperty {


    @Before
    public void setUp() {
        setUpWebDriver("Chrome");
        shipmentsPage = new ShipmentsPage(driver);
        signInAsShipperPage = new SignInAsShipperPage(driver);
    }


    @Test
    public void shipperSignIn(){
        driver.get(getTestData("defaultURLs") + "/signin/shipper");

        signInAsShipperPage.typeEmail(getTestData("shipperEmail"));
        signInAsShipperPage.typePassword(getTestData("shipperPassword"));
        signInAsShipperPage.clickSignIn();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.get(getTestData("defaultURLs") + "/shipper/shipperList/shipments/1/days/?page=1");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("Shipments", shipmentsPage.getTitle());
    }
}
