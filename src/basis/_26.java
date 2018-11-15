package basis;

import java.util.Scanner;

/*
 * 
 * 基础练习 报时助手  
	问题描述
	　　给定当前的时间，请用英文的读法将它读出来。
	　　时间用时h和分m表示，在英文的读法中，读一个时间的方法是：
	　　如果m为0，则将时读出来，然后加上“o'clock”，如3:00读作“three o'clock”。
	　　如果m不为0，则将时读出来，然后将分读出来，如5:30读作“five thirty”。
	　　时和分的读法使用的是英文数字的读法，其中0~20读作：
	　　0:zero, 1: one, 2:two, 3:three, 4:four, 5:five, 6:six, 7:seven, 8:eight, 9:nine, 10:ten, 11:eleven, 12:twelve, 13:thirteen, 14:fourteen, 15:fifteen, 16:sixteen, 17:seventeen, 18:eighteen, 19:nineteen, 20:twenty。
	　　30读作thirty，40读作forty，50读作fifty。
	　　对于大于20小于60的数字，首先读整十的数，然后再加上个位数。如31首先读30再加1的读法，读作“thirty one”。
	　　按上面的规则21:54读作“twenty one fifty four”，9:07读作“nine seven”，0:15读作“zero fifteen”。
	输入格式
	　　输入包含两个非负整数h和m，表示时间的时和分。非零的数字前没有前导0。h小于24，m小于60。
	输出格式
	　　输出时间时刻的英文。
	样例输入
		0 15
	样例输出
		zero fifteen
 */
//public class Main {
public class _26 {
	public static void main(String[] args) {
		String[] english = new String[61];
		english[0] = "zero";
		english[1] = "one";
		english[2] = "two";
		english[3] = "three";
		english[4] = "four";
		english[5] = "five";
		english[6] = "six";
		english[7] = "seven";
		english[8] = "eight";
		english[9] = "nine";
		english[10] = "ten";
		english[11] = "eleven";
		english[12] = "twelve";
		english[13] = "thirteen";
		english[14] = "fourteen";
		english[15] = "fifteen";
		english[16] = "sixteen";
		english[17] = "seventeen";
		english[18] = "eighteen";
		english[19] = "nineteen";
		english[20] = "twenty";
		english[30] = "thirty";
		english[40] = "forty";
		english[50] = "fifty";
		Scanner sc = new Scanner(System.in);
		int h = 0, m = 0;
		h = sc.nextInt();
		m = sc.nextInt();
		
		String minute = "", hour = "";
		
		if (h > 20) {
			hour = english[20] + ( (h - 20 > 0) ? " " + english[h - 20] : "");
		} else {
			hour = english[h];
		}

		if (m == 0) {
			minute = "o'clock";
		} else if (m > 20 && m < 60) {
			minute += english[m - m % 10];
			m %= 10;
			minute += (m > 0 ? " " + english[m] : "");
		} else {
			minute = english[m];
		}
		System.out.printf(hour + " " + minute);
	}
}














