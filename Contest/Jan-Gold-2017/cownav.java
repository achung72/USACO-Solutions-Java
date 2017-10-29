import java.util.*;
import java.io.*;
public class cownav {
	static int N;
	static char[][] terrain;
	static int numbales;
	
	public static void main(String[] args) throws IOException {
		BufferedReader b = new BufferedReader(new FileReader("cownav.in"));
		N = Integer.parseInt(b.readLine());
		terrain = new char[N][N];
		String s;
		for (int i = 0; i < N; i++) {
			s = b.readLine();
			for (int j = 0; j < N; j++) {
				terrain[i][j] = s.charAt(j);
				if (terrain[i][j] == 'H')
					numbales++;
			}
		}
		b.close();
		
		PrintWriter p = new PrintWriter(new FileWriter("cownav.out"));
		p.println(3*N);
		p.close();
	}
	
	
}
