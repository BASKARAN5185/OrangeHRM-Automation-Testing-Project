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

    // Locators
    By fromTitle = By.xpath("//h6[contains(text(),'Add Candidate')]");
    By firstName = By.xpath("//input[@name='firstName' and @placeholder='First Name']");
    By middleName = By.xpath("//input[@name='middleName' or @placeholder='Middle Name']");
    By lastName = By.xpath("//*[contains(@name,'lastName')]");
    By vacancy = By.xpath("//div[starts-with(@class , 'oxd-select-text ')]");
    By email = By.xpath("(//input[@placeholder='Type here'])[1]");
    By contact = By.xpath("(//input[@placeholder='Type here'])[2]");
    By resumeUpload = By.xpath("//div[text()='Browser']/parent::div");
    By keywords = By.xpath("//div[@data-v-957b4417='']/child::input");
    By dateOfApplication = By.xpath("//div[@class='oxd-date-input']//descendant::input");
    By notes = By.tagName("textarea");
    By keepDataCheckBox = By.xpath("//span[contains(@class,'oxd-checkbox-input oxd-checkbox-input--active')]//i[1]");
    By cancelButton = By.xpath("(//div[@class='oxd-form-actions']//button)[2]");

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

    public void clickCancelButton(){
        WebElement cancelButtoWebElement=wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
        cancelButtoWebElement.click();
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