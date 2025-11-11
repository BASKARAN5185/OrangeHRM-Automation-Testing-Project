package pageObjectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import baseClass.BaseClass;

public class Contact_Page extends BaseClass {

    //  Proper constructor
    public Contact_Page(RemoteWebDriver driver) {
        this.driver = driver;
    }

    // ---------------- Locators ----------------
    private By Street_1 = By.xpath("//div[@id='app']//form//div/div/div/div/div[2]/input");
    private By Street_2 = By.xpath("//div[@id='app']//form//div/div/div[2]/div/div[2]/input");
    private By city = By.xpath("//div[@id='app']//form//div/div/div[3]/div/div[2]/input");
    private By state = By.xpath("//div[@id='app']//form//div/div/div[4]/div/div[2]/input");
    private By Zipcode = By.xpath("//div[@id='app']//form//div/div/div[5]/div/div[2]/input");
    private By Country = By.xpath("//*[text()='-- Select --']");
    private By Home = By.xpath("//div[@id='app']//form/div[2]/div/div/div/div[2]/input");
    private By Mobile = By.xpath("//div[@id='app']//form/div[2]/div/div[2]/div/div[2]/input");
    private By work = By.xpath("//div[@id='app']//form/div[2]/div/div[3]/div/div[2]/input");
    private By work_Email = By.xpath("//div[@id='app']//form/div[3]/div/div/div/div[2]/input");
    private By Othermail = By.xpath("//div[@id='app']//form/div[3]/div/div[2]/div/div[2]/input");
    private By saveButton = By.cssSelector("button.oxd-button.oxd-button--secondary.orangehrm-left-space");

    // ---------------- Action Methods ----------------
    public void Street1(String street1) {
        driver.findElement(Street_1).clear();
        driver.findElement(Street_1).sendKeys(street1);
    }

    public void Street2(String street2) {
        driver.findElement(Street_2).clear();
        driver.findElement(Street_2).sendKeys(street2);
    }

    public void City(String cityName) {
        driver.findElement(city).clear();
        driver.findElement(city).sendKeys(cityName);
    }

    public void State(String stateName) {
        driver.findElement(state).clear();
        driver.findElement(state).sendKeys(stateName);
    }

    public void ZipCode(String zip) {
        driver.findElement(Zipcode).clear();
        driver.findElement(Zipcode).sendKeys(zip);
    }

    public void CountryDropdown(String countryName) {
        driver.findElement(Country).sendKeys(countryName);
    }

    public void HomePhone(String homePhone) {
        driver.findElement(Home).clear();
        driver.findElement(Home).sendKeys(homePhone);
    }

    public void MobilePhone(String mobileNum) {
        driver.findElement(Mobile).clear();
        driver.findElement(Mobile).sendKeys(mobileNum);
    }

    public void WorkPhone(String workNum) {
        driver.findElement(work).clear();
        driver.findElement(work).sendKeys(workNum);
    }

    public void WorkEmail(String workEmail) {
        driver.findElement(work_Email).clear();
        driver.findElement(work_Email).sendKeys(workEmail);
    }

    public void OtherEmail(String otherEmail) {
        driver.findElement(Othermail).clear();
        driver.findElement(Othermail).sendKeys(otherEmail);
    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

    // ---------------- Getter Methods ----------------
    public String getStreet1Value() {
        return driver.findElement(Street_1).getAttribute("value");
    }

    public String getStreet2Value() {
        return driver.findElement(Street_2).getAttribute("value");
    }

    public String getCityValue() {
        return driver.findElement(city).getAttribute("value");
    }

    public String getStateValue() {
        return driver.findElement(state).getAttribute("value");
    }

    public String getZipValue() {
        return driver.findElement(Zipcode).getAttribute("value");
    }

    public String getHomeValue() {
        return driver.findElement(Home).getAttribute("value");
    }

    public String getMobileValue() {
        return driver.findElement(Mobile).getAttribute("value");
    }

    public String getWorkValue() {
        return driver.findElement(work).getAttribute("value");
    }

    public String getWorkEmailValue() {
        return driver.findElement(work_Email).getAttribute("value");
    }

    public String getOtherEmailValue() {
        return driver.findElement(Othermail).getAttribute("value");
    }

    // ---------------- Utility Methods ----------------
    public void clearStreet1() {
        driver.findElement(Street_1).clear();
    }

    public void clearCity() {
        driver.findElement(city).clear();
    }

    public boolean isErrorDisplayed(String message) {
        return driver.getPageSource().contains(message);
    }
}
