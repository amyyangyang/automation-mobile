package com.nexttrucking.automation.mobile.dispatcher;

import com.nexttrucking.automation.mobile.property.PageProperty;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.util.HashMap;
import java.util.Map;

public class AccountPage extends PageProperty {

    public String editProfileBtn = "(//*[@%s='Edit Profile'])[last()]";
    public String nameTitle = "(//*[@%s='Name'])[last()]";
    public String phoneNumberTitle = "(//*[@%s='Phone Number'])[last()]";
    public String emailTitle = "(//*[@%s='Email'])[last()]";
    public String homeBaseTitle = "(//*[@%s='Home Base'])[last()]";
    public String passwordTitle = "(//*[@%s='Password'])[last()]";
    public String languageTitle = "(//*[@%s='Language'])[last()]";
    public String carrierInfoTitle = "(//*[@%s='Carrier Info'])[last()]";
    public String equipmentTitle = "(//*[@%s='Equipment'])[last()]";
    public String carrierDocsTitle = "(//*[@%s='Carrier Docs'])[last()]";
    public String bankAccountTitle = "(//*[@%s='Bank Account'])[last()]";

    public Map<String, String> accountCardMap;
    public AccountPage(AppiumDriver<MobileElement> driver, String attributeName) {
        super(driver, attributeName);
        if (attributeName.equals("text")) {
            accountCardMap = new HashMap<>();
            accountCardMap.put("nameValue","(//*[@text='Name'])/following-sibling::*[1]");
            accountCardMap.put("phoneNumberValue","(//*[@text='Phone Number'])/following-sibling::*[1]");
            accountCardMap.put("emailValue","(//*[@text'Email'])/following-sibling::*[1]");
            accountCardMap.put("homeBaseValue","(//*[@text='Home Base'])/following-sibling::*[1]");
            accountCardMap.put("passwordValue","(//*[@text='password'])/following-sibling::*[1]");
            accountCardMap.put("languageValue","(//*[@text='Language'])/following-sibling::*[1]");
            accountCardMap.put("carrierInfoValue","(//*[@text='Carrier Info'])/following-sibling::*[1]");
            accountCardMap.put("equipmentValue","(//*[@text='Equipment'])/following-sibling::*[1]");
            accountCardMap.put("carrierDocsValue","(//*[@text='Carrier Docs'])/following-sibling::*[1]");
            accountCardMap.put("bankAccountValue","(//*[@text='Bank Account'])/following-sibling::*[1]");
        }else {
            accountCardMap = new HashMap<>();
            accountCardMap.put("nameValue","(//XCUIElementTypeStaticText[@name='Name'])/../*[2]");
            accountCardMap.put("phoneNumberValue","(//XCUIElementTypeStaticText[@name='Phone Number'])/../*[2]");
            accountCardMap.put("emailValue","(//XCUIElementTypeStaticText[@name='Email'])/../*[2]");
            accountCardMap.put("homeBaseValue","(//XCUIElementTypeStaticText[@name='Home Base'])/../*[2]");
            accountCardMap.put("passwordValue","(//XCUIElementTypeStaticText[@name='password'])/../*[2]");
            accountCardMap.put("languageValue","(//XCUIElementTypeStaticText[@name='Language'])/../*[2]");
            accountCardMap.put("carrierInfoValue","(//XCUIElementTypeStaticText[@name='Carrier Info'])/../*[2]");
            accountCardMap.put("equipmentValue","(//XCUIElementTypeStaticText[@name='Equipment'])/../*[2]");
            accountCardMap.put("carrierDocsValue","(//XCUIElementTypeStaticText[@name='Carrier Docs'])/../*[2]");
            accountCardMap.put("bankAccountValue","(//XCUIElementTypeStaticText[@name='Bank Account'])/../*[2]");
        }
    }

}
