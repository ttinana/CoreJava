package upwork.corejava.q04.weakreference;

import java.util.WeakHashMap;

/*
 * WeakHashMap has only weak references to the keys, 
 * not strong references like other Map classes. 
 * There are situations which you have to take care 
 * when the value or key is strongly referenced though 
 * you have used WeakHashMap. 
 * This can avoided by wrapping the object in a 
 * WeakReference.
 * */
/*
 * Soft References.

 Soft Reference is slightly stronger that weak reference. 
 Soft reference allows for garbage collection, but begs 
 the garbage collector to clear it only if there is no other option. 

 The garbage collector does not aggressively collect 
 softly reachable objects the way it does with weakly 
 reachable ones -- instead it only collects softly 
 reachable objects if it really "needs" the memory. 
 Soft references are a way of saying to the garbage 
 collector, "As long as memory isn't too tight, 
 I'd like to keep this object around. 
 But if memory gets really tight, go ahead and collect 
 it and I'll deal with that."
  The garbage collector is required to clear all soft 
  references before it can throw OutOfMemoryError.

 * */

public class TestWeakHashMap {

	public static void main(String args[]) {
		WeakHashMap<Employee, EmployeeVal> aMap = new WeakHashMap<Employee, EmployeeVal>();

		Employee emp = new Employee("Vinoth");
		EmployeeVal val = new EmployeeVal("Programmer");

		aMap.put(emp, val);

		emp = null;

		System.gc();
		int count = 0;
		while (0 != aMap.size()) {
			++count;
			System.gc();
		}
		System.out.println("Took " + count
				+ " calls to System.gc() to result in weakHashMap size of : "
				+ aMap.size());
	}
}
