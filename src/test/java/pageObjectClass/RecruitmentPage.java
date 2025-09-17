package pageObjectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClass.BaseClass;

public class RecruitmentPage extends BaseClass {

	public RecruitmentPage(RemoteWebDriver driver) {

		 BaseClass.driver=driver;
	}

	// Recruitment Page Loactors
	By recruitmentMenu = By.xpath("//span[text()='Recruitment']");
	By jobTitle = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
	By vacancy = By.xpath("(//div[@class='oxd-select-text-input'])[2]");
	By hiringManager = By.xpath("(//div[@class='oxd-select-text-input'])[3]");
	By status = By.xpath("(//div[@class='oxd-select-text-input'])[4]");
	By candidateName = By.xpath("//input[@placeholder='Type for hints...']");
	By keywords =By.xpath("//input[@placeholder='Enter comma seperated words...']");
	By dateOfApplicationFrom=By.xpath("//input[@placeholder='From']");
	By dateOfApplicationTo=By.xpath("//input[@placeholder='To']");
	By methodOfApplication =By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[3]/div/div/div/div[2]/div/div/div[1]");
	By resetButton =By.xpath("//button[@type='reset']");
	By submitButton =By.xpath("//button[@type='submit']");
	By addButton =By.xpath("//button[contains(.,'Add')]");
	
	// Add Candidate Page Locators 
	By firstName =By.name("firstName");
	By middleName=By.name("middleName");
    By lastname=By.name("lastName");		
	By addvacancy =By.className("oxd-select-text-input");
	By email =By.xpath("(//input[@placeholder='Type here'])[1]");
	By contactNumber=By.xpath("(//input[@placeholder='Type here'])[2]");
	By resume=By.xpath("//i[@class='oxd-icon bi-upload oxd-file-input-icon']");
	By addCandidateKeywords=By.xpath("//input[@placeholder='Enter comma seperated words...']");
	By addCandidateDateOfApplication=By.xpath("//input[@placeholder='yyyy-dd-mm']");
	By notes=By.tagName("textarea");
	By keepData=By.xpath("//i[contains(@class,'oxd-icon bi-check')]");
	By cancelButton=By.xpath("//button[contains(.,'Cancel')]");
	By saveButton =By.xpath("//button[@type='submit']");
	
	
}
