package utility;

import org.testng.annotations.DataProvider;

public class AddCandidateFromDataSet {

    @DataProvider(name = "validCandidateData")
    public Object[][] validCandidateData() {
    return new Object[][] {
        {"Mr", "John", "A", "Doe", "john.doe@gmail.com", "9876543210",
                "/files/resume1.pdf", "Experienced QA engineer", "Selenium,Java"},

        {"Ms", "Sarah", "L", "Connor", "sarah.connor@mail.com", "+1-555-223344",
                "/files/resume2.pdf", "Strong automation background", "Automation,Testing"},

        {"Dr", "Albert", "", "Newton", "albert.newton@company.org", "0123456789",
                "/files/resume3.pdf", "Research-oriented candidate", "Research,AI"},
        };
    }

    @DataProvider(name = "invalidCandidateData")
    public Object[][] invalidCandidateData() {
     return new Object[][] {
        {"Mr", "John", "A", "Doe", "john.doe", "12345",
                "/files/resume.pdf", "invalid email", "test"},

        {"Mr", "", "B", "Wayne", "bruce@wayne.com", "9876543210",
                "/files/resume.pdf", "missing firstname", "hero"},

        {"Mrs", "@@@", "###", "$$$", "test@mail.com", "9999999999",
                "/files/resume.pdf", "symbols", "symbols"},

        {"Ms", "Lily", "", "Ford", "lily.ford@mail.com", "abcdefg",
                "/files/resume.pdf", "invalid phone", "test"},

        {"Mr", "Mark", "K", "Wood", "mark.wood@mail.com", "1122334455",
                "", "no file", "empty"},
        };
        }
     

        @DataProvider(name = "edgeCandidateData")
        public Object[][] edgeCandidateData() {
        return new Object[][] {

        {"Mr", "JonathanAlexanderMaximus", "X", "LonglastnameOver30chars",
                "jon.max@sample.com", "8888888888",
                "/files/resume.pdf", "long names", "long,edge"},

        {"Ms", "Tina", "", "Vale", "tina.vale@mail.com", "6677889900",
                "/files/resume.pdf", "no middle", "blank"},

        {"Dr", "Eve", "M", "Carter",
                "verylongemailaddress12345678901234567890@testdomain.com",
                "1234567890", "/files/resume.pdf", "boundary email", "boundary"},

        {"Mr", "José", "Luís", "García",
                "jose.garcia@mail.es", "+34987654321",
                "/files/resume.pdf", "unicode", "español"},

        {"Ms", "Amanda", "R", "Collins",
                "amanda.collins@mail.com", "2233445566",
                "/files/resume.pdf",
                "This is a very long note text used to test boundary limits in the notes field...",
                "longnote"}
         };
         }


        @DataProvider(name = "securityCandidateData")
        public Object[][] securityCandidateData() {
        return new Object[][] {
        // XSS
        {"<script>alert('XSS')</script>", "<img src=x onerror=alert(1)>", "", "<svg/onload=alert('XSS')>", "xss@example.com", "1234567890",
         "/files/resume.pdf", "<iframe src=\"javascript:alert('XSS')\"></iframe>", "<b onmouseover=alert(1)>hover</b>"},
        
        // SQL Injection
        {"Mr", "' OR 1=1--", "", "'; DROP TABLE candidates; --", "' OR '1'='1", "9876543210",
         "/files/resume.pdf", "'); UPDATE candidates SET email='hacked@example.com' WHERE '1'='1", "sql,test"},

        // Command Injection / File Path
        {"Mr", "John", "", "Doe", "cmdinjection@example.com", "1234567890",
         "../../../../etc/passwd", "$(rm -rf /)", "`whoami`"},

        // Very Large Input
        {"Mr", "A".repeat(5000), "", "B".repeat(5000), "longinput@example.com", "1234567890",
         "/files/resume.pdf", "N".repeat(10000), "K".repeat(2000)},

        // Special Characters / Unicode
        {"Mr", "O’Connor", "É", "Renée", "unicode@example.com", "+1-555-667788",
         "/files/resume.pdf", "😀🚀🔥", "test,emoji"}
        };
    }
}
