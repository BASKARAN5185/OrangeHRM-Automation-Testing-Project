package utility;
import org.testng.annotations.DataProvider;

public class AddVacancyDataSet {

    @DataProvider(name = "validVacancyCreationData")
    public Object[][] getValidVacancyData() {
        return new Object[][] {
            // Data Row 1: Fully Active, Specific Manager (High Priority)
            {
                "Automation Architect Role",
                4, // Job Title: 4th item in dropdown
                "Design and oversee the automated testing framework.",
                "Paul Collings", 
                "1",
                "check",        // Active: Yes
                "check"         // RSS: Yes
            },
            
            // Data Row 2: Inactive, Default Manager (Testing the 'else' block)
            {
                "Junior Software Tester",
                1, // Job Title: 1st item in dropdown
                "Manual and basic automated testing tasks.",
                "",             // Triggers the default (logged-in user) logic
                "5",
                "uncheck",      // Active: No
                "uncheck"       // RSS: No
            },

            // Data Row 3: Active, Another Specific Manager
            {
                "Mid-level Java Developer",
                2,
                "Backend development and system maintenance.",
                "Kiran Sharma", 
                "3",
                "check",        // Active: Yes
                "uncheck"       // RSS: No
            },

            // Data Row 4: Inactive, Testing 'null' for Manager
            {
                "Senior Product Owner",
                5,
                "Defining features and prioritizing backlogs.",
                null,           // Also triggers the default (logged-in user) logic
                "10",
                "uncheck",      // Active: No
                "check"         // RSS: Yes
            },

            // Data Row 5: Active, High Positions Count
            {
                "UI/UX Designer",
                3,
                "Design prototypes, user flows, and wireframes.",
                "Fiona Grace",
                "25",
                "check",        // Active: Yes
                "uncheck"       // RSS: No
            }
        };
    }
}