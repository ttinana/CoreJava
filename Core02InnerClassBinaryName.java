package org.corejavatests.ttinana.inner;

public class Core02InnerClassBinaryName {

	public Object getObject1() {
		class Thing {
			public String toString() {
				return "I am a Thing";
			}
		}
		return new Thing();
	}

	public Object getObject2() {
		class Thing {
			public String toString() {
				return "I am another Thing";
			}
		}
		return new Thing();
	}

	public Object getObject3() {
		class Thing {
			public String toString() {
				return "I am a rather different Thing";
			}
		}
		return new Thing();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Core02InnerClassBinaryName test = new Core02InnerClassBinaryName();
		Object[] objects = new Object[] { test.getObject1(), test.getObject2(), test.getObject3() };

		for (Object o : objects) {
			System.out.println("Object      : " + o);
			System.out.println("Simple Name : " + o.getClass().getSimpleName());
			System.out.println("Name        : " + o.getClass().getName());
		}
	}
}
