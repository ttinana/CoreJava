/**
 * 
 */
package org.corejavatests.ttinana.inner;

/**
 * @author ttinana
 *
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
