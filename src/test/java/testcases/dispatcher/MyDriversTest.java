package testcases.dispatcher;

import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import com.nexttrucking.automation.mobile.dispatcher.MyDriversPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import property.SetProperty;
import java.net.MalformedURLException;



public class MyDriversTest extends SetProperty {


    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException {
        setUpDriver();
        availableLoadsAllPage = new AvailableLoadsAllPage(driver, attributeName);
        allowLocationPage = new AllowLocationPage(driver, attributeName);
        welcomePage = new WelcomePage(driver, attributeName);
        signInPage = new SignInPage(driver, attributeName);
        myDriversPage = new MyDriversPage(driver, attributeName);
        // SignIn as Dispatcher
        signInPage.signIn(getTestData("dispatcherEmail"), getTestData("dispatcherPassword"));
//        Thread.sleep(30000);
        availableLoadsAllPage.clickMenuButtonFirstLevel("My Drivers");
    }


//    @Test
    public void addDriver() throws InterruptedException {
        myDriversPage.clickAddDriverButton();
        myDriversPage.typeEmail(getTestData("driverAddEmail"));
        myDriversPage.typePassword(getTestData("driverAddPassword"));
        myDriversPage.clickContinueButton();
        myDriversPage.selectDriverType("Reefer");
        myDriversPage.clickContinueButton();
        myDriversPage.selectDriverSize("48");
        myDriversPage.clickContinueButton();
        myDriversPage.typeFirstName(getTestData("driveFirstName"));
        myDriversPage.typeLastName(getTestData("driveLastName"));
        myDriversPage.typePhoneNumber(getTestData("drivePhoneNumber"));
        myDriversPage.clickSignUpButton();
        Assert.assertTrue(myDriversPage.getFirstDriverName("TestFirst").contains("Test"));
    }


//    @Test
    public void editDriverFirstName() throws InterruptedException {
        myDriversPage.selectFirstDriver();
        myDriversPage.selectField("Name");
        myDriversPage.editFirstName("SeraNew");
        myDriversPage.clickSaveButton();
        Assert.assertTrue(myDriversPage.getSavedData("FirstName").contains("SeraNew"));
        myDriversPage.selectField("Name");
        myDriversPage.editFirstName("Sera");
        myDriversPage.clickSaveButton();
        Assert.assertTrue(!myDriversPage.getSavedData("FirstName").contains("SeraNew") && myDriversPage.getSavedData("FirstName").contains("Sera"));
        signInPage.clickBackButton();
    }


//    @Test
    public void editDriverLastName() throws InterruptedException {
        myDriversPage.selectFirstDriver();
        myDriversPage.selectField("Name");
        myDriversPage.editLastName("AbeNew");
        myDriversPage.clickSaveButton();
        Assert.assertTrue(myDriversPage.getSavedData("LastName").contains("AbeNew"));
        myDriversPage.selectField("Name");
        myDriversPage.editLastName("Abe");
        myDriversPage.clickSaveButton();
        Assert.assertTrue(!myDriversPage.getSavedData("LastName").contains("AbeNew") && myDriversPage.getSavedData("LastName").contains("Abe"));
        signInPage.clickBackButton();
    }


    @Test
    public void editDriverPhone() throws InterruptedException {
        myDriversPage.selectFirstDriver();
        myDriversPage.selectField("Phone");

//
        myDriversPage.editFirstName("SeraNew");
        myDriversPage.editLastName("AbeNew");
//

        myDriversPage.editPhone("2343423111");
        myDriversPage.clickSaveButton();

//
        Assert.assertTrue(myDriversPage.getSavedData("FirstName").contains("SeraNew"));
        Assert.assertTrue(myDriversPage.getSavedData("LastName").contains("AbeNew"));
//


        myDriversPage.selectField("Phone");
        System.out.println("PHONE: " + myDriversPage.getSavedData("Phone"));

//
        myDriversPage.editFirstName("Sera");
        myDriversPage.editLastName("Abe");
//

        Assert.assertTrue(myDriversPage.getSavedData("Phone").contains("234-342-3111"));
        myDriversPage.editPhone("2343423424");
        myDriversPage.clickSaveButton();

//
        Assert.assertTrue(!myDriversPage.getSavedData("FirstName").contains("SeraNew") && myDriversPage.getSavedData("FirstName").contains("Sera"));
        Assert.assertTrue(!myDriversPage.getSavedData("LastName").contains("AbeNew") && myDriversPage.getSavedData("LastName").contains("Abe"));
//

        myDriversPage.selectField("Phone");
        Assert.assertTrue(!myDriversPage.getSavedData("Phone").contains("234-342-3111") && myDriversPage.getSavedData("Phone").contains("234-342-3424"));
        myDriversPage.clickSaveButton();
        signInPage.clickBackButton();
    }
}
