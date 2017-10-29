import java.util.*;
import java.io.*;
public class pails {
	static int X;
	static int Y;
	static int K;
	static int M;
	static boolean[] mValues;
	static int[][] checked;
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		BufferedReader b = new BufferedReader(new FileReader("pails.in"));
		StringTokenizer st = new StringTokenizer(b.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		b.close();
		mValues = new boolean[201];
		checked = new int[X+1][Y+1];
		for (int i = 0; i < checked.length; i++) {
			for (int j = 0; j < checked[0].length; j++) {
				checked[i][j] = 200;
			}
		}
		
		// ---------------------------------------------------------
		solve(0,0,0);
		
		for (int i = 0; i < mValues.length; i++) {
			if (mValues[i])
				System.out.print(i + " ");
		}
		
		
		int min = 10000;
		for (int i = 0; i < mValues.length; i++) {
			if (mValues[i] && Math.abs(i-M) < min) {
				min = Math.abs(i-M);
			}
		}
		
		System.out.println(min);
		PrintWriter p = new PrintWriter(new FileWriter("pails.out"));
		p.println(min);
		p.close();
		long endTime = System.currentTimeMillis();
		System.out.println("Time Elapsed: " + (endTime - startTime));
	}
	
	public static void solve(int curX, int curY, int count) {
		/*System.out.println("X: " + curX + " Y: " + curY + " Count: " + count);
		if (curX == 14 && curY == 50) {
			System.out.println("First yesss");
			System.out.println("The checked value is " + checked[curX][curY]);
		}*/
		if (count >= checked[curX][curY])
			return;
		else if (count > K)
			return;
		else
			checked[curX][curY] = count;
		/*if (curX == 14 && curY == 50) {
			System.out.println("Second yesss");
		}*/
		mValues[curX+curY] = true;
		solve(X,curY,count+1);
		solve(curX,Y,count+1);
		solve(0,curY,count+1);
		solve(curX,0,count+1);
		int totalSum = curX+curY;
		solve(Math.min(totalSum,X),totalSum - Math.min(totalSum,X),count+1);
		solve(totalSum - Math.min(totalSum,Y),Math.min(totalSum, Y),count+1);
	}
	
	
	
	
}
