package AdminPortal;

import AdminPortal.Acccounting.InvoiceManagementPage;
import AdminPortal.Acccounting.PayoutManagementPage;
import AdminPortal.Account.PasswordPage;
import AdminPortal.Account.SettingsPage;
import AdminPortal.Administration.AppUpgradePage;
import AdminPortal.Administration.AuthorityManagementPage;
import AdminPortal.Administration.ChatUserManagementPage;
import AdminPortal.Administration.DepartmentManagementPage;
import AdminPortal.Administration.FuelSurchargeRateManagementPage;
import AdminPortal.Administration.LoginHistoryPage;
import AdminPortal.Administration.ReportDownloadHistoryPage;
import AdminPortal.Administration.TruckBirdsEyeViewPage;
import AdminPortal.Administration.UserManagementPage;
import AdminPortal.Carrier.FleetManagementPage;
import AdminPortal.Carrier.OfferManagementPage;
import AdminPortal.Carrier.ReviewManagementPage;
import AdminPortal.Carrier.TruckerManagementPage;
import AdminPortal.Carrier.ViewOnMapePage;
import AdminPortal.Data.AppConfigurationPage;
import AdminPortal.Data.BookItStatusStatisticsPage;
import AdminPortal.Data.EmailConfigurationPage;
import AdminPortal.Data.GEOFensingInfoPage;
import AdminPortal.Data.QuartzJobInfoPage;
import AdminPortal.Data.SMSPhoneBlacklistPage;
import AdminPortal.Data.SystemSettingsPage;
import AdminPortal.Data.TaskStatisticsPage;
import AdminPortal.Data.UserUpdateLogPage;
import AdminPortal.Home.HomeAdminPage;
import AdminPortal.Home.LogInPage;
import AdminPortal.Shipment.NewShipmentPage;
import AdminPortal.Shipment.ShipmentManagementPage;
import AdminPortal.Shipment.TenderDraftPage;
import AdminPortal.Shipment.TenderTemplatePage;
import AdminPortal.Shipper.CustomizedRatePage;
import AdminPortal.Shipper.QuotationHistoryPage;
import AdminPortal.Shipper.QuotationReportPage;
import AdminPortal.Shipper.QuotationUsersPage;
import AdminPortal.Shipper.ShipperManagementPage;
import AdminPortal.Tools.AddressBookManagementPage;
import AdminPortal.Tools.AnnouncementPage;
import AdminPortal.Tools.FeedbacksPage;
import AdminPortal.Tools.LaneHistoryPage;
import AdminPortal.Tools.SMSMessageCenterPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import zProperty.RetryRule;
import zProperty.SetProperty;


public class AvailablePagesContent extends SetProperty {

