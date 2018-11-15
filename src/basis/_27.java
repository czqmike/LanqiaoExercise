package basis;

import java.io.InputStreamReader;
import java.util.Scanner;

/*
	基础练习 2n皇后问题  
	
	问题描述
	　　给定一个n*n的棋盘，棋盘中有一些位置不能放皇后。现在要向棋盘中放入n个黑皇后和n个白皇后，使任意的两个黑皇后都不在同一行、同一列或同一条对角线上，任意的两个白皇后都不在同一行、同一列或同一条对角线上。问总共有多少种放法？n小于等于8。
	输入格式
	　　输入的第一行为一个整数n，表示棋盘的大小。
	　　接下来n行，每行n个0或1的整数，如果一个整数为1，表示对应的位置可以放皇后，如果一个整数为0，表示对应的位置不可以放皇后。
	输出格式
	　　输出一个整数，表示总共有多少种放法。
	样例输入
	4
	1 1 1 1
	1 1 1 1
	1 1 1 1
	1 1 1 1
	样例输出
	2
	样例输入
	4
	1 0 1 1
	1 1 1 1
	1 1 1 1
	1 1 1 1
	样例输出
	0
 */
public class _27 {
//public class Main {

	static Scanner sc = new Scanner(new InputStreamReader(System.in));
	static char [][] canStep = new char [8][8];
	static int count = 0;
	static int n = 0;
	static boolean[] line1, line2, line3, line4; // line1-4 分别代表在水平,竖直,主对角线方向,副对角线方向是否有黑棋子
	static boolean[] line5, line6, line7, line8; // 同上, 不过代表的是白棋子
	
	private static void displayMap() {
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				System.out.print((Character)canStep[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static boolean canPassW(int i, int j) {
		int disr = i + Math.abs(j - n + 1);	// 到右上角顶点的距离
		int disl = i + j + 1;	// 到左上角顶点的距离
		if (line5[i] || line6[j] || line7[disr] || line8[disl] || canStep[i][j] != '1') {
			return false;
		}
		return true;
	}

	private static void checkWhite(int level) {
		if (level == n) {
//			displayMap();
//			System.out.println();
			count ++ ;
		} else {
			for (int j = 0; j < n; j ++) {
				if (canPassW(level, j)) {
					line5[level] = true;
					line6[j] = true;
					line7[level + Math.abs(j - n + 1)] = true;
					line8[level + j + 1] = true; 
					canStep[level][j] = 'w';

					checkWhite(level + 1);

					line5[level] = false;
					line6[j] = false;
					line7[level + Math.abs(j - n + 1)] = false;
					line8[level + j + 1] = false; 
					canStep[level][j] = '1';
				}
			}
		}
	}

	private static boolean canPassB(int i, int j) {
		int disr = i + Math.abs(j - n + 1);	// 到右上角顶点的距离
		int disl = i + j + 1;	// 到左上角顶点的距离
		if (line1[i] || line2[j] || line3[disr] || line4[disl] || canStep[i][j] != '1') {
			return false;
		}
		return true;
	}

	private static void checkBlack(int level) {
		if (level == n) {
			checkWhite(0);
//			displayMap();
		} else {
			for (int j = 0; j < n; j ++) {
				if (canPassB(level, j)) {
					line1[level] = true;
					line2[j] = true;
					line3[level + Math.abs(j - n + 1)] = true;
					line4[level + j + 1] = true; 
					canStep[level][j] = 'b';

					checkBlack(level + 1);

					line1[level] = false;
					line2[j] = false;
					line3[level + Math.abs(j - n + 1)] = false;
					line4[level + j + 1] = false; 
					canStep[level][j] = '1';
				}
			}
		}
	}

	public static void main(String[] args) {
		n = sc.nextInt();
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < n; j ++) {
				canStep[i][j] = sc.next().charAt(0);
			}
		}
		line1 = new boolean[8]; 
		line2 = new boolean[8];
		line3 = new boolean[17];
		line4 = new boolean[17];
		line5 = new boolean[8];
		line6 = new boolean[8];
		line7 = new boolean[17];
		line8 = new boolean[17];
		
		checkBlack(0);
		
		System.out.println(count);
	}

}
