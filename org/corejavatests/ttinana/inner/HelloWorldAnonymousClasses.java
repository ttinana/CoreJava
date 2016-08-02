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

