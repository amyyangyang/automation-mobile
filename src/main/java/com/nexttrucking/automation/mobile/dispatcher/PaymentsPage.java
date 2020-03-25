package com.nexttrucking.automation.mobile.dispatcher;

import com.nexttrucking.automation.mobile.property.PageProperty;
import com.nexttrucking.automation.mobile.property.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

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
            paymentList.put("paymentPrice", "(//*[@content-desc='payment_view_list']/*/*/*/*/*[3])[2]");
            paymentList.put("paymentPriceSpecial", "(//*[@content-desc='payment_view_list']/*/*/*/*/*[3])[1]");
            paymentList.put("jobNumberSpecial", "//*[@content-desc='payment_view_list']/*/*/*");
            paymentList.put("jobNumber", "//*[@content-desc='payment_view_list']/*/*/*");
            paymentList.put("statusSpecial","//*[@content-desc='payment_view_list']/*/*[1]/*/*/*/*[1]");
            paymentList.put("status","//*[@content-desc='payment_view_list']/*/*[1]/*/*/*/*[1]");
        } else {
            paymentList.put("firstPayment", "//*[@name='Payments']/following-sibling::*/*/*/*/*[2]/*");
            paymentList.put("paymentStatus", "//*[@name='Payments']/following-sibling::*/*/*/*/*[2]/*");
            paymentList.put("paymentPrice", "//*[@name='Payments']/following-sibling::*/*/*/*/*[2]/*");
        }
    }

    public boolean isPaymentStatusCorrect() {
        boolean correctStatus = false;
        String paymentStatus = getElementText("path", paymentList.get("paymentStatus"));
        for (int i = 0; i < 3; i++) {
            if (paymentStatus.contains(Utils.paymentsStatusList.get(i))) {
                correctStatus = true;
            }
        }
        return correctStatus;
    }

    public boolean isHavingVerifiedPayment() {
        int count = sizeOfElements(paymentList.get("paymentStatus"));
        for (int i = 0; i < count; i++) {
            String paymentStatus = driver.findElements(By.xpath(paymentList.get("paymentStatus"))).get(i).getText();
            if (paymentStatus.contains("PAYMENT SENT")) {
                return true;
            }
        }
        return false;
    }
}
