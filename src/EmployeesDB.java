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

	public static final Comparator<Employee> COMPARE_BY_FIRST_NAME = new Comparator<Employee>() {

		@Override
		public int compare(Employee e1, Employee e2) {
			return ((e1.getFirstName())).compareTo(e2.getFirstName());
		}
		public String toString() {
			return "first name";
		}
	};
	public static final Comparator<Employee> COMPARE_BY_LAST_NAME = new Comparator<Employee>() {

		@Override
		public int compare(Employee e1, Employee e2) {

			return ((e1.getLastName())).compareTo(e2.getLastName());
		}
		public String toString() {
			return "last name";
		}
		
	};
	public static final Comparator<Employee> COMPARE_BY_DATE = new Comparator<Employee>() {

		@Override
		public int compare(Employee e1, Employee e2) {

			return ((e1.getDateOfBirth())).compareTo(e2.getDateOfBirth());
		}
		public String toString() {
			return "date of birth";
		}
	};

	public void add(Employee aEmployee) {
		myE_sList.add(aEmployee);
		System.out.println("Employee ADDED.");
	}

	public void remove(Employee aEmployee) {
		myE_sList.remove(aEmployee);
		System.out.println("Employee REMOVED.");
	}

	public void listAllEmployees() {
		System.out.println("Listing database contents:");
		for (Employee aEmployee : myE_sList) {
			aEmployee.listDetails();
		}
	}

	public void listBy(Comparator<Employee> comparator) {
		Collections.sort(myE_sList, comparator);
		System.out.println("Database sorted by " + comparator + ".");
		listAllEmployees();
	}
}
