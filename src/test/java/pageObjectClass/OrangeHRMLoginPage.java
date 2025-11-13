package pageObjectClass;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import baseClass.BaseClass;

public class OrangeHRMLoginPage  {
    private RemoteWebDriver driver;

    public OrangeHRMLoginPage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By loginPageTitle = By.tagName("h5");
    private By username = By.name("username");
    private By password = By.name("password");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By logo = By.xpath("//img[@alt='company-branding']");
    private By sideLogo = By.xpath("(//img[@alt='orangehrm-logo'])[2]");
    private By forgotPasswordLink = By.xpath("//p[contains(.,'Forgot your password?')]");

    // Forgot password page
    private By forgotUser = By.name("username");
    private By cancelButton = By.xpath("//*[text()=' Cancel ']");
    private By resetPasswordButton = By.xpath("//*[text()=' Reset Password ']");

    // Social media icons
    private By linkedinIcon = By.xpath("//a[@href='https://www.linkedin.com/company/orangehrm/mycompany/']");
    private By facebookIcon = By.xpath("//a[@href='https://www.facebook.com/OrangeHRM/']");
    private By twitterIcon = By.xpath("//a[@href='https://twitter.com/orangehrm?lang=en']");
    private By youtubeIcon = By.xpath("//a[@href='https://www.youtube.com/c/OrangeHRMInc']");

    // Footer
    private By osVersion = By.xpath("//p[text()='OrangeHRM OS 5.7']");
    private By copyright =
        By.xpath("//p[contains(.,'© 2005 - 2025 OrangeHRM, Inc. All rights reserved.')]");

    // Actions
    public void login(String loginname, String pass) {
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(loginname);
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginButton).click();
    }

    public void clickForgotPasswordLink() {
        driver.findElement(forgotPasswordLink).click();
    }

    public void cancelPasswordReset() {
        driver.findElement(cancelButton).click();
    }

    public void resetPassword(String username) {
        driver.findElement(forgotUser).sendKeys(username);
        driver.findElement(resetPasswordButton).click();
    }

    public void goBack() {
        driver.navigate().back();
    }

    // Validation methods
    public boolean logoVisible() {
        return driver.findElement(logo).isDisplayed();
    }

    public boolean sideLogoVisible() {
        return driver.findElement(sideLogo).isDisplayed();
    }

    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageTitle() {
        return driver.findElement(loginPageTitle).getText();
    }

    public boolean pageTitleVisible() {
        return driver.findElement(loginPageTitle).isDisplayed();
    }

    // Social icon visibility
    public boolean linkedinIconVisible() {
        return driver.findElement(linkedinIcon).isDisplayed();
    }

    public boolean facebookIconVisible() {
        return driver.findElement(facebookIcon).isDisplayed();
    }

    public boolean twitterIconVisible() {
        return driver.findElement(twitterIcon).isDisplayed();
    }

    public boolean youtubeIconVisible() {
        return driver.findElement(youtubeIcon).isDisplayed();
    }

    // Click methods
    public String clickLinkedinIcon() {
        driver.findElement(linkedinIcon).click();
        return driver.getCurrentUrl();
    }

    public String clickFacebookIcon() {
        driver.findElement(facebookIcon).click();
        return driver.getCurrentUrl();
    }

    public String clickTwitterIcon() {
        driver.findElement(twitterIcon).click();
        return driver.getCurrentUrl();
    }

    public String clickYoutubeIcon() {
        driver.findElement(youtubeIcon).click();
        return driver.getCurrentUrl();
    }

    // Footer text
    public String getOSVersionText() {
        return driver.findElement(osVersion).getText();
    }

    public String getCopyrightText() {
        return driver.findElement(copyright).getText();
    }

    // Button styling info
    public List<String> getLoginButtonCssProperties() {
        WebElement btnLogin = driver.findElement(loginButton);
        String color = btnLogin.getCssValue("color");
        String backgroundColor = btnLogin.getCssValue("background-color");
        String font = btnLogin.getCssValue("font-size");
        String border = btnLogin.getCssValue("border-radius");
        String padding = btnLogin.getCssValue("padding");
        String margin = btnLogin.getCssValue("margin");
        return List.of(color, backgroundColor, font, border, padding, margin);
    }

    public String LoginValidation() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'LoginValidation'");
    }
}
