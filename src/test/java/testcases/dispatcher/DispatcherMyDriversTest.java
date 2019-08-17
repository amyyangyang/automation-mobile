package testcases.dispatcher;

import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import com.nexttrucking.automation.mobile.dispatcher.MyDriversPage;
import com.nexttrucking.automation.mobile.property.PageProperty;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.Tag;
import org.junit.runners.MethodSorters;
import property.SetProperty;
import java.net.MalformedURLException;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DispatcherMyDriversTest extends SetProperty {


    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException {
        setUpDriver();
        pageProperty = new PageProperty(driver, attributeName) {};
        availableLoadsAllPage = new AvailableLoadsAllPage(driver, attributeName);
        allowLocationPage = new AllowLocationPage(driver, attributeName);
        welcomePage = new WelcomePage(driver, attributeName);
        signInPage = new SignInPage(driver, attributeName);
        myDriversPage = new MyDriversPage(driver, attributeName);
        // SignIn as Dispatcher
        signInPage.signIn(getTestData("dispatcherEmail"), getTestData("dispatcherPassword"));
        availableLoadsAllPage.clickMenuButtonFirstLevel("My Drivers");
    }


    @Test
    public void checkDriverList() {
        boolean isDriversExist = myDriversPage.isElementPresent("path", myDriversPage.getDrivers());
        if (isDriversExist) {
            Assert.assertTrue(myDriversPage.getDriverLoadInfo().contains("load"));
            Assert.assertTrue(myDriversPage.getDriverEarnedInfo().contains("earned"));
            Assert.assertTrue(myDriversPage.getDriverEarnedInfo().contains("$"));
        } else {
        Assert.assertTrue(myDriversPage.isElementPresent("path", myDriversPage.getAddDriverTitle()));
        }
    }


    @Test
    public void editDriverInfo() throws InterruptedException {
        boolean isDriversExist = myDriversPage.isElementPresent("path", myDriversPage.getDrivers());
        if (isDriversExist) {
            myDriversPage.selectFirstDriver();
            myDriversPage.selectField("Phone");
            String currentFirstName = myDriversPage.getCurrentName("FirstName");
            String currentLastName = myDriversPage.getCurrentName("LastName");
            myDriversPage.editFirstName("SeraNew");
            myDriversPage.editLastName("AbeNew");
            myDriversPage.editPhone("2343423111");
            myDriversPage.clickSaveButton();
            Assert.assertTrue(myDriversPage.getSavedData("FirstName").contains("SeraNew"));
            Assert.assertTrue(myDriversPage.getSavedData("LastName").contains("AbeNew"));
            myDriversPage.selectField("Phone");
            System.out.println("PHONE: " + myDriversPage.getSavedData("Phone"));
            myDriversPage.editFirstName(currentFirstName);
            myDriversPage.editLastName(currentLastName);
            Assert.assertTrue(myDriversPage.getSavedData("Phone").contains("234-342-3111"));
            myDriversPage.editPhone("2343423424");
            myDriversPage.clickSaveButton();
            myDriversPage.selectField("Phone");
            Assert.assertTrue(myDriversPage.getCurrentName("FirstName").contains(currentFirstName));
            Assert.assertTrue(myDriversPage.getCurrentName("LastName").contains(currentLastName));
            Assert.assertTrue(!myDriversPage.getSavedData("Phone").contains("234-342-3111") && myDriversPage.getSavedData("Phone").contains("234-342-3424"));
            myDriversPage.clickSaveButton();
            signInPage.clickBackButton();
        } else {
            Assert.assertTrue(myDriversPage.isElementPresent("path", myDriversPage.getAddDriverTitle()));
        }
    }


    @Test
    public void editDriverEmail() throws InterruptedException {
        boolean isDriversExist = myDriversPage.isElementPresent("path", myDriversPage.getDrivers());
        if (isDriversExist) {
            myDriversPage.selectFirstDriver();
            myDriversPage.selectField("Email");
            Assert.assertTrue(myDriversPage.getText(myDriversPage.getAnyTitle(), "You").contains("You can't edit"));
            myDriversPage.clickDarnOkButton();
            signInPage.clickBackButton();
        } else {
            Assert.assertTrue(myDriversPage.isElementPresent("path", myDriversPage.getAddDriverTitle()));
        }
    }

    @Test
    public void editDriverPassword() throws InterruptedException {
        boolean isDriversExist = myDriversPage.isElementPresent("path", myDriversPage.getDrivers());
        if (isDriversExist) {
            myDriversPage.selectFirstDriver();
            myDriversPage.selectField("Password");
            Assert.assertTrue(myDriversPage.getText(myDriversPage.getAnyTitle(), "Edit").contains("Edit Password"));
            myDriversPage.typeNewPassword("111111");
            myDriversPage.clickSaveButton();
            signInPage.clickBackButton();
            Assert.assertTrue(myDriversPage.getText(myDriversPage.getAnyTitle(), "My").contains("My Drivers"));
        } else {
            Assert.assertTrue(myDriversPage.isElementPresent("path", myDriversPage.getAddDriverTitle()));
        }
    }

    @Test
    public void editDriverEquipment() throws InterruptedException {
        boolean isDriversExist = myDriversPage.isElementPresent("path", myDriversPage.getDrivers());
        if (isDriversExist) {
            myDriversPage.selectFirstDriver();
            myDriversPage.selectField("Equipment");
            myDriversPage.selectDriverType("Reefer");
            myDriversPage.clickContinueButton();
            myDriversPage.selectDriverSize("53");
            myDriversPage.clickSaveButton();
            Assert.assertTrue(myDriversPage.isEquipmentEdited());
            myDriversPage.selectField("Equipment");
            myDriversPage.selectDriverType("Flatbed");
            myDriversPage.clickContinueButton();
            myDriversPage.selectDriverSize("48");
            myDriversPage.clickSaveButton();
            Assert.assertTrue(myDriversPage.isEquipmentFixed());
            signInPage.clickBackButton();
        } else {
            Assert.assertTrue(myDriversPage.isElementPresent("path", myDriversPage.getAddDriverTitle()));
        }
    }

    @Test
    public void editDriverPriceVisibility() throws InterruptedException {
        boolean isDriversExist = myDriversPage.isElementPresent("path", myDriversPage.getDrivers());
        if (isDriversExist) {
            myDriversPage.selectFirstDriver();
            Thread.sleep(3000);
            pageProperty.swipeForAnyPlatform(5);
            myDriversPage.selectField("Edit");
            myDriversPage.selectPriceVisibilityRadio("Show");
            myDriversPage.selectPriceVisibilityRadio("Save");
            Thread.sleep(3000);
            pageProperty.swipeForAnyPlatform(5);
            Assert.assertTrue(myDriversPage.getText(myDriversPage.getAnyTitle(), "Your").contains("Your driver will see the price"));
            myDriversPage.selectField("Edit");
            myDriversPage.selectPriceVisibilityRadio("Hide");
            myDriversPage.selectPriceVisibilityRadio("Save");
            Thread.sleep(3000);
            Assert.assertTrue(myDriversPage.getText(myDriversPage.getAnyTitle(), "Your").contains("Your driver won't see the price"));
            signInPage.clickBackButton();
        } else {
            Assert.assertTrue(myDriversPage.isElementPresent("path", myDriversPage.getAddDriverTitle()));
        }
    }

}
