package pageObjectClass.recuritment;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
	private  By clickableLabelLocator = By.xpath("//div[contains(@class, 'orangerhrm-switch-wrapper') and .//p[text()='Active']]//label");
    private  By switchInputSpanLocator = By.xpath("//div[contains(@class, 'orangerhrm-switch-wrapper') and .//p[text()='Active']]//span[contains(@class, 'oxd-switch-input')]");
	private By publishInRSSCheckbox = By
			.xpath("(//div[@class='oxd-switch-wrapper']//label)[2]");
    private By rssCheckBoxSwitchLocator=By.xpath("//div[contains(@class, 'orangerhrm-switch-wrapper') and .//p[text()='Publish in RSS Feed and Web Page']]//span[contains(@class, 'oxd-switch-input')]");        
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

    @SuppressWarnings("null")
    public boolean clickActiveCheckbox(String conditionString) {
    
    if (conditionString == null || conditionString.trim().isEmpty()) {
        System.err.println("Error: conditionString cannot be null or empty.");
        return false;
    } 

    try {
        // Find elements based on the robust XPath
        WebElement clickableLabel = driver.findElement(clickableLabelLocator);
        WebElement switchInputSpan = driver.findElement(switchInputSpanLocator);
        
        String checkCondition = conditionString.trim().toLowerCase();
        
        // CUSTOM STATE CHECK: Check for the '--active' class on the span
        boolean isCurrentlyActive = switchInputSpan.getAttribute("class").contains("--active");
        
        if (checkCondition.equals("check")) {
            if (!isCurrentlyActive) {
                clickableLabel.click();
                System.out.println("Switch was inactive; clicked to set to active.");
            } else {
                System.out.println("Switch is already checked (active).");
            }
            return true;
            
        } else if (checkCondition.equals("uncheck")) {
            if (isCurrentlyActive) {
                clickableLabel.click();
                System.out.println("Switch was active; clicked to set to inactive.");
            } else {
                System.out.println("Switch is already unchecked (inactive).");
            }
            return true;
            
        } else {
            System.err.println("Invalid condition string: " + conditionString + ". Must be 'check' or 'uncheck'.");
            return false;
        }

    } catch (org.openqa.selenium.NoSuchElementException e) {
        System.err.println("Error: The 'Active' switch element was not found. " + e.getMessage());
        return false;
    } catch (Exception e) {
        System.err.println("An unexpected error occurred: " + e.getMessage());
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

    @SuppressWarnings("null")
    public boolean clickPublishInRSSCheckbox(String conditionString) {
    
    // 1. IMPROVEMENT: Check for null BEFORE calling methods on the string.
    if (conditionString == null || conditionString.trim().isEmpty()) {
        System.out.println("Error: conditionString cannot be null or empty.");
        return false;
    } 

    try {
        // 2. Element Retrieval (Best practice is to handle WebDriver exceptions)
        WebElement publishInRSSChkBox = driver.findElement(publishInRSSCheckbox);
        WebElement swapElement=driver.findElement(rssCheckBoxSwitchLocator);
        String checkCondition = conditionString.trim().toLowerCase();
        boolean isCurrentlyActive=swapElement.getAttribute("class").contains("--active");;
         
        // 3. Conditional Logic
        if (checkCondition.equals("check")) {
            if (!isCurrentlyActive) {
                publishInRSSChkBox.click();
                System.out.println("Checkbox was unchecked and has been clicked to check it.");
            } else {
                System.out.println("Checkbox is already checked.");
            }
            return true;
            
        } else if (checkCondition.equals("uncheck")) {
            if (isCurrentlyActive) {
                publishInRSSChkBox.click();
                System.out.println("Checkbox was checked and has been clicked to uncheck it.");
            } else {
                System.out.println("Checkbox is already unchecked.");
            }
            return true;
            
        } else {
            // 4. Invalid Input
            System.out.println("Invalid condition string: " + conditionString + ". Must be 'check' or 'uncheck'.");
            return false;
        }

    // Handle case where the element could not be found
    } catch (org.openqa.selenium.NoSuchElementException e) {
        System.err.println("Error: Element not found using locator: " + publishInRSSCheckbox + ". " + e.getMessage());
        return false;
    } catch (Exception e) {
        System.err.println("An unexpected error occurred: " + e.getMessage());
        return false;
    }
}

    public void clickCancelButton(){
        WebElement cancelBtn=driver.findElement(cancelButton);
        cancelBtn.click();
    }
    
}
