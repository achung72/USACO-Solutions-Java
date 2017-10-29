import java.util.*;
import java.io.*;
public class cowsignal {
	// This is the paper length
	static int M;
	// Paper width
	static int N;
	// Amplification constant
	static int K;
	
	static char[][] allChars;
	
	public static void main(String[] args) throws IOException {
		BufferedReader b = new BufferedReader(new FileReader("cowsignal.in"));
		StringTokenizer st = new StringTokenizer(b.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		allChars = new char[M][N];
		
		for (int i = 0; i < M; i++) {
			String temp = b.readLine();
			for (int j = 0 ; j < N; j++) {
				allChars[i][j] = temp.charAt(j);
			}
		}
		
		b.close();
		
		/*
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(allChars[i][j]);
			}
			System.out.println();
		}
		*/
		
		PrintWriter p = new PrintWriter(new FileWriter("cowsignal.out"));
		
		for (int i = 0; i < M; i++) {
			for (int temp = 0; temp < K; temp++) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < K; k++) {
						p.print(allChars[i][j]);
					}
				}
				p.println();
			}
		}
			
		
		p.close();
	}
}
