package pageObjectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClass.BaseClass;
import io.reactivex.rxjava3.functions.Action;

public class AddCandidatePage extends BaseClass {
    
	public AddCandidatePage(RemoteWebDriver driver, Action action) {
		BaseClass.driver = driver;
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
    
    
    
    
    
    
    
}