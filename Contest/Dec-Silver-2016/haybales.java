import java.util.*;
import java.io.*;
public class haybales {
	static int numBales;
	static int numQueries;
	static int[] locations;
	static int[][] queries;
	public static void main(String[] args) throws IOException {
		BufferedReader b = new BufferedReader(new FileReader("haybales.in"));
		StringTokenizer st = new StringTokenizer(b.readLine());
		numBales = Integer.parseInt(st.nextToken());
		numQueries = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(b.readLine());
		locations = new int[numBales];
		for (int i = 0; i < numBales; i++) {
			locations[i] = Integer.parseInt(st.nextToken());
		}
		
		queries = new int[numQueries][2];
		for (int i = 0; i < numQueries; i++) {
			st = new StringTokenizer(b.readLine());
			queries[i][0] = Integer.parseInt(st.nextToken());
			queries[i][1] = Integer.parseInt(st.nextToken());
		}
		
		b.close();
		
		Arrays.sort(locations);
		printArray(locations);
		System.out.println();
		// For each query - we do a binary search. Given A, we find the smallest integer greater than or equal to A.
		System.out.println(lowerBound(1));
		System.out.println(upperBound(9));
		
		PrintWriter p = new PrintWriter(new FileWriter("haybales.out"));
		for (int i = 0; i < queries.length; i++) {
			int low = lowerBound(queries[i][0]);
			int high = upperBound(queries[i][1]);
			
			if (high < 0 || high < low) {
				p.println(0);
			} else if (high == low) {
				p.println(1);
			} else {
				p.println(high-low+1);
			}
		}
		p.close();
	}
	
	public static int upperBound(int higher) {
		int index = Arrays.binarySearch(locations,higher);
		if (index >= 0)
			return index;
		else
			return -(index+2);
	}
	
	public static int lowerBound(int lower) {
		int index = Arrays.binarySearch(locations,lower);
		if (index >= 0)
			return index;
		else
			return -(index+1);
	}
	
	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	
	
	
}

