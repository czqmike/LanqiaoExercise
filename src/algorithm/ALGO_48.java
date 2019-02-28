package algorithm;

import java.util.Scanner;

/*
 * 算法训练 关联矩阵  
 * 
	问题描述
	　　有一个n个结点m条边的有向图，请输出他的关联矩阵。
	输入格式
	　　第一行两个整数n、m，表示图中结点和边的数目。n<=100,m<=1000。
	　　接下来m行，每行两个整数a、b，表示图中有(a,b)边。
	　　注意图中可能含有重边，但不会有自环。
	输出格式
	　　输出该图的关联矩阵，注意请勿改变边和结点的顺序。
	样例输入
		5 9
		1 2
		3 1
		1 5
		2 5
		2 3
		2 3
		3 2
		4 3
		5 4
	样例输出
		1 -1 1 0 0 0 0 0 0
		-1 0 0 1 1 1 -1 0 0
		0 1 0 0 -1 -1 1 -1 0
		0 0 0 0 0 0 0 1 -1
		0 0 -1 -1 0 0 0 0 1
 */
public class ALGO_48 {
//public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int point = 0, line = 0;
		point = sc.nextInt(); 
		line = sc.nextInt();
		
		int[][] arr = new int[point][line];
		
		int a = 0, b = 0;
		for (int i = 0; i < line; ++i) {
			a = sc.nextInt();
			b = sc.nextInt();
			arr[a - 1][i] = 1;
			arr[b - 1][i] = -1;
		}
		
		for (int[] tmpa : arr) {
			for (int i = 0; i < tmpa.length; ++i) {
				if (i != 0) {
					System.out.print(" ");
				}
				System.out.print(tmpa[i]);
			}
			System.out.println();
		}
	}
}
