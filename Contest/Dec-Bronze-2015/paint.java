import java.io.*;
import java.util.*;
public class paint {
	public static void main(String[] args) throws IOException {
		BufferedReader b = new BufferedReader(new FileReader("paint.in"));
		PrintWriter p = new PrintWriter(new FileWriter("paint.out"));
		StringTokenizer a = new StringTokenizer(b.readLine());
		StringTokenizer c = new StringTokenizer(b.readLine());
		int low1 = Integer.parseInt(a.nextToken());
		int high1 = Integer.parseInt(a.nextToken());
		int low2 = Integer.parseInt(c.nextToken());
		int high2 = Integer.parseInt(c.nextToken());
		
		// Both of the 2's are less than the one's
		
		
		if (low1 == low2) {
			p.println(Math.max(high1-low1, high2-low1));
			p.close();
			b.close();
			return;
		}
		
		if (high2 == high1) {
			p.println(Math.max(high1 - low1, high1 - low2));
			p.close();
			b.close();
			return;
		}
		
		if (high1 <= low2) {
			p.println((high2-low2) + (high1-low1));
			p.close();
			b.close();
			return;
		}
		
		if (low1 < low2 && low2 <= high1 && high1 < high2) {
			p.println(high2-low1);
			p.close();
			b.close();
			return;
		}
		
		if (low1 < low2 && high1 > high2) {
			p.println(high1-low1);
			System.out.println(low1);
			System.out.println(high1);
			System.out.println(low2);
			System.out.println(high2);
			p.close();
			b.close();
			return;
		}
		
		if (low1 < low2 && high1 > high2) {
			p.println(high1-low1);
			p.close();
			b.close();
			return;
		}
		if (low1 > low2 && high1 < high2) {
			p.println(high2-low2);
		}
		
		if (low1 > low2 && low1 <= high2 && high1 > high2) {
			p.println((high1-low2));
			p.close();
			b.close();
			return;
		}
		
		if (low1 >= high2) {
			p.println(high2-low2 + high1-low1);
			p.close();
			b.close();
			return;
		}
		
		b.close();
		p.close();
	}
}
