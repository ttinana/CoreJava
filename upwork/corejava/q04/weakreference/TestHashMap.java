package upwork.corejava.q04.weakreference;

import java.util.HashMap;

public class TestHashMap {

	public static void main(String args[]) {
		/*
		 * http://stackoverflow.com/questions/299659/what-is-the-difference-between
		 * -a-soft-reference-and-a-weak-reference-in-java
		 */
		/*
		 * Now, during the execution of the program we have made emp = null. The
		 * Map holding the key makes no sense here as it is null. In the above
		 * situation, the object is not garbage collected.
		 */
		HashMap<Employee, EmployeeVal> aMap = new HashMap<Employee, EmployeeVal>();

		Employee emp = new Employee("Vinoth");
		EmployeeVal val = new EmployeeVal("Programmer");

		aMap.put(emp, val);

		emp = null;

		System.gc();
		System.out.println("Size of Map" + aMap.size());

	}
}
