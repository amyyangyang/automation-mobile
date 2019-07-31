package com.nexttrucking.automation.mobile.owneroperator;

import com.nexttrucking.automation.mobile.property.PageProperty;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.util.HashMap;

public class Payments extends PageProperty {
    public Payments(AppiumDriver<MobileElement> driver, String attributeName) {
        super(driver, attributeName);
    }


    public String noPayments = "(//*[contains(@%s,'Book a load before')])[last()]";


    public HashMap<String, String> paymentList;
    {
        paymentList = new HashMap<>();
        if (attributeName.equals("text")) {
            paymentList.put("filterButton", "//*[contains(@text,'\uF182')]");
        } else {
            paymentList.put("filterButton", "//XCUIElementTypeStaticText[@name=\"\uF182\"]");
        }
    }



}
