package titanic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.function.Predicate;

public class TitanicUtils {
	public static final String FILE_NAME = "src/titanic/titanic.csv";
	public static ArrayList<Passenger> passengers = new ArrayList<>();
	
	public static void init(){
		try(BufferedReader buf = new BufferedReader(new FileReader(FILE_NAME))){
			String line;
			buf.readLine(); //clear header line
			while ((line = buf.readLine()) != null) {
				String[] values = line.split(",");
				if (values.length > 0) {passengers.add(new Passenger(values));}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	

}
