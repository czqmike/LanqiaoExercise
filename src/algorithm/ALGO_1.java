package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ALGO_1 {
//  public class Main {
	/*
	 *  算法训练 区间k大数查询  
	 *  问题描述
		给定一个序列，每次询问序列中第l个数到第r个数中第K大的数是哪个。
		
		输入格式
		第一行包含一个数n，表示序列长度。
		
		第二行包含n个正整数，表示给定的序列。
		
		第三个包含一个正整数m，表示询问个数。
		
		接下来m行，每行三个数l,r,K，表示询问序列从左往右第l个数到第r个数中，从大往小第K大的数是哪个。序列元素从1开始标号。
		
		输出格式
		总共输出m行，每行一个数，表示询问的答案。
		样例输入
		5
		1 2 3 4 5
		2
		1 5 2
		2 3 2
		样例输出
		4
		2
		数据规模与约定
		对于30%的数据，n,m<=100；
		
		对于100%的数据，n,m<=1000；
		
		保证k<=(r-l+1)，序列中的数<=10e+6。
		4 2 3 1
	 */
	
	private static void sortDesc(int[] arr) {
		Arrays.sort(arr);
//		Collections.sort(new ArrayList<Integer>(), Collections.reverseOrder());
		
		int len = arr.length;
		for (int i = 0; i < len / 2; ++i) {
			int temp = arr[i];
			arr[i] = arr[len - 1 - i];
			arr[len - 1 - i] = temp;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0, m = 0;
		int[] arr = new int[1001];
		
		n = sc.nextInt();
		for (int i = 0; i < n; ++i) {
			arr[i] = sc.nextInt();
		}
		
		m = sc.nextInt();
		int l = 0, r = 0, K = 1;
		for (int i = 0; i < m; ++i) {
			l = sc.nextInt();
			r = sc.nextInt();
			K = sc.nextInt();
			int[] temp = Arrays.copyOfRange(arr, l - 1, r);
			
			sortDesc(temp);
			
			System.out.println(Integer.toString(temp[K - 1]));
		}
	}
	
}

