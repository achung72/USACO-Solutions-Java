/*
ID: alanchu4
LANG: JAVA
TASK: subset
 */
import java.util.*;
import java.io.*;
public class subset {
	static int N;
	static int sum;
	static int count;
	static int goal;
	static int[][] states;
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		BufferedReader b = new BufferedReader(new FileReader("subset.in"));
		N = Integer.parseInt(b.readLine());
		b.close();
		sum = N*(N+1)/2;
		if (sum % 2 == 1) {
			PrintWriter p = new PrintWriter(new FileWriter("subset.out"));
			p.println(0);
			p.close();
			long endTime = System.currentTimeMillis();
			System.out.println("Time Elapsed: " + (endTime - startTime));
			return;
		} else {
			goal = sum/2;
		}
		states = new int[goal+1][N+1];
		states[1][1] = 1;
		solve();
		
		
		System.out.println(states[goal][N]);
		PrintWriter p = new PrintWriter(new FileWriter("subset.out"));
		p.println(states[goal][N]);
		p.close();
		long endTime = System.currentTimeMillis();
		System.out.println("Time Elapsed: " + (endTime - startTime));
	}
	// f(n,k) = f(n,k-1) + f(n-k, k-1)
	
	public static void solve() {
		 for (int j = 1; j <= N; j++){
			 for (int i = 1; i <= goal; i++){
				if (i == 1 && j == 1)
					continue;
				if (i-j < 0) {
					states[i][j] = states[i][j-1];
				}
				else
					states[i][j] = states[i][j-1] + states[i-j][j-1];
					// System.out.println("i,j " + states[i][j]);
				}
			}
		}
	}
