package pageObjectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClass.BaseClass;

public class PIMPage extends BaseClass {

	public PIMPage(RemoteWebDriver driver) {
		BaseClass.driver = driver;
	}

	// Menu
	By pimMenuItem = By.linkText("PIM");


	// Employee Name Field (Autocomplete)
	By EmployeeInfo_employeeNameInput = By.xpath("//input[@placeholder='Type for hints...']");

	// Employee Id Field (Text Input)
	By EmployeeInfo_employeeIdInput = By.xpath("//input[@class='oxd-input oxd-input--active']");

	// Employment Status Dropdown (Select)
	By EmployeeInfo_employmentStatusDropdown = By.xpath("//div[@class='oxd-select-text oxd-select-text--active']//div[@class='oxd-select-text-input']");

	// Include Dropdown (Current Employees Only option)
	By EmployeeInfo_includeDropdown = By.xpath("//div[@class='oxd-select-text oxd-select-text--active']//div[@class='oxd-select-text-input']");

	// Supervisor Name Field (Autocomplete)
	By EmployeeInfo_supervisorNameInput = By.xpath("//input[@placeholder='Type for hints...']");

	// Job Title Dropdown (Select)
	By EmployeeInfo_jobTitleDropdown = By.xpath("//div[@class='oxd-select-text oxd-select-text--active']//div[@class='oxd-select-text-input']");

	// Sub Unit Dropdown (Select)
	By EmployeeInfo_subUnitDropdown = By.xpath("//div[@class='oxd-select-text oxd-select-text--active']//div[@class='oxd-select-text-input']");

	// Reset Button
	By EmployeeInfo_resetButton = By.xpath("//button[@type='reset' and contains(text(),'Reset')]");

	// Search Button
	By EmployeeInfo_searchButton = By.xpath("//button[@type='submit' and contains(text(),'Search')]");

	// Locators for the buttons
	By resetButton = By.xpath("//button[@type='reset']");
	By searchButton = By.xpath("//button[@type='submit']");
	By employeeListAddbitton = By.xpath("//button[contains(.,'Add')]");
	
	By EMPaddButton = By.xpath("//div[@class='orangehrm-header-container']//button[1]");



	public void MenuClickPIMPage() {

		driver.findElement(pimMenuItem).click();
	}
	
	public void clickAddButton() {
	    WebElement addButton = driver.findElement(EMPaddButton);
	    addButton.click();
	}


	public void enterEmployeeName(String employeeName) {
		driver.findElement(EmployeeInfo_employeeNameInput).clear();
	    WebElement employeeNameField = driver.findElement(EmployeeInfo_employeeNameInput);
	    // Create an instance of Actions class
        Actions actions = new Actions(driver);

        // Perform 'Ctrl + A' to select all text in the input field
        actions.click(employeeNameField)
               .keyDown(Keys.CONTROL)  // Press 'Ctrl' key
               .sendKeys("a")          // Press 'A' key (Ctrl + A)
               .keyUp(Keys.CONTROL)    // Release 'Ctrl' key
               .build()
               .perform();

        // Perform 'Delete' to remove the selected text
        actions.sendKeys(Keys.DELETE).perform();  // Press 'Delete' key
	    employeeNameField.sendKeys(employeeName);
	}

	public void EmployeelistenterEmployeeId(String employeeId) {
	    WebElement employeeIdField = driver.findElement(EmployeeInfo_employeeIdInput);
	    // Create an instance of Actions class
        Actions actions = new Actions(driver);

        // Perform 'Ctrl + A' to select all text in the input field
        actions.click(employeeIdField)
               .keyDown(Keys.CONTROL)  // Press 'Ctrl' key
               .sendKeys("a")          // Press 'A' key (Ctrl + A)
               .keyUp(Keys.CONTROL)    // Release 'Ctrl' key
               .build()
               .perform();

        // Perform 'Delete' to remove the selected text
        actions.sendKeys(Keys.DELETE).perform();  // Press 'Delete' key
	    employeeIdField.sendKeys(employeeId);
	}

	public void selectEmploymentStatus(String status) {
	    WebElement statusDropdown = driver.findElement(EmployeeInfo_employmentStatusDropdown);
	    statusDropdown.click(); 
	    // Additional code to select the status from dropdown
	}

	public void selectIncludeOption(String option) {
	    WebElement includeDropdown = driver.findElement(EmployeeInfo_includeDropdown);
	    includeDropdown.click(); 
	    // Additional code to select "Current Employees Only" or other options
	}

	public void enterSupervisorName(String supervisorName) {
	    WebElement supervisorNameField = driver.findElement(EmployeeInfo_supervisorNameInput);
	    // Create an instance of Actions class
        Actions actions = new Actions(driver);

        // Perform 'Ctrl + A' to select all text in the input field
        actions.click(supervisorNameField)
               .keyDown(Keys.CONTROL)  // Press 'Ctrl' key
               .sendKeys("a")          // Press 'A' key (Ctrl + A)
               .keyUp(Keys.CONTROL)    // Release 'Ctrl' key
               .build()
               .perform();

        // Perform 'Delete' to remove the selected text
        actions.sendKeys(Keys.DELETE).perform();  // Press 'Delete' key
	    supervisorNameField.sendKeys(supervisorName);
	}

