package pageObjectClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.BaseClass;

public class RecruitmentPage {

	private JavascriptExecutor js;
    private RemoteWebDriver driver;
	public RecruitmentPage(RemoteWebDriver driver) {

		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
	}

	// Page headers locators
	private By candidateHeader = By.xpath("(//a[@class='oxd-topbar-body-nav-tab-item'])[1]");
	private By vacanciesHeader = By.xpath("//a[text()='Vacancies']");

	// Requirement Candidate Page Locators
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
	private By searchButton = By.xpath("//button[@type='submit']");
	private By addButton = By.xpath("//button[contains(.,'Add')]");


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

	private String getCurrentUrlpage() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getCurrentUrlpage'");
	}

	// Requirement Menu Option Click
	public String requirementMenuClick() {
		driver.findElement(recruitmentMenu).click();
		return driver.getCurrentUrl();
	}

	// Requirement Candidate Page Action methods
	public String candidateJobTitleSelection(String title) {

		try {
			WebElement job = driver.findElement(jobTitle);
			job.click();
			driver.findElement(By.xpath("//*[text()='" + title + "']")).click();
			return job.getText();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return "Element is not found in the page ";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error is occurad job selected ";
		}
	}

	public String vacancySelection(String vacancyopt) {
		try {
			WebElement vacancy1 = driver.findElement(vacancy);
			vacancy1.click();
			driver.findElement(By.xpath("//*[text()='" + vacancyopt + "']")).click();
			return vacancy1.getAttribute("value");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return "The Dropdown Element is not find there ";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error is occurad Vacancy selected ";
		}

	}

	public String hiringManagerSelection(String manageropt) {
		try {
			WebElement manger = driver.findElement(hiringManager);
			manger.click();
			driver.findElement(By.xpath("//*[text()='" + manageropt + "']")).click();
			return manger.getAttribute("value");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return "The Dropdown Element is not find there ";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error is occurad Vacancy selected ";
		}

	}

	public String statusSelection(String statusOption) {
		try {
			WebElement statuselement = driver.findElement(status);
			Select dd = new Select(statuselement);
			dd.selectByVisibleText(statusOption);
			return dd.getFirstSelectedOption().getAttribute("Value").trim().toLowerCase();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return "The Dropdown Element is not find there ";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error is occurad Vacancy selected ";
		}

	}

	public String candidateNameEnter(String name) {
		WebElement nameofcandidate = driver.findElement(candidateName);
		nameofcandidate.sendKeys(name);
		return nameofcandidate.getAttribute("value");
	}

	public String keywordEnter(String key) {
		WebElement keywordfield = driver.findElement(keywords);
		keywordfield.sendKeys(key);
		return keywordfield.getAttribute("value");
	}

	public String candidateApplicationFromDatePickup(String from) {
		try {
			WebElement fromdate = driver.findElement(dateOfApplicationFrom);
			js.executeScript("arguments[0].value='" + from + "'", fromdate);
			return fromdate.getText().trim();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return "Calender Element not found in the page";
		} catch (Exception e) {
			e.printStackTrace();
			return "Calender date pickup there error is occurd";
		}

	}

	public String candidateApplicationToDatePickup(String to) {
		try {
			WebElement todate = driver.findElement(dateOfApplicationTo);
			js.executeScript("arguments[0].value='" + to + "'", todate);
			return todate.getText().trim();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return "Calender Element not found in the page";
		} catch (Exception e) {
			e.printStackTrace();
			return "Calender date pickup there error is occurd";
		}

	}

	public String methodOfApplicationSelection(String selection) {
		WebElement applicationtype = driver.findElement(methodOfApplication);
		By dropdownoption = By.xpath("//*[text()='" + selection + "']");
		applicationtype.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownoption));
		driver.findElement(dropdownoption).click();
		return applicationtype.getAttribute("value");
	}

	public String requirmentPageButtons(String buttonname) {
		String Button = buttonname.trim();
		try {
			switch (Button) {
			case "Reset":
				driver.findElement(resetButton).click();
				return Button;
			case "Search":
				driver.findElement(searchButton).click();
				return Button;
			case "Add":
				driver.findElement(addButton).click();
				return Button;
			default:
				return "The button name '" + Button + "' is not available on the page";
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return "The element for button '" + Button + "' was not find";

		} catch (Exception e) {
			e.printStackTrace();
			return "An error occurad while clicking the '" + Button + "' button";

		}
	}

}
