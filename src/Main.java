import java.time.DateTimeException;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		handleEmployees();
	}

	private static void handleEmployees()  {
		Employee firstEe = null;
		Employee secondEe = null;
		Employee thirdEe = null;
		
		try {
			firstEe = new Employee("Mihai", "Savin", "10.07.1982", 'M');
			secondEe = new Employee("Anamaria", "Marcu", "11.06.1988", 'F');
			thirdEe = new Employee("Mihaela", "Savin", "28.07.1990", 'F');

		} catch (VoidNameException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (DateTimeException e1) {
			e1.printStackTrace();
		}
		
		
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(firstEe);
		employees.add(secondEe);
		employees.add(thirdEe);
		
		
		for (Employee aEmployee : employees ) {
			aEmployee.listDetails();
		}
		
		EmployeesDB myDB = new EmployeesDB();
		
		myDB.add(firstEe);
		myDB.add(secondEe);
		myDB.add(thirdEe);
		myDB.add(secondEe);
		myDB.add(thirdEe);
		myDB.add(firstEe);
		
		myDB.listAllEmployees();
		
		myDB.listBy(myDB.COMPARE_BY_FIRST_NAME);
		myDB.remove(thirdEe);
		myDB.listBy(myDB.COMPARE_BY_LAST_NAME);
		myDB.listBy(myDB.COMPARE_BY_DATE);
		
		
	}

}
