package pageObjectClass;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DirectoryPage  {
    private RemoteWebDriver driver;
    public DirectoryPage(RemoteWebDriver driver) {
        
        this.driver=driver;
        
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
  
    public String getNameSearchFieldValue() {
        return driver.findElement(nameSearchField).getAttribute("value");
    }

    public String getSelectedJobTitle() {
        return driver.findElement(jobTitleDropdown).getAttribute("value");
    }

    public String getSelectedLocation() {
        return driver.findElement(locationDropdown).getAttribute("value");
    }

    public boolean isSearchButtonDisplayed() {
        return driver.findElement(searchButton).isDisplayed();
    }

    public boolean isResetButtonDisplayed() {
        return driver.findElement(resetButton).isDisplayed();
    }

    public void clearNameSearchField() {
        driver.findElement(nameSearchField).clear();
    }

    public void selectJobTitleByVisibleText(String jobTitle) {
        driver.findElement(jobTitleDropdown).sendKeys(jobTitle);
    }

    public void selectLocationByVisibleText(String location) {
        driver.findElement(locationDropdown).sendKeys(location);
    }

}