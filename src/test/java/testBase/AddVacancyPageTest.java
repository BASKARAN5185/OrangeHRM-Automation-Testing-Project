package testBase;

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
        addVacancyPage.selectVacancyTitle();
        addVacancyPage.enterDesscription("dssd");
        addVacancyPage.enterHiringManager("");
        addVacancyPage.enterNumberOfPositions("5");
        addVacancyPage.clickActiveCheckbox("check");
        addVacancyPage.clickPublishInRSSCheckbox("check");
        addVacancyPage.clickSaveButton();
    }


    

}
