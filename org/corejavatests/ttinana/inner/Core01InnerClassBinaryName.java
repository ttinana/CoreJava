package org.corejavatests.ttinana.inner;
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

import java.util.HashSet;
import java.util.Set;

public class Core01InnerClassBinaryName {

	public static class Example {
		public static class Inner1 {
			public static class Inner2 {
			}
		}
	}

	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> cl1 = Class.forName("org.corejavatests.ttinana.inner.Core01InnerClassBinaryName$Example$Inner1$Inner2");
		//Class<?> cl2 = Class.forName("org.corejavatests.ttinana.inner.Core01InnerClassBinaryName.Example.Inner1.Inner2");
        System.out.println(cl1.getName());
        System.out.println(cl1.getSimpleName());
        System.out.println(cl1.getCanonicalName());
        System.out.println();
        //System.out.println(cl2.getName());
       // System.out.println(cl2.getSimpleName());
       // System.out.println(cl2.getCanonicalName());

	}
	
	/**
	 * Returns the single class at the specified canonical name, or throws a {@link java.lang.ClassNotFoundException}.
	 *
	 * <p>Read about the issues of fully-qualified class paths vs the canonical name string
	 * <a href="http://stackoverflow.com/questions/13331902/how-to-get-the-binary-name-of-a-java-class-if-one-has-only-the-fully-qualified">discussed here</a>.
	 * 
	 * http://stackoverflow.com/questions/13331902/how-to-get-the-binary-name-of-a-java-class-if-one-has-only-the-fully-qualified
	 */
	public static <TStaticallyNeeded> Class<TStaticallyNeeded> classForCanonicalName(String canonicalName)
	        throws ClassNotFoundException {

	    if (canonicalName == null) { throw new IllegalArgumentException("canonicalName"); }

	    int lastDotIndex = canonicalName.length();
	    boolean hasMoreDots = true;

	    String attemptedClassName = canonicalName;

	    Set<Class> resolvedClasses = new HashSet<>();

	    while (hasMoreDots) try {
	        Class resolvedClass = Class.forName(attemptedClassName);
	        resolvedClasses.add(resolvedClass);
	    }
	    catch (ClassNotFoundException e) {
	        continue;
	    }
	    finally {
	        if(hasMoreDots){
	            lastDotIndex = attemptedClassName.lastIndexOf('.');
	            attemptedClassName = new StringBuilder(attemptedClassName)
	                    .replace(lastDotIndex, lastDotIndex + 1, "$")
	                    .toString();
	            hasMoreDots = attemptedClassName.contains(".");
	        }
	    }

	    if (resolvedClasses.isEmpty()) {
	        throw new ClassNotFoundException(canonicalName);
	    }

	    if (resolvedClasses.size() >= 2) {
	        StringBuilder builder = new StringBuilder();
	        for (Class clazz : resolvedClasses) {
	            builder.append("'").append(clazz.getName()).append("'");
	            builder.append(" in ");
	            builder.append("'").append(
	                    clazz.getProtectionDomain().getCodeSource() != null
	                            ? clazz.getProtectionDomain().getCodeSource().getLocation()
	                            : "<unknown code source>"
	            ).append("'");
	            builder.append(System.lineSeparator());
	        }

	        builder.replace(builder.length() - System.lineSeparator().length(), builder.length(), "");

	        throw new ClassNotFoundException(
	                "found multiple classes with the same canonical names:" + System.lineSeparator() +
	                        builder.toString()
	        );
	    }

	    return resolvedClasses.iterator().next();
	}

}
