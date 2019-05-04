package MobileAPP;

import org.junit.Test;
import java.net.MalformedURLException;
import zProperty.SetProperty;


public class TestClass extends SetProperty {


    @Test
    public void getHomePage() throws InterruptedException, MalformedURLException {


        setUpWebDriver();

        System.out.println("Step 1");
        System.out.println(driver);
        Thread.sleep(5000);
        System.out.println("Step 2");
        Thread.sleep(5000);

        driver.findElementByAccessibilityId("language_button_save").click();
//        driver.findElement(By.xpath("//*[contains(@text, 'Save')]")).click();
        System.out.println("Step 3");
        Thread.sleep(6000);

        driver.findElementByAccessibilityId("welcome_button_signIn").click();
//        driver.findElement(By.xpath("//*[contains(@text, 'Sign In')]")).click();
        System.out.println("Step 4");

//        driver.findElement(By.xpath("//*[contains(@resource-id='login_input_email')]")).sendKeys("aliehu67+driverone@gmail.com");
//        driver.findElement(By.xpath("//*[@content-desc='login_input_email']")).sendKeys("aliehu67+driverone@gmail.com");
        driver.findElementByAccessibilityId("login_input_email").sendKeys("aliehu67+driverone@gmail.com");


//        driver.findElement(By.xpath("//*[contains(@resource-id='login_input_password')]")).sendKeys("111111");
//        driver.findElement(By.xpath("//*[@content-desc='login_input_password']")).sendKeys("111111");
        driver.findElementByAccessibilityId("login_input_password").sendKeys("111111");

//        driver.findElementByAccessibilityId("login_button_login").click();


//        driver.findElement(By.name("Email")).sendKeys("aliehu67+driverone@gmail.com");
//        MobileElement signUpButton = adriver.findElement(By.xpath("//*[contains(@text, '2')]"));
//        MobileElement signUpButton = (MobileElement) adriver.findElement(By.xpath("//*[contains(@text, '2')]"));
//        MobileElement signUpButton = adriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View"));
//        TouchAction touchAction = new TouchAction(adriver);
//        touchAction.tap(PointOption.point(1118, 2228)).perform();
//        adriver.findElement(By.xpath("//*[@content-desc='welcome_button_signup']")).click();
//        adriver.findElementByAccessibilityId("welcome_button_signup").click();
//        adriver.findElement(accessibilty_id, "Tap Me");
//        adriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout"));
//        adriver.findElement(By.id("android:id/content"));
//        adriver.findElement(By.xpath("//*[contains(@text, 'Hello, Chat App33333!')]"));
//        adriver.findElement(By.xpath("//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[2]")).sendKeys("neeck@ukr.net");
//         adriver.findElementByAccessibilityId("welcome_button_signup");
//         adriver.findElement(By.xpath("//*[contains(@content-desc, 'welcome_button_signup')]")).click();
//         adriver.findElementByXPath("//*[@content-desc='welcome_button_signup']").click();
//         adriver.findElementByXPath("//*[contains(text(), '5']").click();
//         adriver.findElement(By.id("com.nexttrucking.trucker.dev:content-desc/welcome_button_signup"));
//         adriver.findElement(By.xpath("//*[contains(@content-desc, 'welcome_button_signup')]")).click();
//        adriver.findElement(By.id("welcome_button_signup"));
//        MobileElement signUpButton = adriver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"Numbers and basic operations\"]/android.view.ViewGroup[1]/android.widget.Button[7]"));
//        signUpButton.click();
//        adriver.findElement(By.id("com.google.android.calculator:id/digit_1")).click();
//        adriver.get("https://nexttrucking.com");
//        adriver.quit();
    }
}
