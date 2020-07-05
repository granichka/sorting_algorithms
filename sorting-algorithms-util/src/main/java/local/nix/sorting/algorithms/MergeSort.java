package local.nix.sorting.algorithms;

import java.util.Arrays;

public class MergeSort implements Sort{

	@Override
	public int[] sort(int[] arr) {
		return mergeSort(arr, 0, arr.length-1);
	}

	private static int[] mergeSort(int[] arr, int left, int right) {
		if (right > left) { 
	    int mid = left + (right - left) / 2;
	    mergeSort(arr, left, mid);
	    mergeSort(arr, mid + 1, right);

	    int[] buf = Arrays.copyOf(arr, arr.length);

	    for (int k = left; k <= right; k++)
	        buf[k] = arr[k];

	    int i = left, j = mid + 1;
	    for (int k = left; k <= right; k++) {

	        if (i > mid) {
	        	arr[k] = buf[j];
	            j++;
	        } else if (j > right) {
	        	arr[k] = buf[i];
	            i++;
	        } else if (buf[j] < buf[i]) {
	        	arr[k] = buf[j];
	            j++;
	        } else {
	        	arr[k] = buf[i];
	            i++;
	        	}
	    	}
		}
		
		return arr;
	}
}
