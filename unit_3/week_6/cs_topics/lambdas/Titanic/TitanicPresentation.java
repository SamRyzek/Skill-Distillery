package titanic;

import java.util.ArrayList;

public class TitanicPresentation {
	public static ArrayList<Passenger> passengers;

	public static void main(String[] args) {

		//so why lambdas?
		//we already have all the tools we need to work with data structures, right?
		//alright, smarty pants... here's your assignment then.
		
		TitanicUtils.init(); 
		passengers = TitanicUtils.passengers; 
		
		//the ArrayList "passengers" now contains 1,309 entries representing the names
		//and some possibly important data about all of the recorded passengers who were 
		//on board the RMS Titanic at the time of her sinking in 1912. 
		
		//Your job? Write code to find the following information. Use lambdas
		//only if you want to. (evil snicker)
		
		
		//Each passenger has the following methods:
			//public int getCabin()         		 -cabin class 1, 2, or 3
			//public boolean didSurvive()        -true or false
			//public String getFirstName() 
		    //public String getLastName() 
			//public String getSex()             -"male" or "female"
			//public double getAge()             -sometimes fractional. 999 if unknown
			//public int getSiblingsOrSpouses()  -number of siblings or spouse(s?) they were travelling with
			//public int getParentsOrChildren()  -number of parents or children they were travelling with
			//public String getTicketNumber()    -a String showing their ticket number (combo of numbers and letters)
			//public String getEmbarked()		 -the port they boarded from: "Southampton", "Cherbourg", or "Queenstown"
	
		
		
		
		
		
		//Let's start with some easy ones!	
		//1) find out whether a "Miss Alice Cleaver" survived the accident.
		System.out.printf("Miss Alice Cleaver: %s", "Unknown");
		
		
		
		
		
		//2) there were six 52-year-olds on board, however, only one embarked from Cherbourg. What was his or her
		//name? Did he or she survive?
		System.out.printf("%s %s survived?: %s\n", "Unk", "Unk", "Unk");
		
		
		
		
		
		//3) find the number of adult men, adult women, and minor children in the passenger list and print to console.
		System.out.printf("Men: %d\tWomen:%d\tChildren:%d\n", 0, 0, 0);
		
		
		
		
		
		
		//4) Who was the youngest survivor? Who was the oldest casualty? (remember that unknown ages are 999)
		System.out.printf("Youngest survivor: %s %s, %.1f years old\n", "Unk", "Unk", 0.0);
		System.out.printf("Oldest casualty: %s %s, %.1f years old\n", "Unk", "Unk", 0.0);
		
		
		
		
		//Do you still think you can get away without lambdas by writing methods
		//and/or inner classes? Then try the next batch!
		
		//5) Calculate the overall survival odds for all passengers, as well as
		//   for each of the following demographics:
			//a) All adult women
			//b) All adult men
			//c) All minor children
			//d) All first class
			//e) All second class
			//f) All third class
			//g) Minor female children in first class with 2 or more of any relative
			//h) Adult men in third class with no relatives
			//i) Anyone who embarked from Southampton and whose fare was over 10 pounds
			//j) Anyone whose ticket number included the substring "13"
			//k) Anyone with the word "sink" in their name (case insensitive)
			
		
		System.out.printf("Survival rate (overall): %.1f\n", 0.0);
		System.out.printf("Survival rate (adult women): %.1f\n", 0.0);
		System.out.printf("Survival rate (minor children): %.1f\n", 0.0);
		System.out.printf("Survival rate (1st class): %.1f\n", 0.0);
		System.out.printf("Survival rate (2nd class): %.1f\n", 0.0);
		System.out.printf("Survival rate (3rd class): %.1f\n", 0.0);
		System.out.printf("Survival rate (minor females in 1st class, >2 relatives): %.1f\n", 0.0);
		System.out.printf("Survival rate (men in 3rd class, no relatives): %.1f\n", 0.0);
		System.out.printf("Survival rate (Southampton, paid >10#): %.1f\n", 0.0);
		System.out.printf("Survival rate (ticket with \"13\"): %.1f\n", 0.0);
		System.out.printf("Survival rate (name includes \"sink\"): %.1f\n", 0.0);
		
		

	}
}
