package pageObjectClass;

import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class EmployeeFrom {

    private RemoteWebDriver driver;

    public EmployeeFrom(RemoteWebDriver driver){
        this.driver=driver;
    }

// Employee Form Locators

By EmployeeForm_firstNameInput= By.xpath("//input[@name='firstName']");
By EmployeeForm_middleNameInput= By.xpath("//input[@name='middleName']");
By EmployeeForm_lastNameInput= By.xpath("//input[@name='lastName']");
By EmployeeForm_employeeIdInput= By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
By EmployeeForm_uploadButton= By.xpath("//button[contains(@class,'employee-image-action')]");
By EmployeeForm_loginDetailsSwitch= By.xpath("//span[contains(@class,'oxd-switch-input')]");
By EmployeeForm_usernameInput= By.xpath("(//label[normalize-space(text())='Username']/following::input)[1]");
By EmployeeForm_statusEnabledRadio= By.xpath("//input[@type='radio' and @value='1']");
By EmployeeForm_statusDisabledRadio= By.xpath("//input[@type='radio' and @value='2']");
By EmployeeForm_passwordInput= By.xpath("(//label[normalize-space(text())='Password']/following::input)[1]");
By EmployeeForm_confirmPasswordInput= By.xpath("//label[normalize-space(text())='Confirm Password']/following::input");
By EmployeeForm_cancelButton= By.xpath("//button[contains(.,'Cancel')]");
By EmployeeForm_saveButton= By.xpath("//button[@type='submit']");


// Helper method 
private void clearAndType(By locator, String text) {
    WebElement element = driver.findElement(locator);
    element.clear();
    element.sendKeys(text);
}

// Form Actions
public void enterEmployeeFirstName(String firstName) {
    clearAndType(EmployeeForm_firstNameInput, firstName);
}

public void enterEmployeeMiddleName(String middleName) {
    clearAndType(EmployeeForm_middleNameInput, middleName);
}

public void enterEmployeeLastName(String lastName) {
    clearAndType(EmployeeForm_lastNameInput, lastName);
}

public void enterEmployeeId(String employeeId) {
    clearAndType(EmployeeForm_employeeIdInput, employeeId);
}

public void uploadEmployeeProfileImage(String imagePath) {
    driver.findElement(EmployeeForm_uploadButton).click();
    driver.findElement(By.xpath("//input[@type='file']")).sendKeys(imagePath);
}

public void toggleEmployeeLoginDetailsSwitch() {
    WebElement loginSwitch = driver.findElement(EmployeeForm_loginDetailsSwitch);
    loginSwitch.click(); // Switch is a toggle; clicking is enough
}

public void enterEmployeeUsername(String username) {
    clearAndType(EmployeeForm_usernameInput, username);
}

public void selectEmployeeStatus(String status) {
    if (status.equalsIgnoreCase("Enabled")) {
        driver.findElement(EmployeeForm_statusEnabledRadio).click();
    } else if (status.equalsIgnoreCase("Disabled")) {
        driver.findElement(EmployeeForm_statusDisabledRadio).click();
    }
}

public void enterEmployeePassword(String password) {
    clearAndType(EmployeeForm_passwordInput, password);
}

public void enterEmployeeConfirmPassword(String confirmPassword) {
    clearAndType(EmployeeForm_confirmPasswordInput, confirmPassword);
}

public void clickCancelButton() {
    driver.findElement(EmployeeForm_cancelButton).click();
}

public boolean clickSaveButton() {
    WebElement saveBtn = driver.findElement(EmployeeForm_saveButton);
    saveBtn.click();
    return saveBtn.isDisplayed();
}

}
