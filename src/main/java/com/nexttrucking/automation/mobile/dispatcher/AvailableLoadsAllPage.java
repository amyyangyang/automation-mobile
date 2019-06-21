package com.nexttrucking.automation.mobile.dispatcher;

import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.property.PageProperty;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;


public class AvailableLoadsAllPage extends PageProperty {


    private String title = "(//*[contains(@%1$s, \"%2$s\")])[last()]";
    private String menuButtonIOS = "(//XCUIElementTypeStaticText)[1]";
    private String menuButtonAndroid = "//*[@%s='\uF1C3']";
    private String menuNameButton = "(//*[contains(@%1$s, \"%2$s\")])[last()]";
    private String confirmLogOutButton = "(//*[contains(@%s, 'Yes')])[last()]";

    public AvailableLoadsAllPage(AppiumDriver<MobileElement> driver, String attributeName) {
        super(driver, attributeName);
    }


    public String getTitle(String titleText) {
        return getText(title, titleText);
    }



    public void clickMenuButtonFirstLevel(String menuName) throws InterruptedException {
        if (attributeName.equals("text")) {
            clickElement(menuButtonAndroid);
        } else driver.findElement(By.xpath(menuButtonIOS)).click();
        Thread.sleep(3000);
        clickMenu(menuNameButton, menuName);
        Thread.sleep(3000);
    }

    public void clickMenuButtonSecondLevel(String menuName) throws InterruptedException {
        clickMenu(menuNameButton, menuName);
        Thread.sleep(3000);
    }

    public WelcomePage confirmLogout() throws InterruptedException {
        if (attributeName.equals("text")) {
           clickElement(confirmLogOutButton);
        } else if (attributeName.equals("name")){
            TouchAction touchAction = new TouchAction(driver);
            touchAction.tap(PointOption.point(270, 600)).perform();
        }
        Thread.sleep(3000);
        return new WelcomePage(driver, attributeName);
    }

}

