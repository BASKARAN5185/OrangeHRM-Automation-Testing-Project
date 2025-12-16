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
            
            // Test Case 1: Required Field Missing (Vacancy Name is "")
            {
                "", // Vacancy Name: Empty/Missing
                "Account Assistant", 
                "Description for missing name test.",
                "Paul Collings", 
                "1",
                "check", 	
                "check" 
            },

            // Test Case 2: Required Field Missing (Job Title is missing/null)
            {
                "Vacancy without Job Title",
                null, // Job Title: Missing (will likely fail at selectVacancyTitleReliable)
                "Description for missing job title.",
                "Paul Collings", 
                "1",
                "check", 	
                "check"
            },

            // Test Case 3: Boundary Condition (Non-numeric input for Positions)
            {
                "Vacancy with Invalid Position Count",
                "Automation Test Engineer", 
                "Description for invalid position count.",
                "Paul Collings", 
                "NonNumeric", // Positions: Invalid data type
                "check", 	
                "uncheck"
            },
            
            // Test Case 4: Boundary Condition (Max Length Name)
            {
                "A very long Vacancy Name exceeding typical limits and containing special characters #%^&*()", 
                "Automaton Tester", 
                "Description for long name test.",
                "Paul Collings", 
                "1",
                "uncheck", 	
                "uncheck"
            },
            
            // Test Case 5: Negative Number of Positions
            {
                "Vacancy with Negative Positions",
                "Chief Financial Officer", 
                "Description for negative position count.",
                "Paul Collings", 
                "-1", // Positions: Negative number
                "check", 	
                "check"
            },
            
            // Test Case 6: Zero Positions (Boundary Check)
            {
                "Vacancy with Zero Positions",
                "Account Assistant", 
                "Boundary check for zero positions.",
                "Paul Collings", 
                "0", // Positions: Zero
                "check", 	
                "check" 
            },
            
            // Test Case 7: High Boundary Positions (Max Value Check)
            {
                "Vacancy with Excessive Positions",
                "Chief Executive Officer", 
                "Boundary check for maximum number of positions.",
                "Paul Collings", 
                "9999999999", // Positions: Extremely large number
                "check", 	
                "uncheck"
            },
            
            // Test Case 8: Invalid Manager Name (Lookup failure)
            {
                "Vacancy with Non-existent Manager",
                "Automaton Tester", 
                "Testing invalid hiring manager name.",
                "NonExistentUser", // Manager: A user that does not exist in the system
                "1",
                "uncheck", 	
                "check"
            }
        };
    }

    /**
     * Data provider specifically for high-priority edge case and boundary condition testing.
     * Contains cases like extreme values, invalid data types, security risks, and unique system failures.
     * * Column Order: 
     * { VacancyName, JobTitle (TEXT), Description, HiringManagerName, Positions, ActiveSwitch, RSSSwitch }
     */
    @DataProvider(name = "vacancyEdgeCases")
    public Object[][] getVacancyEdgeCases() {
        return new Object[][] {
            
            // --- EDGE CASE 1: Positions - Upper Boundary Test (Above 32-bit max) ---
            {
                "High Positions Overflow Check", 
                "Chief Executive Officer", 
                "Testing boundary overflow for number of positions.",
                "Paul Collings", 
                "2147483648", // Positions: One above 32-bit max (2,147,483,647)
                "check",
                "uncheck"
            },
            
            // --- EDGE CASE 2: Positions - Decimal/Float Input ---
            {
                "Decimal Positions Check", 
                "Automaton Tester", 
                "Invalid data type for position count.",
                null, 
                "2.5", // Positions: Decimal input instead of integer
                "check",
                "check"
            },
            
            // --- EDGE CASE 3: Positions - Non-numeric Input ---
            {
                "Invalid Positions DataType",
                "Automation Test Engineer", 
                "Testing non-numeric characters in a numeric field.",
                "Paul Collings", 
                "NonNumeric", // Positions: Invalid data type
                "uncheck",
                "uncheck"
            },

            // --- EDGE CASE 4: String Length / Special Characters ---
            {
                "A very long Vacancy Name exceeding typical limits and containing special characters #%^&*()", 
                "Automaton Tester", 
                "Test description for max length name.",
                "Paul Collings", 
                "1",
                "check", 
                "check"
            },
            
            // --- EDGE CASE 5: Security (SQL/XSS) ---
            {
                "' OR 1=1;--", // Vacancy Name: SQL Injection Attempt
                "Automation Test Engineer", 
                "<script>alert('XSS')</script>", // Description: XSS Script Attempt
                null, 
                "1",
                "check",  
                "uncheck" 
            },

            // --- EDGE CASE 6: Whitespace Only Input ---
            {
                "     ", // Vacancy Name: Only Spaces
                "Account Assistant", 
                "A description is present.",
                null, 
                "1",
                "check",
                "check"
            },
            
            // --- EDGE CASE 7: Invalid/Non-Existent Reference Data ---
            {
                "Vacancy with Non-existent Manager",
                "Automaton Tester", 
                "Testing for failure when reference data (Hiring Manager) is not found.",
                "NonExistentUser", // Manager: A user that does not exist in the system
                "1",
                "uncheck",
                "check"
            }
        };
    }

    /**
     * Data provider for Advanced Security and Injection testing.
     * Focuses on NoSQL injection, Path Traversal, Command Injection, 
     * and specialized character encoding.
     */
    @DataProvider(name = "securityInjectionData")
    public Object[][] getSecurityInjectionData() {
        return new Object[][] {
            
            // 1. NoSQL Injection (useful if the backend uses MongoDB/etc.)
            {
                "{ $ne: null }", // Vacancy Name: Logic bypass attempt
                "Automation Test Engineer", 
                "Attempting NoSQL logic bypass in name field.",
                null, 
                "1", "check", "uncheck"
            },

            // 2. OS Command Injection
            {
                "SecurityTest; ls -la /etc/passwd", // Vacancy Name: Command chaining
                "Account Assistant", 
                "Checking if input is passed directly to system shell.",
                "Paul Collings", 
                "1", "uncheck", "check"
            },

            // 3. Path Traversal / LFI
            {
                "../../../etc/passwd", // Vacancy Name: File system navigation
                "Chief Executive Officer", 
                "Testing if the application attempts to resolve file paths from input.",
                null, 
                "1", "check", "check"
            },

            // 4. Broken Encoding / Null Byte Injection
            {
                "Job\0Title.exe", // Vacancy Name: Null byte termination
                "Automaton Tester", 
                "Testing how the system handles null bytes in strings.",
                "Paul Collings", 
                "1", "check", "uncheck"
            },

            // 5. Large Payload (Buffer Overflow / ReDoS attempt)
            {
                "A".repeat(5000), // Vacancy Name: Extremely long string
                "Account Assistant", 
                "Testing for application hang or crash on massive string input.",
                null, 
                "1", "uncheck", "uncheck"
            },

            // 6. Template Injection (SSTI)
            {
                "{{7*7}}", // Vacancy Name: Server-Side Template Injection
                "Automation Test Engineer", 
                "Checking if the server evaluates expressions (Result 49?).",
                null, 
                "1", "check", "check"
            }
        };
    }
}