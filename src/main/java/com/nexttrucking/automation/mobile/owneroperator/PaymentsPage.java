package com.nexttrucking.automation.mobile.owneroperator;

import com.nexttrucking.automation.mobile.property.PageProperty;
import com.nexttrucking.automation.mobile.property.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.util.HashMap;
import java.util.Map;

public class PaymentsPage extends PageProperty {

    public HashMap<String, String> paymentList;



    public PaymentsPage(AppiumDriver<MobileElement> driver, String attributeName) {
        super(driver, attributeName);
        paymentList = new HashMap<>();
        if (attributeName.equals("text")) {
            paymentList.put("firstPayment", "//*[@content-desc='payment_view_list']/*/*/*/*/*/*[1]");
            paymentList.put("paymentStatus", "//*[@content-desc='payment_view_list']/*/*/*/*/*/*[1]");
        } else {
//            paymentList.put("firstPayment", "//*[@name=\"Payments\"]/following-sibling::*/*/*/*/*[2]]");
            paymentList.put("firstPayment", "//*[@name='Payments']/following-sibling::*/*/*/*/*[1]");
            paymentList.put("paymentStatus", "//*[@name='Payments']/following-sibling::*/*/*/*/*[1]");
        }
    }


    public boolean isPaymentStatusCorrect() {
        boolean correctStatus = false;
        String paymentStatus = getElementText("path", paymentList.get("paymentStatus"));
        for (int i=0; i<3; i++) {
            if (paymentStatus.contains(Utils.paymentsStatusList.get(i))) {
                correctStatus = true;
            }
        }
        return correctStatus;
    }

}
