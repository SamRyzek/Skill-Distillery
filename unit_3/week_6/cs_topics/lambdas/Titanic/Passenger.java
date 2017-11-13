package titanic;

import java.util.Arrays;

public class Passenger {
	private int cabinClass;
	private boolean survived;
	private String firstName;
	private String lastName;
	private String sex;
	private double age = 999; //default if unknown
	private int siblingsOrSpouses;
	private int parentsOrChildren;
	private String ticketNumber;
	private double fare;
	private String cabin;
	private String embarked; // C = Cherbourg; Q = Queenstown; S = Southampton
	// leaving out boat, body, home.dest fields

	public Passenger(String[] values) {
		cabinClass = Integer.parseInt(values[0]);
		survived = values[1].equals("1");
		firstName = values[3].trim().replace("\"", "");
		lastName = values[2].trim().replace("\"", "");
		sex = values[4];
		if (values[5].length() > 0) {
			age = Double.parseDouble(values[5]);
		}
		siblingsOrSpouses = Integer.parseInt(values[6]);
		parentsOrChildren = Integer.parseInt(values[7]);
		ticketNumber = values[8].trim();
		fare = values[9].length()>0 ? Double.parseDouble(values[9]) : 0.0;
		cabin = values[10];
		switch (values[11]) {
		case "S":
			embarked = "Southampton";
			break;
		case "C":
			embarked = "Cherbourg";
			break;
		case "Q":
			embarked = "Queenstown";
			break;
		default:
			embarked = "";
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(age);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((cabin == null) ? 0 : cabin.hashCode());
		result = prime * result + cabinClass;
		result = prime * result + ((embarked == null) ? 0 : embarked.hashCode());
		temp = Double.doubleToLongBits(fare);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + parentsOrChildren;
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + siblingsOrSpouses;
		result = prime * result + (survived ? 1231 : 1237);
		result = prime * result + ((ticketNumber == null) ? 0 : ticketNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passenger other = (Passenger) obj;
		if (Double.doubleToLongBits(age) != Double.doubleToLongBits(other.age))
			return false;
		if (cabin == null) {
			if (other.cabin != null)
				return false;
		} else if (!cabin.equals(other.cabin))
			return false;
		if (cabinClass != other.cabinClass)
			return false;
		if (embarked == null) {
			if (other.embarked != null)
				return false;
		} else if (!embarked.equals(other.embarked))
			return false;
		if (Double.doubleToLongBits(fare) != Double.doubleToLongBits(other.fare))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (parentsOrChildren != other.parentsOrChildren)
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (siblingsOrSpouses != other.siblingsOrSpouses)
			return false;
		if (survived != other.survived)
			return false;
		if (ticketNumber == null) {
			if (other.ticketNumber != null)
				return false;
		} else if (!ticketNumber.equals(other.ticketNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String c = new String[] {"st", "nd", "rd"}[this.cabinClass - 1];
		String s = this.survived ? "survived" : "perished";
		return String.format("%s %s, age %.1f, %d%s class, %s", firstName, lastName, age, cabinClass, c, s);
	}
	
	public void print(){
		System.out.println(this);
	}
	
	

	public int getCabin() {
		return cabinClass;
	}

	public boolean didSurvive() {
		return survived;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSex() {
		return sex;
	}

	public double getAge() {
		return age;
	}

	public int getSiblingsOrSpouses() {
		return siblingsOrSpouses;
	}

	public int getParentsOrChildren() {
		return parentsOrChildren;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public double getFare() {
		return fare;
	}

	public String getEmbarked() {
		return embarked;
	}

}
