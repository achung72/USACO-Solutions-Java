/*
ID: alanchu4
LANG: JAVA
TASK: milk
*/
import java.io.*;
import java.util.*;
public class milk {
	public static void main(String[] args) throws IOException {
		BufferedReader b = new BufferedReader(new FileReader("milk.in"));
		PrintWriter p = new PrintWriter(new FileWriter("milk.out"));
		StringTokenizer firstString = new StringTokenizer(b.readLine());
		int totalMilk = Integer.parseInt(firstString.nextToken());
		int numFarmers = Integer.parseInt(firstString.nextToken());
		int[][] market = new int[numFarmers][2];
		for(int i = 0; i < numFarmers; i++) {
			StringTokenizer st = new StringTokenizer(b.readLine());
			int price = Integer.parseInt(st.nextToken());
			int quan = Integer.parseInt(st.nextToken());
			market[i][1] = quan;
			market[i][0] = price;
		}
		Arrays.sort(market, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if (a[0] < b[0])
					return -1;
				else if (a[0] == b[0])
					return 0;
				else
					return 1;
			}
		});
		
		
		int total = 0;
		int cur = 0;
		while(totalMilk > 0) {
			if (market[cur][1] < totalMilk) {
				total += market[cur][1] * market[cur][0];
				totalMilk -= market[cur][1];
				cur++;
			}
			else {
				total += market[cur][0] * totalMilk;
				totalMilk = 0;
			}	
		}
		p.println(total);
		
		b.close();
		p.close();
	}
}
