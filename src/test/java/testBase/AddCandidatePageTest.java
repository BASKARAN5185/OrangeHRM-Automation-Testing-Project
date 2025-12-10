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
        // Initialize page objects
        login = new OrangeHRMLoginPage(driver);
        addCandidate = new AddCandidatePage(driver);
        
        // Perform login
        login.login();
        
        // FIX 1: Assert successful login by checking for the Dashboard URL
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("dashboard/index"), "Login was unsuccessful. Driver is not on the Dashboard page.");
    }

    @BeforeMethod 
    public void navigateAddcandidatepage(){
        // Navigate directly to the Add Candidate page before each test execution
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/addCandidate");
    }

    // --- Valid Data Test ---
    @Test(groups = "Regression" , dataProviderClass = utility.AddCandidateFromDataSet.class ,dataProvider = "validCandidateData")
    public void testValidCandidateDataFromFilling(String firstnameString,
        String middleString,String lastnameString,String mailString,String contacString,
        String filePathString,String noteString,String keywordString,String errormessageString){

        addCandidate.fillFromAddCandidatePage(firstnameString,
        middleString, lastnameString, mailString, contacString,
        filePathString, noteString, keywordString, errormessageString );

        // Validation for successful candidate addition
        // Assuming rejectButtonVisibleValidattion() returns TRUE if the candidate was added successfully
        Assert.assertTrue(addCandidate.applicationStageVisibleValidattion(), errormessageString);     
    }
  /*   
    // --- Invalid Data Test ---
    @Test(groups = "Regression" , dataProviderClass = utility.AddCandidateFromDataSet.class ,dataProvider = "invalidCandidateData")
    public void testInvalidCandidateDataFromFilling(String firstnameString,
        String middleString,String lastnameString,String mailString,String contacString,
        String filePathString,String noteString,String keywordString){

        addCandidate.fillFromAddCandidatePage( firstnameString,
        middleString, lastnameString, mailString, contacString,
        filePathString, noteString, keywordString );
        
        // Validation for unsuccessful candidate addition (expected failure)
        // Assert that the page's success indicator (e.g., the reject button) is NOT visible.
        Assert.assertFalse(addCandidate.rejectButtonVisibleValidattion(), "Candidate was unexpectedly added with invalid data. Test failed.");
    }

    // --- Edge Case Data Test ---
    @Test(groups = "Regression" , dataProviderClass = utility.AddCandidateFromDataSet.class ,dataProvider = "edgeCandidateData")
    public void testEdgeCaseCandidateDataFromFilling(String firstnameString,
        String middleString,String lastnameString,String mailString,String contacString,
        String filePathString,String noteString,String keywordString,String errormessageString ){

        addCandidate.fillFromAddCandidatePage( firstnameString,
        middleString, lastnameString, mailString, contacString,
        filePathString, noteString, keywordString );

        // Validation for successful candidate addition (assuming edge cases are valid inputs)
        Assert.assertTrue(addCandidate.rejectButtonVisibleValidattion(), errormessageString);
        
    }

    // --- Security Data Test (e.g., XSS, SQLi) ---
    @Test(groups = "Regression" , dataProviderClass = utility.AddCandidateFromDataSet.class ,dataProvider = "securityCandidateData")
    public void testSecurityCandidateDataFromFilling(String firstnameString,
        String middleString,String lastnameString,String mailString,String contacString,
        String filePathString,String noteString,String keywordString){

        addCandidate.fillFromAddCandidatePage( firstnameString,
        middleString, lastnameString, mailString, contacString,
        filePathString, noteString, keywordString );
        
        // Validation for unsuccessful candidate addition (expected failure due to security restrictions)
        Assert.assertFalse(addCandidate.rejectButtonVisibleValidattion(), "Security data (e.g., XSS payload) successfully added candidate. Test failed.");
    }
        */
}