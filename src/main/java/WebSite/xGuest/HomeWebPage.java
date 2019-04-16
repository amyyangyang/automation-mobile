package WebSite.xGuest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.By.xpath;


public class HomeWebPage {
    private WebDriver driver;
//    private Actions actions;

    public HomeWebPage(WebDriver driver){
        this.driver = driver;
    }

    private By singUpButton = xpath("//nav[@class='fusion-main-menu']//span[contains(text(),'Sign up')]");
    private By singInButton = xpath("//nav[@class='fusion-main-menu']//span[@class='menu-text'][contains(text(),'Sign in')]");
    private By blogMenu = xpath("//a[@class='fusion-bar-highlight']//span[contains(text(),'Blog')]");
    private By supportMenu = xpath("//a[@class='fusion-bar-highlight']//span[contains(text(),'Support')]");
    private By content = xpath("//img[contains(@class, 'img-responsive')]");
    private By aboutUsMenu = xpath("//span[contains(text(), 'About Us') and @class='menu-text']");


    public int getContent() {
        return driver.findElements(content).size();
    }

    public SignUpPage clickSingUpButton(){
        driver.findElement(singUpButton).click();
        return new SignUpPage(driver);
    }

    public SignInPage clickSingInButton(){
        driver.findElement(singInButton).click();
        return new SignInPage(driver);
    }

    public BlogGuestPage clickBlogButton(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(aboutUsMenu)).build().perform();
        driver.findElement(blogMenu).click();
        return new BlogGuestPage(driver);
    }

    public SupportPage clickSupportButton(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(aboutUsMenu)).build().perform();
        driver.findElement(supportMenu).click();
        return new SupportPage(driver);
    }


}
