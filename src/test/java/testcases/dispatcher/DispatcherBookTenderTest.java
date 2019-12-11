package testcases.dispatcher;

import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import com.nexttrucking.automation.mobile.dispatcher.JobDetailPage;
import com.nexttrucking.automation.mobile.dispatcher.MyLoadsPage;
import com.nexttrucking.automation.mobile.property.PageProperty;
import com.nexttrucking.automation.mobile.property.Utils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import property.SetProperty;

import javax.xml.parsers.ParserConfigurationException;
import java.net.MalformedURLException;

import static org.hamcrest.core.IsCollectionContaining.hasItem;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DispatcherBookTenderTest extends SetProperty {
    public static JobDetailPage jobDetailPage;
    public static MyLoadsPage   myLoadsPage;

    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException, ParserConfigurationException {
        setUpDriver();
        pageProperty = new PageProperty(driver, attributeName) {};
        availableLoadsAllPage = new AvailableLoadsAllPage(driver, attributeName);
        allowLocationPage = new AllowLocationPage(driver, attributeName);
        welcomePage = new WelcomePage(driver, attributeName);
        signInPage = new SignInPage(driver, attributeName);
        jobDetailPage = new JobDetailPage(driver, attributeName);
        myLoadsPage=new MyLoadsPage(driver,attributeName);
        signInPage.signIn(getTestData("dispatcherEmail"), getTestData("dispatcherPassword"));
        availableLoadsAllPage.clickElementByLocator("id",availableLoadsAllPage.longHaulButton);
    }

    @Test
    public void bookJobOnly() throws InterruptedException {
        Boolean isPresentException = false;
        do {
            Boolean isPresentLoad = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.originationAddress);
            if (isPresentLoad) {
                availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.equipmentType);
                jobDetailPage.clickElementByLocator("path", jobDetailPage.bookButton);
                Thread.sleep(3000);
                isPresentException = jobDetailPage.checkBookJobForErrors(jobDetailPage);
                if (isPresentException) {
                    continue;
                }
                jobDetailPage.bookTender();
                isPresentException = jobDetailPage.checkBookJobForErrors(jobDetailPage);
                if (isPresentException) {
                    continue;
                }
                Assert.assertTrue(jobDetailPage.getElementText("path", jobDetailPage.booked).contains("You're booked!"));
                jobDetailPage.skipAssignDriver();
            } else {
                Assert.assertTrue(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoadAllType).contains("All of our loads have been taken"));
            }
        } while (isPresentException);
    }

    //@Test
    public void bookJobAndAssignDriver() throws InterruptedException {
        for (int i = 0; i < 4; i++) {
            Boolean isPresentLoadNow = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.originationAddress);
            if(!isPresentLoadNow){
                break;
            }
            Boolean isPresentException = false;
            int loop=0;
            do {
                ++loop;
                Boolean isPresentLoad = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.originationAddress);
                if (isPresentLoad) {
                    availableLoadsAllPage.findLiveUnloadJob();
                    boolean isLiveUnloadPresent = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.liveLoadAddress);
                    if (isLiveUnloadPresent) {
                        pageProperty.clickElementByLocator("id", availableLoadsAllPage.liveLoadAddress);
                        jobDetailPage.clickElementByLocator("path", jobDetailPage.bookButton);
                        Thread.sleep(3000);
                        isPresentException = jobDetailPage.checkBookJobForErrors(jobDetailPage);
                        if (isPresentException) {
                            continue;
                        }
                        jobDetailPage.bookTender();
                        isPresentException = jobDetailPage.checkBookJobForErrors(jobDetailPage);
                        if (isPresentException) {
                            continue;
                        }
                        Assert.assertTrue(jobDetailPage.getElementText("path", jobDetailPage.booked).contains("You're booked!"));
                        isPresentException = jobDetailPage.assignDriver(jobDetailPage.jobDetailCard.get("driver"));
                        if(isPresentException){
                            availableLoadsAllPage.clickMenuButtonFirstLevel("Available Loads");
                        }
                    }
                } else {
                    Assert.assertTrue(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoadAllType).contains("All of our loads have been taken"));
                }
            } while ((isPresentException)&&(loop<3));
        }
    }
}
