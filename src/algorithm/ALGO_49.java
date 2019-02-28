package algorithm;

import java.util.Scanner;

/*
 * 问题描述
　　对于给定整数数组a[],寻找其中最大值，并返回下标。
	输入格式
	　　整数数组a[],数组元素个数小于1等于100。输出数据分作两行：第一行只有一个数，表示数组元素个数；第二行为数组的各个元素。
	输出格式
	　　输出最大值，及其下标
	样例输入

		3
		3 2 1

	样例输出

		3 0
 */
public class ALGO_49 {
//public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int max = 0, maxi = 0;
		max = sc.nextInt();
		for (int i = 1; i < n; ++i) {
			int tmp = sc.nextInt();
			if (max < tmp) {
				max = tmp;
				maxi = i;
			}
		}
		
		System.out.println(max + " " + maxi);
	}

}
