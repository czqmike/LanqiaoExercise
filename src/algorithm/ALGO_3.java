package algorithm;

import java.util.Scanner;

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
