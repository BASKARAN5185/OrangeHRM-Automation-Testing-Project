package pageObjectClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClass.BaseClass;

public class OrangeHRMLoginPage extends BaseClass {

	// driver intialazation
	public OrangeHRMLoginPage(RemoteWebDriver driver) {

		BaseClass.driver = driver;
	}

	// locatirs in the page
	By loginpageTitle=By.tagName("h5");
	By username = By.name("username");
	By Pass = By.name("password");
	By loginbutton = By.xpath("//button[@type='submit']");
	By logo = By.xpath("//img[@alt='company-branding']");
	By sidelogo = By.xpath("(//img[@alt='orangehrm-logo'])[2]");
	By forgetpass = By.xpath("//p[contains(.,'Forgot your password?')]");
	
	//forget pass page locators
	By forgetuser=By.name("username");
	By Cancel =By.xpath("//*[text()=' Cancel ']");
	By Resetpass=By.xpath("//*[text()=' Reset Password ']");

    // Icon Link locators
	By linkedinicon=By.xpath("//a[@href='https://www.linkedin.com/company/orangehrm/mycompany/']");
	By faceBokk=By.xpath("//a[@href='https://www.facebook.com/OrangeHRM/']");
	By twittericon=By.xpath("//a[@href='https://twitter.com/orangehrm?lang=en']");
	By youtubeicon=By.xpath("//a[@href='https://www.youtube.com/c/OrangeHRMInc']");

    // footer locators
	By osversion=By.xpath("//p[text()='OrangeHRM OS 5.7']");
	By copyRight=By.xpath("//p[contains(.,'© 2005 - 2025 OrangeHRM, Inc. All rights reserved.')]");

    
	// Action method

	public void login(String loginname, String password) {

		driver.findElement(username).sendKeys(loginname);
		driver.findElement(Pass).sendKeys(password);
		driver.findElement(loginbutton).click();
	}

	public void forgetpass() {

		driver.findElement(forgetpass).click();

	}
	
	public void forgetpasscancel() {

		driver.findElement(Cancel).click();

	}
	
	public void forgetpassreset(String forgetusername) {
        driver.findElement(forgetuser).sendKeys(forgetusername);
		driver.findElement(Resetpass).click();

	}
	
    public void goback() {
    	driver.navigate().back();
    }

	public boolean logoVisiblible() {

		boolean logovisible = driver.findElement(logo).isDisplayed();
		return logovisible;

	}

	public boolean sidelogovisible() {

		boolean sidelogovisible = driver.findElement(sidelogo).isDisplayed();
		return sidelogovisible;
	}

	  
	  public String LoginValidation() { 
		  String LoginUrl=driver.getCurrentUrl();
	      return LoginUrl;
	  
	  }
 
}
