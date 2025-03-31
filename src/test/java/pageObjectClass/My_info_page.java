package pageObjectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClass.BaseClass;

public class My_info_page extends BaseClass {

	public My_info_page(RemoteWebDriver driver) {
		BaseClass.driver = driver;
	}

	// My info page menu locators
	By PersonalHeader=By.xpath("//h6[text()='Personal Details']");
	By Myinfomenu = By.xpath("//span[text()='My Info']");
	By firstNameField = By.xpath("//input[@placeholder = 'First Name']");
	By middleNameField = By.xpath("//input[@placeholder = 'Middle Name']");
	By lastNameField = By.xpath("//input[@placeholder = 'Last Name']");
	By dateOfBirthField = By.xpath("//input[@placeholder = 'yyyy-dd-mm']");
	By datePickerDay = By.xpath("//*[text() = '8']");
	By selectDropdown = By.xpath("//*[text() = '-- Select --']");
	By selectButton = By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space");
	By bloodGroupField = By.xpath(
			"//div[@id='app']/div/div[2]/div[2]/div/div/div/div[2]/div[2]/div/form/div/div/div/div/div[2]/input");
	By bloodGroupOption = By.xpath("//*[text() = 'A+']");
	By submitButton = By.cssSelector(
			"div.orangehrm-card-container > form.oxd-form > div.oxd-form-actions > button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space");

	public void enterFirstName(String firstName) {
		driver.findElement(firstNameField).sendKeys(firstName);
	}
	
	public boolean PersonalDetailsHeader() {
		boolean Visible=driver.findElement(firstNameField).isDisplayed();
		return Visible;
	}

	public void enterMiddleName(String middleName) {
		driver.findElement(middleNameField).sendKeys(middleName);
	}

	public void enterLastName(String lastName) {
		driver.findElement(lastNameField).sendKeys(lastName);
	}

	public void selectDateOfBirth() {
		driver.findElement(dateOfBirthField).click();
		driver.findElement(datePickerDay).click(); // Selecting the 8th as an example
	}

	public void Clickthemyinfomenu() {
		driver.findElement(Myinfomenu).click();
	}

	public void selectDropdownOption() {
		driver.findElement(selectDropdown).click();
	}

	public void clickButton() {
		driver.findElement(selectButton).click();
	}

	public void setBloodGroup() {
		driver.findElement(bloodGroupField).click();
		driver.findElement(bloodGroupOption).click();
	}

	public void submitForm() {
		driver.findElement(submitButton).click();
	}

	public String getFirstNameValue() {
		return driver.findElement(firstNameField).getAttribute("value");
	}

	public String getMiddleNameValue() {
		return driver.findElement(middleNameField).getAttribute("value");
	}

	public String getLastNameValue() {
		return driver.findElement(lastNameField).getAttribute("value");
	}

	public String getDateOfBirthValue() {
		return driver.findElement(dateOfBirthField).getAttribute("value");
	}

	public String getBloodGroupValue() {
		return driver.findElement(bloodGroupField).getAttribute("value");
	}

	public String getDropdownSelectedValue() {
		return driver.findElement(selectDropdown).getText();
	}

	public String getCurrentPageUrl() {
		return driver.getCurrentUrl();
	}
}
