package testcases.owneroperator;

import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import com.nexttrucking.automation.mobile.dispatcher.JobDetailPage;
import com.nexttrucking.automation.mobile.dispatcher.MyLoadsPage;
import com.nexttrucking.automation.mobile.property.PageProperty;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import property.SetProperty;

import javax.xml.parsers.ParserConfigurationException;
import java.net.MalformedURLException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OwnerBookTenderTest extends SetProperty {
    public static JobDetailPage jobDetailPage;
    public static MyLoadsPage myLoadsPage;

    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException, ParserConfigurationException {
        setUpDriver();
        pageProperty = new PageProperty(driver, attributeName) {
        };
        availableLoadsAllPage = new AvailableLoadsAllPage(driver, attributeName);
        allowLocationPage = new AllowLocationPage(driver, attributeName);
        welcomePage = new WelcomePage(driver, attributeName);
        signInPage = new SignInPage(driver, attributeName);
        jobDetailPage = new JobDetailPage(driver, attributeName);
        myLoadsPage = new MyLoadsPage(driver, attributeName);
        signInPage.signIn(getTestData("ownerOperatorEmail"), getTestData("ownerOperatorPassword"));
        availableLoadsAllPage.clickElementByLocator("id",availableLoadsAllPage.portButton);
        Thread.sleep(3000);
    }

    @Test
    public void bookLiveUnLoadJobOnly() throws InterruptedException {
            boolean isPresentException = false;
            int loop = 0;
            do {
                ++loop;
                boolean isPresentLoad = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.originationAddress);
                if (isPresentLoad) {
                        availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.originationAddress);
                        jobDetailPage.clickElementByLocator("path", jobDetailPage.bookButton);
                        isPresentException = jobDetailPage.checkBookJobForErrors();
                        if (isPresentException) {
                            continue;
                        }
                        Thread.sleep(3000);
                        jobDetailPage.bookTender();
                        isPresentException = jobDetailPage.checkBookJobForErrors();
                        if (isPresentException) {
                            continue;
                        }
                        Assert.assertTrue(jobDetailPage.getElementText("path", jobDetailPage.booked).contains("You're booked!"));
                        jobDetailPage.goToMyLoadsOrAvailableLoadsPage(jobDetailPage.goToMyLoadsButton);
                        availableLoadsAllPage.clickMenuButtonFirstLevel("Available Loads");
                } else {
                    Assert.assertTrue(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoadAllType).contains("All of these loads are taken"));
                }
            } while ((isPresentException) && (loop < 3));
        }
}
