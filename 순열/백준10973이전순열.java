package week4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 1부터 N까지의 수로 이루어진 순열이 있다. 이때, 사전순으로 바로 이전에 오는 순열을 구하는 프로그램을 작성하시오.
 * 사전 순으로 가장 앞서는 순열은 오름차순으로 이루어진 순열이고, 가장 마지막에 오는 순열은 내림차순으로 이루어진 순열이다.
 * N = 3인 경우에 사전순으로 순열을 나열하면 다음과 같다.
		1, 2, 3
		1, 3, 2
		2, 1, 3
		2, 3, 1
		3, 1, 2
		3, 2, 1
 */

/* 알고리즘
 * (1) i는 오른쪽에서부터 시작. while( arr[i-1] < arr[i] ) i--
 * (2) j는 오른쪽에서부터 시작. while( arr[j] >= arr[i-1]) j--
 * (3) swap
 * (4) 
 */

/*
 * 생각해보자
 * (1) 다음 것 -> i 뒤에서부터 봤을 때 역행 되는 경우! whie(arr[i-1] > arr[i]) 뒤에서부터 봤을 때 순행일 때 그대로 진행~~
 * (2) 이전 것 -> i 뒤에서부터 봤을 때 순행 되는 경우! while(arr[i-1] < arr[i]) 뒤에서부터 봤을 때 역행일 때 그대로 진행~~
 * 
 * 다음 꺼는 순차적으로 진행할 수 있지~~~ (뒤에서부터 순차일 때 pass)
 */

public class 백준10973이전순열 {
	static int[] arr;
	public static boolean previousPermuatation() {
		int i = arr.length-1;
		while(i>0 && arr[i]> arr[i-1]) i--;
		if (i==0) return false;
		int j = arr.length-1;
		while(j>0 && arr[j] >= arr[i-1]) j--;
		if (j==0) return false;
		swap(i-1, j);
		reverse(i);
		return true;
	}
	static void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	static void reverse(int start) {
		int end = arr.length-1;
		while (start < end) {
			swap(start, end);
			start++;
			end--;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준10973이전순열.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		String s = br.readLine();
		s.replace(" ", "");
		StringTokenizer st = new StringTokenizer(s);
		for (int i = 0; i < N; i++) {
		    arr[i] = Integer.parseInt(st.nextToken());
		}
		if (!previousPermuatation()) System.out.println(-1);
		else {
			for (int i = 0; i<arr.length; i++) {
				System.out.print(arr[i]+" ");
			}
		}

	}

}
