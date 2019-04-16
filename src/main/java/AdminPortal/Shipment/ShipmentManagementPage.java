package AdminPortal.Shipment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class ShipmentManagementPage {
    private WebDriver driver;



    public ShipmentManagementPage(WebDriver driver) {
        this.driver = driver;
    }

    private By content = xpath("//tbody[@class='hoverColor borderTop ng-scope']");
    private By dedicatedLane = xpath("//select[@name='dedicatedLane']");
    private By dedicatedLaneYes = xpath("//select[@id='dedicatedLane']/option[contains(text(),'Yes')]");
    private By searchButton = xpath("//div[@class='col-md-5 form-group']//div[2]//button[1]");
    private By exportAsExcelButton = xpath("//div[@id='originThead']//thead//button[1]");
    private By auditHistoryButton = xpath("//button[@id='order_btn_auditHistory_0']");
    private By auditHistoryContent = xpath("//audit-history[@class='ng-isolate-scope']//tr");
    private By shipmentStatusButton = xpath("//button[@id='order_btn_shipmentStatus_0_b']");
    private By shipmentStatusContent = xpath("//div[@class='col-sm-8']/div");
    private By shipmentTimelineButton = xpath("//a[contains(text(),'Shipment Timeline')]");
    private By shipmentTimelineContent = xpath("//div[@class='time-line-content']");
    private By exceptionButton = xpath("//a[@class='ng-binding'][contains(text(),'Exceptions')]");
    private By exceptionContent = xpath("//exceptions//div[@class='col-sm-6']");
    private By truckingButton = xpath("//button[@id='order_btn_tracking_0']");
    private By truckingHistoryButton = xpath("//a[contains(text(),'Tracking History')]");
    private By macroPointButton = xpath("//a[contains(text(),'MacroPoint')]");
    private By manualUpdateButton = xpath("//a[contains(text(),'Manual Update')]");
    private By truckingContent = xpath("//div[@id='trackingMap']");
    private By truckingHistoryContent = xpath("//table[@class='table table-striped trackingTable']");
    private By macroPointContent = xpath("//fieldset[@ng-disabled='vm.macroPoint.trackDisabled']/div");
    private By manualUpdateContent = xpath("//table[@class='table table-striped trackingTable']//tr");
    private By showPageNumber = xpath("//div[@class='col-sm-5']//select/option");



    public int getShowEntries() {
        return driver.findElements(showPageNumber).size();
    }

    public int getContent() {
        return driver.findElements(content).size();
    }

    public ShipmentManagementPage chooseDedicateYes() throws InterruptedException {
        driver.findElement(dedicatedLane).click();
        Thread.sleep(1000);
        driver.findElement(dedicatedLaneYes).click();
        return this;
    }

    public ShipmentManagementPage clickSearchButton() {
        driver.findElement(searchButton).click();
        return this;
    }

    public ShipmentManagementPage clickExportButton(){
        driver.findElement(exportAsExcelButton).click();
        return this;
    }

    public ShipmentManagementPage clickAuditHistoryButton(){
        driver.findElement(auditHistoryButton).click();
        return this;
    }

    public int getAuditHistoryContent(){
        return driver.findElements(auditHistoryContent).size();
    }

    public ShipmentManagementPage clickShipmentStatusButton(){
        driver.findElement(shipmentStatusButton).click();
        return this;
    }

    public int getShipmentStatusContent(){
        return driver.findElements(shipmentStatusContent).size();
    }

    public ShipmentManagementPage clickShipmentTimelineButton(){
        driver.findElement(shipmentTimelineButton).click();
        return this;
    }

    public int getShipmentTimelineContent(){
        return driver.findElements(shipmentTimelineContent).size();
    }

    public ShipmentManagementPage clickExceptionsButton(){
        driver.findElement(exceptionButton).click();
        return this;
    }

    public int getExceptionContent(){
        return driver.findElements(exceptionContent).size();
    }

    public ShipmentManagementPage clickTruckingButton(){
        driver.findElement(truckingButton).click();
        return this;
    }

    public int getTruckingContent(){
        return driver.findElements(truckingContent).size();
    }

    public ShipmentManagementPage clickTruckingHistoryButton(){
        driver.findElement(truckingHistoryButton).click();
        return this;
    }

    public int getTruckingHistoryContent(){
        return driver.findElements(truckingHistoryContent).size();
    }

    public ShipmentManagementPage clickMacroPointButton(){
        driver.findElement(macroPointButton).click();
        return this;
    }

    public int getMacroPointContent(){
        return driver.findElements(macroPointContent).size();
    }

    public ShipmentManagementPage clickManualUpdateButton(){
        driver.findElement(manualUpdateButton).click();
        return this;
    }

    public int getManualUpdateContent(){
        return driver.findElements(manualUpdateContent).size();
    }



}
