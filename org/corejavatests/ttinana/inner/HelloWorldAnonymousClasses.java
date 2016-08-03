package org.corejavatests.ttinana.inner;

/*
 * First to get the terms right:

    A nested class is a class which is contained in another class at the source code level.
    It is static if you declare it with the static modifier.
    A non-static nested class is called inner class. (I stay with non-static nested class.)

The actual question is: What is the purpose of declaring a nested class static or not?

You use static nested classes if you just want to keep your classes together if they belong 
topically together or if the nested class is exclusively used in the enclosing class. 
There is no semantic difference between a static nested class and every other class.

Non-static nested classes are a different beast. Similar to anonymous inner classes, 
such nested classes are actually closures. That means they capture their surrounding 
scope and their enclosing instance and make that accessible.
 * 
 * 
 * */


/**
@see <a href= https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html"> nested </a>
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


public class HelloWorldAnonymousClasses {

	interface HelloWorld {
		public void greet();

		public void greetSomeone(String someone);
	}

	public void sayHello() {

		class EnglishGreeting implements HelloWorld {
			String name = "world";

			public void greet() {
				greetSomeone("world");
			}

			public void greetSomeone(String someone) {
				name = someone;
				System.out.println("Hello " + name);
			}
		}

		HelloWorld englishGreeting = new EnglishGreeting();

		HelloWorld frenchGreeting = new HelloWorld() {
			String name = "tout le monde";

			public void greet() {
				greetSomeone("tout le monde");
			}

			public void greetSomeone(String someone) {
				name = someone;
				System.out.println("Salut " + name);
			}
		};

		HelloWorld spanishGreeting = new HelloWorld() {
			String name = "mundo";

			public void greet() {
				greetSomeone("mundo");
			}

			public void greetSomeone(String someone) {
				name = someone;
				System.out.println("Hola, " + name);
			}
		};
		englishGreeting.greet();
		frenchGreeting.greetSomeone("Fred");
		spanishGreeting.greet();
	}

	public static void main(String... args) {
		HelloWorldAnonymousClasses myApp = new HelloWorldAnonymousClasses();
		myApp.sayHello();
	}
}

