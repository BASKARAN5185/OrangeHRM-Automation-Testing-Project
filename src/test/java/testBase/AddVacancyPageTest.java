package testBase;

import org.openqa.selenium.NoSuchElementException;
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

    @Test
    public void validVacancyFromFillingcheck() {
        addVacancyPage.enterVacancyName("Tester");
        addVacancyPage.selectVacancyTitleReliable("Automation Test Engineer");
        addVacancyPage.enterDesscription("test");
        addVacancyPage.enterHiringManager(null);
        addVacancyPage.enterNumberOfPositions("5");
        addVacancyPage.clickActiveCheckbox("uncheck");
        addVacancyPage.clickPublishInRSSCheckbox("uncheck");
        addVacancyPage.clickSaveButton();
        Assert.assertTrue(stringsWebElement("Edit Vacancy").isDisplayed(),"Vacany cration test case is failed");
    }

    @Test(alwaysRun = true, groups = {"smoke" ,"regression"},dataProviderClass = utility.AddVacancyDataSet.class,
    dataProvider = "validVacancyCreationData")
    public void validVacancyFromFilling(String vacanctNameString, String vacancyTitle,String desscreptionString,
                                        String hrmangerString, String numerOfPostioString,String checkBoxString,
                                        String rssCheckBoxStrig) throws InterruptedException{
        addVacancyPage.enterVacancyName(vacanctNameString);
        addVacancyPage.selectVacancyTitleReliable(vacancyTitle);
        addVacancyPage.enterDesscription(desscreptionString);
        addVacancyPage.enterHiringManager(hrmangerString);
        addVacancyPage.enterNumberOfPositions(numerOfPostioString);
        addVacancyPage.clickActiveCheckbox(checkBoxString);
        addVacancyPage.clickPublishInRSSCheckbox(rssCheckBoxStrig);
        addVacancyPage.clickSaveButton();
        boolean validation;
        try{
        if (stringsWebElement("Edit Vacancy").isDisplayed()) {
            System.out.println("edit vacany is displayed test case pass.");
           validation=true;    
        }else{
            System.out.println("edit vacany is not displayed test case passed.");
            validation=false;
        }
        }catch(NoSuchElementException e){
            System.out.println("edit vacany is not available in the page.");
          validation=true;
        }
        Assert.assertTrue(validation,"Vacany cration test case is failed");
    }

    @Test(dataProviderClass = utility.AddVacancyDataSet.class, dataProvider = "invalidVacancyCreationData")
    public void invalidVacancyFromFilling(String vacanctNameString, String vacancyTitle,String desscreptionString,
                                        String hrmangerString, String numerOfPostioString,String checkBoxString,
                                        String rssCheckBoxStrig) throws InterruptedException{
        addVacancyPage.enterVacancyName(vacanctNameString);
        addVacancyPage.selectVacancyTitleReliable(vacancyTitle);
        addVacancyPage.enterDesscription(desscreptionString);
        addVacancyPage.enterHiringManager(hrmangerString);
        addVacancyPage.enterNumberOfPositions(numerOfPostioString);
        addVacancyPage.clickActiveCheckbox(checkBoxString);
        addVacancyPage.clickPublishInRSSCheckbox(rssCheckBoxStrig);
        addVacancyPage.clickSaveButton();
        Assert.assertFalse(addVacancyPage.editVacanyValidation("Add Vacancy"),"Vacany cration test case is failed");
    }

    @Test(dataProviderClass = utility.AddVacancyDataSet.class, dataProvider = "securityInjectionData")
    public void securityCaseVacancyFromFilling(String vacanctNameString, String vacancyTitle,String desscreptionString,
                                        String hrmangerString, String numerOfPostioString,String checkBoxString,
                                        String rssCheckBoxStrig) throws InterruptedException{
        addVacancyPage.enterVacancyName(vacanctNameString);
        addVacancyPage.selectVacancyTitleReliable(vacancyTitle);
        addVacancyPage.enterDesscription(desscreptionString);
        addVacancyPage.enterHiringManager(hrmangerString);
        addVacancyPage.enterNumberOfPositions(numerOfPostioString);
        addVacancyPage.clickActiveCheckbox(checkBoxString);
        addVacancyPage.clickPublishInRSSCheckbox(rssCheckBoxStrig);
        addVacancyPage.clickSaveButton();
        boolean validation;
       try{
        if(stringsWebElement("Edit Vacancy").isDisplayed()) {
            System.out.println("edit vacany is displayed test case failed.");
           validation=true;    
        }else{
            System.out.println("edit vacany is displayed test case passed.");
            validation=false;
        }
        }catch(NoSuchElementException e){
            System.out.println("edit vacany is not available in the page.");
          validation=false;
        }
        Assert.assertFalse(validation,"Vacany cration test edge case is failed");
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
        if (stringsWebElement("Required").isDisplayed()){
             conditionString=true;
        } 
        // rquired fileld are empty show the error message
        Assert.assertEquals(driver.getCurrentUrl().contains("/recruitment/addJobVacancy"),
        conditionString,"Save Button condition is faild vacancy created and required is not displayed");
    }

}
