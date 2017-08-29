package labels;

public class GotEm {

	public static void main(String[] args) {
		String[][][] stuff = {
			{
				{ "Daniel Balarezo", "David Burnett", "Dennis Carrasquillo", "Stephen Chiang", "Shaun Dashian",
						"Greg Engler", "Stefan Fuller", "Matt Gmur", "William Odham", "Will Roberts", "Chandan Thakur",
						"Greg Taylor", "Seth Thomas", "Ehren Williamson" },
				{ "George  Washington", "John  Adams", "Thomas  Jefferson", "James  Madison", "James  Monroe",
						"John Quincy Adams", "Andrew  Jackson", "Martin  Van Buren", "William Henry Harrison",
						"John  Tyler", "James Knox Polk", "Zachary  Taylor", "Millard  Fillmore", "Franklin  Pierce",
						"James  Buchanan", "Abraham  Lincoln", "Andrew  Johnson", "Ulysses Simpson Grant",
						"Rutherford Birchard Hayes", "James Abram Garfield", "Chester Alan Arthur", "Grover  Cleveland",
						"Benjamin  Harrison", "William  McKinley", "Theodore  Roosevelt", "William Henry Taft",
						"Woodrow  Wilson", "Warren Gamaliel Harding", "Calvin  Coolidge", "Herbert Clark Hoover",
						"Franklin Delano Roosevelt", "Waldo", "Harry S Truman", "Dwight David Eisenhower",
						"John Fitzgerald Kennedy", "Lyndon Baines Johnson", "Richard Milhous Nixon",
						"Gerald Rudolph Ford", "James Earl Carter", "Ronald Wilson Reagan",
						"George Herbert Walker Bush", "William Jefferson Clinton", "George Walker Bush",
						"Barack Hussein Obama", "Donald John Trump" },
			},
			{
				{ "Cat", "Dog", "Frog", "Giraffe", "Elephant", "Lemur" },
				{ "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware",
						"Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky",
						"Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi",
						"Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico",
						"New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania",
						"Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont",
						"Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming" }
				},
			{
					{"Pizza", "Ice cream","Spam","Eggs","Sausage","Spam"},
					{"Steve","Kris","Rob","Andrew","Aaron","Cole"},
					{"Hello","World","Foo","Bar","Baz","Qux","Quux","Corge","Grault","Garply","Waldo","Fred","Plugh","Xyzzy","Thud"}
					
			}
		};
		
		String searchFor = "Waldo";
		int i=0, j=0, k=0;
		//MAINSEARCH:
		for (i=0; i<stuff.length; i++) {
			for (j=0; j<stuff[i].length; j++) {
				for (k=0; k<stuff[i][j].length; k++) {
					if ( searchFor.equals(stuff[i][j][k]) ) {
						System.out.println("Got em! "+searchFor+" at "+i+" "+j+" "+k);
						//break MAINSEARCH;
					}
				}
			}
		}
		System.out.println(""+i+" "+j+" "+k);

	}

}
