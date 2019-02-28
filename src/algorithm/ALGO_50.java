package algorithm;

import java.util.Scanner;

/*
 * 算法训练 Torry的困惑(基本型)  
 * 问题描述
	　　Torry从小喜爱数学。一天，老师告诉他，像2、3、5、7……这样的数叫做质数。Torry突然想到一个问题，前10、100、1000、10000……个质数的乘积是多少呢？他把这个问题告诉老师。老师愣住了，一时回答不出来。于是Torry求助于会编程的你，请你算出前n个质数的乘积。不过，考虑到你才接触编程不久，Torry只要你算出这个数模上50000的值。
	输入格式
	　　仅包含一个正整数n，其中n<=100000。
	输出格式
	　　输出一行，即前n个质数的乘积模50000的值。
	样例输入
		1
	样例输出
		2
 */
public class ALGO_50 {
//public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int size = n * n;
		int[] arr = new int[size + 1];

		// 使用筛法求素数
		for (int i = 2; i * i <= size; ++i) {
			int j = i * 2;
			if (j <= size) {
				for (; j <= size; j += i) {
					arr[j] = -1;
				}
			}
		}
		
		int result = 1;
		int count = 0;
		for (int i = 2; count < n; ++i) {
			if (arr[i] != -1) {
				result *= i;
				result %= 50000;
				++count;
			}
		}
		
		System.out.println(result);
//		for (int item : arr) {
//			System.out.print(item + " ");
//		}
	}

}