	public void selectJobTitle(String jobTitle) {
	    WebElement jobTitleDropdown = driver.findElement(EmployeeInfo_jobTitleDropdown);
	    jobTitleDropdown.click();
	    // Additional code to select the job title
	}

	public void selectSubUnit(String subUnit) {
	    WebElement subUnitDropdown = driver.findElement(EmployeeInfo_subUnitDropdown);
	    subUnitDropdown.click();
	    // Additional code to select the sub-unit
	}

	public void clickResetButton() {
	    WebElement resetButton = driver.findElement(EmployeeInfo_resetButton);
	    resetButton.click();
	}

	public void clickSearchButton() {
	    WebElement searchButton = driver.findElement(EmployeeInfo_searchButton);
	    searchButton.click();
	}


	// Locators for Employee Form (with "EmployeeForm" prefix)

	// Employee Full Name Fields
	By EmployeeForm_firstNameInput = By.xpath("//input[@name='firstName']"); // First Name Input
	By EmployeeForm_middleNameInput = By.xpath("//input[@name='middleName']"); // Middle Name Input
	By EmployeeForm_lastNameInput = By.xpath("//input[@name='lastName']"); // Last Name Input

	// Employee ID Input
	By EmployeeForm_employeeIdInput = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"); // Employee ID Input

	// Profile Image Upload Button
	By EmployeeForm_uploadButton = By.xpath("//button[@class='oxd-icon-button oxd-icon-button--solid-main employee-image-action']"); // Upload Button (for profile image)

	// Login Details Section
	By EmployeeForm_loginDetailsSwitch = By.xpath("//span[contains(@class,'oxd-switch-input oxd-switch-input--active')]"); // Login Details Switch (checkbox)
	By EmployeeForm_usernameInput = By.xpath("(//label[normalize-space(text())='Username']/following::input)[1]"); // Username Input
	By EmployeeForm_statusEnabledRadio = By.xpath("//input[@type='radio'][@value='1']"); // Enabled Radio Button
	By EmployeeForm_statusDisabledRadio = By.xpath("//input[@type='radio'][@value='2']"); // Disabled Radio Button
	By EmployeeForm_passwordInput = By.xpath("(//label[normalize-space(text())='Password']/following::input)[1]"); // Password Input
	By EmployeeForm_confirmPasswordInput = By.xpath("//label[normalize-space(text())='Confirm Password']/following::input"); // Confirm Password Input

	// Buttons (Cancel and Save)
	By EmployeeForm_cancelButton = By.xpath("//button[contains(.,'Cancel')]"); // Cancel Button
	By EmployeeForm_saveButton = By.xpath("//button[@type='submit']"); // Save Button

	// Additional Texts and Hints
	By EmployeeForm_requiredHintText = By.xpath("//p[contains(text(),' * Required')]"); // Required Hint
	By EmployeeForm_fileUploadHintText = By.xpath("//p[contains(text(),'Accepts jpg, .png, .gif up to 1MB')]"); // File upload hint
	By EmployeeForm_profileImage = By.xpath("//img[@alt='profile picture']"); // Profile Image Display

	
	
	public String enterEmployeeFirstName(String firstName) {
	     
	     
	     WebElement Firstname=driver.findElement(EmployeeForm_firstNameInput);
	     // Create an instance of Actions class
	        Actions actions = new Actions(driver);

	        // Perform 'Ctrl + A' to select all text in the input field
	        actions.click(Firstname)
	               .keyDown(Keys.CONTROL)  // Press 'Ctrl' key
	               .sendKeys("a")          // Press 'A' key (Ctrl + A)
	               .keyUp(Keys.CONTROL)    // Release 'Ctrl' key
	               .build()
	               .perform();

	        // Perform 'Delete' to remove the selected text
	        actions.sendKeys(Keys.DELETE).perform();  // Press 'Delete' key
	        Firstname.sendKeys(firstName);
	      return Firstname.getText();
	    
	}

	public void enterEmployeeMiddleName(String middleName) {
	    WebElement middleNameElement = driver.findElement(EmployeeForm_middleNameInput);
	    // Create an instance of Actions class
        Actions actions = new Actions(driver);

        // Perform 'Ctrl + A' to select all text in the input field
        actions.click(middleNameElement)
               .keyDown(Keys.CONTROL)  // Press 'Ctrl' key
               .sendKeys("a")          // Press 'A' key (Ctrl + A)
               .keyUp(Keys.CONTROL)    // Release 'Ctrl' key
               .build()
               .perform();

        // Perform 'Delete' to remove the selected text
        actions.sendKeys(Keys.DELETE).perform();  // Press 'Delete' key
	    middleNameElement.sendKeys(middleName);
	}

