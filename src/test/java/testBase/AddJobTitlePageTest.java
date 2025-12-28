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

@Test
public void verifyTheJobTilteDulpicateErrorMessage(){
    addJobTitlePage.enterJobTitle("QA Engineer");
    addJobTitlePage.saveButtonClick();
    Assert.assertEquals(stringsWebElement("Already exists").getText(),"Already exists", "The Jobtile Duplicate error message is not displayed");
}

@Test
public void verifyTheJobTilteEmptyErrorMessage(){
    addJobTitlePage.enterJobTitle("");
    addJobTitlePage.saveButtonClick();
    Assert.assertEquals(stringsWebElement("Required").getText(),"Required", "The Jobtile Required error message is not displayed");
}

@Test
public void verifyTheJobTilteFileldCharactersLimitation(){
    addJobTitlePage.enterJobTitle("dhdgajhgddkjsajgdsadasjdjdsa".repeat(5));
    addJobTitlePage.saveButtonClick();
    Assert.assertEquals(stringsWebElement("Should not exceed 100 characters").getText(),"Should not exceed 100 characters", "The Jobtile character limitation error message is not displayed");
}

@Test
public void verifyTheJobDescriptionCharacterLimitation(){
    addJobTitlePage.enterDescription("gcjagcjhjgacakgcakjchhcacajhcgjacjacjjaacj".repeat(17));
    addJobTitlePage.saveButtonClick();
    Assert.assertEquals(stringsWebElement("Should not exceed 400 characters").getText()
    , "Should not exceed 400 characters", "The job decription charcters limitation error message was dosen't displayed");
}

@Test
public void verifyTheNotesCharacterLimitation(){
    addJobTitlePage.enterNote("gcjagcjhjgacakgcakjchhcacajhcgjacjacjjaacj".repeat(17));
    addJobTitlePage.saveButtonClick();
    Assert.assertEquals(stringsWebElement("Should not exceed 400 characters").getText()
    , "Should not exceed 400 characters", "The job decription charcters limitation error message was dosen't displayed");
}

}
