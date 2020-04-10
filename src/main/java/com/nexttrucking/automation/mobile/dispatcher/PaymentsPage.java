package com.nexttrucking.automation.mobile.dispatcher;

import com.nexttrucking.automation.mobile.property.PageProperty;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class PaymentsPage extends PageProperty {

    public String paymentStatus = "//*[contains(@content-desc,'paymentStatus')]";
    public String paymentJobNumber = "//*[contains(@content-desc, 'jobNumber')]";
    public String paymentJobPrice = "//*[contains(@content-desc, 'price')]";
    public String paymentAddressAndTimeInfo = "//*[contains(@content-desc, 'addressAndTimeInfo')]";

    public PaymentsPage(AppiumDriver<MobileElement> driver, String attributeName) {
        super(driver, attributeName);
    }

}
