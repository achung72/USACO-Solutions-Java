import java.util.*;
import java.io.*;
public class square {
	static int[][] corners;
	
	public static void main(String[] args) throws IOException {
		BufferedReader b = new BufferedReader(new FileReader("square.in"));
		corners = new int[4][2];
		StringTokenizer st = new StringTokenizer(b.readLine());
		for (int i = 0; i < 2; i++) {
			corners[i][0] = Integer.parseInt(st.nextToken());
			corners[i][1] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(b.readLine());
		for (int i = 2; i < 4; i++) {
			corners[i][0] = Integer.parseInt(st.nextToken());
			corners[i][1] = Integer.parseInt(st.nextToken());
		}
		
		/*
		for (int i = 0; i < corners.length; i++) {
			System.out.println(corners[i][0] + " " + corners[i][1]);
		}
		*/
		b.close();
		
		int minX = corners[0][0];
		for (int i = 0; i < corners.length; i++) {
			if (corners[i][0] < minX)
				minX = corners[i][0];
		}
		
		int maxX = corners[0][0];
		for (int i = 0; i < corners.length; i++) {
			if (corners[i][0] > maxX)
				maxX = corners[i][0];
		}
		
		int minY = corners[0][1];
		for (int i = 0; i < corners.length; i++) {
			if (corners[i][1] < minY)
				minY = corners[i][1];
		}
		
		int maxY = corners[0][1];
		for (int i = 0; i < corners.length; i++) {
			if (corners[i][1] > maxY)
				maxY = corners[i][1];
		}
		
		int sidelength = Math.max(maxX-minX, maxY-minY);
		
		PrintWriter p = new PrintWriter(new FileWriter("square.out"));
		p.println(sidelength*sidelength);
		p.close();
	}	
}
