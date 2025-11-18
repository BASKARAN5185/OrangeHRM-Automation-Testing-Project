package pageObjectClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeavePage  {

    private RemoteWebDriver driver;
    private WebDriverWait wait;
    public LeavePage(RemoteWebDriver driver) {
        this.driver = driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    //Menu
    By LeaveMenu=By.xpath("//*[@class='oxd-main-menu-item active']");
    // Locators
    By leaveListTitle = By.xpath("(//a[@class='oxd-main-menu-item'])[3]");
    By fromDateInput = By.xpath("(//input[starts-with(@placeholder,'yyyy')])[1]");
    By toDateInput = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[2]");
    By leaveStatusDropdown = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
    By leaveTypeDropdown = By.xpath("(//div[@class='oxd-select-text-input'])[2]");
    By employeeNameInput = By.xpath("//input[@placeholder='Type for hints...']");
    By subUnitDropdown = By.xpath("(//div[@class='oxd-select-text-input'])[3]");
    By includePastEmployeesCheckbox = By.xpath("//span[contains(@class,'oxd-switch-input')]");
    By searchButton = By.xpath("(//button[contains(@class,'oxd-button oxd-button--medium')])[2]");
    By resetButton = By.xpath("(//button[contains(@class,'oxd-button oxd-button--medium')])[1]");
    By filterToggleButton = By.xpath("//div[@class='oxd-table-filter-header-options']//button");
    By exportButton = By.xpath("//div[@class='oxd-table-filter-header-options']//div[@class='--export']");
    By leaveRow = By.xpath("//table[@class='oxd-table']/tbody/tr[1]");
    By leaveActionButton = By.xpath("//table[@class='oxd-table']//button[contains(text(),'Action')]");
    By requestLeaveButton = By.xpath("//button[text()='Request Leave']");
    By cancelButton = By.xpath("//button[text()='Cancel']");
    By leaveDateField = By.xpath("//label[text()='From Date']/following-sibling::div//input");
    By leaveStatusInRequestForm = By.xpath("//label[text()='Leave Status']/following-sibling::div//div[@class='oxd-select-text']");


    // Method to enter From Date
    public String enterFromDate(String date) {
        WebElement fromDateField = driver.findElement(fromDateInput);
        Actions actions = new Actions(driver);

        actions.click(fromDateField)
                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .perform();

        fromDateField.sendKeys(date);
        return date;
    }

	// Click the Leave Menu
    public void clickLeaveMenu() {
		wait.until(driver -> driver.findElement(LeaveMenu).isDisplayed());
		driver.findElement(LeaveMenu).click();
	}

    // Method to enter To Date
    public String enterToDate(String date) {
        WebElement toDateField = driver.findElement(toDateInput);
        Actions actions = new Actions(driver);

        actions.click(toDateField)
                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .perform();

        toDateField.sendKeys(date);
        return date;
    }

    // Method to select Leave Status
    public String selectLeaveStatus(String status) {
        WebElement leaveStatus = driver.findElement(leaveStatusDropdown);
        leaveStatus.click();

        WebElement option = driver.findElement(By.xpath("//span[text()='" + status + "']"));
        option.click();
		return leaveStatus.getText(); 
    }

    // Method to select Leave Type
    public void selectLeaveType(String type) {
        WebElement dropdown = driver.findElement(leaveTypeDropdown);
        dropdown.click();

        WebElement option = driver.findElement(By.xpath("//span[text()='" + type + "']"));
        option.click();
    }

    // Method to enter Employee Name
    public void enterEmployeeName(String name) {
        WebElement employeeNameField = driver.findElement(employeeNameInput);
        Actions actions = new Actions(driver);

        actions.click(employeeNameField)
                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .perform();

        employeeNameField.sendKeys(name);
    }

    // Method to select Sub Unit
    public void selectSubUnit(String subUnit) {
        WebElement dropdown = driver.findElement(subUnitDropdown);
        dropdown.click();

        WebElement option = driver.findElement(By.xpath("//span[text()='" + subUnit + "']"));
        option.click();
    }

    // Toggle checkbox
    public void toggleIncludePastEmployees() {
        driver.findElement(includePastEmployeesCheckbox).click();
    }

    public boolean clickSearchButton() {
        driver.findElement(searchButton).click();
		return true;
    }

    public boolean clickResetButton() {
        driver.findElement(resetButton).click();
		return true;
    }

    public void clickFilterToggleButton() {
        driver.findElement(filterToggleButton).click();
    }

    public void clickExportButton() {
        driver.findElement(exportButton).click();
    }

    public void clickLeaveRow() {
        driver.findElement(leaveRow).click();
    }

    public void clickLeaveActionButton() {
        driver.findElement(leaveActionButton).click();
    }

    public void clickRequestLeaveButton() {
        driver.findElement(requestLeaveButton).click();
    }

    public void clickCancelButton() {
        driver.findElement(cancelButton).click();
    }

    public void enterLeaveDate(String date) {
        driver.findElement(leaveDateField).sendKeys(date);
    }

    public void selectLeaveStatusInRequestForm(String status) {
        driver.findElement(leaveStatusInRequestForm).click();
        WebElement option = driver.findElement(By.xpath("//span[text()='" + status + "']"));
        option.click();
    }

}
