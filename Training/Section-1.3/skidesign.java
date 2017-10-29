/*
ID: alanchu4
LANG: JAVA
TASK: skidesign
*/
import java.io.*;
import java.util.*;
public class skidesign {
	public static void main(String[] args) throws IOException {
		BufferedReader b = new BufferedReader(new FileReader("skidesign.in"));
		PrintWriter p = new PrintWriter(new FileWriter("skidesign.out"));
		
		// Initializes the storage of the costs, the heights of the hills, and loads the
		// Heights of the hills in an array.
		int numHills = Integer.parseInt(b.readLine());
		int[] costs = new int[85];
		int[] hills = new int[numHills];
		String line;
		int count = 0;
		while ((line = b.readLine()) != null) {
			hills[count] = Integer.parseInt(line);
			count++;
		}
		
		// Time to process for each interval
		
		for (int i = 0; i <= 84; i++) {
			int curCount = 0;
			for (int h4v3n : hills) {
				if (h4v3n < i) {
					curCount += (i-h4v3n)*(i-h4v3n);
				}
				else if (h4v3n > i+17) {
					curCount += (h4v3n - i - 17) * (h4v3n - i - 17);
				}
			}
			costs[i] = curCount;
		}
		
		// Finding the minimum...
		int min = costs[0];
		for(int i = 0; i < costs.length; i++) {
			if (min > costs[i]) {
				min = costs[i];
			}
		}
		
		//Answer
		p.println(min);
		
		
		
		b.close();
		p.close();
	}
}
