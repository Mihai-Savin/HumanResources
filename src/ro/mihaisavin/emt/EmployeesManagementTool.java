package ro.mihaisavin.emt;

/**
 * This application can be used as Employee Management Tool.
 * @author Me
 *
 */
public class EmployeesManagementTool {

	public static void main(String[] args) {
		HrManager someHuResManager = new HrManager();

		someHuResManager.handleEmployees();
	}
}