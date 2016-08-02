/**
 * 
 */
package org.corejavatests.ttinana.inner;

/**
 * @author ttinana
 * @see <a href=
 *      "https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html">
 *      nested </a>
 *
 */
class OuterClassNestedStatic {
	// static nested class can see static private member of outer class and vice versa
	private static String outerStatic = " static private member of outter Class. ";
	// static nested class can see private (NO STATIC) member of outer class and vice versa
	private String outerNoStatic = " not static public member of outter Class. ";

	private String printInnerNoStatic() {
		OuterClassNestedStatic.InnerClass inner = new OuterClassNestedStatic.InnerClass();
		return ("private non static method of outer class that prints : " + inner.innerNoStatic);
	}
	
	private String printInnerStatic() {
		OuterClassNestedStatic.InnerClass inner = new OuterClassNestedStatic.InnerClass();
		return ("private non static method of outer class that prints : " + inner.innerStatic);
	}

	public static void main(String[] args) {
		System.out.println(" " + OuterClassNestedStatic.class);
		System.out.println(" " + InnerClass.class);
		System.out.println(" ");

		InnerClass.printOuterStatic();
		OuterClassNestedStatic.InnerClass inner = new OuterClassNestedStatic.InnerClass();
		inner.printOuterStatic2();
		
		// ***
		OuterClassNestedStatic outer = new OuterClassNestedStatic();
		System.out.println(outer.printInnerNoStatic());
		System.out.println(outer.printInnerStatic());
		// ***
		System.out.println(
				"Conclusion: in static nested class all private members of inner see private of outer and vice versa.");

	}

	private static class InnerClass {

		private String innerNoStatic = "private non static member of inner class ";
		private static String innerStatic ="private static member of inner class";

		private static void printOuterStatic() {
			System.out.println("private static method of inner that prints A: " + outerStatic);

		}

		private void printOuterStatic2() {
			System.out.println("private non static method of inner class that prints A: " + outerStatic);

		}

	}

}
