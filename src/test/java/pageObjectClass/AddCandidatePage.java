package pageObjectClass;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCandidatePage {

    private RemoteWebDriver driver;
    private WebDriverWait wait;
    public AddCandidatePage(RemoteWebDriver driver) {
        this.driver = driver;
        this.wait=new WebDriverWait(driver,Duration.ofSeconds(10)); 
    }

//Page Locators
// Page Title
By fromTitle = By.cssSelector("h6.orangehrm-main-title");

// Full Name Fields
By firstName = By.name("firstName");
By middleName = By.name("middleName");
By lastName = By.name("lastName");

// Dropdown
By vacancy = By.xpath("//label[text()='Vacancy']/../following-sibling::div//div[@tabindex='0']");

// Contact Information
By email = By.xpath("//label[text()='Email']/../following-sibling::div//input");
By contact = By.xpath("//label[text()='Contact Number']/../following-sibling::div//input");

// Resume Upload (For sending file path)
By resumeUpload = By.cssSelector("input[type='file']");

// Other Fields
By keywords = By.xpath("//label[text()='Keywords']/../following-sibling::div//input");
By dateOfApplication = By.cssSelector("input[placeholder='yyyy-dd-mm']");
By notes = By.tagName("textarea");

// Checkbox and Buttons
By keepDataCheckBox = By.xpath("//label[text()='Consent to keep data']/preceding-sibling::div//input");
By cancelButton = By.xpath("//button[text()=' Cancel ']");
By saveButton = By.xpath("//button[text()=' Save ']"); // Added Save button
By rejectButton = By.xpath("//button[text()=' Reject ']");
    
    // Actions
    public void enterFirstName(String fname) {
        WebElement element = driver.findElement(firstName);
        wait.until(ExpectedConditions.elementToBeClickable(element));      
        element.clear();
        element.sendKeys(fname);
    }

    public void enterMiddlename(String mname) {
        WebElement midName = driver.findElement(middleName);
        wait.until(ExpectedConditions.elementToBeClickable(middleName));
        midName.clear();
        midName.sendKeys(mname);
    }

    public void enterLastName(String lName) {
        WebElement lastNameField = driver.findElement(lastName);
        wait.until(ExpectedConditions.elementToBeClickable(lastNameField));
        lastNameField.clear();
        lastNameField.sendKeys(lName);
    }

    public String enterTitle(String title) {
        WebElement jobTitle = driver.findElement(fromTitle);
        wait.until(ExpectedConditions.elementToBeClickable(jobTitle));
        jobTitle.sendKeys(Keys.chord(Keys.SHIFT, "a"));
        jobTitle.sendKeys(title);
        return jobTitle.getText();
    }

    public String selectVacancyType(){
        WebElement vacancyname= driver.findElement(vacancy);
        wait.until(ExpectedConditions.elementToBeClickable(vacancyname));
        Actions dropdown =new Actions(driver); 
        dropdown.sendKeys(Keys.PAGE_DOWN).build();
        dropdown.sendKeys(Keys.PAGE_DOWN).build();
        dropdown.sendKeys(Keys.ENTER);
        return vacancyname.getText();
    }

    public String enterEmail(String emailadd){
         WebElement enterMail= driver.findElement(email);
         wait.until(ExpectedConditions.elementToBeClickable(enterMail));
         enterMail.sendKeys(emailadd);
        return enterMail.getText(); 
    }

    public  String enterContact(String contcatnum){
         WebElement contacWebElement = driver.findElement(contact);
         wait.until(ExpectedConditions.elementToBeClickable(contacWebElement));
         contacWebElement.sendKeys(contcatnum);
         return contacWebElement.getText();
    }

    public String uploadResumeFile(String resumepath){
        WebElement uplodElement =driver.findElement(resumeUpload);
        wait.until(ExpectedConditions.elementToBeClickable(uplodElement));
        uplodElement.sendKeys(resumepath);
        return uplodElement.getAttribute("value");
    }

    public String enterKeywords(String inputKeywords){
      WebElement keywordElement=driver.findElement(keywords);
      wait.until(ExpectedConditions.elementToBeClickable(keywordElement));
      keywordElement.sendKeys(inputKeywords);
      return keywordElement.getText();
    }

    public String enterNotes(String inputNotes){
       WebElement notesweWebElement = driver.findElement(notes);
       wait.until(ExpectedConditions.elementToBeClickable(notesweWebElement));
       notesweWebElement.sendKeys(inputNotes);
       return notesweWebElement.getText();
    }

    public boolean clickKeepDataCheckBox(){
          boolean dataWebElement=wait.until(ExpectedConditions.elementToBeSelected(keepDataCheckBox));
         return dataWebElement;
    }

    @SuppressWarnings("null")
    public void clickCancelButton(){
        WebElement cancelButtoWebElement=wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
        cancelButtoWebElement.click();
    }

    @SuppressWarnings("null")
    public boolean rejectButtonVisibleValidattion(){
        WebElement rejectButton= wait.until(ExpectedConditions.visibilityOfElementLocated(this.rejectButton)); 
        return rejectButton.isDisplayed();
    }

    public String verifyPageTitle(){
         return driver.getTitle();
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public void fillFromAddCandidatePage(String titleString,String firstnameString,
        String middleString,String lastnameString,String mailString,String contacString,
        String filePathString,String noteString,String keywordString )
        {
        enterTitle(titleString);
        enterFirstName(firstnameString);
        enterMiddlename(middleString);
        enterLastName(lastnameString);
        selectVacancyType();
        enterEmail(mailString);
        enterContact(contacString);
        uploadResumeFile(filePathString);
        enterNotes(noteString);
        enterKeywords(keywordString);
        clickKeepDataCheckBox();
        clickCancelButton();
    }

}