package local.nix.sorting.algorithms;

public class SelectionSort implements Sort{

	@Override
	public int[] sort(int[] arr) {
		for (int left = 0; left < arr.length; left++) {
			int minInd = left;
			for (int i = left; i < arr.length; i++) {
				if (arr[i] < arr[minInd]) {
					minInd = i;
				}
			}
			int temp = arr[left];
			arr[left] = arr[minInd];
			arr[minInd] = temp;
		}
		return arr;
	}


}
