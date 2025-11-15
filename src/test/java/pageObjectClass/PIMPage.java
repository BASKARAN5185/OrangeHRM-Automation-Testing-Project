package pageObjectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import baseClass.BaseClass;

public class PIMPage {
    private RemoteWebDriver driver;
	public PIMPage(RemoteWebDriver driver) {
		this.driver = driver;
	}

	// Menu
	By pimMenuItem = By.linkText("PIM");
	By EmployeeInfo_employeeNameInput = By.xpath("//input[@placeholder='Type for hints...']");
	By EmployeeInfo_employeeIdInput = By.xpath("//input[@class='oxd-input oxd-input--active']");
	By EmployeeInfo_employmentStatusDropdown = By.xpath("//div[@class='oxd-select-text oxd-select-text--active']//div[@class='oxd-select-text-input']");
	By EmployeeInfo_includeDropdown = By.xpath("//div[@class='oxd-select-text oxd-select-text--active']//div[@class='oxd-select-text-input']");
	By EmployeeInfo_supervisorNameInput = By.xpath("//input[@placeholder='Type for hints...']");
	By EmployeeInfo_jobTitleDropdown = By.xpath("//div[@class='oxd-select-text oxd-select-text--active']//div[@class='oxd-select-text-input']");
	By EmployeeInfo_subUnitDropdown = By.xpath("//div[@class='oxd-select-text oxd-select-text--active']//div[@class='oxd-select-text-input']");
	By EmployeeInfo_resetButton = By.xpath("//button[@type='reset' and contains(text(),'Reset')]");
	By EmployeeInfo_searchButton = By.xpath("//button[@type='submit' and contains(text(),'Search')]");
	By resetButton = By.xpath("//button[@type='reset']");
	By searchButton = By.xpath("//button[@type='submit']");
	By employeeListAddbitton = By.xpath("//button[contains(.,'Add')]");	
	By EMPaddButton = By.xpath("//div[@class='orangehrm-header-container']//button[1]");

	// Helper method for clearing and typing into fields
    private void clearAndType(By locator, String text) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        
        // Select all text, delete it, and type the new text
        actions.click(element)
               .keyDown(Keys.CONTROL).sendKeys("a")
               .keyUp(Keys.CONTROL)
               .sendKeys(Keys.DELETE) // Delete current text
               .sendKeys(text)        // Type new text
               .perform();
    }

    // Methods to interact with PIM Page elements

    public void menuClickPIMPage() {
        driver.findElement(pimMenuItem).click();
    }

    public void clickAddButton() {
        WebElement addButton = driver.findElement(EMPaddButton);
        addButton.click();
    }

    public void enterEmployeeName(String employeeName) {
        clearAndType(EmployeeInfo_employeeNameInput, employeeName);
    }

    public void enterEmployeeId(String employeeId) {
        clearAndType(EmployeeInfo_employeeIdInput, employeeId);
    }

    public void selectEmploymentStatus(String status) {
        WebElement statusDropdown = driver.findElement(EmployeeInfo_employmentStatusDropdown);
        statusDropdown.click();
        Select select = new Select(statusDropdown);
        select.selectByVisibleText(status); // You can select the option by visible text
    }

    public void selectIncludeOption(String option) {
        WebElement includeDropdown = driver.findElement(EmployeeInfo_includeDropdown);
        includeDropdown.click();
        Select select = new Select(includeDropdown);
        select.selectByVisibleText(option); // You can select the option by visible text
    }

    public void enterSupervisorName(String supervisorName) {
        clearAndType(EmployeeInfo_supervisorNameInput, supervisorName);
    }

    public void selectJobTitle(String jobTitle) {
        WebElement jobTitleDropdown = driver.findElement(EmployeeInfo_jobTitleDropdown);
        jobTitleDropdown.click();
        Select select = new Select(jobTitleDropdown);
        select.selectByVisibleText(jobTitle); // You can select the option by visible text
    }

    public void selectSubUnit(String subUnit) {
        WebElement subUnitDropdown = driver.findElement(EmployeeInfo_subUnitDropdown);
        subUnitDropdown.click();
        Select select = new Select(subUnitDropdown);
        select.selectByVisibleText(subUnit); // You can select the option by visible text
    }

    // General Button Click Methods
    public void clickResetButton() {
        WebElement resetButton = driver.findElement(EmployeeInfo_resetButton);
        resetButton.click();
    }

    public void clickSearchButton() {
        WebElement searchButton = driver.findElement(EmployeeInfo_searchButton);
        searchButton.click();
    }

    // Additional Helper Methods for Clicking Reset and Search buttons (if they share the same action)
    public void clickButton(By buttonLocator) {
        WebElement button = driver.findElement(buttonLocator);
        button.click();
    }

}
