package com.nexttrucking.automation.mobile.dispatcher;

import com.nexttrucking.automation.mobile.property.PageProperty;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class PaymentsPage extends PageProperty {

    public String paymentStatus = "paymentStatus";
    public String paymentJobNumber = "jobNumber";
    public String paymentJobPrice = "price";
    public String paymentAddressAndTimeInfo = "addressAndTimeInfo";

    public PaymentsPage(AppiumDriver<MobileElement> driver, String attributeName) {
        super(driver, attributeName);
    }

}
