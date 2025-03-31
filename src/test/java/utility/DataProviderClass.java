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

}
