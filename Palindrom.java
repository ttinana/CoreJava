package palindrom;

public class Palindrom {

	public static boolean isItPalindrom(String input) {
		boolean bool = true;

		int len = input.length();
		char[] inputChar = input.toCharArray();

		for (int i = 0; i < len / 2; i++) {
			if (inputChar[i] != inputChar[len - i - 1]) {
				bool = false;
			}
		}
		return bool;
	}

	public static boolean isItPalindromIgnorespace(String input) {
		input = input.replaceAll("\\s+", "");
		boolean bool = true;

		int len = input.length();
		char[] inputChar = input.toCharArray();

		for (int i = 0; i < len / 2; i++) {
			if (inputChar[i] != inputChar[len - i - 1]) {
				bool = false;
			}
		}
		return bool;
	}

	public static boolean isItPalindromIgnorespaceIgnoreCase(String input) {
		input = input.replaceAll("\\s+", "");
		boolean bool = true;

		int len = input.length();
		char[] inputChar = input.toCharArray();

		for (int i = 0; i < len / 2; i++) {
			if (Character.toLowerCase(inputChar[i]) != Character
					.toLowerCase(inputChar[len - i - 1])) {
				bool = false;
			}
		}
		return bool;
	}

	public static boolean isItPalindromRecursive(String input) {
		if (input.length() < 2)
			return true;
		if (input.charAt(0) == input.charAt(input.length() - 1)) {
			return isItPalindromRecursive(input
					.substring(1, input.length() - 1));
		} else
			return false;

	}

	public static void main(String[] args) {
		System.out.println(isItPalindromRecursive(""));
		System.out.println(isItPalindromRecursive("7"));
		System.out.println(isItPalindromRecursive("123321"));
		System.out.println(isItPalindromRecursive("1233218"));
		System.out.println(isItPalindromIgnorespace("12 3321 "));
		System.out.println(isItPalindromIgnorespace("Ana voli Milovana "));
		System.out
				.println(isItPalindromIgnorespaceIgnoreCase("Ana voli Milovana "));

	}
}