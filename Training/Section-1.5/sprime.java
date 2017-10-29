/*
ID: alanchu4
LANG: JAVA
TASK: sprime
*/

import java.io.*;
import java.util.*;
public class sprime {
	static int[][] primeRibs;
	static int N;
	
	public static void main(String[] args) throws IOException {
		// Reads input
		long startTime = System.currentTimeMillis();
		BufferedReader b = new BufferedReader(new FileReader("sprime.in"));
		PrintWriter p = new PrintWriter(new FileWriter("sprime.out"));
		String s = b.readLine();
		N = Integer.parseInt(s);
		
		primeRibs = new int[9][10000];
		for(int i = 1; i<= 8; i++) {
			generate(i);
		}
		
		int i = 0;
		while (primeRibs[N][i] != 0) {
			p.println(primeRibs[N][i]);
			i++;
		}
		
		b.close();
		p.close();
		long endTime = System.currentTimeMillis();
		System.out.println("Time Elapsed: " + (startTime - endTime));
	}
	
	public static void generate(int n) {
		// count will consider the index of the PREVIOUS row
		int count = 0;
		// count1 will iterate over elements of the current row
		int count1 = 0;
		
		if (n == 1) {
			primeRibs[n][count] = 2;
			count++;
			primeRibs[n][count] = 3;
			count++;
			primeRibs[n][count] = 5;
			count++;
			primeRibs[n][count] = 7;
			count++;
		}
		else {
			while(primeRibs[n-1][count] != 0) {
				for(int i = 1; i <= 9; i+=2) {
					if (i == 5) continue;
					else if (checkPrime(primeRibs[n-1][count]*10+i)) {
						primeRibs[n][count1] = primeRibs[n-1][count]*10+i;
						count1++;
					}
				}
				count++;
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
