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
}