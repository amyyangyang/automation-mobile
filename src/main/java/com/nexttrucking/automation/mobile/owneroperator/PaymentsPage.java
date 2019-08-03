package com.nexttrucking.automation.mobile.owneroperator;

import com.nexttrucking.automation.mobile.property.PageProperty;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.util.HashMap;

public class PaymentsPage extends PageProperty {
    public PaymentsPage(AppiumDriver<MobileElement> driver, String attributeName) {
        super(driver, attributeName);
    }

    public HashMap<String, String> paymentList;


    {
        paymentList=new HashMap<>();
        if (attributeName.equals("text")) {
            paymentList.put("firstPayment", "//*[@name=\"Payments\"]/following-sibling::*/*/*/*/*[1]");
            paymentList.put("paymentStatus", "//*[@content-desc='payment_view_list']/*/*/*/*/*/*[1]");
        } else {
//            paymentList.put("firstPayment", "//*[@name=\"Payments\"]/following-sibling::*/*/*/*/*[2]]");
            paymentList.put("firstPayment", "//*[@content-desc='payment_view_list']/*/*/*/*");
            paymentList.put("paymentStatus", "//*[@content-desc='payment_view_list']/*/*/*/*/*/*[1]");
        }
    }



}
