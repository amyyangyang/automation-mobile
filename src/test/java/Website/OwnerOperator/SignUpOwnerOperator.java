package Website.OwnerOperator;

import AdminPortal.Carrier.TruckerManagementPage;
import AdminPortal.Home.LogInPage;
import WebSite.xGuest.SignUpPage;
import zProperty.SetProperty;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.xpath;

public class SignUpOwnerOperator extends SetProperty {


    @Before
    public void setUp() {
        setUpWebDriver("Chrome");
        signUpPage = new SignUpPage(driver);
        logInPage = new LogInPage(driver);
        truckerManagementPage = new TruckerManagementPage(driver);
    }


    @Test
    public void registerOwnerOparator(){

        By submitButton = xpath("//button[@class='primaryButton']");

        driver.get(getTestData("defaultURLs") + "/register/");
        signUpPage.selectCheckbox();
        jse.executeScript("scroll(0, 250)");
        signUpPage.chooseUser("Owner");
        signUpPage.typeFirstName(getTestData("firstName"))
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

        driver.get(getTestData("defaultURL") + "/#/trucker/?mock=false");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("neeck24@ukr.net", truckerManagementPage.findLastEmail());
        truckerManagementPage.clickDeleteLastShipperAccount();

        for (String tab : driver.getWindowHandles()){
            driver.switchTo().window(tab);
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        truckerManagementPage.clickDeleteSubmitButton();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        truckerManagementPage.clickDeleteSubmitButton();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertNotEquals("neeck24@ukr.net", truckerManagementPage.findLastEmail());

    }
}
