package org.corejavatests.ttinana.inner;

public class Core01InnerClassBinaryName {

	public static class Example {
		public static class Inner1 {
			public static class Inner2 {
			}
		}
	}

	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> cl1 = Class.forName("org.corejavatests.ttinana.inner.Core01InnerClassBinaryName$Example$Inner1$Inner2");
       Class<?> cl2 = Class.forName("org.corejavatests.ttinana.inner.Core01InnerClassBinaryName.Example.Inner1.Inner2");
        System.out.println(cl1.getName());
        System.out.println(cl1.getSimpleName());
        System.out.println(cl1.getCanonicalName());
        System.out.println();
        //System.out.println(cl2.getName());
       // System.out.println(cl2.getSimpleName());
       // System.out.println(cl2.getCanonicalName());

	}

}
