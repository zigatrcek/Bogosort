import java.util.Arrays;
import java.util.Scanner;

public class Bogosort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numOfElements = sc.nextInt();
		int[] arr = new int[numOfElements];
		for (int i = 0; i < numOfElements; i++) {
			arr[i] = sc.nextInt();
		}
		permutate(numOfElements, arr);
	}

	static void permutate(int n, int[] arr) {
		int[] indexes = new int[n];
		for (int i = 0; i < n; i++) {
			indexes[i] = 0;
		}
		System.out.println(Arrays.toString(arr));
		int i = 0;
		while (i < n) {
			boolean isSorted = true;
			for (int j = 1; j < arr.length; j++) {
				if (arr[j - 1] > arr[j]) {
					isSorted = false;
					break;
				}
			}
			if (isSorted) {
				System.out.println("Uspelo mi je!");
				System.out.println(Arrays.toString(arr));
				return;
			}
			if (indexes[i] < i) {
				// if i is divisible by 2, we swap it with the 0th element,
				// otherwise we swap it with the next element in indexes[i]
				swap(arr, i % 2 == 0 ? 0 : indexes[i], i);
				System.out.println(Arrays.toString(arr));
				indexes[i]++;
				i = 0;
			}
			else {
				indexes[i] = 0;
				i++;
			}
		}
	}
	static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
