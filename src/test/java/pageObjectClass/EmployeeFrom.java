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

By EmployeeForm_firstNameInput        = By.xpath("//input[@name='firstName']");
By EmployeeForm_middleNameInput       = By.xpath("//input[@name='middleName']");
By EmployeeForm_lastNameInput         = By.xpath("//input[@name='lastName']");
By EmployeeForm_employeeIdInput       = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");

By EmployeeForm_uploadButton          = By.xpath("//button[contains(@class,'employee-image-action')]");

By EmployeeForm_loginDetailsSwitch    = By.xpath("//span[contains(@class,'oxd-switch-input')]");
By EmployeeForm_usernameInput         = By.xpath("(//label[normalize-space(text())='Username']/following::input)[1]");
By EmployeeForm_statusEnabledRadio    = By.xpath("//input[@type='radio' and @value='1']");
By EmployeeForm_statusDisabledRadio   = By.xpath("//input[@type='radio' and @value='2']");
By EmployeeForm_passwordInput         = By.xpath("(//label[normalize-space(text())='Password']/following::input)[1]");
By EmployeeForm_confirmPasswordInput  = By.xpath("//label[normalize-space(text())='Confirm Password']/following::input");

By EmployeeForm_cancelButton          = By.xpath("//button[contains(.,'Cancel')]");
By EmployeeForm_saveButton            = By.xpath("//button[@type='submit']");


}
