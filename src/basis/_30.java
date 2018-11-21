package basis;

import java.math.BigInteger;
import java.util.Scanner;

public class _30 {
//public class Main {
	/*
	 * 基础练习 阶乘计算  
	 * 
		问题描述
		　　输入一个正整数n，输出n!的值。
		　　其中n!=1*2*3*…*n。
		算法描述
		　　n!可能很大，而计算机能表示的整数范围有限，需要使用高精度计算的方法。使用一个数组A来表示一个大整数a，A[0]表示a的个位，A[1]表示a的十位，依次类推。
		　　将a乘以一个整数k变为将数组A的每一个元素都乘以k，请注意处理相应的进位。
		　　首先将a设为1，然后乘2，乘3，当乘到n时，即得到了n!的值。
		输入格式
		　　输入包含一个正整数n，n<=1000。
		输出格式
		　　输出n!的准确值。
		样例输入
			10
		样例输出
			3628800
	 */
	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String n = "";
//		n = sc.next();
//		System.out.print(f(new BigInteger(n)));
//		
//	}
//	
//	private static BigInteger f(BigInteger n) {
//		if (n.equals(BigInteger.ONE)) {
//			return n;
//		} else {
//			return n.multiply(f(n.subtract(BigInteger.ONE)));
//		}
//	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		final int N = 3000;
		int[] arr = new int[N];
		arr[0] = 1;
		
		for (int i = 2; i <= n; ++i) {
			int up = 0;
			for (int j = 0; j < N; ++j) {
				int sum = 0;
				sum = arr[j] * i + up;
				arr[j] = sum % 10;
				up = sum / 10;
			}
		}
		
		boolean meet_not_zero = false;
		for (int i = N - 1; i >= 0; --i) {
			if (arr[i] == 0 && !meet_not_zero) {
				continue;
			}
			meet_not_zero = true;
			System.out.print(arr[i]);
		}
		
//		for (int i = 0; i < N; ++i) {
//			System.out.print(arr[i]);
//		}
	}
	
	
	
	
	
	
	
	
}
