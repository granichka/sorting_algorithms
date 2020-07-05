package local.nix.sorting.algorithms;

public class InsertionSort implements Sort{

	@Override
	public int[] sort(int[] arr) {
		for(int left = 0; left < arr.length; left++) {
			int value = arr[left];
			int i = left-1;
			for(; i>=0; i--) {
				if(value < arr[i]) {
					arr[i+1] = arr[i];
				} else {
					break;
				}
			}
			
			arr[i+1] = value;
		}
		return arr;
	}

}
