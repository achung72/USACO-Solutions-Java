import java.util.*;
import java.io.*;
import java.util.Arrays;
public class citystate {
	static int numCities;
	static String[][] cities;
	static String[][] firstSorted;
	static String[][] secondSorted;
	
	public static void main(String[] args) throws IOException {
		BufferedReader b = new BufferedReader(new FileReader("citystate.in"));
		numCities = Integer.parseInt(b.readLine());
		
		cities = new String[numCities][2];
		firstSorted = new String[numCities][2];
		secondSorted = new String[numCities][2];
		
		StringTokenizer st;
		for (int i = 0; i < numCities; i++) {
			st = new StringTokenizer(b.readLine());
			cities[i][0] = st.nextToken();
			cities[i][1] = st.nextToken();
			
			firstSorted[i][0] = cities[i][0];
			firstSorted[i][1] = cities[i][1];
			secondSorted[i][0] = cities[i][0];
			secondSorted[i][1] = cities[i][1];
		}
		b.close();
		
		 Arrays.sort(firstSorted, new Comparator<String[]>() {
	            @Override
	            public int compare(final String[] entry1, final String[] entry2) {
	                final String time1 = entry1[0];
	                final String time2 = entry2[0];
	                return time1.compareTo(time2);
	            }
	        });
		
		 Arrays.sort(secondSorted, new Comparator<String[]>() {
	            @Override
	            public int compare(final String[] entry1, final String[] entry2) {
	                final String time1 = entry1[1];
	                final String time2 = entry2[1];
	                return time1.compareTo(time2);
	            }
	        });
		/*
		printArray(cities); System.out.println();
		printArray(firstSorted); System.out.println();
		printArray(secondSorted);
		*/
		PrintWriter p = new PrintWriter(new FileWriter("citystate.out"));
		
		int total = 0;
		
		for (int i = 0; i < firstSorted.length; i++) {
			String cur = firstSorted[i][0].substring(0,2);
			int x = binarySearch(cur);
			if (x < 0)
				continue;
			while (secondSorted[x][1].equals(cur)) {
				if (firstSorted[i][0].equals(secondSorted[x][0])) {
					if (x == secondSorted.length-1) {
						break;
					}
					else {
						x++;
					}
				} else {
					if (secondSorted[x][0].substring(0,2).equals(firstSorted[i][1])) {
						total++;
					}
					if (x == secondSorted.length-1)
						break;
					else
						x++;
				}
			}
		}
		
		p.println(total/2);
		p.close();
	}
	
	public static int binarySearch(String key) {
		int low = 0;
		int high = secondSorted.length-1;
		
		while (high >= low) {
			int middle = low + (high-low)/2;
			if (middle == 0 && secondSorted[middle][1].equals(key))
				return middle;
			if (key.compareTo(secondSorted[middle][1]) > 0) {
				low = middle+1;
			}
			else if (key.compareTo(secondSorted[middle][1]) < 0) {
				high = middle-1;
			} 
			else if (key.equals(secondSorted[middle][1]) && key.equals(secondSorted[middle-1][1])) {
				high = middle-1;
			}
			else
				return middle;
		}
		return -1;
	}
	
	public static void printArray(String[][] a)  {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i][0] + " " + a[i][1]);
		}
	}
}