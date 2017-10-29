import java.util.*;
import java.io.*;

public class hps {
	static int N;
	static int K;
	static int[] farmerMoves;
	static int[][][] cowMoves;
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		BufferedReader b = new BufferedReader(new FileReader("hps.in"));
		StringTokenizer st = new StringTokenizer(b.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		farmerMoves = new int[N];
		for (int i = 0; i < N; i++) {
			String s = b.readLine();
			if (s.equals("H")) {
				farmerMoves[i] = 0;
			} else if (s.equals("P")) {
				farmerMoves[i] = 1;
			} else
				farmerMoves[i] = 2;
		}
		b.close();
		
		// Data Loaded -------------------------------------------------------
		
		cowMoves = new int[3][K+1][N];
		
		for (int k = 0; k < N; k++) {
			for (int j = 0; j <= K; j++) {
				if (k == 0) {
					for (int state = 0; state <= 2; state++) {
							cowMoves[state][j][k] = 1;					
					}
				} else {
					for (int state = 0; state <= 2; state++) {
						int state1 = (state + 1)%3;
						int state2 = (state+2)%3;	
						if (j == 0) {
							if (farmerMoves[k] == state) {
								cowMoves[state][j][k] = cowMoves[state][j][k-1] + 1;
							} else {
								cowMoves[state][j][k] = cowMoves[state][j][k-1];
							}
						} else {
							if (farmerMoves[k] == state) {
								cowMoves[state][j][k] = Math.max(Math.max(cowMoves[state1][j-1][k-1],cowMoves[state2][j-1][k-1]), cowMoves[state][j][k-1]) + 1 ;
							} else {
								cowMoves[state][j][k] = Math.max(Math.max(cowMoves[state1][j-1][k-1],cowMoves[state2][j-1][k-1]), cowMoves[state][j][k-1]);
							}
						}
					}
				}
			}
		}
		/*for (int i = 0; i < N; i++) {
			for (int j = 0; j <= K; j++) {
				for (int k = 0; k < 3; k++) {
					System.out.println("When i = " + i + ", j = " + j + ", and k = " + k + ", we have " + cowMoves[k][j][i]);
				}
			}
		}*/
		
		System.out.println(Math.max(Math.max(cowMoves[0][K][N-1], cowMoves[1][K][N-1]), cowMoves[2][K][N-1]));
		
		
		PrintWriter p = new PrintWriter(new FileWriter("hps.out"));
		p.println(Math.max(Math.max(cowMoves[0][K][N-1], cowMoves[1][K][N-1]), cowMoves[2][K][N-1]));
		p.close();
		long endTime = System.currentTimeMillis();
		System.out.println("Time Elapased: " + (endTime - startTime));
	}

}