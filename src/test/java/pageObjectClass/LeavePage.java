package pageObjectClass;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import baseClass.BaseClass;

public class LeavePage extends BaseClass {

	public LeavePage(RemoteWebDriver driver) {

		BaseClass.driver = driver;

	}

	// 1. Header - Leave List Title
	By leaveListTitle = By.xpath("(//a[@class='oxd-main-menu-item'])[3]");

	// 2. From Date Field
	By fromDateInput = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[1]");

	// 3. To Date Field
	By toDateInput = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[2]");

	// 4. Leave Status Dropdown
	By leaveStatusDropdown = By.xpath("(//div[@class='oxd-select-text-input'])[1]");

	// 5. Leave Type Dropdown
	By leaveTypeDropdown = By.xpath("(//div[@class='oxd-select-text-input'])[2]");

	// 6. Employee Name Autocomplete
	By employeeNameInput = By.xpath("//input[@placeholder='Type for hints...']");

	// 7. Sub Unit Dropdown
	By subUnitDropdown = By.xpath("(//div[@class='oxd-select-text-input'])[3]");

	// 8. Include Past Employees Checkbox
	By includePastEmployeesCheckbox = By.xpath("//span[contains(@class,'oxd-switch-input oxd-switch-input--active')]");

	// 9. Search Button
	By searchButton = By.xpath("(//button[contains(@class,'oxd-button oxd-button--medium')])[2]");

	// 10. Reset Button
	By resetButton = By.xpath("(//button[contains(@class,'oxd-button oxd-button--medium')])[1]");

	// 11. Filter Panel Toggle Button
	By filterToggleButton = By.xpath("//div[@class='oxd-table-filter-header-options']//button");

	// 12. Export Button
	By exportButton = By.xpath("//div[@class='oxd-table-filter-header-options']//div[@class='--export']");

	// 13. Leave Table (Leave List)
	By leaveTable = By.xpath("//table[@class='oxd-table']");

	// 14. Individual Leave Row (First Row in Table)
	By leaveRow = By.xpath("//table[@class='oxd-table']/tbody/tr[1]");

	// 15. Leave Status Chip (Example for Pending Approval)
	By leaveStatusChip = By.xpath("//span[@class='oxd-chip oxd-chip--default']");

	// 16. Leave Type (inside the table)
	By leaveTypeColumn = By.xpath("//table[@class='oxd-table']//td[text()='Leave Type']");

	// 17. Leave Action Button (for each leave record)
	By leaveActionButton = By.xpath("//table[@class='oxd-table']//button[contains(text(),'Action')]");

	// 18. Leave Details Page (after clicking Action)
	By leaveDetailsPage = By.xpath("//div[@class='leave-details-page']");

	// 19. Leave Request Form - Request Leave Button
	By requestLeaveButton = By.xpath("//button[text()='Request Leave']");

	// 20. Leave Request Form - Cancel Button
	By cancelButton = By.xpath("//button[text()='Cancel']");

	// 21. Leave Date Field (Inside Leave Request Form)
	By leaveDateField = By.xpath("//label[text()='From Date']/following-sibling::div//input");

	// 22. Leave Status Dropdown (Inside Leave Request Form)
	By leaveStatusInRequestForm = By
			.xpath("//label[text()='Leave Status']/following-sibling::div//div[@class='oxd-select-text']");

	// Basic Action Methods (for interacting with the elements)

	// Method to enter From Date
	public String enterFromDate(String date) throws AWTException {
		WebElement fromDateField = driver.findElement(fromDateInput);
		// Create an instance of Actions class
		Actions actions = new Actions(driver);

		// Perform 'Ctrl + A' to select all text in the input field
		actions.click(fromDateField).keyDown(Keys.CONTROL) // Press 'Ctrl' key
				.sendKeys("a") // Press 'A' key (Ctrl + A)
				.keyUp(Keys.CONTROL) // Release 'Ctrl' key
				.build().perform();

		// Perform 'Delete' to remove the selected text
		actions.sendKeys(Keys.DELETE).perform(); // Press 'Delete' key
		fromDateField.sendKeys(date); // Simple sendKeys method

		return fromDateField.getText();
	}

	// Method to enter To Date
	public String enterToDate(String date) {
		WebElement toDateField = driver.findElement(toDateInput);
		// Create an instance of Actions class
		Actions actions = new Actions(driver);

		// Perform 'Ctrl + A' to select all text in the input field
		actions.click(toDateField).keyDown(Keys.CONTROL) // Press 'Ctrl' key
				.sendKeys("a") // Press 'A' key (Ctrl + A)
				.keyUp(Keys.CONTROL) // Release 'Ctrl' key
				.build().perform();

		// Perform 'Delete' to remove the selected text
		actions.sendKeys(Keys.DELETE).perform(); // Press 'Delete' key
		toDateField.sendKeys(date); // Simple sendKeys method
		return toDateField.getText();
	}

