package testcases.owneroperator;

import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import com.nexttrucking.automation.mobile.dispatcher.MyDriversPage;
import com.nexttrucking.automation.mobile.dispatcher.AccountPage;
import com.nexttrucking.automation.mobile.property.PageProperty;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import property.SetProperty;

import javax.xml.parsers.ParserConfigurationException;
import java.net.MalformedURLException;

public class OwnerAccountTest extends SetProperty {
    public static AccountPage accountPage;

    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException, ParserConfigurationException {
        setUpDriver();
        pageProperty = new PageProperty(driver, attributeName) {
        };
        availableLoadsAllPage = new AvailableLoadsAllPage(driver, attributeName);
        allowLocationPage = new AllowLocationPage(driver, attributeName);
        welcomePage = new WelcomePage(driver, attributeName);
        signInPage = new SignInPage(driver, attributeName);
        myDriversPage = new MyDriversPage(driver, attributeName);
        accountPage = new AccountPage(driver, attributeName);
        // SignIn as OwnerOperator
        signInPage.signIn(getTestData("ownerOperatorEmail"), getTestData("ownerOperatorPassword"));
        availableLoadsAllPage.clickMenuButtonFirstLevel("Account");
    }


    class AccountTitle {
        private String titleText;
        private String title;
        private String titleValue;

        public AccountTitle(String titleText, String title, String titleValue) {
            this.titleText = titleText;
            this.title = title;
            this.titleValue = titleValue;
        }
    }

    @Test
    public void checkEditProfilePage() throws InterruptedException {
        accountPage.clickElementByLocator("path", accountPage.editProfileBtn);
        AccountTitle AccountTitles[] = {
                new AccountTitle(accountPage.nameTitle, "Name", "nameValue"),
                new AccountTitle(accountPage.phoneNumberTitle, "Phone Number", "phoneNumberValue"),
                new AccountTitle(accountPage.emailTitle, "Email", "emailValue"),
                new AccountTitle(accountPage.homeBaseTitle, "Home Base", "homeBaseValue"),
                new AccountTitle(accountPage.passwordTitle, "Password", "passwordValue"),
                new AccountTitle(accountPage.languageTitle, "Language", "languageValue"),
                new AccountTitle(accountPage.carrierInfoTitle, "Carrier Info", "carrierInfoValue"),
                new AccountTitle(accountPage.equipmentTitle, "Equipment", "equipmentValue"),
                new AccountTitle(accountPage.carrierDocsTitle, "Carrier Docs", "carrierDocsValue"),
                new AccountTitle(accountPage.bankAccountTitle, "Bank Account", "bankAccountValue")
        };

        for (int i = 0; i < AccountTitles.length; i++) {
            AccountTitle name = AccountTitles[i];
            if (name.titleText == accountPage.passwordTitle) {
                accountPage.swipeToUpForAndroid();
            }
            Assert.assertEquals(accountPage.getElementText("path", name.titleText), name.title);
            Assert.assertNotNull(accountPage.accountCardMap.get(name.titleValue));
        }
       accountPage.clickElementByLocator("path", accountPage.backBtn);
    }

    @Test
    public void checkAccountPage() throws InterruptedException{
        Assert.assertEquals(accountPage.getElementText("path", accountPage.accountPageTitle),"Account");
        Assert.assertEquals(accountPage.getElementText("path", accountPage.editProfileBtn),"Edit Profile");
        Assert.assertEquals(accountPage.getElementText("path", accountPage.loadPreferenceBtn),"Load Preferences");
        Assert.assertEquals(accountPage.getElementText("path", accountPage.LogoutBtn),"Logout");
    }

    @Test
    public void loadPreferenceModal() throws InterruptedException {
        accountPage.clickElementByLocator("path", accountPage.loadPreferenceBtn);
        Thread.sleep(3000);
        boolean showModal = accountPage.isElementPresent("path", accountPage.preferenceModalTitle);
        if (showModal) {
            Assert.assertEquals(accountPage.getElementText("path", accountPage.preferenceModalTitle), "Don't waste time looking for loads");
            Assert.assertEquals(accountPage.getElementText("path", accountPage.preferenceModalBodyText), "Let us know what you like and we’ll text you loads that match your preferences");
            accountPage.clickElementByLocator("'path", accountPage.preferenceModalButton);
            Thread.sleep(3000);
            Assert.assertFalse(accountPage.isElementPresent("path", accountPage.preferenceModalBodyText));
        }
       accountPage.clickElementByLocator("path", accountPage.backBtn);
    }

    @Test
    public void checkLoadPreferenceFields() throws InterruptedException {
        accountPage.clickElementByLocator("path", accountPage.loadPreferenceBtn);
        Thread.sleep(3000);
        boolean showModal = accountPage.isElementPresent("path", accountPage.preferenceModalTitle);
        if (showModal) {
            accountPage.clickElementByLocator("'path", accountPage.preferenceModalButton);
            Thread.sleep(3000);
        }
        Assert.assertEquals(accountPage.getElementText("path", accountPage.loadCostTitle), "Minimum Load Cost");
        Assert.assertNotNull(accountPage.accountCardMap.get("loadCostValue"));
        Assert.assertEquals(accountPage.getElementText("path", accountPage.distanceFromTitle), "Maximum distance from you");
        Assert.assertNotNull(accountPage.accountCardMap.get("distanceFromValue"));
        Assert.assertEquals(accountPage.getElementText("path", accountPage.loadDistanceTitle), "Load Distance");
        Assert.assertNotNull(accountPage.accountCardMap.get("loadDistanceValue"));
        Assert.assertEquals(accountPage.getElementText("path", accountPage.desiredDestinationTitle), "Desired Destinations");
        Assert.assertNotNull(accountPage.accountCardMap.get("desiredDestinationValue"));
        Assert.assertEquals(accountPage.getElementText("path", accountPage.commoditiesTitle), "Commodities to avoid");
        Assert.assertNotNull(accountPage.accountCardMap.get("commoditiesValue"));
        Assert.assertEquals(accountPage.getElementText("path", accountPage.maxWeightTitle), "Max Weight");
        Assert.assertNotNull(accountPage.accountCardMap.get("maxWeightValue"));
    }

}
