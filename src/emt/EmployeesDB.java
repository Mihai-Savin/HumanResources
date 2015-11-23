package emt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 */

/**
 * @author Me
 *
 */
public class EmployeesDB {

	private List<Employee> myE_sList = new ArrayList<Employee>();

	/**
	 * Type used for sorting the database by first name.
	 */
	public static final Comparator<Employee> COMPARE_BY_FIRST_NAME = new Comparator<Employee>() {

		@Override
		public int compare(Employee e1, Employee e2) {
			return ((e1.getFirstName())).compareTo(e2.getFirstName());
		}

		public String toString() {
			return "first name";
		}
	};
	/**
	 * Type used for sorting the database by last name.
	 */
	public static final Comparator<Employee> COMPARE_BY_LAST_NAME = new Comparator<Employee>() {

		@Override
		public int compare(Employee e1, Employee e2) {

			return ((e1.getLastName())).compareTo(e2.getLastName());
		}

		public String toString() {
			return "last name";
		}

	};
	/**
	 * Type used for sorting the database by date of birth.
	 */
	public static final Comparator<Employee> COMPARE_BY_DATE = new Comparator<Employee>() {

		@Override
		public int compare(Employee e1, Employee e2) {

			return ((e1.getDateOfBirth())).compareTo(e2.getDateOfBirth());
		}

		public String toString() {
			return "date of birth";
		}
	};

	/**
	 * Adds a specified employee to the database.
	 * @param aEmployee
	 */
	public void add(Employee aEmployee) {
		myE_sList.add(aEmployee);
		System.out.println("Employee ADDED to DB.");
	}

	/**
	 * Removes a specified employee to the database.
	 * @param aEmployee
	 */
	public void remove(Employee aEmployee) {
		myE_sList.remove(aEmployee);
		System.out.println("Employee REMOVED from DB.");
	}

	/**
	 * Lists all employees currently existing in the database.
	 */
	public void listAllEmployees() {
		System.out.println("Listing database contents (all employees):");
		for (Employee aEmployee : myE_sList) {
			aEmployee.listDetails();
		}
	}

	/**
	 * Orders employees by specified criteria.  
	 * @param comparator
	 */
	public void listBy(Comparator<Employee> comparator) {
		Collections.sort(myE_sList, comparator);
		System.out.println("Database sorted by " + comparator + ".");
		listAllEmployees();
	}

	/**
	 * Returns a list of employees that have a specified age.
	 * @param age
	 * @return a list of employees that have a specified age.
	 */
	public List<Employee> getListOfEmployeesWithAge(int age) {
		List<Employee> aE_sList = new ArrayList<Employee>();
		for (Employee aEmployee : myE_sList) {
			if (aEmployee.getAge() == age) {
				aE_sList.add(aEmployee);
			}
			;
		}
		return aE_sList;
	}

	/**
	 * Lists the employees that have a specified age.
	 * @param age
	 */
	public void listEmployeesWithAge(int age) {
		System.out.println("Employees aged " + age + " :");
		for (Employee aEmployee : getListOfEmployeesWithAge(age)) {
			aEmployee.listDetails();
		}
	}
	
	/**
	 * Returns a list of employees that have a specified name.
	 * @param lastName
	 * @return a list of employees that have a specified name.
	 */
	public List<Employee> getListOfEmployeesWithLastName(String lastName) {
		List<Employee> aE_sList = new ArrayList<Employee>();
		for (Employee aEmployee : myE_sList) {
			if (aEmployee.getLastName() == lastName) {
				aE_sList.add(aEmployee);
			}
			;
		}
		return aE_sList;
	}
	
	/**
	 * Lists the employees that have a specified name.
	 * @param lastName
	 */
	public void listEmployeesWithLastName(String lastName) {
		System.out.println("Employees named '" + lastName + "' :");
		for (Employee aEmployee : getListOfEmployeesWithLastName(lastName)) {
			aEmployee.listDetails();
		}
	}
	
}
