import java.util.*;
import java.io.*;
public class angry {
	
	static int numBales;
	static int numCows;
	
	public static void main(String[] args) throws IOException {
		BufferedReader b = new BufferedReader(new FileReader("angry.in"));
		StringTokenizer st = new StringTokenizer(b.readLine());
		numBales = Integer.parseInt(st.nextToken());
		numCows = Integer.parseInt(st.nextToken());
		
		boolean[] bales = new boolean[1000000001];
		
		int min = 0;
		int max = 1000000000;
		
		for(int i = 0; i < numBales; i++) {
			int x = Integer.parseInt(b.readLine());
			if (i == 0) {
				min = x;
				max = x;
			}
			bales[x] = true;
			if (x < min)
				min = x;
			else if (x > max)
				max = x;
		}
		
		
		
		
		
		b.close();
		
		
		PrintWriter p = new PrintWriter(new FileWriter("angry.out"));
		p.close();
	}
}
