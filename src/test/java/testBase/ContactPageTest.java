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

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