    @Before
    public void setUpWait() {
        setUpWebDriver("Chrome");
        logInPage = new LogInPage(driver);
    //LogIn to AdminPortal
        driver.get(getTestData("defaultURL") + "/#/login");
        logInPage.typePassword(getTestData("passwordAdminPortal"))
                .typeUsername(getTestData("usernameAdminPortal"))
                .clickAuthenticateButton();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void homePageContentIsAvailable() {
        homeAdminPage = new HomeAdminPage(driver);
        driver.get(getTestData("defaultURL") + "/#/");
        Assert.assertTrue(homeAdminPage.getContent() > 0);
    }

    @Test
    public void shipperManagementPageContentIsAvailable() {
        shipperManagementPage = new ShipperManagementPage(driver);
        driver.get(getTestData("defaultURL") + "/#/shipper");
        Assert.assertTrue(shipperManagementPage.getContent() > 0);
    }

    @Test
    public void quotationHistoryPageContentIsAvailable() {
        quotationHistoryPage = new QuotationHistoryPage(driver);
        driver.get(getTestData("defaultURL") + "/#/quotationHistory");
        Assert.assertTrue(quotationHistoryPage.getContent() > 0);
    }

    @Test
    public void quotationUsersPageContentIsAvailable() {
        quotationUsersPage = new QuotationUsersPage(driver);
        driver.get(getTestData("defaultURL") + "/#/quotationUser");
        Assert.assertTrue(quotationUsersPage.getContent() > 0);
    }

    @Test
    public void quotationReportPageContentIsAvailable() {
        quotationReportPage = new QuotationReportPage(driver);
        driver.get(getTestData("defaultURL") + "/#/quotationReport");
        Assert.assertTrue(quotationReportPage.getContent() > 0);
    }

    @Test
    public void customizedRatePageContentIsAvailable() {
        customizedRatePage = new CustomizedRatePage(driver);
        driver.get(getTestData("defaultURL") + "/#/customizedRate/single");
        Assert.assertTrue(customizedRatePage.getContent() > 0);
    }

    @Test
    public void fleetManagementRatePageContentIsAvailable() {
        fleetManagementPage = new FleetManagementPage(driver);
        driver.get(getTestData("defaultURL") + "/#/fleetAccount");
        Assert.assertTrue(fleetManagementPage.getContent() > 0);
    }

    @Test
    public void truckerManagementRatePageContentIsAvailable() {
        truckerManagementPage = new TruckerManagementPage(driver);
        driver.get(getTestData("defaultURL") + "/#/trucker/?mock=false");
        Assert.assertTrue(truckerManagementPage.getContent() > 0);
    }

    @Test
    public void offerManagementRatePageContentIsAvailable() {
        offerManagementPage = new OfferManagementPage(driver);
        driver.get(getTestData("defaultURL") + "/#/offer?mock=false");
        Assert.assertTrue(offerManagementPage.getContent() > 0);
    }

    @Test
    public void reviewManagementRatePageContentIsAvailable() {
        reviewManagementPage = new ReviewManagementPage(driver);
        driver.get(getTestData("defaultURL") + "/#/orderReview?page=2");
        Assert.assertTrue(reviewManagementPage.getContent() > 0);
    }

    @Test
    public void viewOnMapPageContentIsAvailable() {
        viewOnMapePage = new ViewOnMapePage(driver);
        driver.get(getTestData("defaultURL") + "/#/viewOnMap?departmentId=0");
        Assert.assertTrue(viewOnMapePage.getContent() > 0);
    }

    @Test
    public void viewOnMapPageCarsIsAvailable() {
        viewOnMapePage = new ViewOnMapePage(driver);
        driver.get(getTestData("defaultURL") + "/#/viewOnMap?departmentId=0");
        Assert.assertTrue(viewOnMapePage.getCars() > 0);
    }

    @Test
    public void shipmentManagementPagePageContentIsAvailable() {
        shipmentManagementPage = new ShipmentManagementPage(driver);
        driver.get(getTestData("defaultURL") + "/#/order");
        Assert.assertTrue(shipmentManagementPage.getContent() > 0);
    }

    @Test
    public void newShipmentPagePageContentIsAvailable() {
        newShipmentPage = new NewShipmentPage(driver);
        driver.get(getTestData("defaultURL") + "/#/manualOrder");
        Assert.assertTrue(newShipmentPage.getContent() > 0);
    }

    @Test
    public void tenderTemplatePageContentIsAvailable() {
        tenderTemplatePage = new TenderTemplatePage(driver);
        driver.get(getTestData("defaultURL") + "/#/tenderTemplate");
        Assert.assertTrue(tenderTemplatePage.getContent() > 0);
    }

    @Test
    public void tenderDraftPageContentIsAvailable() {
        tenderDraftPage = new TenderDraftPage(driver);
        driver.get(getTestData("defaultURL") + "/#/tenderDraft?status=needCover");
        Assert.assertTrue(tenderDraftPage.getContent() > 0);
    }

    @Test
    public void invoiceManagementPageContentIsAvailable() {
        invoiceManagementPage = new InvoiceManagementPage(driver);
        driver.get(getTestData("defaultURL") + "/#/invoice");
        Assert.assertTrue(invoiceManagementPage.getContent() > 0);
    }

    @Test
    public void payoutManagementPageContentIsAvailable() {
        payoutManagementPage = new PayoutManagementPage(driver);
        driver.get(getTestData("defaultURL") + "/#/payout");
        Assert.assertTrue(payoutManagementPage.getContent() > 0);
    }

    @Test
    public void smsMessageCenterPageContentIsAvailable() {
        smsMessageCenterPage = new SMSMessageCenterPage(driver);
        driver.get(getTestData("defaultURL") + "/#/smsMsgCenter");
        Assert.assertTrue(smsMessageCenterPage.getContent() > 0);
    }

    @Test
    public void feedbacksPageContentIsAvailable() {
        feedbacksPage = new FeedbacksPage(driver);
        driver.get(getTestData("defaultURL") + "/#/helpQa");
        Assert.assertTrue(feedbacksPage.getContent() > 0);
    }

    @Test
    public void announcementPageContentIsAvailable() {
        announcementPage = new AnnouncementPage(driver);
        driver.get(getTestData("defaultURL") + "/#/annoumcement");
        Assert.assertTrue(announcementPage.getContent() > 0);
    }

    @Test
    public void addressBookManagementPageContentIsAvailable() {
        addressBookManagementPage = new AddressBookManagementPage(driver);
        driver.get(getTestData("defaultURL") + "/#/addressBook");
        Assert.assertTrue(addressBookManagementPage.getContent() > 0);
    }

    @Test
    public void laneHistoryPageContentIsAvailable() {
        laneHistoryPage = new LaneHistoryPage(driver);
        homeAdminPage = new HomeAdminPage(driver);
        homeAdminPage.clickToolButton();
        homeAdminPage.clickLaneHistoryDrop();
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
        Assert.assertTrue(laneHistoryPage.getContent() > 0);
    }

    @Test
    public void departmentManagementPageContentIsAvailable() {
        departmentManagementPage = new DepartmentManagementPage(driver);
        driver.get(getTestData("defaultURL") + "/#/department");
        Assert.assertTrue(departmentManagementPage.getContent() > 0);
    }

    @Test
    public void userManagementPageContentIsAvailable() {
        userManagementPage = new UserManagementPage(driver);
        driver.get(getTestData("defaultURL") + "/#/user");
        Assert.assertTrue(userManagementPage.getContent() > 0);
    }

//    @Test
    public void chatUserManagementPageContentIsAvailable() {
        chatUserManagementPage = new ChatUserManagementPage(driver);
        driver.get(getTestData("defaultURL") + "/#/chatUser");
        Assert.assertTrue(chatUserManagementPage.getContent() > 0);
    }

    @Test
    public void loginHistoryPageContentIsAvailable() {
        loginHistoryPage = new LoginHistoryPage(driver);
        driver.get(getTestData("defaultURL") + "/#/loginInfo");
        Assert.assertTrue(loginHistoryPage.getContent() > 0);
    }

    @Test
    public void reportDownloadHistoryPageContentIsAvailable() {
        reportDownloadHistoryPage = new ReportDownloadHistoryPage(driver);
        driver.get(getTestData("defaultURL") + "/#/reportDownload/logs");
        Assert.assertTrue(reportDownloadHistoryPage.getContent() > 0);
    }

    @Test
    public void truckBirdsEyeViewPageContentIsAvailable() {
        truckBirdsEyeViewPage = new TruckBirdsEyeViewPage(driver);
        driver.get(getTestData("defaultURL") + "/#/birdsEyeView?departmentId=0");
        Assert.assertTrue(truckBirdsEyeViewPage.getContent() > 0);
    }

    @Test
    public void truckBirdsEyeViewPageCarsIsAvailable() {
        truckBirdsEyeViewPage = new TruckBirdsEyeViewPage(driver);
        driver.get(getTestData("defaultURL") + "/#/birdsEyeView?departmentId=0");
        Assert.assertTrue(truckBirdsEyeViewPage.getCars() > 0);
    }

    @Test
    public void appUpgradePageContentIsAvailable() {
        appUpgradePage = new AppUpgradePage(driver);
        driver.get(getTestData("defaultURL") + "/#/appUpgrade");
        Assert.assertTrue(appUpgradePage.getContent() > 0);
    }

    @Test
    public void authorityManagementPageContentIsAvailable() {
        authorityManagementPage = new AuthorityManagementPage(driver);
        driver.get(getTestData("defaultURL") + "/#/authority");
        Assert.assertTrue(authorityManagementPage.getContent() > 0);
    }

    @Test
    public void fuelSurchargeRateManagementPageContentIsAvailable() {
        fuelSurchargeRateManagementPage = new FuelSurchargeRateManagementPage(driver);
        driver.get(getTestData("defaultURL") + "/#/manageFuelSurcharge");
        Assert.assertTrue(fuelSurchargeRateManagementPage.getContent() > 0);
    }

    @Test
    public void emailConfigurationPageContentIsAvailable() {
        emailConfigurationPage = new EmailConfigurationPage(driver);
        driver.get(getTestData("defaultURL") + "/#/emailsettings");
        Assert.assertTrue(emailConfigurationPage.getContent() > 0);
    }

    @Test
    public void appConfigurationPageContentIsAvailable() {
        appConfigurationPage = new AppConfigurationPage(driver);
        driver.get(getTestData("defaultURL") + "/#/appConfiguration");
        Assert.assertTrue(appConfigurationPage.getContent() > 0);
    }

    @Test
    public void systemSettingsPageContentIsAvailable() {
        systemSettingsPage = new SystemSettingsPage(driver);
        driver.get(getTestData("defaultURL") + "/#/sysSettings");
        Assert.assertTrue(systemSettingsPage.getContent() > 0);
    }

    @Test
    public void userUpdateLogPageContentIsAvailable() {
        userUpdateLogPage = new UserUpdateLogPage(driver);
        driver.get(getTestData("defaultURL") + "/#/update/logs");
        Assert.assertTrue(userUpdateLogPage.getContent() > 0);
    }

    @Test
    public void geoFensingInfoPageContentIsAvailable() {
        geoFensingInfoPage = new GEOFensingInfoPage(driver);
        driver.get(getTestData("defaultURL") + "/#/fencingInfo");
        Assert.assertTrue(geoFensingInfoPage.getContent() > 0);
    }

    @Test
    public void bookItStatusStatisticsPageContentIsAvailable() {
        bookItStatusStatisticsPage = new BookItStatusStatisticsPage(driver);
        driver.get(getTestData("defaultURL") + "/#/fastfinger");
        Assert.assertTrue(bookItStatusStatisticsPage.getContent() > 0);
    }

    @Test
    public void quartzJobInfoPageContentIsAvailable() {
        quartzJobInfoPage = new QuartzJobInfoPage(driver);
        driver.get(getTestData("defaultURL") + "/#/quartzJobInfo");
        Assert.assertTrue(quartzJobInfoPage.getContent() > 0);
    }

    @Test
    public void smsPhoneBlacklistPageContentIsAvailable() {
        smsPhoneBlacklistPage = new SMSPhoneBlacklistPage(driver);
        driver.get(getTestData("defaultURL") + "/#/sms/blacklist");
        Assert.assertTrue(smsPhoneBlacklistPage.getContent() > 0);
    }

    @Test
    public void taskStatisticsPageContentIsAvailable() {
        taskStatisticsPage = new TaskStatisticsPage(driver);
        driver.get(getTestData("defaultURL") + "/#/taskStatistics");
        Assert.assertTrue(taskStatisticsPage.getContent() > 0);
    }

    @Test
    public void settingsPageContentIsAvailable() {
        settingsPage = new SettingsPage(driver);
        driver.get(getTestData("defaultURL") + "/#/settings");
        Assert.assertTrue(settingsPage.getContent() > 0);
    }

    @Test
    public void passwordPageContentIsAvailable() {
        passwordPage = new PasswordPage(driver);
        driver.get(getTestData("defaultURL") + "/#/password");
        Assert.assertTrue(passwordPage.getContent() > 0);
    }



}
