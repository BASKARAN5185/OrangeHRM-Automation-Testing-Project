package pageObjectClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddVacancyPage {
  
    private RemoteWebDriver driver;
    private WebDriverWait wait;
    public AddVacancyPage(RemoteWebDriver driver) {
        this.driver = driver;
        this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    // Add Vacancy Page locators
	private By vacancyName = By.xpath("(//span[contains(.,'Albert Hemibgue')]/following::input)[1]");
	private By addVacancyJobTitle = By.xpath("oxd-select-text-input");
	private By description = By.tagName("textarea");
	private By addVacancyHioringManage = By
			.xpath("(//label[normalize-space(text())='Hiring Manager']/following::input)[1]");
	private By numberOfPosition = By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]");
	private By activeCheckbox = By.xpath("(//span[contains(@class,'oxd-switch-input oxd-switch-input--active')])[1]");
	private By publishInRSSCheckbox = By
			.xpath("//(span[contains(@class,'oxd-switch-input oxd-switch-input--active --label-right')[2]]");
    private By cancelButton = By.xpath("//button[contains(.,'Cancel')]");
    private By saveButton = By.xpath("//button[text()=' Save ']");  
    
    // Methods to interact with Add Vacancy Page elements
    public void enterVacancyName(String name) {
        WebElement vacancyNameInput = driver.findElement(vacancyName);
        vacancyNameInput.clear();
        vacancyNameInput.sendKeys(name);
    }

    public void clickSaveButton() {
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveBtn.click();
    }

    public void selectVacancyTitle(){
		WebElement statusDropdown=driver.findElement(addVacancyJobTitle);
		statusDropdown.click();
		Actions action=new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).perform();
		action.sendKeys(Keys.PAGE_DOWN).perform();
		action.sendKeys(Keys.ENTER).perform();
	}


    
}
