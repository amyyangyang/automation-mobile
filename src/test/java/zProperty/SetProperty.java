package zProperty;

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
import WebSite.Dispatcher.AvailableLoadsPage;
import WebSite.Dispatcher.BillingInfoForDispatcherPage;
import WebSite.Dispatcher.CarrierPacketForDispatcherPage;
import WebSite.Dispatcher.ChatPage;
import WebSite.Dispatcher.DriversPage;
import WebSite.Dispatcher.MyAccountForDispatcherPage;
import WebSite.Dispatcher.MyJobsPage;
import WebSite.Dispatcher.NotificationForDispatcherPage;
import WebSite.Dispatcher.PostTruckPage;
import WebSite.OwnerOperator.*;
import WebSite.Shipper.BillingInfoForShipperPage;
import WebSite.Shipper.DashboardPage;
import WebSite.Shipper.InvoicesDetailPage;
import WebSite.Shipper.InvoicesPage;
import WebSite.Shipper.MyAccountForShipperPage;
import WebSite.Shipper.NewShipmentsPage;
import WebSite.Shipper.NotificationForSipperPage;
import WebSite.Shipper.ShipmentsPage;
import WebSite.xGuest.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.After;
import org.junit.Rule;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileReader;
import java.util.concurrent.TimeUnit;


public abstract class SetProperty {

    public static WebDriver driver;
    public static JavascriptExecutor jse;
    public static ShipperManagementPage shipperManagementPage;
    public static HomeWebPage homeWebPage;
    public static HomeAdminPage homeAdminPage;
    public static LogInPage logInPage;
    public static FleetManagementPage fleetManagementPage;
    public static TruckerManagementPage truckerManagementPage;
    public static SignInAsDispatcherPage signInAsDispatcherPage;
    public static SignInAsShipperPage signInAsShipperPage;
    public static SignInAsOwnerOperatorPage signInAsOwnerOperatorPage;
    public static SignInPage signInPage;
    public static DashboardPage dashboardPage;
    public static SignUpPage signUpPage;
    public static JobsPage jobsPage;
    public static AvailableLoadsPage availableLoadsPage;
    public static Object obj;
    public static PostTruckPage postTruckPage;
    public static MyJobsPage myJobsPage;
    public static DriversPage driversPage;
    public static WebSite.Dispatcher.BirdsEyeViewPage birdsEyeViewPage;
    public static ChatPage chatPage;
    public static WebSite.Dispatcher.PayoutsPage payoutsPage;
    public static BillingInfoForDispatcherPage billingInfoPage;
    public static CarrierPacketForDispatcherPage carrierPacketPage;
    public static MyAccountForDispatcherPage myAccountPage;
    public static NotificationForDispatcherPage notificationPage;
    public static OffersPage offersPage;
    public static PayoutPage payoutPage;
    public static BillingInfoForOwnerPage billingInfoForOwnerPage;
    public static NotificationForOwnerPage notificationForOwnerPage;
    public static CarrierPacketForOwnerPage carrierPacketForOwnerPage;
    public static MyAccountForOwnerPage myAccountForOwnerPage;
    public static QuotationHistoryPage quotationHistoryPage;
    public static QuotationUsersPage quotationUsersPage;
    public static QuotationReportPage quotationReportPage;
    public static CustomizedRatePage customizedRatePage;
    public static OfferManagementPage offerManagementPage;
    public static ReviewManagementPage reviewManagementPage;
    public static ViewOnMapePage viewOnMapePage;
    public static ShipmentManagementPage shipmentManagementPage;
    public static NewShipmentPage newShipmentPage;
    public static TenderTemplatePage tenderTemplatePage;
    public static TenderDraftPage tenderDraftPage;
    public static InvoiceManagementPage invoiceManagementPage;
    public static PayoutManagementPage payoutManagementPage;
    public static SMSMessageCenterPage smsMessageCenterPage;
    public static FeedbacksPage feedbacksPage;
    public static AnnouncementPage announcementPage;
    public static AddressBookManagementPage addressBookManagementPage;
    public static LaneHistoryPage laneHistoryPage;
    public static DepartmentManagementPage departmentManagementPage;
    public static UserManagementPage userManagementPage;
    public static ChatUserManagementPage chatUserManagementPage;
    public static LoginHistoryPage loginHistoryPage;
    public static ReportDownloadHistoryPage reportDownloadHistoryPage;
    public static TruckBirdsEyeViewPage truckBirdsEyeViewPage;
    public static AppUpgradePage appUpgradePage;
    public static AuthorityManagementPage authorityManagementPage;
    public static FuelSurchargeRateManagementPage fuelSurchargeRateManagementPage;
    public static EmailConfigurationPage emailConfigurationPage;
    public static AppConfigurationPage appConfigurationPage;
    public static SystemSettingsPage systemSettingsPage;
    public static UserUpdateLogPage userUpdateLogPage;
    public static GEOFensingInfoPage geoFensingInfoPage;
    public static BookItStatusStatisticsPage bookItStatusStatisticsPage;
    public static QuartzJobInfoPage quartzJobInfoPage;
    public static SMSPhoneBlacklistPage smsPhoneBlacklistPage;
    public static TaskStatisticsPage taskStatisticsPage;
    public static SettingsPage settingsPage;
    public static PasswordPage passwordPage;
    public static NewShipmentsPage newShipmentsPage;
    public static ShipmentsPage shipmentsPage;
    public static InvoicesPage invoicesPage;
    public static BillingInfoForShipperPage billingInfoForShipperPage;
    public static NotificationForSipperPage notificationForSipperPage;
    public static MyAccountForShipperPage myAccountForShipperPage;
    public static ShippersGuestPage shippersGuestPage;
    public static OwnerOperatorGuestPage ownerOperatorGuestPage;
    public static DispatcherGuestPage dispatcherGuestPage;
    public static AboutUsGuestPage aboutUsGuestPage;
    public static CareersGuestPage careersGuestPage;
    public static BlogGuestPage blogGuestPage;
    public static DriverForNEXTGuestPage driverForNEXTGuestPage;
    public static SupportPage supportPage;
    public static ContactUsPage contactUsPage;
    public static InvoicesDetailPage invoicesDetailPage;
    public static String filePath;


