import java.io.*;
import java.util.*;
public class speeding {
	public static void main(String[] args) throws IOException {
		BufferedReader b = new BufferedReader(new FileReader("speeding.in"));
		PrintWriter p = new PrintWriter(new PrintWriter("speeding.out")); 
		
		int[] bessie = new int[100];
		int[] road = new int[100];
		
		int N;
		int M;
		
		StringTokenizer st = new StringTokenizer(b.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int countN = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(b.readLine());
			int dist = Integer.parseInt(st.nextToken());
			int limit = Integer.parseInt(st.nextToken());
			for(int j = 0; j < dist; j++) {
				road[countN] = limit;
				countN++;
			}
		}
		
		int countM = 0;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(b.readLine());
			int dist = Integer.parseInt(st.nextToken());
			int limit = Integer.parseInt(st.nextToken());
			for(int j = 0; j < dist; j++) {
				bessie[countM] = limit;
				countM++;
			}
		}
		
		int max = 0;
		
		for(int i = 0; i < bessie.length; i++) {
			if ((bessie[i] - road[i] > max)) {
				max = bessie[i] - road[i];
			}
		}
		
		p.println(max);
		
		
		
		b.close();
		p.close();
	}
}
