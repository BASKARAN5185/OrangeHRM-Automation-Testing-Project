package testBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectClass.AddCandidatePage;
import pageObjectClass.OrangeHRMLoginPage;

public class AddCandidatePageTest extends BaseClass {
    
    OrangeHRMLoginPage login;
    AddCandidatePage addCandidate;
    @BeforeClass
    public void setup(){
      login = new OrangeHRMLoginPage(driver);
      addCandidate=new AddCandidatePage(driver);
    }

    @BeforeMethod 
    public void navigateAddcandidatepage(){
      driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/addCandidate");
    }

    @Test(groups = "Regression" , dataProviderClass = utility.AddCandidateFromDataSet.class ,dataProvider = "validCandidateData")
    public void testValidCandidateDataFromFilling(String titleString,String firstnameString,
        String middleString,String lastnameString,String mailString,String contacString,
        String filePathString,String noteString,String keywordString){

         addCandidate.fillFromAddCandidatePage(titleString , firstnameString,
         middleString, lastnameString, mailString, contacString,
         filePathString, noteString, keywordString );

        Assert.assertTrue(addCandidate.rejectButtonVisibleValidattion(), "New candidate add is Failed");         
        
      }
     
    @Test(groups = "Regression" , dataProviderClass = utility.AddCandidateFromDataSet.class ,dataProvider = "invalidCandidateData")
    public void testInvalidCandidateDataFromFilling(String titleString,String firstnameString,
        String middleString,String lastnameString,String mailString,String contacString,
        String filePathString,String noteString,String keywordString){

         addCandidate.fillFromAddCandidatePage(titleString , firstnameString,
         middleString, lastnameString, mailString, contacString,
         filePathString, noteString, keywordString );
        
         Assert.assertFalse(addCandidate.rejectButtonVisibleValidattion(), "The Candidate successfully added in the resouce,Invalid test is failed");
      }


      @Test(groups = "Regression" , dataProviderClass = utility.AddCandidateFromDataSet.class ,dataProvider = "edgeCandidateData")
    public void testEdgeCaseCandidateDataFromFilling(String titleString,String firstnameString,
        String middleString,String lastnameString,String mailString,String contacString,
        String filePathString,String noteString,String keywordString){

         addCandidate.fillFromAddCandidatePage(titleString , firstnameString,
         middleString, lastnameString, mailString, contacString,
         filePathString, noteString, keywordString );

        Assert.assertTrue(addCandidate.rejectButtonVisibleValidattion(), "New candidate add is Failed");
        
      }

      @Test(groups = "Regression" , dataProviderClass = utility.AddCandidateFromDataSet.class ,dataProvider = "securityCandidateData")
    public void testSecurityCandidateDataFromFilling(String titleString,String firstnameString,
        String middleString,String lastnameString,String mailString,String contacString,
        String filePathString,String noteString,String keywordString){

         addCandidate.fillFromAddCandidatePage(titleString , firstnameString,
         middleString, lastnameString, mailString, contacString,
         filePathString, noteString, keywordString );
        
         Assert.assertFalse(addCandidate.rejectButtonVisibleValidattion(), "The Candidate successfully added in the resouce,Security test is failed");

      }
      

    }
