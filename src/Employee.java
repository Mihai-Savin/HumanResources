import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {
	private static int employeeIDs = 1;
	private int employeeID;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private char gender;

	/**
	 * @param firstName
	 * @param lastName
	 * @param dateOfBirth
	 * @param gender
	 * @throws VoidNameException
	 */
	public Employee(String firstName, String lastName, String dateOfBirthString, char gender) throws VoidNameException {
		employeeID = employeeIDs++;
		if (firstName == "" || lastName == "") {
			throw new VoidNameException("Void names are not allowed.");
		}
		this.firstName = firstName;
		this.lastName = lastName;

		SimpleDateFormat simpleDate = new SimpleDateFormat("dd.MM.yyyy");
		Date dateOfBirthD = null;

		try {
			dateOfBirthD = simpleDate.parse(dateOfBirthString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Calendar now = Calendar.getInstance();
		
		Date today = new Date();
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(today);
		gc.add(Calendar.YEAR, -18);
		Date yearsAgo18 = gc.getTime();
		
		Date begining = null;
		today.getTime();
		try {
			begining = simpleDate.parse("01.01.1900");			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (dateOfBirthD.before(begining)) {
			System.out.println("Out of range.");
			throw new DateTimeException("Cannot handle Employees born before 1900.");
		}
		if (dateOfBirthD.after(yearsAgo18)) {
			System.out.println("Too young.");
			throw new DateTimeException("Cannot handle Employees which are still minors (18-).");
		}
		dateOfBirth = dateOfBirthD;
		this.gender = gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void listDetails() {
		System.out.println(this.toString());

	}

	@Override
	public String toString() {
		return "Employee #" + employeeID + "[firstName = " + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", gender=" + gender + "]";
	}

}
