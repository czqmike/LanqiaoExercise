package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class ALGO_2 {
//public class Main {

	/*
	 *  算法训练 最大最小公倍数  
	 *  
		问题描述

		已知一个正整数N，问从1~N中任选出三个数，他们的最小公倍数最大可以为多少。
		输入格式

		输入一个正整数N。
		输出格式
		输出一个整数，表示你找到的最小公倍数。
		样例输入
		9
		样例输出
		504
		数据规模与约定

		1 <= N <= 106。
	 */

	public static void main(String[] args) {
		long n = new Scanner(System.in).nextInt();
		
		long result = 1;
		if (n % 2 == 1) {
			result = n * (n - 1) * (n - 2);
		} else if (n % 3 == 0) {
			result = (n - 1) * (n - 2) * (n - 3);
		} else {
			result = n * (n - 1) * (n - 3);
		}
		System.out.println(result);
	}
	
	/*
	 * 这道题，首先说明一下，公认的5,8,9,10四个测试数据有错误，详情看论坛。。。

		还有，类型用long long，

		题意很简单，就是求三个互质的数，何为互质？两两最大公约数为1，

		而且，在所有两两互质的数中，肯定值越大乘积越大，因此，可以向这方面做。

		但是，列出几个例子就会发现，这题目是有规律的：

		例1： 1 2 3 4 5 6 （n为6）

		例2： 1 2 3 4 5 6 7（n为7）

		例3： 1 2 3 4 5 6 7 8 （n为8）

		规律：

		①. 当n为奇数时， n*n-1*n-2最大

		②. 当n为偶数时，有两个选择方案，要么选n-1*n-2*n-3 要么选n*n-1*n-3，这两个选择差就差在与3的余数关系，

		这个优先策略很简单，尽量先选最大的，然后往下选，但是，如果你选了最大的以后，比如例1中，选了6，就

		无法选择4也无法选择3，甚至2，所以，这种情况就不能去选择6，只能退一步选择n-1，再讨论
		--------------------- 
		作者：ltree98 
		来源：CSDN 
		原文：https://blog.csdn.net/lttree/article/details/20136051 
		版权声明：本文为博主原创文章，转载请附上博文链接！
	 */
}
