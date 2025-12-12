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
	private By vacancyName = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	private By addVacancyJobTitle = By.className("oxd-select-text-input");
	private By description = By.tagName("textarea");
	private By addVacancyHioringManage = By
			.xpath("(//label[normalize-space(text())='Hiring Manager']/following::input)[1]");
	private By numberOfPosition = By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]");
	private By activeCheckbox = By.xpath("(//span[contains(@class,'oxd-switch-input oxd-switch-input--active')])[1]");
	private By publishInRSSCheckbox = By
			.xpath("(//*[@class='oxd-switch-input oxd-switch-input--active --label-right'])[2]");
    private By cancelButton = By.xpath("//button[contains(.,'Cancel')]");
    private By saveButton = By.xpath("//button[text()=' Save ']");  
    
    // Methods to interact with Add Vacancy Page elements
    public void enterVacancyName(String name) {
        WebElement vacancyNameInput = driver.findElement(vacancyName);
        vacancyNameInput.clear();
        vacancyNameInput.sendKeys(name);
    }

    @SuppressWarnings("null")
    public void clickSaveButton() {
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveBtn.click();
    }

    @SuppressWarnings("unused")
    public void enterHiringManager(String name){
        WebElement hiringManagerInput=driver.findElement(addVacancyHioringManage);
        if(name != null && !name.trim().isEmpty()){
           hiringManagerInput.clear();
           hiringManagerInput.sendKeys(name);
        }else{
        String mangerName=driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).getText();
        hiringManagerInput.clear();
        hiringManagerInput.sendKeys(mangerName);
        }
    }

    public void enterNumberOfPositions(String number){
        WebElement numberOfPositionsInput=driver.findElement(numberOfPosition);
        numberOfPositionsInput.clear();
        numberOfPositionsInput.sendKeys(number);
    }

    public boolean clickActiveCheckbox(String conditionString){
        if (conditionString.isEmpty()|| conditionString==null) {
          return false;  
        } 
        
        String checkCondtion= conditionString.toLowerCase().trim();
        WebElement activeChkBox=driver.findElement(activeCheckbox);
        if(checkCondtion.equalsIgnoreCase("check")){
             if (!activeChkBox.isSelected()) {
                activeChkBox.click();
            }
             return true;
        }else if (checkCondtion.equalsIgnoreCase("uncheck")) {
            if (activeChkBox.isSelected()) {
                activeChkBox.click();
            }
            return true;
        } else {
            return false;
        }
    }

    public void enterDesscription(String desc){
        WebElement descriptionsInput=driver.findElement(description);
        descriptionsInput.clear();
        descriptionsInput.sendKeys(desc);
    }

    @SuppressWarnings("null")
    public void selectVacancyTitleReliable(String vacancyTitle) {
    WebElement dropdownInput = driver.findElement(addVacancyJobTitle);
    dropdownInput.click();
    // Use WebDriverWait for better synchronization
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    // 2. Construct a reliable locator (XPath) for the option based on its text
    // This XPath assumes the options are in a standard format like:
    // <div class="oxd-select-option"><span>vacancyTitle</span></div>
    String optionXpath = String.format("//div[@role='listbox']//span[text()='%s']", vacancyTitle);
    // 3. Wait for the specific option to be clickable
    By optionLocator = By.xpath(optionXpath);
    WebElement desiredOption = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
    desiredOption.click();
   }

public boolean clickPublishInRSSCheckbox(String conditionString) {

    // 1. Safety Check: Handle null or empty input immediately and safely
    if (conditionString == null || conditionString.trim().isEmpty()) {
        System.out.println("Condition string is null or empty. Action aborted.");
        return false;
    }

    // 2. Normalize Input
    String checkCondition = conditionString.trim().toLowerCase();
    
    // 3. Locate the element
    WebElement publishInRSSChkBox = driver.findElement(publishInRSSCheckbox);
    
    // 4. Implement Logic based on the normalized condition
    if (checkCondition.equals("check")) {
        
        if (!publishInRSSChkBox.isSelected()) {
            System.out.println("Checking the 'Publish In RSS' checkbox.");
            publishInRSSChkBox.click();
        } else {
            System.out.println("'Publish In RSS' checkbox is already checked.");
        }
        return true;
        
    } else if (checkCondition.equals("uncheck")) {
        
        if (publishInRSSChkBox.isSelected()) {
            System.out.println("Unchecking the 'Publish In RSS' checkbox.");
            publishInRSSChkBox.click();
        } else {
            System.out.println("'Publish In RSS' checkbox is already unchecked.");
        }
        return true;
        
    } else {
        // 5. Handle Invalid Input
        System.err.println("Invalid condition provided: '" + conditionString + "'. Must be 'check' or 'uncheck'.");
        return false;
    }}

    public void clickCancelButton(){
        WebElement cancelBtn=driver.findElement(cancelButton);
        cancelBtn.click();
    }
    
}
