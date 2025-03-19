import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 1부터 N까지의 수로 이루어진 순열이 있다. 이때, 사전순으로 다음에 오는 순열을 구하는 프로그램을 작성하시오.
	사전 순으로 가장 앞서는 순열은 오름차순으로 이루어진 순열이고, 가장 마지막에 오는 순열은 내림차순으로 이루어진 순열이다.
	N = 3인 경우에 사전순으로 순열을 나열하면 다음과 같다.
		1, 2, 3 (오름차순 : 비 내림차순)
		1, 3, 2
		2, 1, 3
		2, 3, 1
		3, 1, 2
		3, 2, 1 (내림차순 : 비 오름차순)
	
	순열 : 순서가 부여된 임의의 집합을 다른 순서로 뒤섞는 연산 
	(1) A[i-1] < A[i] 을 만족하는 가장 큰 I를 찾음 (내림차순을 찾아야함)
	(2) j>=i이면서 A[j] > A[i-1]를 만족하는 가장 큰 J
	(3) A[i-1]과 A[j]를 swap
	(4) A[i]부터 순열을 뒤집음
	
	EX) 7, 2, 3, 6, 5, 4, 1
	(1) 7, 2, 3, (6, 5, 4, 1) -> 왼쪽에서부터 3 < 6이 큼
	(2) 7, 2, (3), 6, 5, (4), 1 -> 오른쪽에서부터 3<4
	(3) 7, 2, (4), 6, 5, (3), 1 -> swap
	(4) 7, 2, 4, ((1, 3, 5, 6)) -> 순열을 뒤집음 
	
 */

/*
 * 순회란
 * (1) i는 length-2부터 시작해서 만약 arr[i-1] > arr[i]일 때 stop. 
 * (2) j는 length-1부터 시작해서 만약 arr[j] > arr[i-1]일 때 stop.
 * (3) swap
 * (4) reverse는 while(start<end) start++ end--;
 */

public class 백준10972다음순열 {
	static int[] arr;
	static boolean nextPermutation() {
		// 표준 알고리즘에서는 "오른쪽"부터 순회하면서 'arr[i-1] < arr[i]'를 만족하는 가장 큰 i를 찾아야 함
		int i = arr.length-1;
		while(i >0 && arr[i-1] >= arr[i]) i--;
		if (i <= 0) return false;
		int changeKey = arr.length-1;
		while(changeKey >0 && arr[i-1] >= arr[changeKey]) changeKey--;
		swap(i-1, changeKey);
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
		System.setIn(new FileInputStream("res/백준10972다음순열.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		String s = br.readLine();
		s.replace(" ", "");
		StringTokenizer st = new StringTokenizer(s);
		for (int i = 0; i < N; i++) {
		    arr[i] = Integer.parseInt(st.nextToken());
		}
		if (!nextPermutation()) System.out.println(-1);
		else System.out.println(Arrays.toString(arr));
		
	}

}
