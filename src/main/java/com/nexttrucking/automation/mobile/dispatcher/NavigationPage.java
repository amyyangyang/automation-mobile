package com.nexttrucking.automation.mobile.dispatcher;

import com.nexttrucking.automation.mobile.property.PageProperty;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class NavigationPage extends PageProperty {

    public String canHelpTitle="(//*[contains(@%s, \"How can we help?\")])[last()]";
    public String canHelpBodyText="(//*[contains(@%s, \"Find the answer to your question in our FAQs or chat with our support team.\")])[last()]";
    public String chatButton="(//*[contains(@%s, \"Chat\")])[last()]";
    public String FAQs="(//*[contains(@%s, \"FAQs\")])[last()]";


    public NavigationPage(AppiumDriver<MobileElement> driver, String attributeName) {
        super(driver, attributeName);
    }

}
