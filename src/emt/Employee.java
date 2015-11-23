package emt;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.naming.directory.InvalidAttributesException;

/**
 * This class holds information about employees and is able to deliver names of
 * employees, current age, and to list all the details of it. Names should not
 * be empty, dates of birth should not be before 1900 and only 18+ years old
 * individuals can be employed.
 * 
 * @author Meehai Savin
 *
 */
public class Employee {
	private static int employeeIDs = 1;
	private int employeeID;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private short gender;
	public static final short MALE = 1, FEMALE = 2, UNDEFINED = 0;

	/**
	 * Constructs an Employee
	 * 
	 * @param firstName
	 * @param lastName
	 * @param dateOfBirth
	 * @param gender
	 * @throws VoidNameException
	 * @throws InvalidAttributesException
	 * @throws DateTimeException
	 */
	public Employee(String firstName, String lastName, String dateOfBirthString, short gender)
			throws VoidNameException, InvalidAttributesException, DateTimeException {
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

		switch (gender) {
		case MALE:
		case FEMALE:
		case UNDEFINED:
			this.gender = gender;
			break;
		default:
			throw new InvalidAttributesException("Gender should be M(ale), F(emale) or U(ndifined)");

		}

		dateOfBirth = dateOfBirthD;
		System.out.println("Employee #" + this.employeeID + " created.");
	}

	/**
	 * Returns first name of employee
	 * 
	 * @return first name of employee
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Returns first name of employee
	 * 
	 * @return first name of employee
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Returns birth date of employee
	 * 
	 * @return birth date of employee
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * I hope this is ok. This method is used for returning the current age of
	 * an Employee. I've got this source code from
	 * http://stackoverflow.com/a/7496073 and adapted a little bit of it to suit
	 * my context.
	 * 
	 * 
	 * This Method is unit tested properly for very different cases , taking
	 * care of Leap Year days difference in a year, and date cases month and
	 * Year boundary cases (12/31/1980, 01/01/1980 etc)
	 **/
	public int getAge() {

		Calendar today = Calendar.getInstance();
		Calendar birthDate = Calendar.getInstance();

		int age = 0;

		birthDate.setTime(dateOfBirth);
		if (birthDate.after(today)) {
			throw new IllegalArgumentException("Can't be born in the future");
		}

		age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

		// If birth date is greater than todays date (after 2 days adjustment of
		// leap year) then decrement age one year
		if ((birthDate.get(Calendar.DAY_OF_YEAR) - today.get(Calendar.DAY_OF_YEAR) > 3)
				|| (birthDate.get(Calendar.MONTH) > today.get(Calendar.MONTH))) {
			age--;

			// If birth date and todays date are of same month and birth day of
			// month is greater than todays day of month then decrement age
		} else if ((birthDate.get(Calendar.MONTH) == today.get(Calendar.MONTH))
				&& (birthDate.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH))) {
			age--;
		}

		return age;
	}

	/**
	 * Lists all relevand details of an employee.
	 */
	public void listDetails() {
		System.out.println(this.toString());

	}

	/**
	 * @return a String human readable format of an Employee object
	 */
	@Override
	public String toString() {
		return "Employee #" + employeeID + "[firstName = " + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", gender=" + gender + "]";
	}

}
