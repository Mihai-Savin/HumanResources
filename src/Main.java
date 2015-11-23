import java.util.*;

public class Main {

	public static void main(String[] args) {
		handleEmployees();
	}

	private static void handleEmployees() {
		Employee firstEe = new Employee("Mihai", "Savin", "10.07.1982", 'M');
		Employee secondEe = new Employee("Mihai", "Savin", "10.07.1982", 'M');
		Employee thirdEe = new Employee("Mihai", "Savin", "10.07.1982", 'M');
		
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(firstEe);
		employees.add(secondEe);
		employees.add(thirdEe);
		
		
		for (Employee aEmployee : employees ) {
			aEmployee.listDetails();
		}
		
	}

}
