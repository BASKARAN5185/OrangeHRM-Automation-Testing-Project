package pageObjectClass;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
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

// In your Page Object Class (AddCandidatePage) or Constants file
private static final By resumeUpload = By.xpath("//input[@type='file' and @class='oxd-file-input']");

// Other Fields
By keywords = By.xpath("//label[text()='Keywords']/../following-sibling::div//input");
By dateOfApplication = By.cssSelector("input[placeholder='yyyy-dd-mm']");
By notes = By.tagName("textarea");

// Checkbox and Buttons
By keepDataCheckBox = By.xpath("//input[@type='checkbox']");
By cancelButton = By.xpath("//button[text()=' Cancel ']/");
By saveButton = By.xpath("//button[text()=' Save ']"); // Added Save button
By applicationStage= By.xpath("//*[text()='Application Stage']");

    
    // Actions
    public void enterFirstName(String fname) {
        WebElement element = driver.findElement(firstName);
        wait.until(ExpectedConditions.elementToBeClickable(element)); 
        element.click();     
        element.clear();
        element.sendKeys(fname);
    }

    public void enterMiddlename(String mname) {
        WebElement midName = driver.findElement(middleName);
        wait.until(ExpectedConditions.elementToBeClickable(middleName));
        midName.click();
        midName.clear();
        midName.sendKeys(mname);
    }

    public void enterLastName(String lName) {
        WebElement lastNameField = driver.findElement(lastName);
        wait.until(ExpectedConditions.elementToBeClickable(lastNameField));
        lastNameField.click();
        lastNameField.clear();
        lastNameField.sendKeys(lName);
    }

   /*  public String enterTitle(String title) {
        WebElement jobTitle = driver.findElement(fromTitle);
       // wait.until(ExpectedConditions.elementToBeClickable(jobTitle));
        jobTitle.clear();
        jobTitle.sendKeys(title);
        return jobTitle.getText();
    }  */

    public String selectVacancyType(){
        WebElement vacancyname= driver.findElement(vacancy);
        wait.until(ExpectedConditions.elementToBeClickable(vacancyname));
        Actions dropdown =new Actions(driver); 
        dropdown.click();
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

   // NOTE: 'resumeUpload' MUST be a correctly defined By object (e.g., By.cssSelector("input[type='file'].oxd-file-input"))

public boolean uploadResumeFile(String resumePath) {
    try {
        // 1. Wait for the element to be present in the DOM (presence doesn't check visibility)
        wait.until(ExpectedConditions.presenceOfElementLocated(resumeUpload));
        
        WebElement uploadElement = driver.findElement(resumeUpload);

        // 2. Use JavaScript Executor to force the HIDDEN element to be interactable
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.display='block'; arguments[0].style.visibility='visible';", uploadElement);

        // 3. Send the absolute file path directly to the input element
        uploadElement.sendKeys(resumePath);
        
        System.out.println("Resume file path sent successfully to: " + uploadElement.getAttribute("value"));
        return true;

    } catch (TimeoutException e) {
        System.err.println("Timeout: Resume upload element was not present in the DOM within the time limit.");
        return false;
    } catch (Exception e) {
        System.err.println("An unexpected error occurred during file upload interaction: " + e.getMessage());
        return false;
    }
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
          driver.findElement(keepDataCheckBox).click();
          return true;  
    }

    @SuppressWarnings("null")
    public void clickCancelButton(){
        WebElement cancelButtoWebElement=wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
        cancelButtoWebElement.click();
    }

    @SuppressWarnings("null")
    public void clickSaveButton(){
        WebElement saveButtonWebElement=wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButtonWebElement.click();
    }

    @SuppressWarnings("null")
    public boolean applicationStageVisibleValidattion(){
        WebElement appStage= wait.until(ExpectedConditions.visibilityOfElementLocated(this.applicationStage)); 
        return appStage.isDisplayed();
    }

    public String verifyPageTitle(){
         return driver.getTitle();
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public String stringValidation(String alretmess){
          WebElement alrweWebElement=  driver.findElement(By.xpath("//*[text()='"+alretmess+"']"));
          return alrweWebElement.getText();
    }

    public void fillFromAddCandidatePage(String firstnameString,String middleString,
        String lastnameString,String mailString,String contacString,
        String filePathString,String noteString,String keywordString , String erroString)
        {
        enterFirstName(firstnameString);
        enterMiddlename(middleString);
        enterLastName(lastnameString);
        enterEmail(mailString);
        enterContact(contacString);
        // uploadResumeFile(filePathString);
        enterNotes(noteString);
        enterKeywords(keywordString);
        clickSaveButton();
    }

}