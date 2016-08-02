package upwork.corejava.q04.weakreference;

import java.lang.ref.WeakReference;
import java.util.HashMap;

public class TestWeakReference {
	/*
	 * WeakHashMap has only weak references to the keys, not strong references
	 * like other Map classes. There are situations which you have to take care
	 * when the value or key is strongly referenced though you have used
	 * WeakHashMap. This can avoided by wrapping the object in a WeakReference.
	 */

	/*
	 * What is a weak reference?
	 * 
	 * A reference to an object which may have been garbage collected when the
	 * object is asked for.
	 */

	public static void main(String args[]) {
		HashMap<Employee, EmployeeVal> map = new HashMap<Employee, EmployeeVal>();
		WeakReference<HashMap<Employee, EmployeeVal>> aMap = new WeakReference<HashMap<Employee, EmployeeVal>>(
				map);

		map = null;

		while (null != aMap.get()) {
			aMap.get().put(new Employee("Vinoth"),
					new EmployeeVal("Programmer"));
			System.out.println("Size of aMap " + aMap.get().size());
			System.gc();
		}
		System.out.println("Its garbage collected");
	}
}
