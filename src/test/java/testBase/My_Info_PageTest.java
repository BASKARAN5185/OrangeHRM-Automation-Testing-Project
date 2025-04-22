package testBase;

import org.testng.Assert;
import org.testng.annotations.Test;
import baseClass.BaseClass;
import pageObjectClass.AdminPage;
import pageObjectClass.DashboardPage;
import pageObjectClass.My_info_page;
import pageObjectClass.OrangeHRMLoginPage;

public class My_Info_PageTest extends BaseClass {
    
    AdminPage admin = new AdminPage(driver);
    My_info_page myInfoPage = new My_info_page(driver);
    DashboardPage DS = new DashboardPage(driver);
    OrangeHRMLoginPage login = new OrangeHRMLoginPage(driver);

    @Test(priority = 0, groups = { "Smoke", "Regression", "MyInfoTest" })
    void loginTest001() {
        login.login("Admin", "admin123");
        String pageurl = login.LoginValidation();
        Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index", pageurl);
        myInfoPage.Clickthemyinfomenu();
    }

    @Test(priority = 1, groups = { "Smoke", "Regression", "MyInfoTest" })
    public void testEnterFirstName() {
        myInfoPage.enterFirstName("John");
        String enteredFirstName = myInfoPage.getFirstNameValue();
        Assert.assertEquals(enteredFirstName, "John", "First name does not match");
    }

    @Test(priority = 2, groups = { "Smoke", "Regression", "MyInfoTest" })
    public void testEnterMiddleName() {
        myInfoPage.enterMiddleName("Paul");
        String enteredMiddleName = myInfoPage.getMiddleNameValue();
        Assert.assertEquals(enteredMiddleName, "Paul", "Middle name does not match");
    }

    @Test(priority = 3, groups = { "Smoke", "Regression", "MyInfoTest" })
    public void testEnterLastName() {
        myInfoPage.enterLastName("Doe");
        String enteredLastName = myInfoPage.getLastNameValue();
        Assert.assertEquals(enteredLastName, "Doe", "Last name does not match");
    }

    @Test(priority = 4, groups = { "Smoke", "Regression", "MyInfoTest" })
    public void testSelectDateOfBirth() {
        myInfoPage.selectDateOfBirth();
        String selectedDate = myInfoPage.getDateOfBirthValue();
        Assert.assertTrue(selectedDate.contains("08"), "Date of birth is not selected correctly");
    }

    @Test(priority = 5, groups = { "Smoke", "Regression", "MyInfoTest" })
    public void testSelectDropdownOption() {
        myInfoPage.selectDropdownOption();
        String selectedOption = myInfoPage.getDropdownSelectedValue();
        Assert.assertNotNull(selectedOption, "Dropdown option was not selected correctly");
    }

    @Test(priority = 6, groups = { "Smoke", "Regression", "MyInfoTest" })
    public void testClickButton() {
        myInfoPage.clickButton();
        String currentUrl = myInfoPage.getCurrentPageUrl();
        Assert.assertTrue(currentUrl.contains("expected-url-part"), "Button click did not navigate to the expected page");
    }

    @Test(priority = 7, groups = { "Smoke", "Regression", "MyInfoTest" })
    public void testSetBloodGroup() {
        myInfoPage.setBloodGroup();
        String selectedBloodGroup = myInfoPage.getBloodGroupValue();
        Assert.assertEquals(selectedBloodGroup, "A+", "Blood group was not selected correctly");
    }

    @Test(priority = 8, groups = { "Smoke", "Regression", "MyInfoTest" })
    public void testSubmitForm() {
        myInfoPage.submitForm();
        String currentUrl = myInfoPage.getCurrentPageUrl();
        Assert.assertTrue(currentUrl.contains("confirmation-page"), "Form was not submitted successfully");
    }
}
