
public class Employee {
	private static int employeeIDs = 1;
	private int employeeID;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private char gender;
	/**
	 * @param firstName
	 * @param lastName
	 * @param dateOfBirth
	 * @param gender
	 */
	public Employee(String firstName, String lastName, String dateOfBirth, char gender) {
		employeeID = employeeIDs++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}
	public void listDetails() {
		System.out.println(this.toString());
		
	}
	@Override
	public String toString() {
		return "Employee #" + employeeID + "[firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + "]";
	}
	
	

}
