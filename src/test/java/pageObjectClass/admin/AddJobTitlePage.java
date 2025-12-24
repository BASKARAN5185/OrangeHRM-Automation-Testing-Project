package pageObjectClass.admin;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddJobTitlePage {
     
    private RemoteWebDriver driver;
    private WebDriverWait  wait; 
    
    // constructor 
    public AddJobTitlePage(RemoteWebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    // Add Title Page Locators
    private final By pageOfTitle=By.xpath("//h6[text()='Add Job Title']");
    private final By jobTiltle=By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private final By description=By.xpath("//textarea[@placeholder='Type description here']");
    private final By fileUpload=By.className("oxd-file-input-div");
    private final By textNote=By.xpath("//textarea[@placeholder='Add note']");
    private final By cancelButton=By.xpath("//button[text()=' Cancel ']");
    private final By saveButton=By.xpath("//button[text()=' Save ']");

    // Actions Methods
    // Page title validation method
    public boolean validateThePageTitle(){
       try {
        driver.findElement(pageOfTitle).isDisplayed();
        return true;
       } catch (Exception e) {
        System.out.println("the error message was : "+e);
        return false;
       }          
    } 

    // input jobtitle string enter method
    public String enterJobTitle(String titleString){
        WebElement titleElement=driver.findElement(jobTiltle);
        wait.until(ExpectedConditions.elementToBeClickable(titleElement));
        titleElement.sendKeys(titleString);   
        return titleElement.getText();
    }

     // input descripttion string enter method
    public String enterDescription(String descriptionString){
        WebElement discriptionElement=driver.findElement(description);
        wait.until(ExpectedConditions.elementToBeClickable(discriptionElement));
        discriptionElement.sendKeys(descriptionString);   
        return discriptionElement.getText();
    }

    // input note string enter method
    public String enterNote(String noteString){
        WebElement noteElement=driver.findElement(textNote);
        wait.until(ExpectedConditions.elementToBeClickable(noteElement));
        noteElement.sendKeys(noteString);   
        return noteElement.getText();
    }

    // save utton clcik action method
    public boolean saveButtonClick(){
        WebElement saveElement =driver.findElement(saveButton);
        try {
        if (saveElement.isEnabled()) {
            saveElement.click();
            return true;
        }else{
            System.out.println("the save button is not clickable");
            return false;
        }
        }catch(Exception e){
            System.out.println("the save Button click error message is :"+e);
            return false;      
        }
    }

    // cancel button click action method
    public boolean cancelButtonClick(){
        WebElement cancelElement =driver.findElement(cancelButton);
        try {
        if (cancelElement.isEnabled()) {
            cancelElement.click();
            return true;
        }else{
            System.out.println("the cancel button is not clickable");
            return false;
        }
        }catch(Exception e){
            System.out.println("the cancel Button click error message is :"+e);
            return false;      
        }
    }
 
    // Job description File Uploadmethod
    public boolean fileUploadJobSpecification(String filepathString,String uploadFileNameString){
        WebElement uploadWebElement=driver.findElement(fileUpload);
        try {
            if (uploadWebElement.isDisplayed()) {
                uploadWebElement.sendKeys(filepathString);
                String fileName= uploadWebElement.getText().trim().toLowerCase();
                if (fileName.equalsIgnoreCase(uploadFileNameString)) {
                    return true;
                }else{
                    System.out.println("upload file is missmathing");
                    return false;
                }
            }else{
                System.out.println("job specification is not displayed yet");
                return false;
            }
        } catch (Exception e) {
                System.out.println("job specification during upload error message was:"+e); 
                return false;   
        }   
    }
}
