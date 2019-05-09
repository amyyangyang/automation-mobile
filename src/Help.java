public class Help {

//    Maven: Run specific test(s)

//# Test one class
//    mvn test -Dtest=AppTest
//# Test one method
//    mvn test -Dtest=AppTest#testFoo
//# Test two methods with the plus sign (+)
//    mvn test -Dtest=AppTest#testFoo+testBar
//# Test multiple items comma separated and with a wildcard (*)
//    mvn test -Dtest=AppTest,Web*
//# Test by Package with a wildcard (*)
//    mvn test -Dtest=com.mycompany.*.*Test


//    Maven: Exclude specific test(s)

//# Exclude one test class, by using the explanation mark (!)
//    mvn test -Dtest=!LegacyTest
//# Exclude one test method
//    mvn verify -Dtest=!LegacyTest#testFoo
//# Exclude two test methods
//    mvn verify -Dtest=!LegacyTest#testFoo+testBar
//# Exclude a package with a wildcard (*)
//    mvn test -Dtest=!com.mycompany.app.Legacy*



//            adb shell
//            dumpsys window windows | grep -E 'mCurrentFocus'


//             emulator -list-avds
//             emulator -avd Nexus_9_JavaAutoTest
//             appium --address 127.0.0.1 --port 4723


//        jse.executeScript("arguments[0].click();", com.nexttrucking.automation.mobile.pages.driver.findElement(authenticateLink));
//        jse.executeScript("arguments[0].value=arguments[1].toString();", com.nexttrucking.automation.mobile.pages.driver.findElement(passwordField), "xfqrf2424N");
//        actions.moveToElement(com.nexttrucking.automation.mobile.pages.driver.findElement(checkbox)).click().perform();


//        com.nexttrucking.automation.mobile.pages.driver.findElementByAccessibilityId("language_button_save").click();
//        driver.findElement(By.xpath("//*[contains(@text, 'Save')]")).click();
//        System.out.println("Step 3");
//        Thread.sleep(6000);
//
////        com.nexttrucking.automation.mobile.pages.driver.findElementByAccessibilityId("welcome_button_signIn").click();
////        com.nexttrucking.automation.mobile.pages.driver.findElement(By.xpath("//*[contains(@text, 'Sign In')]")).click();
//        System.out.println("Step 4");

//        com.nexttrucking.automation.mobile.pages.driver.findElement(By.xpath("//*[contains(@resource-id='login_input_email')]")).sendKeys("aliehu67+driverone@gmail.com");
//        com.nexttrucking.automation.mobile.pages.driver.findElement(By.xpath("//*[@content-desc='login_input_email']")).sendKeys("aliehu67+driverone@gmail.com");
//        com.nexttrucking.automation.mobile.pages.driver.findElementByAccessibilityId("login_input_email").sendKeys("aliehu67+driverone@gmail.com");


//        com.nexttrucking.automation.mobile.pages.driver.findElement(By.xpath("//*[contains(@resource-id='login_input_password')]")).sendKeys("111111");
//        com.nexttrucking.automation.mobile.pages.driver.findElement(By.xpath("//*[@content-desc='login_input_password']")).sendKeys("111111");
//        com.nexttrucking.automation.mobile.pages.driver.findElementByAccessibilityId("login_input_password").sendKeys("111111");

//        com.nexttrucking.automation.mobile.pages.driver.findElementByAccessibilityId("login_button_login").click();


//        com.nexttrucking.automation.mobile.pages.driver.findElement(By.name("Email")).sendKeys("aliehu67+driverone@gmail.com");
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
