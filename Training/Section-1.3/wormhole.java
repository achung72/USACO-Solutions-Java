/*
ID: alanchu4
LANG: JAVA
TASK: wormhole
*/

import java.io.*;
import java.util.*;
public class wormhole {
	static int maxn = 12;
	static int[] x = new int[maxn+1];
	static int[] y = new int[maxn+1];
	static int partner[] = new int[maxn+1];
	static int N;
	static int[] nextOnRight = new int[maxn+1];
	
	public static void main(String[] args) throws IOException {
		Scanner b = new Scanner(new File("wormhole.in"));
		PrintWriter p = new PrintWriter(new FileWriter("wormhole.out"));
		
		for (int i = 0; i < nextOnRight.length; i++) {
			nextOnRight[i] = 0;
		}
		
		N = b.nextInt();
		for(int i=1; i<= N; i++) {
			x[i] = b.nextInt();
			y[i] = b.nextInt();
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (x[j]>x[i] && y[i] == y[j]) {
					if (nextOnRight[i] == 0 || x[j]-x[i] < x[nextOnRight[i]]-x[i]) {
						nextOnRight[i] = j;
					}
				}
			}
		}
		for(int i = 1; i <= N; i++) {
			//System.out.println(i + ":" + nextOnRight[i]);
		}
		
		
		p.println(solve());
		
		b.close();
		p.close();
	}
	
	public static int solve() {
		// Find the first unpaired wormhole
		int total = 0;
		int i;
		for(i = 1; i <= N; i++) 
			if (partner[i] == 0) break;
		
		// Check to see if everyone is paired
		if (i > N) {
			if (cycle_exists()) return 1;
			else return 0;
		}
		
		for (int j = i+1; j <= N;j++) {
			if (partner[j] == 0) {
				partner[i] = j;
				partner[j] = i;
				total += solve();
				partner[i] = 0;
				partner[j] = 0;
			}
		}
		
		return total;
	}
	
	public static boolean cycle_exists() {
		/*for (int i=1; i <= N; i++) {
			System.out.println(i + ":" + partner[i]);
			System.out.println();
		}*/
		
		for (int i = 1; i <= N; i++) {
			int pos = i;
			for (int j = 0; j < N; j++) {
				pos = nextOnRight[partner[pos]];
			}
			if (pos != 0) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
}
