package pageObjectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AddVacancyPage {
  
    private RemoteWebDriver driver;
    
    public AddVacancyPage(RemoteWebDriver driver) {
        this.driver = driver;
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
}
