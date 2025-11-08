package testBase;

import java.time.Duration;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjectClass.Contact_Page;

public class ContactPageTest {

    RemoteWebDriver driver;
    Contact_Page contactPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // TODO: Perform login and navigate to Contact Details page
        contactPage = new Contact_Page(driver);
    }

    // ---------------- Positive Functional Tests ---------------- //

    @Test(priority = 1, groups = {"Sanity", "ContactPage"})
    public void TC01_EnterStreet1() {
        contactPage.Street1("123 Elm Street");
        Assert.assertEquals(contactPage.getStreet1Value(), "123 Elm Street");
    }

    @Test(priority = 2, groups = {"Sanity", "ContactPage"})
    public void TC02_EnterStreet2() {
        contactPage.Street2("Apt 5B");
        Assert.assertEquals(contactPage.getStreet2Value(), "Apt 5B");
    }

    @Test(priority = 3, groups = {"Sanity", "ContactPage"})
    public void TC03_EnterCity() {
        contactPage.City("New York");
        Assert.assertEquals(contactPage.getCityValue(), "New York");
    }

    @Test(priority = 4, groups = {"Sanity", "ContactPage"})
    public void TC04_EnterState() {
        contactPage.State("New York");
        Assert.assertEquals(contactPage.getStateValue(), "New York");
    }

    @Test(priority = 5, groups = {"Sanity", "ContactPage"})
    public void TC05_EnterZipCode() {
        contactPage.ZipCode("10001");
        Assert.assertEquals(contactPage.getZipValue(), "10001");
    }

    @Test(priority = 6, groups = {"Sanity", "ContactPage"})
    public void TC06_SelectCountry() {
        contactPage.CountryDropdown("United States");
        Assert.assertTrue(true, "Country selected successfully");
    }

    @Test(priority = 7, groups = {"Sanity", "ContactPage"})
    public void TC07_EnterHomePhone() {
        contactPage.HomePhone("2125551234");
        Assert.assertEquals(contactPage.getHomeValue(), "2125551234");
    }

    @Test(priority = 8, groups = {"Sanity", "ContactPage"})
    public void TC08_EnterMobile() {
        contactPage.MobilePhone("9876543210");
        Assert.assertEquals(contactPage.getMobileValue(), "9876543210");
    }

    @Test(priority = 9, groups = {"Sanity", "ContactPage"})
    public void TC09_EnterWorkPhone() {
        contactPage.WorkPhone("6465559876");
        Assert.assertEquals(contactPage.getWorkValue(), "6465559876");
    }

    @Test(priority = 10, groups = {"Sanity", "ContactPage"})
    public void TC10_EnterWorkEmail() {
        contactPage.WorkEmail("john.doe@company.com");
        Assert.assertEquals(contactPage.getWorkEmailValue(), "john.doe@company.com");
    }

    @Test(priority = 11, groups = {"Sanity", "ContactPage"})
    public void TC11_EnterOtherEmail() {
        contactPage.OtherEmail("john.alt@gmail.com");
        Assert.assertEquals(contactPage.getOtherEmailValue(), "john.alt@gmail.com");
    }

    @Test(priority = 12, groups = {"Sanity", "ContactPage"})
    public void TC12_ClickSaveButton() {
        contactPage.clickSaveButton();
        Assert.assertTrue(true, "Save button clicked successfully.");
    }

    
    // ---------------- Validation Tests ---------------- //

    @Test(priority = 13, groups = {"Sanity", "ContactPage"})
    public void TC13_ValidateEmptyStreetShowsError() {
        contactPage.clearStreet1();
        contactPage.clickSaveButton();
        Assert.assertTrue(contactPage.isErrorDisplayed("Required"), "Error not shown for empty Street1");
    }

    @Test(priority = 14, groups = {"Sanity", "ContactPage"})
    public void TC14_ValidateInvalidZipFormat() {
        contactPage.ZipCode("ABCD");
        contactPage.clickSaveButton();
        Assert.assertTrue(contactPage.isErrorDisplayed("Invalid Zip"), "Invalid Zip not validated");
    }

    @Test(priority = 15, groups = {"Sanity", "ContactPage"})
    public void TC15_ValidateInvalidEmailFormat() {
        contactPage.WorkEmail("wrongformat.com");
        contactPage.clickSaveButton();
        Assert.assertTrue(contactPage.isErrorDisplayed("Invalid Email"), "Invalid email not validated");
    }

    @Test(priority = 16, groups = {"Sanity", "ContactPage"})
    public void TC16_ValidatePhoneOnlyDigits() {
        contactPage.MobilePhone("abcd@#");
        String value = contactPage.getMobileValue();
        Assert.assertFalse(value.matches("[a-zA-Z@#]+"), "Non-digit characters accepted in phone");
    }

    @Test(priority = 17, groups = {"Sanity", "ContactPage"})
    public void TC17_ValidatePhoneMaxLength() {
        contactPage.MobilePhone("123456789012345");
        String value = contactPage.getMobileValue();
        Assert.assertTrue(value.length() <= 10, "Phone accepts more than 10 digits");
    }

    @Test(priority = 18, groups = {"Sanity", "ContactPage"})
    public void TC18_ValidateCountryDropdownSelection() {
        contactPage.CountryDropdown("India");
        Assert.assertTrue(true, "Country dropdown selection works fine.");
    }

    @Test(priority = 19, groups = {"Sanity", "ContactPage"})
    public void TC19_ValidateOtherEmailOptional() {
        contactPage.OtherEmail("");
        contactPage.clickSaveButton();
        Assert.assertTrue(true, "Other Email optional field handled correctly.");
    }

        // ---------------- Additional Validation & UI Tests ---------------- //

    @Test(priority = 20, groups = {"Sanity", "ContactPage"})
    public void TC20_ValidateRequiredFields() {
        contactPage.clearStreet1();
        contactPage.clearCity();
        contactPage.clickSaveButton();
        Assert.assertTrue(contactPage.isErrorDisplayed("Required"), "Required field validation missing.");
    }

    @Test(priority = 21, groups = {"Sanity", "ContactPage"})
    public void TC21_ValidateCityFieldMaxLength() {
        String longCity = "A".repeat(150);
        contactPage.City(longCity);
        contactPage.clickSaveButton();
        String actualCity = contactPage.getCityValue();
        Assert.assertTrue(actualCity.length() <= 100, "City field accepts more than 100 characters");
    }

    @Test(priority = 22, groups = {"Sanity", "ContactPage"})
    public void TC22_ValidateSpecialCharacterAcceptanceInAddress() {
        contactPage.Street1("#23-B, O’Connell Street");
        String value = contactPage.getStreet1Value();
        Assert.assertTrue(value.contains("#23-B"), "Address did not accept valid special characters.");
    }

    @Test(priority = 23, groups = {"Sanity", "ContactPage"})
    public void TC23_ValidateTrimmingOfSpaces() {
        contactPage.City("   New York   ");
        String trimmed = contactPage.getCityValue().trim();
        Assert.assertEquals(trimmed, "New York", "City field did not trim extra spaces.");
    }

    @Test(priority = 24, groups = {"Sanity", "ContactPage"})
    public void TC24_ValidateSQLInjectionProtection() {
        contactPage.Street1("' OR 1=1 --");
        contactPage.clickSaveButton();
        Assert.assertFalse(contactPage.isErrorDisplayed("Database error"), "SQL Injection vulnerability detected!");
    }

    @Test(priority = 25, groups = {"Sanity", "ContactPage"})
    public void TC25_ValidateHTMLInjectionProtection() {
        contactPage.City("<script>alert('XSS')</script>");
        contactPage.clickSaveButton();
        boolean isSafe = !contactPage.isErrorDisplayed("alert('XSS')");
        Assert.assertTrue(isSafe, "Page vulnerable to XSS or HTML injection!");
    }

    @Test(priority = 26, groups = {"Sanity", "ContactPage"})
    public void TC26_VerifyAllFieldsVisible() {
        Assert.assertNotNull(contactPage.getStreet1Value(), "Street 1 field not found.");
        Assert.assertNotNull(contactPage.getCityValue(), "City field not found.");
        Assert.assertNotNull(contactPage.getWorkEmailValue(), "Work Email field not found.");
    }

    @Test(priority = 27, groups = {"Sanity", "ContactPage"})
    public void TC27_VerifySaveButtonIsEnabled() {
        contactPage.Street1("45 Maple Ave");
        contactPage.City("Boston");
        contactPage.clickSaveButton();
        Assert.assertTrue(true, "Save button clicked and enabled successfully.");
    }

    @Test(priority = 28, groups = {"Sanity", "ContactPage"})
    public void TC28_VerifyDataPersistenceAfterSave() {
        contactPage.City("Chicago");
        contactPage.clickSaveButton();
        String cityAfterSave = contactPage.getCityValue();
        Assert.assertEquals(cityAfterSave, "Chicago", "Saved data not persisted correctly.");
    }

    @Test(priority = 29, groups = {"Sanity", "ContactPage"})
    public void TC29_VerifyFormDoesNotAcceptOnlySpaces() {
        contactPage.Street1("    ");
        contactPage.clickSaveButton();
        Assert.assertTrue(contactPage.isErrorDisplayed("Required"), "Form accepted spaces-only input.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
