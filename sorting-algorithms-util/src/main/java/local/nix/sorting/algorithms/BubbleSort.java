package local.nix.sorting.algorithms;

public class BubbleSort implements Sort{

	@Override
	public int[] sort(int[] arr) {
			for(int j = 0; j < arr.length; j++) {
				for(int i = 0; i < arr.length-1; i++) {
						if(arr[i] > arr[i+1]) { 
							int temp = arr[i];
							arr[i] = arr[i+1];
							arr[i+1] = temp;
					}
				}
			}
		return arr;
	}

}
