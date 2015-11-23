package emt;

import static emt.Employee.FEMALE;
import static emt.Employee.MALE;
import static emt.Employee.UNDEFINED;

import java.time.DateTimeException;
import javax.naming.directory.InvalidAttributesException;

public class HrManager {

	public void handleEmployees() {
		// Creating some employees to have fun with
		// ----------------------------------------------------

		Employee firstEe = null;
		Employee secondEe = null;
		Employee thirdEe = null;
		Employee fourthEe = null;

		try {
			firstEe = new Employee("Mihai", "Savin", "10.07.1982", MALE);
			secondEe = new Employee("Anamaria", "Marcu", "11.06.1988", FEMALE);
			thirdEe = new Employee("Mihaela", "Savin", "23.11.1990", UNDEFINED);
			fourthEe = new Employee("Corina", "Dragan", "10.05.1992", FEMALE);

		} catch (VoidNameException e) {
			System.out.println("Names cannot be void.");
			e.printStackTrace();
		} catch (DateTimeException e) {
			System.out.println("Employee too old 1900- or 18- years old.");
			e.printStackTrace();
		} catch (InvalidAttributesException e) {
			System.out.println("Must have a gender or UNDEFINED");
			e.printStackTrace();
		}

		// Creating a database and populating it with the employees previously
		// created ------------------------

		EmployeesDB myDB = new EmployeesDB();

		myDB.add(firstEe);
		myDB.add(secondEe);
		myDB.add(thirdEe);
		myDB.add(fourthEe);

		// Listing, sorting, removing, finding by age and last name of employees
		// -------------------------------

		myDB.listAllEmployees();

		myDB.listBy(myDB.COMPARE_BY_FIRST_NAME);
		myDB.remove(thirdEe);
		myDB.listBy(myDB.COMPARE_BY_LAST_NAME);
		myDB.listBy(myDB.COMPARE_BY_DATE);

		System.out.println("Employee (not in DB anymore but still alive) named " + thirdEe.getLastName() + " " + thirdEe.getFirstName() + " is " + thirdEe.getAge() + " years old.");

		myDB.listEmployeesWithAge(33);

		myDB.listEmployeesWithLastName("Savin");

	}
}