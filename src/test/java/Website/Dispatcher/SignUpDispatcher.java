package Website.Dispatcher;

import AdminPortal.Carrier.FleetManagementPage;
import AdminPortal.Home.LogInPage;
import WebSite.xGuest.SignUpPage;
import zProperty.SetProperty;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.xpath;



public class SignUpDispatcher extends SetProperty{


    @Before
    public void setUp() {
        setUpWebDriver("Chrome");
        signUpPage = new SignUpPage(driver);
        logInPage = new LogInPage(driver);
        fleetManagementPage = new FleetManagementPage(driver);
    }


    @Test
    public void registerDispatcher(){
        By submitButton = xpath("//button[@class='primaryButton']");
        driver.get(getTestData("defaultURLs") + "/register/");
        signUpPage.selectCheckbox();
        signUpPage.chooseUser("Dispatcher")
                .typeFirstName(getTestData("firstName"))
                .typeLastName(getTestData("lastName"))
                .typeCompanyName(getTestData("companyName"))
                .typePhoneNumber(getTestData("phoneNumber"))
                .typeEmail(getTestData("emailForGest"))
                .typePassword(getTestData("passwordForGest"));
        jse.executeScript("arguments[0].click();", driver.findElement(submitButton));

        driver.get(getTestData("defaultURL") + "/#/login");
        logInPage.typePassword(getTestData("passwordAdminPortal"))
                .typeUsername(getTestData("usernameAdminPortal"))
                .clickAuthenticateButton();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.get(getTestData("defaultURL") + "/#/fleetAccount");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("neeck24@ukr.net", fleetManagementPage.findLastEmail());
        fleetManagementPage.clickDeleteLastDispatcherAccount();

        for (String tab : driver.getWindowHandles()){
            driver.switchTo().window(tab);
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fleetManagementPage.clickDeleteSubmitButton();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fleetManagementPage.clickDeleteSubmitButton();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertNotEquals("neeck24@ukr.net", fleetManagementPage.findLastEmail());

    }
}
