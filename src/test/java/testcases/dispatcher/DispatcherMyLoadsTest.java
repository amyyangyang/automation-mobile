package testcases.dispatcher;

import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import com.nexttrucking.automation.mobile.dispatcher.MyLoadsPage;
import com.nexttrucking.automation.mobile.property.PageProperty;
import com.nexttrucking.automation.mobile.dispatcher.MyLoadDetailsPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import property.SetProperty;
import javax.xml.parsers.ParserConfigurationException;
import java.net.MalformedURLException;

import static org.hamcrest.CoreMatchers.containsString;


public class DispatcherMyLoadsTest extends SetProperty {
    public static MyLoadsPage myLoadsPage;
    public static MyLoadDetailsPage myLoadDetailsPage;

    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException, ParserConfigurationException {
        setUpDriver();
        pageProperty = new PageProperty(driver, attributeName) {
        };
        availableLoadsAllPage = new AvailableLoadsAllPage(driver, attributeName);
        allowLocationPage = new AllowLocationPage(driver, attributeName);
        welcomePage = new WelcomePage(driver, attributeName);
        signInPage = new SignInPage(driver, attributeName);
        myLoadsPage = new MyLoadsPage(driver, attributeName);
        myLoadDetailsPage = new MyLoadDetailsPage(driver, attributeName);
        signInPage.signIn(getTestData("dispatcherEmail"), getTestData("dispatcherPassword"));
        availableLoadsAllPage.clickMenuButtonFirstLevel("My Loads");
        Thread.sleep(20000);
    }

    @Test
    public void myLoadsPage() {
        Assert.assertTrue(availableLoadsAllPage.getTitle("My Loads").contains("My Loads"));
        boolean isPresentLoad = myLoadsPage.isElementPresent("id", myLoadsPage.originationAddress);
        if (isPresentLoad) {
            Assert.assertNotNull(pageProperty.getElementText("id", myLoadsPage.jobNumber));
            Assert.assertTrue(pageProperty.getElementText("id", myLoadsPage.payment).contains("$"));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("id", myLoadsPage.getTextInAddress,0));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("id", myLoadsPage.getTextInAddress,1));
            boolean isLegacy=availableLoadsAllPage.isElementPresent("id",myLoadsPage.pickUpTime);
            if(isLegacy){
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", myLoadsPage.pickUpTime));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", myLoadsPage.deliveryTime));
            }else{
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", myLoadsPage.getTextInTime,0));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", myLoadsPage.getTextInTime,1));
            }
        } else {
            Assert.assertEquals(availableLoadsAllPage.getElementText("path", myLoadsPage.noLoadOnMyLoads), "You don't have any loads");
        }
    }

    @Test
    public void checkMyLoadDetail()throws InterruptedException{
        Boolean isPresentJob=myLoadsPage.isElementPresent("id",myLoadsPage.jobNumber);
        if(isPresentJob){
            Boolean isPresent=myLoadsPage.findAndClickNotStartedLiveUnloadJob();
            if(isPresent) {
                Thread.sleep(3000);
                Assert.assertThat(myLoadDetailsPage.getElementText("path",myLoadDetailsPage.locationPanel), containsString("Locations"));
                Assert.assertThat(myLoadDetailsPage.getElementText("path",myLoadDetailsPage.detailPanel), containsString("Details for Job"));

                myLoadsPage. clickElementByLocator("path", myLoadDetailsPage.locationPanel);
                Assert.assertNotNull(myLoadDetailsPage.getElementText("id", myLoadDetailsPage.getTextInAddress,0));
                Assert.assertNotNull(myLoadDetailsPage.getElementText("id", myLoadDetailsPage.getTextInAddress,1));
                Assert.assertNotNull(myLoadDetailsPage.getElementText("id", myLoadDetailsPage.getTextInAddress,2));
                Assert.assertThat(myLoadDetailsPage.getElementText("path",myLoadDetailsPage.containerStatus), containsString("Container"));
                myLoadsPage. clickElementByLocator("path", myLoadDetailsPage.locationPanel);

                myLoadsPage. clickElementByLocator("path", myLoadDetailsPage.detailPanel);
                Assert.assertEquals(myLoadDetailsPage.getElementText("path", myLoadDetailsPage.myLoadsDetailCardMap.get("youWillMake")), "You'll Make");
                Assert.assertNotNull(myLoadDetailsPage.getElementText("path", myLoadDetailsPage.myLoadsDetailCardMap.get("youWillMakeValue")));
                Assert.assertEquals(myLoadDetailsPage.getElementText("path", myLoadDetailsPage.myLoadsDetailCardMap.get("rateContract")), "Rate Contract");
                Assert.assertNotNull(myLoadDetailsPage.getElementText("path", myLoadDetailsPage.myLoadsDetailCardMap.get("rateContractValue")));
                Assert.assertEquals(myLoadDetailsPage.getElementText("path", myLoadDetailsPage.myLoadsDetailCardMap.get("equipment")), "Equipment");
                Assert.assertEquals(myLoadDetailsPage.getElementText("path", myLoadDetailsPage.myLoadsDetailCardMap.get("equipmentValue")),"Power Only");
                myLoadDetailsPage.clickElementByLocator("path",myLoadDetailsPage.myLoadsDetailCardMap.get("backToMyLoads"));
            }
        }
    }

}



