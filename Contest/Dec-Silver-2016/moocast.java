import java.util.*;
import java.io.*;
public class moocast {
	static double[][] cows;
	static int numCows;
	static boolean[][] transmit;
	static double[][] distances;
	static boolean[] reachable;
	static int[] temp;
	static int count;
	static int bestCount;
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		BufferedReader b = new BufferedReader(new FileReader("moocast.in"));
		numCows = Integer.parseInt(b.readLine());
		cows = new double[numCows][3];
		transmit = new boolean[numCows][numCows];
		distances = new double[numCows][numCows];
		StringTokenizer st;
		for (int i = 0; i < numCows; i++) {
			st = new StringTokenizer(b.readLine());
			cows[i][0] = Double.parseDouble(st.nextToken());
			cows[i][1] = Double.parseDouble(st.nextToken());
			cows[i][2] = Double.parseDouble(st.nextToken());
		}
		b.close();
		
		for (int i = 0; i < numCows; i++) {
			for (int j = 0; j < numCows; j++) {
				distances[i][j] = Math.sqrt(Math.pow((cows[i][0] - cows[j][0]),2) + Math.pow((cows[i][1] - cows[j][1]), 2));
				distances[j][i] = distances[i][j];
			}
		}
		
		for (int i = 0; i < numCows; i++) {
			for (int j = 0; j < numCows; j++) {
				if (cows[i][2] >= distances[i][j])
					transmit[i][j] = true;
			}
		}
		
		for (int i = 0; i < transmit.length; i++) {
			for (int j = 0; j < transmit.length; j++) {
				System.out.print(transmit[i][j] + " ");
			}
			System.out.println();
		}
		
		for (int i = 0; i < cows.length; i++) {
			count = 0;
			reachable = new boolean[numCows];
			temp = new int[numCows];
			temp[i] = -2;
			for (int j = 0; j < numCows+100; j++) {
				floodFill();
			}
			
			
			for (int j = 0; j < reachable.length; j++) {
				if (reachable[j])
					count++;
			}
			if (count > bestCount)
				bestCount = count;
		}
		System.out.println(bestCount);
		PrintWriter p = new PrintWriter(new FileWriter("moocast.out"));
		p.println(bestCount);
		p.close();
		long endTime = System.currentTimeMillis();
		System.out.println("Time elapsed: " + (endTime - startTime));
	}
	
	public static void floodFill() {
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == -2) {
				temp[i] = 1;
				reachable[i] = true;
				for (int j = 0; j < numCows; j++) {
					if (transmit[i][j] && temp[j] == 0) {
						temp[j] = -2;
					}
				}
			}
		}
	}
	
	
	
}
