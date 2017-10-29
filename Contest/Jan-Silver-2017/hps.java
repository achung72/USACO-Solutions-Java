import java.util.*;
import java.io.*;
public class hps {
	static int maxWins;
	static int N;
	static char[] moves;
	// The following array contains H,P,S
	static char[] options;
	
	// IMPORTANT: H - 0; P - 1; S - 1
	static int[][] beforeIndex;
	static int[][] afterIndex;
	public static void main(String[] args) throws IOException {
		BufferedReader b = new BufferedReader(new FileReader("hps.in"));
		N = Integer.parseInt(b.readLine());
		moves = new char[N];
		for (int i = 0; i < N; i++) {
			String s = b.readLine();
			moves[i] = s.charAt(0);
		}
		b.close();
		
		
		beforeIndex = new int[N][3];
		char temp = moves[0];
		if (temp == 'H')
			beforeIndex[0][0]++;
		else if (temp == 'P')
			beforeIndex[0][1]++;
		else if (temp == 'S')
			beforeIndex[0][2]++;
		
		for (int i = 1; i < N; i++) {
			if (moves[i] == 'H') {
				beforeIndex[i][0] = beforeIndex[i-1][0] + 1;
				beforeIndex[i][1] = beforeIndex[i-1][1];
				beforeIndex[i][2] = beforeIndex[i-1][2];
			} else if (moves[i] == 'P') {
				beforeIndex[i][1] = beforeIndex[i-1][1] + 1;
				beforeIndex[i][0] = beforeIndex[i-1][0];
				beforeIndex[i][2] = beforeIndex[i-1][2];
			} else {
				beforeIndex[i][2] = beforeIndex[i-1][2] + 1;
				beforeIndex[i][0] = beforeIndex[i-1][0];
				beforeIndex[i][1] = beforeIndex[i-1][1];;
			}
		}
		
		afterIndex = new int[N][3];
		temp = moves[N-1];
		if (temp == 'H')
			afterIndex[N-1][0]++;
		else if (temp == 'P')
			afterIndex[N-1][1]++;
		else if (temp == 'S')
			afterIndex[N-1][2]++;
		
		for (int i = N-2; i >= 0; i--) {
			if (moves[i] == 'H') {
				afterIndex[i][0] = afterIndex[i+1][0] + 1;
				afterIndex[i][1] = afterIndex[i+1][1];
				afterIndex[i][2] = afterIndex[i+1][2];
			} else if (moves[i] == 'P') {
				afterIndex[i][1] = afterIndex[i+1][1] + 1;
				afterIndex[i][0] = afterIndex[i+1][0];
				afterIndex[i][2] = afterIndex[i+1][2];
			} else {
				afterIndex[i][2] = afterIndex[i+1][2] + 1;
				afterIndex[i][1] = afterIndex[i+1][1];
				afterIndex[i][0] = afterIndex[i+1][0];;
			}
		}
		
		/*for (int i = 0; i < beforeIndex.length; i++) {
			for (int j = 0; j < beforeIndex[0].length; j++) {
				System.out.print(afterIndex[i][j] + " ");
			}
			System.out.println();
		}*/
		
		maxWins = -2;
		for (int i = 0; i < N-1; i++) {
			int first = Math.max(beforeIndex[i][0], beforeIndex[i][1]);
			first = Math.max(first,beforeIndex[i][2]);
			int second = Math.max(afterIndex[i+1][0], afterIndex[i+1][1]);
			second = Math.max(second, afterIndex[i+1][2]);
			if (first + second > maxWins)
				maxWins = first+second;
		}
		
		System.out.println(maxWins);
		
		PrintWriter p = new PrintWriter(new FileWriter("hps.out"));
		p.println(maxWins);
		p.close();
	}
	
	
	
	
}
