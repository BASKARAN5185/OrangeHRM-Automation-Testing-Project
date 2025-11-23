package testBase;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectClass.DirectoryPage;

public class DirectoryPageTest extends BaseClass {

    DirectoryPage directoryPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        directoryPage = new DirectoryPage(driver);
    }

    @BeforeMethod
    public void beforeEachTest() {
        directoryPage.clearNameSearchField();
    }

    @Test(priority = 1, description = "Verify that all Directory Page elements are displayed correctly")
    public void verifyPageElementsDisplayed() {
        Assert.assertTrue(directoryPage.isSearchButtonDisplayed(), "Search button should be displayed");
        Assert.assertTrue(directoryPage.isResetButtonDisplayed(), "Reset button should be displayed");
    }

    @Test(priority = 2, description = "Verify user can enter name and retrieve it correctly")
    public void verifyEnterNameFunctionality() {
        directoryPage.enterName("John Smith");
        String enteredName = directoryPage.getNameSearchFieldValue();
        Assert.assertEquals(enteredName, "John Smith", "Entered name should match retrieved value");
    }

    @Test(priority = 3, description = "Verify user can select Job Title and Location from dropdowns")
    public void verifyDropdownSelection() {
        directoryPage.selectJobTitleByVisibleText("QA Engineer");
        directoryPage.selectLocationByVisibleText("New York");
        Assert.assertEquals(directoryPage.getSelectedJobTitle(), "QA Engineer", "Selected job title should match");
        Assert.assertEquals(directoryPage.getSelectedLocation(), "New York", "Selected location should match");
    }

    @Test(priority = 4, description = "Verify search functionality works correctly with valid data")
    public void verifySearchButtonClick() {
        directoryPage.enterName("Lisa Brown");
        directoryPage.selectJobTitle("Developer");
        directoryPage.selectLocation("California");
        directoryPage.clickSearchButton();
    }

    @Test(priority = 5, description = "Verify reset button clears all search filters")
    public void verifyResetButtonFunctionality() {
        directoryPage.enterName("Test User");
        directoryPage.selectJobTitle("Manager");
        directoryPage.selectLocation("Texas");
        directoryPage.clickResetButton();
        Assert.assertEquals(directoryPage.getNameSearchFieldValue(), "", "Name field should be cleared after reset");
        Assert.assertEquals(directoryPage.getSelectedJobTitle(), "", "Job Title should reset");
        Assert.assertEquals(directoryPage.getSelectedLocation(), "", "Location should reset");
    }

    
    @Test(priority = 6, description = "Verify user can clear the name search field manually")
    public void verifyClearNameSearchField() {
        directoryPage.enterName("Alex Johnson");
        directoryPage.clearNameSearchField();
        Assert.assertEquals(directoryPage.getNameSearchFieldValue(), "", "Name search field should be empty after clearing");
    }

    @Test(priority = 7, description = "Verify that user can search only by location")
    public void verifySearchByLocationOnly() {
        directoryPage.selectLocation("Florida");
        directoryPage.clickSearchButton();
    }

    @Test(priority = 8, description = "Verify that user can search only by job title")
    public void verifySearchByJobTitleOnly() {
        directoryPage.selectJobTitle("Software Engineer");
        directoryPage.clickSearchButton();
    }

    @Test(priority = 9, description = "Verify that search button is clickable and functional")
    public void verifySearchButtonClickable() {
        Assert.assertTrue(directoryPage.isSearchButtonDisplayed(), "Search button should be visible");
        directoryPage.clickSearchButton();
    }

    @Test(priority = 10, description = "Verify page does not throw any errors with blank search")
    public void verifyBlankSearchDoesNotThrowError() {
        directoryPage.clickSearchButton();
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}




