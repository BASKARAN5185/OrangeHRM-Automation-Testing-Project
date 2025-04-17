package utility;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	@DataProvider(name="UserLogin")
	public Object[][] userdata(){
		
		return new Object [][] {
			{"user1", "pass123"},
	        {"john_doe", "jd2023"},
	        {"alice.smith", "alice99"},
	        {"bob_jones", "bobby$1"},
	        {"emma.watson", "emma#456"},
	        {"mike92", "mikePass!"},
	        {"sarah.connor", "terminator2"},
	        {"david.lee", "david$2023"},
	        {"linda_k", "linda789"},
	        {"peter.parker", "spider22"},
	        {"jessica.m", "jess#123"},
	        {"tom_hardy", "tommy$99"},
	        {"kate.brown", "kate2023!"},
	        {"chris.evans", "captain$1"},
	        {"laura.miller", "lauraPass"},
	        {"ryan_g", "ryan#789"},
	        {"olivia.p", "olive2023"},
	        {"mark.twain", "mark$123"},
	        {"sophia.l", "sophia99"},
	        {"james.bond", "007pass"},
	        {"anna.white", "anna#456"},
	        {"will.smith", "will2023$"},
	        {"emily rose", "emily!12"},
	        {"nick_j", "nickpass3"},
	        {"rachel.k", "rach2023"},
	        {"samuel.l", "sam$456"},
	        {"grace.hopper", "grace#99"},
	        {"tony.stark", "ironman1"},
	        {"lisa.marie", "lisa2023!"},
	        {"patrick.s", "pat$123"},
	        {"julia.roberts", "julia99#"},
	        {"kevin.hart", "kevin$23"},
	        {"mary.jane", "maryPass1"},
	        {"leo.dicaprio", "leo2023"},
	        {"nancy.w", "nancy#789"},
	        {"george.c", "george$12"},
	        {"hannah.m", "hannah99"},
	        {"brad.pitt", "brad#2023"},
	        {"clara.b", "claraPass$"},
	        {"ethan.hunt", "mission1"},
	        {"zoe.saldana", "zoe2023!"},
	        {"victor.k", "vic$456"},
	        {"mia.wallace", "mia#123"},
	        {"oscar.w", "oscar99$"},
	        {"luke.sky", "force2023"},
	        {"ella.fitz", "ellaPass"},
	        {"ian.malcolm", "ian#789"},
	        {"tina.fey", "tina$123"},
	        {"harry.p", "potter99"},
	        {"diana.prince", "wonder2023"},
	        {"Admin","admin123"}
			
		};
		
	}
	
	@DataProvider(name = "employeeDataProvider")
	public Object[][] getEmployeeData() {
	    return new Object[][] {
	        { "Sanjay", "", "S", "5", "Sanja S", "Sanjay123", "Sanjay123", "Disabled" },
	        { "John", "D", "Doe", "10", "John D", "John12345", "John12345", "Disabled" },
	        { "", "A", "Smith", "15", "A Smith", "Smith123", "Smith123", "Disabled" },
	        { "Alice", "Marie", "O'Connor", "20", "Alice M O'Connor", "Alice@123", "Alice@123", "Disabled" },
	        { "12345", "", "Johnson", "25", "12345 Johnson", "Johnson@456", "Johnson@456", "Disabled" },
	        { "Mark", "", "Taylor", "30", "Mark T", "Mark123", "", "Disabled" },
	        { "David", "K", "King", "35", "David K", "King1234", "King1234", "Disabled" },
	        { "Emma", "Grace", "Watson", "40", "Emma Grace Watson", "Emma@2021", "Emma@2021", "Disabled" },
	        { "AlexanderTheGreat", "", "Johnson", "45", "AlexanderTheGreat Johnson", "Alex@123", "Alex@123", "Disabled" },
	        { "TOM", "JACK", "SMITH", "50", "TOM JACK SMITH", "Tom@2021", "Tom@2021", "Disabled" },
	        { "A", "B", "C", "55", "A B C", "A@123", "A@123", "Disabled" },
	        { "Sophia", "", "Jones", "60", "Sophia J", "123", "123", "Disabled" },
	        { "  Michael  ", "  David  ", "  Taylor  ", "65", "  Michael David Taylor  ", "Michael123", "Michael123", "Disabled" },
	        { "Sophie", "", "O'Reilly", "70", "Sophie O'Reilly", "Sophie@123", "Sophie@123", "Disabled" },
	        { "Liam", "", "Brown", "ABC123", "Liam Brown", "Liam@2022", "Liam@2022", "Disabled" },
	        { "Charlotte", "Eve", "Wilson", "75", "Charlotte Eve Wilson", "Charlie@2023", "Charlie@2023", "Disabled" },
	        { "Z", "X", "Y", "80", "Z X Y", "Zxy@123", "Zxy@123", "Disabled" },
	        { "Alice   ", "Marie", "O'Connor", "85", "Alice Marie O'Connor", "Alice123", "Alice123", "Disabled" },
	        { "John", "Paul", "Jackson", "9876543210", "John Paul Jackson", "John12345", "John12345", "Disabled" },
	        { "José", "Carlos", "Méndez", "90", "José Carlos Méndez", "Jose@123", "Jose@123", "Disabled" }
	    };
	}

	
	

}