	// Method to select Leave Status from dropdown
	public String selectLeaveStatus(String status) {
		WebElement leaveStatus = driver.findElement(leaveStatusDropdown);
		Actions actions = new Actions(driver);

		actions.click().keyDown(Keys.CONTROL) // Press 'Ctrl' key
				.sendKeys("a") // Press 'A' key (Ctrl + A)
				.keyUp(Keys.CONTROL) // Release 'Ctrl' key
				.build().perform();

		// Perform 'Delete' to remove the selected text
		actions.sendKeys(Keys.DELETE).perform(); // Press 'Delete' key
		leaveStatus.click(); // Click to open dropdown
		driver.findElement(By.xpath("(//i[contains(@class,'oxd-icon bi-caret-down-fill')])[2]"));
		return status;
	}

	// Method to select Leave Type from dropdown
	public void selectLeaveType(String type) {
		WebElement leaveType = driver.findElement(leaveTypeDropdown);
		leaveType.click(); // Click to open dropdown
		Select dd = new Select(leaveType);
		dd.selectByVisibleText(type);
	}

	// Method to enter Employee Name
	public void enterEmployeeName(String name) {
		WebElement employeeNameField = driver.findElement(employeeNameInput);
		// Create an instance of Actions class
		Actions actions = new Actions(driver);

		// Perform 'Ctrl + A' to select all text in the input field
		actions.click(employeeNameField).keyDown(Keys.CONTROL) // Press 'Ctrl' key
				.sendKeys("a") // Press 'A' key (Ctrl + A)
				.keyUp(Keys.CONTROL) // Release 'Ctrl' key
				.build().perform();

		// Perform 'Delete' to remove the selected text
		actions.sendKeys(Keys.DELETE).perform(); // Press 'Delete' key
		employeeNameField.sendKeys(name); // Simple sendKeys method
	}

	// Method to select Sub Unit from dropdown
	public void selectSubUnit(String subUnit) {
		WebElement subUnitField = driver.findElement(subUnitDropdown);
		subUnitField.click(); // Click to open dropdown
		Select dd = new Select(subUnitField);
		dd.selectByVisibleText(subUnit);
	}

	// Method to toggle Include Past Employees checkbox
	public void toggleIncludePastEmployees() {
		WebElement checkbox = driver.findElement(includePastEmployeesCheckbox);
		checkbox.click(); // Toggle the checkbox
	}

	// Method to click the Search button
	public boolean clickSearchButton() {
		WebElement searchBtn = driver.findElement(searchButton);
		searchBtn.click(); // Click the button
		return true;
	}

	// Method to click the Reset button
	public boolean clickResetButton() {
		WebElement resetBtn = driver.findElement(resetButton);
		resetBtn.click(); // Click the button
		return true;
	}

	// Method to click the Filter Toggle button
	public void clickFilterToggleButton() {
		WebElement filterButton = driver.findElement(filterToggleButton);
		filterButton.click(); // Click to toggle the filter panel
	}

	// Method to click the Export button
	public void clickExportButton() {
		WebElement exportBtn = driver.findElement(exportButton);
		exportBtn.click(); // Click the button
	}

	// Method to click the first leave row in the table
	public void clickLeaveRow() {
		WebElement leaveRowElement = driver.findElement(leaveRow);
		leaveRowElement.click(); // Click on the row
	}

	// Method to click Action button for a leave record
	public void clickLeaveActionButton() {
		WebElement actionBtn = driver.findElement(leaveActionButton);
		actionBtn.click(); // Click Action button
	}

	// Method to click the Request Leave button in the leave request form
	public void clickRequestLeaveButton() {
		WebElement requestLeaveBtn = driver.findElement(requestLeaveButton);
		requestLeaveBtn.click(); // Click Request Leave button
	}

	// Method to click Cancel button in the leave request form
	public void clickCancelButton() {
		WebElement cancelBtn = driver.findElement(cancelButton);
		cancelBtn.click(); // Click Cancel button
	}

	// Method to enter the leave date in the leave request form
	public void enterLeaveDate(String date) {
		WebElement leaveDateFieldElement = driver.findElement(leaveDateField);
		leaveDateFieldElement.sendKeys(date); // Enter the date
	}

	// Method to select Leave Status from dropdown inside the request form
	public void selectLeaveStatusInRequestForm(String status) {
		WebElement leaveStatusField = driver.findElement(leaveStatusInRequestForm);
		leaveStatusField.click(); // Open the dropdown
		WebElement statusOption = driver
				.findElement(By.xpath("//div[@class='oxd-select-text']//span[text()='" + status + "']"));
		statusOption.click(); // Select the status
	}

}
