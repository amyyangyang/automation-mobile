package MobileAPP;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import zProperty.RetryRule;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestClass {

//    private static AppiumDriver<MobileElement> adriver;

//    private AppiumDriver adriver;
//    @Test
    public void getHomePage() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
        capabilities.setCapability("app", "D:\\QA projects\\NEXT DEV-V2.0.0.apk_2.0.0.apk");
        capabilities.setCapability(MobileCapabilityType.PLATFORM, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "2ae7e8449805");
        capabilities.setCapability(MobileCapabilityType.VERSION, "7.1.1");
//        capabilities.setCapability("appActivity", "com.testnavigation.MainActivity");
//        capabilities.setCapability("appPackage", "com.testnavigation");
//
        capabilities.setCapability("appActivity", "com.nextnative.MainActivity");
        capabilities.setCapability("appPackage", "com.nexttrucking.trucker.dev");
//        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
//        capabilities.setCapability("appPackage", "com.google.android.calculator");



        URL url = new URL("http://127.0.0.1:4723/wd/hub");


//        AppiumDriver<MobileElement> adriver = new AndroidDriver<MobileElement>(url, capabilities);
        AndroidDriver adriver = new AndroidDriver(url, capabilities);
        adriver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(driver, 30);

        System.out.println("Step 2");



        Thread.sleep(7000);

//        MobileElement signUpButton = adriver.findElement(By.xpath("//*[contains(@text, '2')]"));
//        MobileElement signUpButton = (MobileElement) adriver.findElement(By.xpath("//*[contains(@text, '2')]"));
//        MobileElement signUpButton = adriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View"));
//        TouchAction touchAction = new TouchAction(adriver);
//        touchAction.tap(PointOption.point(1118, 2228)).perform();
//         adriver.findElement(By.xpath("//*[@content-desc='welcome_button_signup']")).click();
//
//        adriver.findElementByAccessibilityId("welcome_button_signup").click();
//        adriver.findElement(accessibilty_id, "Tap Me");


//        adriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout"));
//         adriver.findElement(By.id("android:id/content"));
         System.out.println("Step 3");

//        adriver.findElement(By.xpath("//*[contains(@text, 'Hello, Chat App33333!')]"));

//        adriver.findElement(By.xpath("//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[2]")).sendKeys("neeck@ukr.net");


//         adriver.findElementByAccessibilityId("welcome_button_signup");
//         adriver.findElement(By.xpath("//*[contains(@content-desc, 'welcome_button_signup')]")).click();
//         adriver.findElementByXPath("//*[@content-desc='welcome_button_signup']").click();
//         adriver.findElementByXPath("//*[contains(text(), '5']").click();
         adriver.findElement(By.xpath("//*[contains(@text, 'Sign Up')]")).click();


//         adriver.findElement(By.id("com.nexttrucking.trucker.dev:content-desc/welcome_button_signup"));
//         adriver.findElement(By.xpath("//*[contains(@content-desc, 'welcome_button_signup')]")).click();
//        adriver.findElement(By.id("welcome_button_signup"));
//        MobileElement signUpButton = adriver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"Numbers and basic operations\"]/android.view.ViewGroup[1]/android.widget.Button[7]"));

//        signUpButton.click();
//        adriver.findElement(By.id("com.google.android.calculator:id/digit_1")).click();
        System.out.println("Step 4");

//        adriver.get("https://nexttrucking.com");
//
//        adriver.quit();
    }

//    public class TestClass {
//    @Test
//    public void getHomePage() throws Exception{
//        URL serverURL = new URL("http://127.0.0.1:4723/wd/hub");
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus_9_JavaAutoTest:5554");
//        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
//
//        System.out.println("Step 1");
//        AppiumDriver adriver = new AndroidDriver(serverURL, capabilities);
//        WebDriverWait wait = new WebDriverWait(adriver, 30);
//
//        System.out.println("Step 2");
//        adriver.get("https://nexttrucking.com");
//    }
}
