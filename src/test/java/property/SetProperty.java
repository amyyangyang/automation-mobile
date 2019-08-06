package property;


import com.microsoft.appcenter.appium.Factory;
import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.aguest.SignUpPage;
import com.nexttrucking.automation.mobile.dispatcher.MyDriversPage;
import com.nexttrucking.automation.mobile.property.PageProperty;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public abstract class SetProperty {


    public static JavascriptExecutor jse;
    public static Object obj;
    public static AppiumDriver<MobileElement> driver;
    public static WelcomePage welcomePage;
    public static SignInPage signInPage;
    public static MyDriversPage myDriversPage;
    public static SignUpPage signUpPage;
    public static AllowLocationPage allowLocationPage;
    public static AvailableLoadsAllPage availableLoadsAllPage;
    public static String attributeName;
    public static PageProperty pageProperty;


    public static void setUpDriver() throws MalformedURLException {
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        try {
            String profile = System.getProperty("LOCATION_NAME");
            System.out.println(profile);
            switch (profile) {
                case "server":
                    try (InputStream input = new FileInputStream("test-classes//application.properties")) {
                        Properties prop = new Properties();
                        prop.load(input);
                        System.out.println(prop.getProperty("platform.name"));
                        switch (prop.getProperty("platform.name")) {
                            case "android":
                                attributeName = "text";
                                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
                                driver = Factory.createAndroidDriver(url, capabilities);
                                break;
                            case "ios":
                                attributeName = "name";
                                capabilities.setCapability("waitForQuiescence", "false");
                                driver = Factory.createIOSDriver(url, capabilities);
                                break;
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "local":
                    try (InputStream input = new FileInputStream("target//upload//test-classes//application.properties")) {
                        Properties prop = new Properties();
                        prop.load(input);
                        System.out.println(prop.getProperty("platform.name"));
                        switch (prop.getProperty("platform.name")) {
                            case "android":
                                attributeName = "text";
                                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
                                capabilities.setCapability(MobileCapabilityType.PLATFORM, MobilePlatform.ANDROID);
                                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "2ae7e8449805");
                                capabilities.setCapability(MobileCapabilityType.VERSION, "8.1.0");
                                capabilities.setCapability("appActivity", "com.nextnative.MainActivity");
                                capabilities.setCapability("waitForQuiescence", "false");
                                    switch (prop.getProperty("env.name")) {
                                        case "dev":
                                            capabilities.setCapability("app", "D:\\app\\NEXT DEV.apk_2.0.7.apk");
                                            capabilities.setCapability("appPackage", "com.nexttrucking.trucker.dev");
                                            break;
                                        case "test":
                                            capabilities.setCapability("app", "D:\\app\\NEXT TEST.apk_2.0.7.apk");
                                            capabilities.setCapability("appPackage", "com.nexttrucking.trucker.testing");
                                            break;
                                        case "demo":
                                            capabilities.setCapability("app", "D:\\app\\NEXT DEMO.apk_2.0.7.apk");
                                            capabilities.setCapability("appPackage", "com.nexttrucking.trucker.im");
                                            break;
                                    }
                                driver = Factory.createAndroidDriver(url, capabilities);
                                break;
                            case "ios":
                                attributeName = "name";
                                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Test's iPhone");
                                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
                                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.3.1");
                                capabilities.setCapability(MobileCapabilityType.APP, "/Users/nexttrucking/NEXT DEV.ipa_2.0.7.ipa");
                                capabilities.setCapability(MobileCapabilityType.UDID, "a9669b67640c7a45ba5025c4ac4cc4d8c4daa85a");
                                capabilities.setCapability("waitForQuiescence", false);
                                capabilities.setCapability("resetOnSessionStartOnly", false);
                                capabilities.setCapability("xcodeOrgID", "mobile@nexttrucking.com");
                                capabilities.setCapability("xcodeSigningID", "iPhone Developer");
                                driver = Factory.createIOSDriver(url, capabilities);
                                break;
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        jse = (JavascriptExecutor)driver;
    }

    public static String getTestData(String parameterName) {
        JSONParser parser = new JSONParser();
        String parameterValue = null;
        try {
            String profile = System.getProperty("LOCATION_NAME");
            switch (profile) {
                case "server":
                    try (InputStream input = new FileInputStream("test-classes//application.properties")) {
                        Properties prop = new Properties();
                        prop.load(input);
                        switch (prop.getProperty("env.name")) {
                            case "dev":
                                obj = parser.parse(new FileReader("test-classes//json//Dev_testData.json"));
                                break;
                            case "test":
                                obj = parser.parse(new FileReader("test-classes//json//Test_testData.json"));
                                break;
                            case "demo":
                                obj = parser.parse(new FileReader("test-classes//json//Demo_testData.json"));
                                break;
                        }
                        JSONObject jsonObject = (JSONObject) obj;
                        parameterValue = (String) jsonObject.get(parameterName);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "local":
                    try (InputStream input = new FileInputStream("target//upload//test-classes//application.properties")) {
                        Properties prop = new Properties();
                        prop.load(input);
                        switch (prop.getProperty("env.name")) {
                            case "dev":
                                obj = parser.parse(new FileReader("src//main//resources//json//Dev_testData.json"));
                                break;
                            case "test":
                                obj = parser.parse(new FileReader("src//main//resources//json//Test_testData.json"));
                                break;
                            case "demo":
                                obj = parser.parse(new FileReader("src//main//resources//json//Demo_testData.json"));
                                break;
                        }
                        JSONObject jsonObject = (JSONObject) obj;
                        parameterValue = (String) jsonObject.get(parameterName);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parameterValue;
    }

//    @Rule
    public RetryRule retryRule = new RetryRule(2);

    @Rule
    public TestWatcher watcher = Factory.createWatcher();

    @AfterClass
    public static void quit() {
        driver.quit();
    }

}
