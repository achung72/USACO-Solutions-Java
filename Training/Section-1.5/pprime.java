/*
ID: alanchu4
LANG: JAVA
TASK: pprime
*/

import java.io.*;
import java.util.*;
public class pprime {
	static int lowBound;
	static int highBound;
	static int[] allPalin;
	static int count;
	
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		BufferedReader b = new BufferedReader(new FileReader("pprime.in"));
		PrintWriter p = new PrintWriter(new FileWriter("pprime.out"));
		
		count = 0;
		StringTokenizer st = new StringTokenizer(b.readLine());
		lowBound = Integer.parseInt(st.nextToken());
		highBound = Integer.parseInt(st.nextToken());
		
		allPalin = new int[4500];
		
		generate1();
		generate3();
		generate5();
		generate7();
		
		/*for (int i = 0; i < allPalin.length; i++)
			if (allPalin[i] == 0) {
				System.out.println(i);
				break;
			}
		*/
		
		for(int i = 0; i < allPalin.length;i++) {
			int x = allPalin[i];
			if (checkPrime(allPalin[i]) && x >= lowBound && x<= highBound)
				p.println(x);
		}
		
		
		
		p.close();
		b.close();
		long endTime = System.currentTimeMillis();
		System.out.println("Time elapsed: " + (startTime-endTime));
	}
	
	public static void generate1() {
		allPalin[count] = 5;
		count++;
		allPalin[count] = 7;
		count++;
	}
	
	public static void generate3() {
		allPalin[count] = 11;
		count++;
		for(int i = 1; i <= 9; i+=2) {
			if (i == 5)
				continue;
			for (int j = 0; j <= 9; j++) {
				allPalin[count] = 100*i + 10*j + i;
				count++;
			}
		}
	}
	
	public static void generate5() {
		for(int i = 1; i <= 9; i+=2) {
			if (i == 5)
				continue;
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k <= 9; k++) {
					allPalin[count] = 10000*i+1000*j+100*k+10*j+i;
					count++;
				}
			}
		}
	}
	
	public static void generate7() {
		for(int i = 1; i <= 9; i+=2) {
			if (i == 5)
				continue;
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k <= 9; k++) {
					for(int a = 0; a <= 9; a++) {
						allPalin[count] = 1000000*i+100000*j+10000*k+1000*a+100*k+10*j+i;
						count++;
					}
				}
			}
		}
	}
	
	public static boolean checkPrime(int a) {
		for(int i = 3; i <= Math.sqrt(a);i = i +2) {
			if (a % i == 0)
				return false;
		}
			
		return true;
	}
	
	
	
	
}
