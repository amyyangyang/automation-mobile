package WebSite.Dispatcher;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class ChatPage {
    private WebDriver driver;

    public ChatPage(WebDriver driver){
        this.driver = driver;
    }

    private By title = xpath("//title");
    private By navChatButton = xpath("//li[@id='nav_chat']/a");
    private By chatHeader = xpath("//div[@id='j-loading']//following-sibling::*[1]");
    private By content = xpath("//div[@class='friends']//div[@class='list']");


    public int getContent() {
        return driver.findElements(content).size();
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public ChatPage clickNavChatButton(){
        driver.findElement(navChatButton).click();
        return new ChatPage(driver);
    }

    public int isChatVisible(){
        return driver.findElements(chatHeader).size();
    }
}
