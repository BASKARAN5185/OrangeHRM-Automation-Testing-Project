package pageObjectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class AdminPage {
	

	private RemoteWebDriver driver;
	
    public AdminPage(RemoteWebDriver driver) {
	
		this.driver=driver;
		
	}
  
	// Admin Page menu locato
	By Adminmenu=By.xpath("//span[text()='Admin']");
	
	// AddUserp (Add User Page) Locators
	By AddUserpUserRoleDropdown = By.xpath("(//div[text()='-- Select --'])[1]");
	By AddUserpEmployeeNameInput = By.xpath("//label[text()='Employee Name']/following-sibling::div//input");
	By AddUserpStatusDropdown = By.xpath("(//div[text()='-- Select --'])[2]");
	By AddUserpUsernameInput = By.xpath("//label[text()='Username']/following-sibling::div//input");
	By AddUserpPasswordInput = By.xpath("//label[text()='Password']/following-sibling::div//input[@type='password']");
	By AddUserpConfirmPasswordInput = By.xpath("//label[text()='Confirm Password']/following-sibling::div//input[@type='password']");
	By AddUserpSaveButton = By.xpath("//button[text()='Save']");
	By AddUserpCancelButton = By.xpath("//button[text()='Cancel']");
	By AddUserpPasswordHint = By.xpath("//p[contains(text(),'For a strong password, please use a hard to guess')]");  // Password hint
	By AddUserpFormTitle = By.xpath("//h6[contains(text(),'Add User')]"); // Title of the Add User form
   
	// Locators for System Users page with prefix SystemUserp
    By SystemUserpTitle = By.xpath("//h5[contains(text(),'System Users')]");
    By SystemUserpUsernameInput = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By SystemUserpUserRoleDropdown = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
    By SystemUserpEmployeeNameInput = By.xpath("//input[@placeholder='Type for hints...']");
    By SystemUserpStatusDropdown = By.xpath("(//div[@class='oxd-select-text-input'])[2]");
    By SystemUserpResetButton = By.xpath("(//button[contains(@class,'oxd-button oxd-button--medium')])[1]");
    By SystemUserpSearchButton = By.xpath("(//button[contains(@class,'oxd-button oxd-button--medium')])[2]");
    By SystemUserpAddButton = By.xpath("(//button[contains(@class,'oxd-button oxd-button--medium')])[3]");
    
    
    public void selectUserRole(String userRole) {
        WebElement userRoleDropdown = driver.findElement(AddUserpUserRoleDropdown);
        userRoleDropdown.click();
        Actions action=new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        action.sendKeys(Keys.PAGE_DOWN).perform();
        action.sendKeys(Keys.ENTER); 
    }

    public void enterEmployeeName(String employeeName) {
        driver.findElement(AddUserpEmployeeNameInput).sendKeys(employeeName);
    }

    public void selectStatus(String status) {
        WebElement statusDropdown = driver.findElement(AddUserpStatusDropdown);
        statusDropdown.click();
        Actions action=new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        action.sendKeys(Keys.PAGE_DOWN).perform();
        action.sendKeys(Keys.ENTER);
    }

    public void enterUsername(String username) {
        driver.findElement(AddUserpUsernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(AddUserpPasswordInput).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        driver.findElement(AddUserpConfirmPasswordInput).sendKeys(confirmPassword);
    }

    public void clickSaveButton() {
        driver.findElement(AddUserpSaveButton).click();
    }

    public void clickCancelButton() {
        driver.findElement(AddUserpCancelButton).click();
    }
    
    public void clicktheadminmenu() {
        driver.findElement(Adminmenu).click();
    }

    public String getPasswordHint() {
        return driver.findElement(AddUserpPasswordHint).getText();
    }

    // Action Methods for System Users Page

    public void enterUsernameForSystemUser(String username) {
        driver.findElement(SystemUserpUsernameInput).sendKeys(username);
    }

    public void selectUserRoleForSystemUser(String userRole) {
        WebElement userRoleDropdown = driver.findElement(SystemUserpUserRoleDropdown);
        Select select = new Select(userRoleDropdown);
        select.selectByVisibleText(userRole); // Select by visible text
    }

    public void enterEmployeeNameForSystemUser(String employeeName) {
        driver.findElement(SystemUserpEmployeeNameInput).sendKeys(employeeName);
    }

    public void selectStatusForSystemUser(String status) {
        WebElement statusDropdown = driver.findElement(SystemUserpStatusDropdown);
        Select select = new Select(statusDropdown);
        select.selectByVisibleText(status); // Select by visible text
    }

    public void clickResetButtonForSystemUser() {
        driver.findElement(SystemUserpResetButton).click();
    }

    public void clickSearchButtonForSystemUser() {
        driver.findElement(SystemUserpSearchButton).click();
    }

    public void clickAddButtonForSystemUser() {
        driver.findElement(SystemUserpAddButton).click();
    }

 
    
    
}
