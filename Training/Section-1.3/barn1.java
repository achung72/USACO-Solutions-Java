/*
ID: alanchu4
LANG: JAVA
TASK: barn1
*/
import java.io.*;
import java.util.*;
public class barn1 {
	public static void main(String[] args) throws IOException {
		BufferedReader b = new BufferedReader(new FileReader("barn1.in"));
		PrintWriter p = new PrintWriter(new FileWriter("barn1.out"));
		StringTokenizer st = new StringTokenizer(b.readLine());
		int numBoards = Integer.parseInt(st.nextToken());
		int numStalls = Integer.parseInt(st.nextToken());
		int numOccupied = Integer.parseInt(st.nextToken());
		if (numOccupied == 1) {
			p.println(1);
			b.close();
			p.close();
			return;
		}
		int[] gaps = new int[numOccupied-1];
		int[] tempCows = new int[numOccupied];
		String line;
		int count = 0;
		while ((line = b.readLine()) != null) {
			tempCows[count] = Integer.parseInt(line);
		 	count++;
		}
		Arrays.sort(tempCows);
		for(int i = 0; i < tempCows.length-1; i++) {
			gaps[i] = tempCows[i+1] - tempCows[i] - 1;
		}
		for(int i = 0; i < gaps.length; i++)
			System.out.println(gaps[i]);
		Arrays.sort(gaps);
		System.out.println();
		for(int i = 0; i < gaps.length; i++)
			System.out.println(gaps[i]);
		int total = tempCows[tempCows.length-1] - tempCows[0] + 1;
		System.out.println(total);
		for(int i = gaps.length-1; i >= gaps.length-numBoards+1; i--) {
			total -= gaps[i];
			if (i == 0) {
				p.println(total);
				p.close();
				b.close();
				return;
			}
		}
		p.println(total);
		b.close();
		p.close();
	}
}
