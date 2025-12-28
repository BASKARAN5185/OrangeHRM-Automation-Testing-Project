package testBase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectClass.OrangeHRMLoginPage;
import pageObjectClass.admin.AddJobTitlePage;

public class AddJobTitlePageTest extends BaseClass {
    String AddJobTitlePageUrl="https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveJobTitle";
    OrangeHRMLoginPage loginPage;
    AddJobTitlePage addJobTitlePage;
    
@BeforeClass
public void setUpBrowser() {
    super.setUpBrowser();
    loginPage = new OrangeHRMLoginPage(driver);
    addJobTitlePage = new AddJobTitlePage(driver);
    loginPage.login();
}

@BeforeMethod
public void navigatePage(){
        driver.get(AddJobTitlePageUrl);
    }

@Test
public void enterValidJobTitle(){
        addJobTitlePage.enterJobTitle("QA the Engineer");
        addJobTitlePage.saveButtonClick();
        Assert.assertTrue(getCurrentPageUrl().equals(AddJobTitlePageUrl),"The Valid type Add Job Title test case is failed.");
    }

}
