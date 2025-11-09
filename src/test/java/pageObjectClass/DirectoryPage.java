package pageObjectClass;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import baseClass.BaseClass;

public class DirectoryPage extends BaseClass {
    
    public DirectoryPage(RemoteWebDriver driver) {
        
        BaseClass.driver=driver;
        
    }

    // Locator for the Directory page elements
    By nameSearchField = By.id("searchDirectory_emp_name_empName");
    By jobTitleDropdown = By.id("searchDirectory_job_title");
    By locationDropdown = By.id("searchDirectory_location");
    By searchButton = By.id("searchBtn");
    By resetButton = By.id("resetBtn");
    
    // Methods to interact with the Directory page elements
    
    public void enterName(String name) {
        driver.findElement(nameSearchField).sendKeys(name);
    }
    
    public void selectJobTitle(String jobTitle) {
        driver.findElement(jobTitleDropdown).sendKeys(jobTitle);
    }

    public void selectLocation(String location) {
        driver.findElement(locationDropdown).sendKeys(location);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public void clickResetButton() {
        driver.findElement(resetButton).click();
    }
}