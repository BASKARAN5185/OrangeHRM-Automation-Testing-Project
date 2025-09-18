package pageObjectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import baseClass.BaseClass;

public class RecruitmentPage extends BaseClass {

	public RecruitmentPage(RemoteWebDriver driver) {

		BaseClass.driver = driver;
	}

	// Page headers locators
	private By candidateHeader = By.xpath("(//a[@class='oxd-topbar-body-nav-tab-item'])[1]");
	private By vacanciesHeader = By.xpath("//a[text()='Vacancies']");

	// Recruitment Page Loactors
	private By recruitmentMenu = By.xpath("//span[text()='Recruitment']");
	private By jobTitle = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
	private By vacancy = By.xpath("(//div[@class='oxd-select-text-input'])[2]");
	private By hiringManager = By.xpath("(//div[@class='oxd-select-text-input'])[3]");
	private By status = By.xpath("(//div[@class='oxd-select-text-input'])[4]");
	private By candidateName = By.xpath("//input[@placeholder='Type for hints...']");
	private By keywords = By.xpath("//input[@placeholder='Enter comma seperated words...']");
	private By dateOfApplicationFrom = By.xpath("//input[@placeholder='From']");
	private By dateOfApplicationTo = By.xpath("//input[@placeholder='To']");
	private By methodOfApplication = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[3]/div/div/div/div[2]/div/div/div[1]");
	private By resetButton = By.xpath("//button[@type='reset']");
	private By submitButton = By.xpath("//button[@type='submit']");
	private By addButton = By.xpath("//button[contains(.,'Add')]");

	// Add Candidate Page Locators
	private By firstName = By.name("firstName");
	private By middleName = By.name("middleName");
	private By lastname = By.name("lastName");
	private By addvacancy = By.className("oxd-select-text-input");
	private By email = By.xpath("(//input[@placeholder='Type here'])[1]");
	private By contactNumber = By.xpath("(//input[@placeholder='Type here'])[2]");
	private By resume = By.xpath("//i[@class='oxd-icon bi-upload oxd-file-input-icon']");
	private By addCandidateKeywords = By.xpath("//input[@placeholder='Enter comma seperated words...']");
	private By addCandidateDateOfApplication = By.xpath("//input[@placeholder='yyyy-dd-mm']");
	private By notes = By.tagName("textarea");
	private By keepData = By.xpath("//i[contains(@class,'oxd-icon bi-check')]");
	private By cancelButton = By.xpath("//button[contains(.,'Cancel')]");
	private By saveButton = By.xpath("//button[@type='submit']");

	// Vacancies Page Locators
	private By vacanciesTitle = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
	private By vacanciesVacancy = By.xpath("(//div[@class='oxd-select-text-input'])[2]");
	private By vacanciesHiringManager = By.xpath("(//div[@class='oxd-select-text-input'])[3]");
	private By vacanciesStatus = By.xpath("(//div[@class='oxd-select-text-input'])[4]");
	private By vacanciesResetButton = By.xpath("//button[contains(.,'Reset')]");
	private By vacanciesSearchButton = By.xpath("//button[contains(.,'Search')]");
	private By vacanciesAddButton = By.xpath("//button[contains(.,'Add')]");

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

	// Page Header locators action methods
	public String headersMenus(String menuname) {
		if (menuname == null || menuname.trim().isEmpty()) {
			System.out.println("Menuname is empty");
			return "Menuname name is empty ";
		}

		String Header = menuname.trim().toLowerCase();
		try {
			if (Header.equals("candidates")) {
				driver.findElement(candidateHeader).click();
				return getCurrentUrlpage();
			} else if (Header.equals("vacancies")) {
				driver.findElement(vacanciesHeader).click();
				return getCurrentUrlpage();
			} else {
				System.out.println("No Header menu find " + menuname);
				return "No matching header found.";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Exception occurred while clicking header.";
		}

	}

	// Requirement Page Action methods
	public String candidateJobTitleSelection(String title) {
		
		try {
			WebElement job = driver.findElement(jobTitle);
			Select dd = new Select(job);
			dd.selectByVisibleText(title);
			return dd.getFirstSelectedOption().getText().trim().toLowerCase();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return "Element is not found in the page ";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error is occurad job selected ";
		}
	}

}
