package pageObjectClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VacancyPage {
    private RemoteWebDriver driver;
    private WebDriverWait wait;

    public VacancyPage(RemoteWebDriver driver) {
        this.driver = driver;
		this.wait= new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    // Vacancies Page Locators
	private By vacanciesTitle = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
	private By vacanciesVacancy = By.xpath("(//div[@class='oxd-select-text-input'])[2]");
	private By vacanciesHiringManager = By.xpath("(//div[@class='oxd-select-text-input'])[3]");
	private By vacanciesStatus = By.xpath("(//div[@class='oxd-select-text-input'])[4]");
	private By vacanciesResetButton = By.xpath("//button[contains(.,'Reset')]");
	private By vacanciesSearchButton = By.xpath("//button[contains(.,'Search')]");
	private By vacanciesAddButton = By.xpath("//button[contains(.,'Add')]");
  
	// Methods to interact with Vacancy Page elements
	public void selectVacancyTitle(String title) {
		WebElement titleDropdown = driver.findElement(vacanciesTitle);
		titleDropdown.click();
		WebElement titleOption = driver.findElement(By.xpath("//div[@role='option']//span[text()='" + title + "']"));
		titleOption.click();
	}

	public void selectVacancy(String vacancy) {
		WebElement vacancyDropdown = driver.findElement(vacanciesVacancy);
		vacancyDropdown.click();
		WebElement vacancyOption = driver.findElement(By.xpath("//div[@role='option']//span[text()='" + vacancy + "']"));
		vacancyOption.click();
	}

	public void selectHiringManager(String manager){
		WebElement managerDropdown=driver.findElement(vacanciesHiringManager);
		managerDropdown.click();
		Actions action=new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).perform();
		action.sendKeys(Keys.PAGE_DOWN).perform();
		action.sendKeys(Keys.ENTER).perform();
	}

	public void selectStatus(String status){
		WebElement statusDropdown=driver.findElement(vacanciesStatus);
		statusDropdown.click();
		Actions action=new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).perform();
		action.sendKeys(Keys.PAGE_DOWN).perform();
		action.sendKeys(Keys.ENTER).perform();
	}

	public void clickResetButton() {
		WebElement button = driver.findElement(vacanciesResetButton);
		WebElement resetButton=wait.until(ExpectedConditions.elementToBeClickable(button));
		resetButton.click();
	}

	public void clickSearchButton() {
		WebElement button = driver.findElement(vacanciesSearchButton);
		WebElement searchButton=wait.until(ExpectedConditions.elementToBeClickable(button));
		searchButton.click();
	}

	public void clickAddVacancyButton() {
		WebElement button = driver.findElement(vacanciesAddButton);
		WebElement addButton=wait.until(ExpectedConditions.elementToBeClickable(button));
		addButton.click();
	}

}
