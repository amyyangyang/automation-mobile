package zProperty;


import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import com.microsoft.appcenter.appium.EnhancedIOSDriver;
import com.microsoft.appcenter.appium.Factory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public abstract class SetProperty {


    public static JavascriptExecutor jse;
    public static Object obj;
    public static AppiumDriver<MobileElement> driver;
//    public static EnhancedIOSDriver<MobileElement> driver;
//    public static EnhancedAndroidDriver<MobileElement> driver;


    public void setUpWebDriver() throws MalformedURLException, InterruptedException{
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 20);

        String profile = System.getProperty("PLATFORM_NAME");
        System.out.println(profile);
        switch (profile) {
            case "android":
                capabilities.setCapability("app", "C:\\Users\\Administrator\\Downloads\\NEXT TEST-V2.0.3 (3).apk");
                capabilities.setCapability(MobileCapabilityType.PLATFORM, MobilePlatform.ANDROID);
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "2ae7e8449805");
                capabilities.setCapability(MobileCapabilityType.VERSION, "8.1.0");
                capabilities.setCapability("appActivity", "com.nextnative.MainActivity");
                capabilities.setCapability("appPackage", "com.nexttrucking.trucker.testing");
                driver = Factory.createAndroidDriver(url, capabilities);
                break;

            case "ios":
//                capabilities.setCapability("app", "C:\\");
//                capabilities.setCapability(MobileCapabilityType.PLATFORM, MobilePlatform.IOS);
//                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
//                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "1b07bf30");
//                capabilities.setCapability(MobileCapabilityType.VERSION, "8.1.0");
//                capabilities.setCapability("appActivity", "com.nextnative.MainActivity");
//                capabilities.setCapability("appPackage", "com.nexttrucking.trucker.testing");
                driver = Factory.createIOSDriver(url, capabilities);

                break;
        }

//        if (driver instanceof EnhancedAndroidDriver) {
//            androidDriver = (EnhancedAndroidDriver<MobileElement>) driver;
//        } else {
//            iosDriver = (EnhancedIOSDriver<MobileElement>) driver;
//        }
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        jse = (JavascriptExecutor)driver;
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

    @Rule
    public TestWatcher watcher = Factory.createWatcher();

    @After
    public void TearDown(){

//        driver.label("Stopping App");
        driver.quit();
    }
}
