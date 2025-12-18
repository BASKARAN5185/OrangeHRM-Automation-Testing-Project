package pageObjectClass.recuritment;

import java.time.Duration;
import java.util.List;

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
    private By recruitmentMenuItem = By.xpath("//span[text()='Recruitment ']");
	private By vacancySubMenuItem = By.xpath("//a[@href='/web/index.php/recruitment/viewJobVacancy']");
    private By dataNotFound=By.xpath("//span[text()='No Records Found']");

	// Methods to interact with Vacancy Page elements
	public boolean selectVacancyTitle(String title) {

    WebElement titleDropdown = wait.until(
            ExpectedConditions.elementToBeClickable(vacanciesTitle));
    titleDropdown.click();

    By optionLocator = By.xpath(
            "//div[contains(@class,'oxd-select-option') and contains(normalize-space(),'" + title + "')]");

    try {
        WebElement option = wait.until(
                ExpectedConditions.elementToBeClickable(optionLocator));
        option.click();
    } catch (Exception e) {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        action.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement option = wait.until(
                ExpectedConditions.elementToBeClickable(optionLocator));
        option.click();
    }
	return false; 
   }


	public void selectVacancy(String vacancy) {
		WebElement vacancyDropdown = driver.findElement(vacanciesVacancy);
		vacancyDropdown.click();
		WebElement vacancyOption = driver.findElement(By.xpath("//*[contains(text(),'"+vacancy+"')]"));
		vacancyOption.click();
	}

	public void selectHiringManager(){
		WebElement managerDropdown=driver.findElement(vacanciesHiringManager);
		managerDropdown.click();
		Actions action=new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).perform();
		action.sendKeys(Keys.PAGE_DOWN).perform();
		action.sendKeys(Keys.ENTER).perform();
	}

	public void selectStatus(){
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

    public void menuClickVacancyPage() {
		
		WebElement recruitmentMenu = driver.findElement(recruitmentMenuItem);
		Actions actions = new Actions(driver);
		actions.moveToElement(recruitmentMenu).perform();

		WebElement vacancySubMenu = wait.until(ExpectedConditions.elementToBeClickable(vacancySubMenuItem));
		vacancySubMenu.click();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	public void searchVacancy(String title , String vacancy ){
       selectVacancyTitle(title);
	   selectVacancy(vacancy);
	   selectHiringManager();
	   selectStatus();
	}
    
	public boolean serachFunctionValidation(String data){
	List<WebElement> searchData = driver.findElements(
            By.xpath("//div[@class='data' and contains(text(),'" + data + "')]"));

    List<WebElement> notFoundData = driver.findElements(dataNotFound);

    if (!searchData.isEmpty()) {
        return true;
    } else if (!notFoundData.isEmpty() && notFoundData.get(0).isDisplayed()) {
        return true;
    }

    return false;
}


}
