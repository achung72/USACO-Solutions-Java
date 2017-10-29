/*
ID: alanchu4
LANG: JAVA
TASK: milk3
*/

import java.io.*;
import java.util.*;
public class milk3 {
	
	static int[] curBuckets;
	static int[] capacities;
	static boolean[][] checked = new boolean[21][21];
	static boolean[] achieveable = new boolean[21];
	
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		Scanner sc = new Scanner(new File("milk3.in"));
		PrintWriter p = new PrintWriter(new FileWriter("milk3.out"));
		
		capacities = new int[3];
		for(int i = 0; i < 3; i++)
			capacities[i] = sc.nextInt();
		
		solve(0,0,capacities[2]);
		
		int count = 0;
		
		for(int i = 0; i < achieveable.length;i++) {
			if (achieveable[i])
				count++;
		}
		
		int count1 = 1;
		for(int i = 0; i< achieveable.length;i++) {
			if (achieveable[i] && count1 < count) {
				p.print(i + " ");
				count1++;
			}
			else if (achieveable[i] && count == count1)
				p.println(i);
		}
		
		
		sc.close();
		p.close();
		
		long endTime = System.currentTimeMillis();
		System.out.println("Time elapsed: " + (endTime - startTime));
	}
	
	public static void solve(int a, int b,int c) {
		if (a < 0 || b < 0 || c < 0)
			return;
		if (checked[a][b])
			return;
		if (a == 0)
			achieveable[c] = true;

		checked[a][b] = true;
		solve(a-Math.min(a, capacities[1]-b),b+Math.min(a,capacities[1]-b),c);
		solve(a-Math.min(a, capacities[2]-c),b,c+Math.min(a,capacities[2]-c));
		solve(a+Math.min(b, capacities[0]-a),b-Math.min(b,capacities[0]-a),c);
		solve(a,b-Math.min(b, capacities[2]-c),c+Math.min(b,capacities[2]-c));
		solve(a+Math.min(c, capacities[0]-a),b,c-Math.min(c,capacities[0]-a));
		solve(a,b+Math.min(c, capacities[1]-b),c-Math.min(c, capacities[1]-b));
	}
}
