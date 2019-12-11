import java.util.Arrays;
import java.util.Scanner;

public class Bogosort {
	static boolean isSorted = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int stElementov = sc.nextInt();
		int[] arr = new int[stElementov];
		for (int i = 0; i < stElementov; i++) {
			arr[i] = sc.nextInt();
		}
		permutate(stElementov, arr);
	}
	
	static void permutate(int n, int[] arr) {
		if (isSorted) return;
		boolean jeSortirana = true;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] > arr[i]) {
				jeSortirana = false;
				break;
			}
		}
		if (jeSortirana) {
			System.out.println("Uspelo mi je!");
			System.out.println(Arrays.toString(arr));
			isSorted = true;
			return;
		}
		if (n == 1) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		for (int i = 0; i < n - 1; i++) {
			permutate(n - 1, arr);
			if (n % 2 == 0) {
				swap(arr, i, n - 1);
			}
			else {
				swap(arr, 0, n - 1);
			}
		}
		permutate(n - 1, arr);
	}
	static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
		