	public void enterEmployeeLastName(String lastName) {
	    WebElement lastNameElement = driver.findElement(EmployeeForm_lastNameInput);
	    // Create an instance of Actions class
        Actions actions = new Actions(driver);

        // Perform 'Ctrl + A' to select all text in the input field
        actions.click(lastNameElement)
               .keyDown(Keys.CONTROL)  // Press 'Ctrl' key
               .sendKeys("a")          // Press 'A' key (Ctrl + A)
               .keyUp(Keys.CONTROL)    // Release 'Ctrl' key
               .build()
               .perform();

        // Perform 'Delete' to remove the selected text
        actions.sendKeys(Keys.DELETE).perform();  // Press 'Delete' key
	    lastNameElement.sendKeys(lastName);
	}

	public void enterEmployeeId(String employeeId) {
	    WebElement employeeIdElement = driver.findElement(EmployeeForm_employeeIdInput);
	    // Create an instance of Actions class
        Actions actions = new Actions(driver);

        // Perform 'Ctrl + A' to select all text in the input field
        actions.click(employeeIdElement)
               .keyDown(Keys.CONTROL)  // Press 'Ctrl' key
               .sendKeys("a")          // Press 'A' key (Ctrl + A)
               .keyUp(Keys.CONTROL)    // Release 'Ctrl' key
               .build()
               .perform();

        // Perform 'Delete' to remove the selected text
        actions.sendKeys(Keys.DELETE).perform();  // Press 'Delete' key
	    employeeIdElement.sendKeys(employeeId);
	}

	public void uploadEmployeeProfileImage(String imagePath) {
	    WebElement uploadButtonElement = driver.findElement(EmployeeForm_uploadButton);
	    uploadButtonElement.click();
	    WebElement fileInputElement = driver.findElement(By.xpath("//input[@type='file']"));
	    fileInputElement.sendKeys(imagePath);
	}

	public void toggleEmployeeLoginDetailsSwitch() {
	    WebElement loginSwitch = driver.findElement(EmployeeForm_loginDetailsSwitch);
	    if (!loginSwitch.isSelected()) {
	        loginSwitch.click();
	    }
	}

	public void enterEmployeeUsername(String username) {
	    WebElement usernameElement = driver.findElement(EmployeeForm_usernameInput);
	    // Create an instance of Actions class
        Actions actions = new Actions(driver);

        // Perform 'Ctrl + A' to select all text in the input field
        actions.click(usernameElement)
               .keyDown(Keys.CONTROL)  // Press 'Ctrl' key
               .sendKeys("a")          // Press 'A' key (Ctrl + A)
               .keyUp(Keys.CONTROL)    // Release 'Ctrl' key
               .build()
               .perform();

        // Perform 'Delete' to remove the selected text
        actions.sendKeys(Keys.DELETE).perform();  // Press 'Delete' key
	    usernameElement.sendKeys(username);
	}

	public void selectEmployeeStatus(String status) {
	    if (status.equalsIgnoreCase("Enabled")) {
	        WebElement enabledRadioButton = driver.findElement(EmployeeForm_statusEnabledRadio);
	        enabledRadioButton.click();
	    } else if (status.equalsIgnoreCase("Disabled")) {
	        WebElement disabledRadioButton = driver.findElement(EmployeeForm_statusDisabledRadio);
	        disabledRadioButton.click();
	    }
	}

	public void enterEmployeePassword(String password) {
	    WebElement passwordElement = driver.findElement(EmployeeForm_passwordInput);
	    // Create an instance of Actions class
        Actions actions = new Actions(driver);

        // Perform 'Ctrl + A' to select all text in the input field
        actions.click(passwordElement)
               .keyDown(Keys.CONTROL)  // Press 'Ctrl' key
               .sendKeys("a")          // Press 'A' key (Ctrl + A)
               .keyUp(Keys.CONTROL)    // Release 'Ctrl' key
               .build()
               .perform();

        // Perform 'Delete' to remove the selected text
        actions.sendKeys(Keys.DELETE).perform();  // Press 'Delete' key
	    passwordElement.sendKeys(password);
	}

	public void enterEmployeeConfirmPassword(String confirmPassword) {
	    WebElement confirmPasswordElement = driver.findElement(EmployeeForm_confirmPasswordInput);
	    // Create an instance of Actions class
        Actions actions = new Actions(driver);

        // Perform 'Ctrl + A' to select all text in the input field
        actions.click(confirmPasswordElement)
               .keyDown(Keys.CONTROL)  // Press 'Ctrl' key
               .sendKeys("a")          // Press 'A' key (Ctrl + A)
               .keyUp(Keys.CONTROL)    // Release 'Ctrl' key
               .build()
               .perform();

        // Perform 'Delete' to remove the selected text
        actions.sendKeys(Keys.DELETE).perform();  // Press 'Delete' key
	    confirmPasswordElement.sendKeys(confirmPassword);
	}

	public void clickCancelButton() {
	    WebElement cancelBtn = driver.findElement(EmployeeForm_cancelButton);
	    cancelBtn.click();
	}

	public boolean clickSaveButton() {
	    WebElement saveBtn = driver.findElement(EmployeeForm_saveButton);
	    saveBtn.click();
	    return saveBtn.isDisplayed();
	}

}
