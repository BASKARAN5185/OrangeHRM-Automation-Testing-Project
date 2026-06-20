package utility;

import org.testng.annotations.DataProvider;

public class AddCandidateFromDataSet {

    // Data Structure: {FirstName, MiddleName/Initial, LastName, Email, PhoneNumber, ResumeFilePath, Notes(Description), Keywords, ExpectedErrorMessage}
    
    // --- FILE PATH CONSTANTS ---
    private final String RES_FOLDER = "src/test/resources/";
    private final String VALID_PDF_PATH = RES_FOLDER + "pdf file";
    private final String VALID_DOCX_PATH = RES_FOLDER + "Docx Test";
    private final String VALID_RTF_PATH = RES_FOLDER + "rtf.text";
    private final String VALID_TXT_PATH = RES_FOLDER + "text file";
    private final String INVALID_XLSX_1_PATH = RES_FOLDER + "New XLSX Worksheet";
    private final String INVALID_XLSX_2_PATH = RES_FOLDER + "123";
    private final String INVALID_IMAGE_PATH = RES_FOLDER + "milky-way-starry-sky-night-mountains-lake-reflection-on-cold-5k-576...";
    private final String INVALID_PPT_PATH = RES_FOLDER + "Selenium_BaseClass_Canvas";
    // ---------------------------

// --------------------------------------------------------------------------------------

    /**
     * Data Provider for all Valid/Positive Candidate Submission tests. (Expected: SUCCESS)
     */
    @DataProvider(name = "validCandidateData")
    public Object[][] validCandidateData() {
        return new Object[][] {
            // ====================================================================================================
            // ➡️ 1. Valid Candidate Data (Positive Testing) - All have 9 elements
            // ====================================================================================================
            {"John", "A", "Doe", "john.doe@gmail.com", "9876543210", VALID_PDF_PATH, "Candidate is java developer (PDF Test)", "Selenium,Java", "SUCCESS"},
            {"Sarah", "L", "Connor", "sarah.connor@mail.com", "+1-555-223344", VALID_TXT_PATH, "Positive test: Valid data and file upload (TXT Test).", "Automation,Testing", "SUCCESS"},
            {"Albert", "", "Newton", "albert.newton@company.org", "0123456789", VALID_DOCX_PATH, "Positive test: Valid data and file upload (DOCX Test).", "Research,AI", "SUCCESS"},
            {"Rebecca", "R", "Chung", "rebecca.chung@mail.com", "5551122334", VALID_RTF_PATH, "Positive test: Valid data and file upload (RTF Test).", "Legal,Compliance", "SUCCESS"},
        };
    }
    
// --------------------------------------------------------------------------------------

    /**
     * Data Provider for Invalid Candidate Data tests (Missing fields, Invalid formats, Invalid files).
     */
    @DataProvider(name = "invalidCandidateData")
    public Object[][] invalidCandidateData() {
        return new Object[][] {
            // ====================================================================================================
            // ❌ 2. Invalid Candidate Data (Negative Testing) - All have 9 elements
            // ====================================================================================================
            // Missing Required Fields
            {"", "B", "Wayne", "bruce@wayne.com", "9876543210", VALID_PDF_PATH, "Missing First Name.", "required", "Required"},
            {"Bruce", "B", "", "bruce@wayne.com", "9876543210", VALID_PDF_PATH, "Missing Last Name.", "required", "Required"},
            {"Bruce", "B", "Wayne", "", "9876543210", VALID_PDF_PATH, "Missing Email.", "required", "Required"},
            {"Thomas", "M", "Edison", "thomas@light.com", "2233445566", "", "Empty File Path (Resume is required).", "file", "Required"},
            
            // Invalid Formats
            {"John", "A", "Doe", "john.doe", "9876543210", VALID_PDF_PATH, "Invalid Email Format.", "format", "Invalid email address"},
            {"Tony", "M", "Stark", "tony..stark@avengers.com", "1234567890", VALID_PDF_PATH, "Invalid Email Format (Consecutive dots).", "format", "Invalid email address"},
            {"Lily", "", "Ford", "lily.ford@mail.com", "abcdefg", VALID_PDF_PATH, "Invalid Phone Number (Non-numeric).", "format", "The telephone number is invalid"},
            {"Mark", "K", "Wood", "mark.wood@mail.com", "12345", VALID_PDF_PATH, "Invalid Phone Number (Too short).", "format", "The telephone number is invalid"},
            {"Peter", "B", "Parker", "peter@dailybugle.com", " 9900990099 ", VALID_PDF_PATH, "Phone with leading/trailing spaces.", "spaces,format", "The telephone number is invalid"},
            {"@@@", "###", "$$$", "test@mail.com", "9999999999", VALID_PDF_PATH, "Symbols in Name fields.", "symbols", "Should contain only letters"},

        /*     // Invalid File Types
            {"Clark", "J", "Kent", "clark.kent@dailyplanet.com", "1122334455", INVALID_XLSX_1_PATH, "Invalid File Format (New XLSX Worksheet).", "file", "Invalid file type"},
            {"Lois", "L", "Lane", "lois@dailyplanet.com", "5544332211", INVALID_XLSX_2_PATH, "Invalid File Format (123 - Spreadsheet).", "file", "Invalid file type"},
            {"Leia", "P", "Organa", "leia@rebel.com", "9988776655", INVALID_IMAGE_PATH, "Invalid File Format (Image file).", "file", "Invalid file type"},
            {"Han", "S", "Solo", "han@falcon.com", "9999888877", INVALID_PPT_PATH, "Invalid File Format (Presentation file).", "file", "Invalid file type"},
        */
            } ;
    }

// --------------------------------------------------------------------------------------
    
