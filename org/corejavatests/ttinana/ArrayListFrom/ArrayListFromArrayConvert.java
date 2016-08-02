package org.corejavatests.ttinana.ArrayListFrom;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.lang.ArrayUtils;

public class ArrayListFromArrayConvert {
	int[] a = { 1, 2, 3, 4, 5, 6 };

	public static ArrayList<Integer> retutnArrayListFromArray(int[] array) {
		ArrayList<Integer> arrayList = (ArrayList<Integer>) Arrays
				.asList(ArrayUtils.toObject(array));
		return arrayList;

	}
	public synchronized  void  a(){
		
	}

}