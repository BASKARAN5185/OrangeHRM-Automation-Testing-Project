package pageObjectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClass.BaseClass;

public class Contact_Page extends BaseClass {

	public void Contact_page(RemoteWebDriver driver) {
		
	    BaseClass.driver=driver;
	};
	
	
	    // Contact Details locators
	    By Street_1 = By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div/div[2]/div/form/div/div/div/div/div[2]/input");
	    By Street_2 = By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div/div[2]/div/form/div/div/div[2]/div/div[2]/input");
	    By city = By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div/div[2]/div/form/div/div/div[3]/div/div[2]/input");
	    By state = By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div/div[2]/div/form/div/div/div[4]/div/div[2]/input");
	    By Zipcode = By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div/div[2]/div/form/div/div/div[5]/div/div[2]/input");
	    By Country = By.xpath("//*[text() = \"-- Select --\"]");
	    By Home = By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div/div[2]/div/form/div[2]/div/div/div/div[2]/input");
	    By Mobile  = By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div/div[2]/div/form/div[2]/div/div[2]/div/div[2]/input");
	    By work = By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div/div[2]/div/form/div[2]/div/div[3]/div/div[2]/input");
	    By work_Email = By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div/div[2]/div/form/div[3]/div/div/div/div[2]/input");
	    By Othermail = By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div/div[2]/div/form/div[3]/div/div[2]/div/div[2]/input");
	    By saveButton = By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space");

	   

	   
	    public void Stree1tname (String street1) {
	        driver.findElement(Street_1).sendKeys(street1);
	    }

	    public void Stree2name (String Stree2  ) {
	        driver.findElement(Street_2).sendKeys(Stree2);
	    }

	    public void cityname(String cityname) {
	        driver.findElement(city).sendKeys(cityname);
	    }

	    public void Statename(String State) {
	        driver.findElement(state).sendKeys(State);
	    }

	    public void zipcode(String Zipcode1) {
	        driver.findElement(Zipcode).click();
	    }

	    public void CountryDropdown(String Countryname) {
	        driver.findElement(Country).sendKeys(Countryname);
	    }

	    public void Homename(String home) {
	        driver.findElement(Home).sendKeys(home);
	    }

	    public void Mobile(String mobilenum1) {
	        driver.findElement(Mobile).sendKeys(mobilenum1);
	    }

	    public void work(String work1) {
	        driver.findElement(work).sendKeys(work1);
	    }

	    public void workmail(String workmail1) {
	        driver.findElement(work_Email).sendKeys(workmail1);
	    }

	    public void othermail(String othermail1) {
	        driver.findElement(Othermail).sendKeys(othermail1);
	    }

	    public void clickSaveButton() {
	        driver.findElement(saveButton).click();
	    }
	}

	
	

