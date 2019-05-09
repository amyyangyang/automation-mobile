package com.nexttrucking.automation.mobile.xguest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class SignUpPage {

    private AppiumDriver<MobileElement> driver;


    public SignUpPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }
}
