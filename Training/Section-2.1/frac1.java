/*
ID: alanchu4
LANG: JAVA
TASK: frac1
*/
import java.util.*;
import java.io.*;

public class frac1 {
	static int N;
	static double[][] all;
	
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		BufferedReader b = new BufferedReader(new FileReader("frac1.in"));
		N = Integer.parseInt(b.readLine());
		b.close();
		
		// 1 Because we first count 0/1
		int numFrac = 1;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				if (gcd(i,j) == 1)
					numFrac++;
			}
		}
		
		all = new double[numFrac][3];
		int count = 1;
		all[0][0] = 0;
		all[0][1] = 1;
		all[0][2] = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				if (gcd(i,j) == 1) {
					all[count][0] = j;
					all[count][1] = i;
					all[count][2] = (double) j/i;
					count++;
				}
			}
		}
		
		
		Arrays.sort(all, new Comparator<double[]>() {
            @Override
            public int compare(final double[] entry1, final double[] entry2) {
                double first = entry1[2];
                double second = entry2[2];
                if (first > second)
                	return 1;
                else if (first < second)
                	return -1;
                else
                	return 0;
            }
        });
		
		PrintWriter p = new PrintWriter(new FileWriter("frac1.out"));
		for (int i = 0; i < all.length; i++) {
			p.println((int) all[i][0] + "/" + (int) all[i][1]);
		}
		
		p.close();
		long endTime = System.currentTimeMillis();
		System.out.println("Time Elapsed:" + (endTime-startTime));
	}
	
	public static int gcd(int a, int b) {
		if (a == 0 || b == 0)
			return a+b;
		return gcd(b, a%b);
	}
}
