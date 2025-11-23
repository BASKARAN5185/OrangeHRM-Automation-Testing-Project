package pageObjectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AddCandidatePage {

    private RemoteWebDriver driver;
    public AddCandidatePage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By fromTitle = By.xpath("//h6[contains(text(),'Add Candidate')]");
    By firstName = By.xpath("//input[@name='firstName' and @placeholder='First Name']");
    By middleName = By.xpath("//input[@name='middleName' or @placeholder='Middle Name']");
    By lastName = By.xpath("//*[contains(@name,'lastName')]");
    By vacancy = By.xpath("//div[starts-with(@class , 'oxd-select-text ')]");
    By email = By.xpath("(//input[@placeholder='Type here'])[1]");
    By contact = By.xpath("(//input[@placeholder='Type here'])[2]");
    By resumeUpload = By.xpath("//div[text()='Browser']/parent::div");
    By keywords = By.xpath("//div[@data-v-957b4417='']/child::input");
    By dataOfApplication = By.xpath("//div[@class='oxd-date-input']//descendant::input");
    By notes = By.tagName("textarea");
    By keepDataCheckBox = By.xpath("//span[contains(@class,'oxd-checkbox-input oxd-checkbox-input--active')]//i[1]");
    By cancelButton = By.xpath("(//div[@class='oxd-form-actions']//button)[2]");

    // Actions
    public void enterFirstName(String fname) {
        WebElement element = driver.findElement(firstName);
        element.clear();
        element.sendKeys(fname);
    }

    public void enterMiddlename(String mname) {
        WebElement midName = driver.findElement(middleName);
        midName.clear();
        midName.sendKeys(mname);
    }

    public void enterLastName(String lName) {
        WebElement lastNameField = driver.findElement(lastName);
        lastNameField.clear();
        lastNameField.sendKeys(lName);
    }

    public String enterTitle(String title) {
        WebElement jobTitle = driver.findElement(fromTitle);
        jobTitle.sendKeys(Keys.chord(Keys.SHIFT, "a"));
        jobTitle.sendKeys(title);
        return jobTitle.getText();
    }
}
