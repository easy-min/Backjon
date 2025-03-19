package week4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준10974모든순열 {
	static int[] arr;
	static boolean nextPermutation() {
		int i = arr.length-1;
		while(i>0 && arr[i-1] > arr[i]) i--;
		if (i==0) return false;
		int j = arr.length-1;
		while(j>0 && arr[j] < arr[i-1]) j--;
		if (j==0) return false;
		swap(i-1, j);
		reverse(i);
		return true;
	}
	
	private static void reverse(int i) {
		int end = arr.length-1;
		while(i<end) {
			swap(i, end);
			i++;
			end--;
		}
	}

	private static void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	static void printArray() {
		for (int i = 0; i<arr.length; i++) {
			System.out.print(arr[i]);
			if (i!=arr.length-1) System.out.print(" ");
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준10974모든순열.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for (int i = 1; i<N+1; i++) {
			arr[i-1] = i;
		}
		printArray();
		while (nextPermutation()) {
			System.out.println();
			printArray();
		}
		

	}

}
