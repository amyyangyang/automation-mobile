package com.nexttrucking.automation.mobile.dispatcher;

import com.nexttrucking.automation.mobile.xguest.WelcomePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

import static org.openqa.selenium.By.xpath;

public class AvailableLoadsAllPage {

    public AvailableLoadsAllPage(AppiumDriver<MobileElement> driver, String attributeName) {
        this.driver = driver;
        this.attributeName = attributeName;
    }

    private AppiumDriver<MobileElement> driver;
    public static String attributeName;
    private String title = "(//*[contains(@name, \"%s\")])[last()]";
    private By localButton = xpath("(//*[contains(@name, 'Local')])[last()]");
    private By menuButtonIOS = xpath("(//XCUIElementTypeStaticText)[1]");
    private By menuButtonAndroid = xpath("//*[@text='\uF1C3']");
    private String menuNameButton = "(//*[contains(@name, \"%s\")])[last()]";


    public String getTitle(String titleText) {
        return driver.findElement(xpath(String.format(title, titleText))).getText();
    }

    public void clickLocalButton(){
        driver.findElement(localButton).click();
    }

    public void clickMenuButtonFirstLevel(String menuName) throws InterruptedException {
        if (driver.findElements(menuButtonAndroid).size()>0) {
            driver.findElement(menuButtonAndroid).click();
        } else driver.findElement(menuButtonIOS).click();
        Thread.sleep(3000);
        driver.findElement(xpath(String.format(menuNameButton, menuName))).click();
        Thread.sleep(3000);
    }

    public void clickMenuButtonSecondLevel(String menuName) throws InterruptedException {
        driver.findElement(xpath(String.format(menuNameButton, menuName))).click();
        Thread.sleep(3000);
    }

    public WelcomePage confirmLogout(){
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(PointOption.point(270, 600)).perform();
        return new WelcomePage(driver, attributeName);
    }

}

