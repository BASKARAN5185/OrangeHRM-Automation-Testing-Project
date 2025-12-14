package utility;
import org.testng.annotations.DataProvider;

public class AddVacancyDataSet {

    @DataProvider(name = "validVacancyCreationData")
    public Object[][] getValidVacancyData() {
        return new Object[][] {
            // { VacancyName, JobTitle (TEXT), Description, HiringManagerName (null/"" for default), Positions, ActiveSwitch, RSSSwitch }
            
            // Data Row 1: Using text from the screenshot
            {
                "Junior Software Tester",
                "Automation Test Engineer", 
                "Design and oversee the automated testing framework.",
                 null, 
                "1",
                "check", 	
                "check" 	
            },
            
            // Data Row 2: Using text from the screenshot
            {
                "Automation Test Engineer",
                "Automation Test Engineer", 
                "Manual and basic automated testing tasks.",
                "", 	 	
                "5",
                "uncheck", 	
                "uncheck" 	
            },

            // Data Row 3: Using text from the screenshot
            {
                "Mid-level Java Developer",
                "Automaton Tester", 
                "Backend development and system maintenance.",
                null, 
                "3",
                "check", 	
                "uncheck" 	
            },

            // Data Row 4: 
            {
                "Senior Product Owner",
                "Chief Executive Officer", // Example text usage
                "Defining features and prioritizing backlogs.",
                null, 	 	
                "4",
                "uncheck", 	
                "check" 	
            },

            // Data Row 5: 
            {
                "UI/UX Designer",
                "Chief Financial Officer", // Example text usage
                "Design prototypes, user flows, and wireframes.",
                null,
                "2",
                "check", 	
                "uncheck" 	
            }
        };
    }

    @DataProvider(name = "invalidVacancyCreationData")
    public Object[][] getInvalidVacancyData() {
        return new Object[][] {
            // -------------------------------------------------------------
            // SCENARIOS FROM PREVIOUS RESPONSE
            // -------------------------------------------------------------
            
            // Test Case 1: Required Field Missing (Vacancy Name is "")
            {
                "", // Vacancy Name: Empty/Missing
                "Account Assistant", 
                "Description for missing name test.",
                "Paul Collings", 
                "1",
                "check", 	
                "check",
                "Expected error: Vacancy Name is required." 
            },

            // Test Case 2: Required Field Missing (Job Title is missing/null)
            {
                "Vacancy without Job Title",
                null, // Job Title: Missing (will likely fail at selectVacancyTitleReliable)
                "Description for missing job title.",
                "Paul Collings", 
                "1",
                "check", 	
                "check",
                "Expected error: Job Title is required."
            },

            // Test Case 3: Boundary Condition (Non-numeric input for Positions)
            {
                "Vacancy with Invalid Position Count",
                "Automation Test Engineer", 
                "Description for invalid position count.",
                "Paul Collings", 
                "NonNumeric", // Positions: Invalid data type
                "check", 	
                "uncheck",
                "Expected error: Number of Positions must be numeric."
            },
            
            // Test Case 4: Boundary Condition (Max Length Name)
            {
                "A very long Vacancy Name exceeding typical limits and containing special characters #%^&*()", 
                "Automaton Tester", 
                "Description for long name test.",
                "Paul Collings", 
                "1",
                "uncheck", 	
                "uncheck",
                "Expected error: Vacancy Name exceeds maximum character limit or contains invalid characters."
            },
            
            // Test Case 5: Negative Number of Positions
            {
                "Vacancy with Negative Positions",
                "Chief Financial Officer", 
                "Description for negative position count.",
                "Paul Collings", 
                "-1", // Positions: Negative number
                "check", 	
                "check",
                "Expected error: Number of Positions cannot be negative/less than 1."
            },
            
            // -------------------------------------------------------------
            // NEW SCENARIOS
            // -------------------------------------------------------------
            
            // Test Case 6: Zero Positions (Boundary Check)
            {
                "Vacancy with Zero Positions",
                "Account Assistant", 
                "Boundary check for zero positions.",
                "Paul Collings", 
                "0", // Positions: Zero
                "check", 	
                "check",
                "Expected error: Number of Positions must be greater than zero." 
            },
            
            // Test Case 7: High Boundary Positions (Max Value Check)
            {
                "Vacancy with Excessive Positions",
                "Chief Executive Officer", 
                "Boundary check for maximum number of positions.",
                "Paul Collings", 
                "9999999999", // Positions: Extremely large number
                "check", 	
                "uncheck",
                "Expected error: Value exceeds maximum acceptable limit."
            },
            
            // Test Case 8: Invalid Manager Name (Lookup failure)
            {
                "Vacancy with Non-existent Manager",
                "Automaton Tester", 
                "Testing invalid hiring manager name.",
                "NonExistentUser", // Manager: A user that does not exist in the system
                "1",
                "uncheck", 	
                "check",
                "Expected error: Invalid or non-matching Hiring Manager name."
            }
        };
    }
}