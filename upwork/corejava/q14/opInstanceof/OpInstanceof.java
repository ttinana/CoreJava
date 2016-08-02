package upwork.corejava.q14.opInstanceof;

public class OpInstanceof {
	public static void main(String[] args) {

		Parent parent = new Parent();
		Parent child = new Child();

		System.out.println("parent instanceof Parent: "
				+ (parent instanceof Parent));
		System.out.println("parent instanceof Child: " + (parent instanceof Child));
		System.out.println("parent instanceof MyInterface: "
				+ (parent instanceof MyInterface));
		System.out.println("child instanceof Parent: "
				+ (child instanceof Parent));
		System.out.println("child instanceof Child: " + (child instanceof Child));
		System.out.println("child instanceof MyInterface: "
				+ (child instanceof MyInterface));
	}

}