    /**
     * Data Provider for Edge Case Candidate tests (Boundary conditions, Unicode, long inputs).
     */
    @DataProvider(name = "edgeCandidateData")
    public Object[][] edgeCandidateData() {
        return new Object[][] {
            // ====================================================================================================
            // 🚧 3. Edge Candidate Data (Boundary Testing) - All have 9 elements
            // ====================================================================================================
            // Long Names (Boundary)
            {"JonathanAlexanderMaximus", "X", "LonglastnameOver30chars", "jon.max@sample.com", "8888888888", VALID_PDF_PATH, "Boundary Test: Long Names (Pass/Fail based on app limit).", "long,edge", "SUCCESS_OR_ERROR"},
            // No Middle Name (This is a valid positive case, but is often grouped with boundary checks)
            {"Tina", "", "Vale", "tina.vale@mail.com", "6677889900", VALID_PDF_PATH, "Boundary Test: No Middle Name (Expected Pass).", "blank", "SUCCESS"},
            // Boundary Email Length
            {"Eve", "M", "Carter", "verylongemailaddress12345678901234567890@testdomain.com", "1234567890", VALID_PDF_PATH, "Boundary Test: Long Email (Pass/Fail based on app limit).", "boundary", "SUCCESS_OR_ERROR"},
            // Unicode Characters (Pass/Fail based on system encoding)
            {"José", "Luís", "García", "jose.garcia@mail.es", "+34987654321", VALID_PDF_PATH, "Boundary Test: Unicode Characters (Expected Pass in modern systems).", "español,unicode", "SUCCESS_OR_ERROR"},
            // Long Note Text
            {"Amanda", "R", "Collins", "amanda.collins@mail.com", "2233445566", VALID_PDF_PATH, "Boundary Test: Very Long Note Text (Pass/Fail based on app limit).", "longnote", "SUCCESS_OR_ERROR"},
        };
    }
    
// --------------------------------------------------------------------------------------

    /**
     * Data Provider for Security Candidate tests (Injection, Traversal, Fuzzing).
     */
    @DataProvider(name = "securityCandidateData")
    public Object[][] securityCandidateData() {
        return new Object[][] {
            // ====================================================================================================
            // 🛡️ 4. Security Candidate Data (Vulnerability Testing) - All have 9 elements
            // ====================================================================================================
            // XSS Payloads
            {"<script>alert('XSS')</script>", "<img src=x onerror=alert(1)>", "<svg/onload=alert('XSS')>", "xss@example.com", "1234567890", VALID_PDF_PATH, "Security Test: XSS Payloads.", "XSS,vulnerability", "Input contains restricted HTML/Script"},
            // SQL Injection Payloads
            {"' OR 1=1--", "", "'; DROP TABLE candidates; --", "' OR '1'='1", "9876543210", VALID_PDF_PATH, "Security Test: SQL Injection Payloads.", "SQL,vulnerability", "Input contains restricted characters or commands"},
            // Command Injection / File Path Traversal
            {"John", "", "Doe", "cmdinjection@example.com", "1234567890", "../../../../etc/passwd", "Security Test: File Path Traversal.", "CMDi,file", "Invalid file path or access denied"},
            // Very Large Input (Fuzz Testing)
            {"A".repeat(5000), "", "B".repeat(5000), "longinput@example.com", "1234567890", VALID_PDF_PATH, "Security Test: Very Large Input (Fuzzing).", "fuzz,large", "Input exceeds maximum allowed length"},
            // Unicode in Security Context
            {"O’Connor", "É", "Renée", "unicode@example.com", "+1-555-667788", VALID_PDF_PATH, "Security Test: Unicode in names/email.", "unicode,security", "SUCCESS_OR_ERROR"},
        };
    }
}