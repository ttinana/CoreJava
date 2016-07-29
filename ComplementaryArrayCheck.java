package palindrom;

public class ComplementaryArrayCheck {
	
	
	// in case that we treat pair (n,m) equal as (m,n)
		// where n and m are indexes of elements ina an array
		public static int[][] complementaryArrayComb(int k, int[] inputArray) {
			int length = inputArray.length;
			//int size = (factorial(length) / (factorial(length - 2) * factorial(2)));
			int[][] res = new int[length][length];

			for (int i = 0; i < length; i++) {
				for (int j = 0; j < length; j++) {
					if (inputArray[i]+ inputArray[j]==k && i != j && i<j) {
						res[i][j] = 1;
					}
				}
			}

			for (int i = 0; i < length; i++) {
				for (int j = 0; j < length; j++) {
					if (res[i][j] == 1) {
						System.out.println("[" + i + "" + j + "]");
					}
				}
			}

			return res;
		}
	
	
	// in case that we treat pair (n,m) not equal as (m,n)
	// where n and m are indexes of elements ina an array
	public static int[][] complementaryArray(int k, int[] inputArray) {
		int length = inputArray.length;
		//int size = (factorial(length) / (factorial(length - 2) * factorial(2)));
		int[][] res = new int[length][length];

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (inputArray[i]+ inputArray[j]==k && i != j) {
					res[i][j] = 1;
				}
			}
		}

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (res[i][j] == 1) {
					System.out.println("[" + i + "" + j + "]");
				}
			}
		}

		return res;
	}

}

