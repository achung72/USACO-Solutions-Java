/*
ID: alanchu4
LANG: JAVA
TASK: numtri
*/

import java.io.*;
import java.util.*;
public class numtri {
	static int numRows;
	static int[][] allNumbers;
	static int[][] maxes;
	
	public static void main(String[] args) throws IOException {
		BufferedReader b = new BufferedReader(new FileReader("numtri.in"));
		PrintWriter p = new PrintWriter(new FileWriter("numtri.out"));
		
		numRows = Integer.parseInt(b.readLine());
		allNumbers = new int[numRows][numRows];
		StringTokenizer st;
		
		for(int i = 0; i < numRows; i++) {
			st = new StringTokenizer(b.readLine());
			for (int j = 0; j <= i; j++) {
				allNumbers[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// Just to make sure we loaded the data correctly
		/* for(int i = 0; i < allNumbers.length;i++) {
			for(int j = 0; j < allNumbers.length; j++) {
				System.out.print(allNumbers[i][j] + " ");
			}
			System.out.println();
		} */
		
		maxes = new int[numRows][numRows];
		
		for(int i = 0; i < maxes[0].length;i++) {
			for(int j = 0; j <= i; j++) {
				if (i == 0) {
					maxes[0][0] = allNumbers[0][0];
					continue;
				}
				if (j == 0) {
					maxes[i][j] = maxes[i-1][j] + allNumbers[i][j];
				}
				else if (j == i) {
					maxes[i][j] = maxes[i-1][j-1] + allNumbers[i][j];
				}
				else {
					maxes[i][j] = Math.max(maxes[i-1][j-1]+allNumbers[i][j],maxes[i-1][j]+allNumbers[i][j]);
				}
			}
		}
		
		int max = maxes[0][maxes.length-1];
		
		for (int i = 0; i < maxes[0].length;i++) {
			if (maxes[maxes.length-1][i] > max) {
				max = maxes[maxes.length-1][i];
			}
		}
		p.println(max);
		
		p.close();
		b.close();
	}
}
