package algorithm;

import java.util.Scanner;

/*
 * 
	问题描述

		如果一个自然数N的K进制表示中任意的相邻的两位都不是相邻的数字，那么我们就说这个数是K好数。求L位K进制数中K好数的数目。例如K = 4，L = 2的时候，所有K好数为11、13、20、22、30、31、33 共7个。由于这个数目很大，请你输出它对1000000007取模后的值。
	输入格式

		输入包含两个正整数，K和L。
	输出格式
		输出一个整数，表示答案对1000000007取模后的值。
	样例输入
		4 2
	样例输出
		7
	数据规模与约定

		对于30%的数据，KL <= 106；

		对于50%的数据，K <= 16， L <= 10；

		对于100%的数据，1 <= K,L <= 100。
 */
public class ALGO_3 {
//public class Main {
	private static int k, l;
	private static int div = 1000000007;
	private static int[][] dp = new int[101][101];
	
	// f(i, j)表示第i位(右起)为j时, 答案的数目, 即sum f(i - 1, x), x 属于 [0, k -1] && x !=  j +- 1;
	private static int f(int i, int j) {
		if (i == 0) {
			return 1;
		} else {
			int sum = 0;
			for (int count = 0; count <= k - 1; ++count) {
				if (count == j + 1 || count == j - 1) {
					continue;
				}
				sum = (sum + f(i - 1, count) ) % div;
			}
			return sum;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		l = sc.nextInt();
		
		for (int j = 0; j < k; ++j) {
			dp[0][j] = 1;
		}
		
		for (int i = 1; i < l; ++i) {
			for (int j = 0; j < k; ++j) {
				int sum = 0;
				for (int cnt = 0; cnt < k; ++cnt) {
					if (cnt == j - 1 || cnt == j + 1) {
						continue;
					}
					sum = (sum + dp[i - 1][cnt]) % div;
				}
				dp[i][j] = ( dp[i][j] + sum ) % div;
			}
		}

		int sum = 0;
		for (int i = 1; i <= k - 1; ++i) {
//			sum = (sum + f(l - 1, i) ) % div ;
			sum = (sum + dp[l - 1][i] ) % div ;
		}
		
		System.out.println(sum);
	}

}
