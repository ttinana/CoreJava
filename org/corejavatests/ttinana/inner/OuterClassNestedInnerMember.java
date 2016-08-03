/**
 * 
 */
package org.corejavatests.ttinana.inner;

/**
 * @author ttinana
 * 
 *  * @see <a href=
 *      "https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html">
 *      nested </a>
 *
 */

/**
 * Serialization

Serialization of inner classes, including local and anonymous classes, 
is strongly discouraged. When the Java compiler compiles certain constructs, 
such as inner classes, it creates synthetic constructs; these are classes, 
methods, fields, and other constructs that do not have a corresponding 
construct in the source code. Synthetic constructs enable Java compilers to 
implement new Java language features without changes to the JVM. However, 
synthetic constructs can vary among different Java compiler implementations, 
which means that .class files can vary among different implementations as well. 
Consequently, you may have compatibility issues if you serialize an inner class 
and then deserialize it with a different JRE implementation. 
See the section Implicit and Synthetic Parameters in the section Obtaining 
Names of Method Parameters 
for more information about the synthetic constructs generated when an inner 
class is compiled.
 */
class OuterClassNestedInnerMember {
	private String outerNoStatic ="outerNoStatic";
	private String outerStatic = "outerStatic";
	public static void main(String args[]) {
	//An instance of InnerClass can exist only within an instance of OuterClass 
	// and has direct access to the methods and fields of its enclosing instance.
	OuterClassNestedInnerMember oco = new OuterClassNestedInnerMember();
	
	OuterClassNestedInnerMember.InnerClass innerObject = oco.new InnerClass();
	System.out.println(innerObject.innerNoStatic);
	System.out.println(innerObject.printOuterNoStaticFromInnerClass());
	System.out.println("inner (therefore NO static class can not have static member or method)");
	}
	class InnerClass {
		private String innerNoStatic ="innerNoStatic";

		private String printOuterNoStaticFromInnerClass(){
			OuterClassNestedInnerMember oco = new OuterClassNestedInnerMember();
			return oco.outerNoStatic;
		}
		
		/*  
		 * static members or methods can only be declared in a static or top level type
		 * 
		 * inner static member can not exist inside inner no static class!!!
		 because inner class can only exist as instance of outer
		 thus below returns compile error:
		 private static String innerStatic ="innerNoStatic";*/
		
		
		
	}

}
