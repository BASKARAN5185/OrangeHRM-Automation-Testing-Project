package testBase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import baseClass.BaseClass;
import pageObjectClass.AddVacancyPage;
import pageObjectClass.OrangeHRMLoginPage;

public class AddVacancyPageTest extends BaseClass{
    
    OrangeHRMLoginPage loginPage;
    AddVacancyPage addVacancyPage;
    @BeforeClass
    public void setup(){
        loginPage=new OrangeHRMLoginPage(driver);
        addVacancyPage=new AddVacancyPage(driver);
        loginPage.login();
    }  

    @BeforeMethod
    public void nativeAddVacancyPage(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/addJobVacancy");
    }

    @Test(groups = {"smoke" ,"regression"})
    public void validVacancyFromFilling(){
        addVacancyPage.enterVacancyName("Junior Software Tester");
        addVacancyPage.selectVacancyTitle(3);
        addVacancyPage.enterDesscription("dssd");
        addVacancyPage.enterHiringManager();
        addVacancyPage.enterNumberOfPositions("5");
        addVacancyPage.clickActiveCheckbox("uncheck");
        addVacancyPage.clickPublishInRSSCheckbox("uncheck");
        addVacancyPage.clickSaveButton();
        Assert.assertTrue(stringEWebElement("Edit Vacancy").isDisplayed(),"Vacany cration test case is failed");
    }

    @Test
    public void cancelButtonValidation(){
        addVacancyPage.clickCancelButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("/recruitment/viewJobVacancy"), "The cancel button function is failed");
    }

    @Test
    public void saveButtonValidation(){
        addVacancyPage.clickSaveButton();
        boolean conditionString = false;
        if (stringEWebElement("Required").isDisplayed()){
             conditionString=true;
        } 
        // rquired fileld are empty show the error message
        Assert.assertEquals(driver.getCurrentUrl().contains("/recruitment/addJobVacancy"),
        conditionString,"Save Button condition is faild vacancy created and required is not displayed");
    }

}
