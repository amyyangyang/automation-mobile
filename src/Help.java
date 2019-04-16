public class Help {

//    Maven: Run specific test(s)
//
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
//
//
//    Maven: Exclude specific test(s)
//
//# Exclude one test class, by using the explanation mark (!)
//    mvn test -Dtest=!LegacyTest
//# Exclude one test method
//    mvn verify -Dtest=!LegacyTest#testFoo
//# Exclude two test methods
//    mvn verify -Dtest=!LegacyTest#testFoo+testBar
//# Exclude a package with a wildcard (*)
//    mvn test -Dtest=!com.mycompany.app.Legacy*


//    mvn surefire:test -Dtest=DownloadFilesShipper

    //    APPIUM

//    to see
//            capabilities.setCapability("appActivity", "com.nextnative.MainActivity");
//            capabilities.setCapability("appPackage", "com.nexttrucking.trucker.dev");
//
//            adb shell
//            dumpsys window windows | grep -E 'mCurrentFocus'


//             emulator -list-avds
//             emulator -avd Nexus_9_JavaAutoTest
//             appium --address 127.0.0.1 --port 4723



//    appium --address 127.0.0.1 --port 4723
//    emulator -avd Nexus_9_JavaAutoTest
//
//-Dtest=DownloadFilesShipper



//
//        WebDriverWait myWaitVar = new WebDriverWait(driver, 100);

//        private Actions actions;
//        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
//        if (signUpPage.isSignInButtonDisable()) {
//            myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
//            myWaitVar.until(ExpectedConditions.elementToBeClickable(submitButton));
//            jse.executeScript("window.scrollTo(0,"+driver.findElement(submitButton).getLocation().y+")");
//            jse.executeScript("arguments[0].click();", driver.findElement(submitButton));
//            signUpPage.clickSubmit();
//            actions.moveToElement(driver.findElement(submitButton)).click().build().perform();
//        }
//        else {
//            signUpPage.clickSubmit();
//        }
//            myWaitVar.until(ExpectedConditions.elementToBeClickable(driver.findElement(submitButton)));
//            actions.moveToElement(driver.findElement(submitButton)).click().build().perform();
//            signUpPage.clickSubmit();
//
//
//        try {
//            Thread.sleep(8000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

}
    public boolean isErrorVisible(String message){
        return driver.findElements(xpath(String.format(errorByText, message))).size() > 0
                && driver.findElements(xpath(String.format(errorByText, message))).get(0).isDisplayed();
    }



//        jse.executeScript("arguments[0].click();", driver.findElement(authenticateLink));
    //    jse.executeScript("arguments[0].value=arguments[1].toString();", driver.findElement(passwordField), "xfqrf2424N");

    //        actions.moveToElement(driver.findElement(checkbox)).click().perform();



//    @BeforeClass
//    public static void qwe(){
//        System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
//        driver.manage().window().setSize(new Dimension(1400, 1000));
//        driver.get("https://devxa2web01.dev.aws.nexttrucking.com/register/");
//    }





//    public static JSONObject jsonObject;
    //    private String mockData = null;
//    public static final String CHAREST_UTF_8 = "utf-8";


//    public void getTestData() throws IOException {
//        File folder = new File(this.getClass().getResource("/json").getPath());
//        File files[] = folder.listFiles();
//
//        for (File file : files) {
//            InputStream inputStream = new ByteArrayInputStream(Files.toByteArray(file));
//            mockData = IOUtils.toString(inputStream, CHAREST_UTF_8);
//            JSONObject jsonObject = JSONObject.fromObject(mockData.replace("null", "''"));
//        }

//
//        try {
//            File folder = new File(this.getClass().getResource("/json").getPath());
//            File files[] = folder.listFiles();
//            InputStream inputStream = new ByteArrayInputStream(Files.toByteArray(file));
//            mockData = IOUtils.toString(inputStream, CHAREST_UTF_8);
//            jsonObject = JSONObject.fromObject(mockData.replace("null", "''"));
//        } catch (IOException e) {
//            // log
//            System.out.printf("" + e.getMessage());
//        }
//    }


//      "URL": "default",
//              "defaultURLs_DevXA2": "https://dev.nexttrucking.com",
//              "defaultRRL_DevXA2": "http://dev.nexttrucking.com",
//              "defaultURLs_Test": "https://test.nexttrucking.com",
//              "defaultURL_Test": "http://test.nexttrucking.com",
//              "defaultURLs_Demo": "https://demo.nexttrucking.com",
//              "defaultURL_Demo": "http://demo.nexttrucking.com",
//
//              "LogIn": "Dispatcher",
//              "usernameForDispatcher_Dev": "1760924800@qq.com",
//              "usernameForDispatcher_Test": "kayla@dispatcher.com",
//              "usernameForDispatcher_Demo": "alicetest@dispatcher.com",
//              "dispatcherPassword": "111111",
//
//              "LogIn": "OwnerOperator",
//              "usernameForOwnerOperator_Dev": "18700824970@163.com",
//              "usernameForOwnerOperator_Test": "optkayla@operator.com",
//              "usernameForOwnerOperator_Demo": "lynn@nexttrucking.com.cn",
//              "ownerOperatorPassword": "111111",
//
//              "LogIn": "Shipper",
//              "usernameForShipper_Dev": "815868120@qq.com",
//              "usernameForShipper_Test": "amy@nexttrucking.com",
//              "usernameForShipper_Demo": "amy@nexttrucking.com",
//              "shipperPassword": "111111",




//    APPIUM

//    to see
//            capabilities.setCapability("appActivity", "com.nextnative.MainActivity");
//            capabilities.setCapability("appPackage", "com.nexttrucking.trucker.dev");
//
//            adb shell
//            dumpsys window windows | grep -E 'mCurrentFocus'


//             emulator -list-avds
//             emulator -avd Nexus_9_JavaAutoTest


}
