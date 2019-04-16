package Website.xGuest;

import WebSite.xGuest.AboutUsGuestPage;
import WebSite.xGuest.BlogGuestPage;
import WebSite.xGuest.CareersGuestPage;
import WebSite.xGuest.ContactUsPage;
import WebSite.xGuest.DispatcherGuestPage;
import WebSite.xGuest.DriverForNEXTGuestPage;
import WebSite.xGuest.HomeWebPage;
import WebSite.xGuest.OwnerOperatorGuestPage;
import WebSite.xGuest.ShippersGuestPage;
import WebSite.xGuest.SupportPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import zProperty.SetProperty;

import static org.openqa.selenium.By.xpath;


public class AvailablePagesContent extends SetProperty {



    @Before
    public void setUp() {
        setUpWebDriver("Chrome");
    }

    @Test
    public void homeWebPageContentIsAvailable() {
        homeWebPage = new HomeWebPage(driver);
        driver.get(getTestData("defaultURLsGuest"));
        Assert.assertTrue(homeWebPage.getContent() > 0);
    }

    @Test
    public void shippersGuestPageContentIsAvailable() {
        shippersGuestPage = new ShippersGuestPage(driver);
        driver.get(getTestData("defaultURLsGuest") + "/shippers/");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(shippersGuestPage.getContent());
        Assert.assertEquals(4, shippersGuestPage.getPictures());
    }

    @Test
    public void ownerOperatorGuestPageContentIsAvailable() {
        ownerOperatorGuestPage = new OwnerOperatorGuestPage(driver);
        driver.get(getTestData("defaultURLsGuest") + "/owner-operators/");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(ownerOperatorGuestPage.getContent());
    }

    @Test
    public void dispatcherGuestPageContentIsAvailable() {
        dispatcherGuestPage = new DispatcherGuestPage(driver);
        driver.get(getTestData("defaultURLsGuest") + "/fleets/");
        Assert.assertEquals(2, dispatcherGuestPage.getContent());
    }

    @Test
    public void aboutUsGuestPageContentIsAvailable() {
        aboutUsGuestPage = new AboutUsGuestPage(driver);
        driver.get(getTestData("defaultURLsGuest") + "/about-us/");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(aboutUsGuestPage.getContent());
    }

    @Test
    public void careersGuestPageContentIsAvailable() {
        careersGuestPage = new CareersGuestPage(driver);
        driver.get(getTestData("defaultURLsGuest") + "/careers/");
        Assert.assertTrue(careersGuestPage.getContent() > 0);
    }

//    @Test
    public void blogGuestPageContentIsAvailable() {
        blogGuestPage = new BlogGuestPage(driver);
        homeWebPage = new HomeWebPage(driver);
        driver.get(getTestData("defaultURLsGuest"));
        homeWebPage.clickBlogButton();
        for (String tab : driver.getWindowHandles()){
            driver.switchTo().window(tab);
        }
        Assert.assertTrue(blogGuestPage.getContent() > 0);
    }

    @Test
    public void driverForNEXTGuestPageContentIsAvailable() {
        driverForNEXTGuestPage = new DriverForNEXTGuestPage(driver);
        driver.get(getTestData("defaultURLsGuest") + "/drive-for-next/");
        Assert.assertTrue(driverForNEXTGuestPage.getContent() > 0);
    }

    @Test
    public void supportPageContentIsAvailable() {
        supportPage = new SupportPage(driver);
        homeWebPage = new HomeWebPage(driver);
        driver.get(getTestData("defaultURLsGuest"));
        homeWebPage.clickSupportButton();
        for (String tab : driver.getWindowHandles()){
            driver.switchTo().window(tab);
        }
        Assert.assertTrue(supportPage.getContent() > 0);
    }



    @Test
    public void contactUsPageContentIsAvailable() {
        contactUsPage = new ContactUsPage(driver);
        driver.get(getTestData("defaultURLsGuest") + "/contact-us/");
        Assert.assertTrue(contactUsPage.getContent() > 0);
    }


}
