package pageObjectClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.BaseClass;
import io.reactivex.rxjava3.functions.Action;

public class AddCandidatePage extends BaseClass {
    WebDriverWait wait;
	
	public AddCandidatePage(RemoteWebDriver driver) {
		BaseClass.driver = driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Add candidate page locators
	By fromTitle = By.xpath("//h6[contains(text(),'Add Candidate')]");
    By firstName = By.xpath("//input[name='firstName' and placeholder='First Name']");
	By middleName = By.xpath("//input[name='middleName' or placeholder='Middle Name'] ");
	By lastName = By.xpath("//*[contains (@name,'lastName')]");
	By vacancy = By.xpath("//div[start-with(@class , 'oxd-select-text ')]");
	By email = By.xpath("(//input[@placeholder='Type here'])[1]");
	By contact = By.xpath("(//input[@placeholder='Type here'])[2]");
	By resumeUpload = By.xpath("//div[text()='Browser']/parent::div");
    By keywords=By.xpath("//div[@data-v-957b4417='']/child::input");
    By dataOfApplication=By.xpath("//div[@class='oxd-date-input']//descendent::input");
    By notes=By.tagName("textarea");
    By keppDataCheckBox=By.xpath("//span[contains(@class,'oxd-checkbox-input oxd-checkbox-input--active')]//i[1]");
    By cancelButton= By.xpath("(//div[@class='oxd-form-actions']//button)[2]");
    
    // Candidate Page Action Methods 
    public void enterFirstName(String fname) throws InterruptedException {
    	driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(fname);	
    }
    
    public void enterMiddlename(String mname) {
    	WebElement midName=getElement(middleName);
    	midName.clear();
    	midName.sendKeys(mname); 	
    }
    
    public void enterLastName(String lName) {
    	WebElement LastName=driver.findElement(lastName);
    	LastName.clear();
    	LastName.sendKeys(lName);
    }
    
    public String enterThitle(String title) {
    	WebElement jobtitle=driver.findElement(fromTitle);
    	jobtitle.clear();
    	jobtitle.sendKeys(Keys.chord(Keys.SHIFT,"a"));
       	jobtitle.sendKeys(title);
       	String gettext=jobtitle.getText();
       	return gettext;
    }
    
    public void selectVacancy(String vacancyName) {
        WebElement vacancyDropdown = wait.until(ExpectedConditions.elementToBeClickable(vacancy));
        vacancyDropdown.click();
        // select from dropdown by visible text
        WebElement option = driver.findElement(By.xpath("//div[@role='option']//span[text()='" + vacancyName + "']"));
        option.click();
    }

    public void enterEmail(String mail) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(email));
        emailField.clear();
        emailField.sendKeys(mail);
    }

    public void enterContact(String phone) {
        WebElement contactField = wait.until(ExpectedConditions.visibilityOfElementLocated(contact));
        contactField.clear();
        contactField.sendKeys(phone);
    }

    public void uploadResume(String filePath) {
        WebElement uploadField = wait.until(ExpectedConditions.presenceOfElementLocated(resumeUpload));
        uploadField.sendKeys(filePath);  // send absolute file path
    }

    public void enterKeywords(String keywordText) {
        WebElement keywordField = wait.until(ExpectedConditions.visibilityOfElementLocated(keywords));
        keywordField.clear();
        keywordField.sendKeys(keywordText);
    }

    public void enterDateOfApplication(String date) {
        WebElement dateField = wait.until(ExpectedConditions.visibilityOfElementLocated(dataOfApplication));
        dateField.clear();
        dateField.sendKeys(date);
        dateField.sendKeys(Keys.ENTER);
    }

    public void enterNotes(String noteText) {
        WebElement notesField = wait.until(ExpectedConditions.visibilityOfElementLocated(notes));
        notesField.clear();
        notesField.sendKeys(noteText);
    }

    public void clickKeepDataCheckbox() {
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(keppDataCheckBox));
        checkbox.click();
    }

    public void clickCancelButton() {
        WebElement cancelBtn = wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
        cancelBtn.click();
    }
    
}