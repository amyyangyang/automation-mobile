package zProperty;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.After;
import org.junit.Rule;
import org.openqa.selenium.Capabilities;
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
    public static Object obj;
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