    public void setUpWebDriver(String driverName) {

        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")){
            //Operating system is based on Windows
            switch (driverName) {
                case "Chrome":
                    System.setProperty("webdriver.chrome.driver", "src//test//resources//drivers//chromedriver.exe");
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("start-maximized"); // open Browser in maximized mode
                    options.addArguments("disable-infobars"); // disabling infobars
                    options.addArguments("--disable-extensions"); // disabling extensions
                    options.addArguments("--disable-gpu"); // applicable to windows os only
                    options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
                    options.addArguments("--no-sandbox"); // Bypass OS security model
                    driver = new ChromeDriver(options);
                    String profile = System.getProperty("ENV_VAR_L");
                    switch (profile) {
                        case "Local":
                            filePath = "C:\\Users\\Administrator\\Downloads\\";
                            break;
                        case "Server":
                            Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
                            String browserVersion = caps.getVersion();
                            filePath = String.format("C:\\Program Files (x86)\\Google\\Chrome\\Application\\%s\\", browserVersion);
                            break;
                    }
                    break;
                case "FireFox":
                    System.setProperty("webdriver.gecko.driver", "src//test//resources//drivers//geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;
            }
        }
        else if (os.contains("nix") || os.contains("aix") || os.contains("nux") || os.contains("NUX")){
            //Operating system is based on Linux/Unix/*AIX
            switch (driverName) {
                case "Chrome":
                    System.setProperty("webdriver.chrome.driver", "src//test//resources//drivers//chromedriver");
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("start-maximized"); // open Browser in maximized mode
                    options.addArguments("disable-infobars"); // disabling infobars
                    options.addArguments("--disable-extensions"); // disabling extensions
                    options.addArguments("--disable-gpu"); // applicable to windows os only
                    options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
                    options.addArguments("--no-sandbox"); // Bypass OS security model
                    driver = new ChromeDriver(options);
                    filePath = "//home//dev//Downloads//";
                    break;
                case "FireFox":
                    System.setProperty("webdriver.gecko.driver", "src//test//resources//drivers//geckodriver");
                    driver = new FirefoxDriver();
                    break;
            }
        }
        jse = (JavascriptExecutor)driver;
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }


    public String getTestData(String parameterName) {
        JSONParser parser = new JSONParser();
        String parameterValue = null;
        try {
            String profile = System.getProperty("ENV_VAR");
            switch (profile) {
                case "Dev":
                    obj = parser.parse(new FileReader("src//test//resources//json//Dev_testData.json"));
                    break;
                case "Test":
                    obj = parser.parse(new FileReader("src//test//resources//json//Test_testData.json"));
                    break;
                case "Demo":
                    obj = parser.parse(new FileReader("src//test//resources//json//Demo_testData.json"));
                    break;
        }
            JSONObject jsonObject = (JSONObject) obj;
            parameterValue = (String) jsonObject.get(parameterName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parameterValue;
      }


    @Rule
    public RetryRule retryRule = new RetryRule(3);


    @After
    public void turnDown(){
        driver.quit();
    }
}
