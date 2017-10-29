import java.util.*;
import java.io.*;
public class bphoto {
	static int N;
	static int[] heights;
	static int[] heightSorted;
	static int[] tallerLeft;
	static int totalUnbalanced;
	static int halfWay;
	public static void main(String[] args) throws IOException {
		BufferedReader b = new BufferedReader(new FileReader("bphoto.in"));
		N = Integer.parseInt(b.readLine());
		heights = new int[N];
		for (int i = 0; i < N; i++) {
			heights[i] = Integer.parseInt(b.readLine());
		}
		b.close();
		totalUnbalanced = 0;
		heightSorted = heights.clone();
		Arrays.sort(heightSorted);
		halfWay = N/2;
		
		for (int i = 0; i <= halfWay; i++) {
			if (i == 0) {
				if (heights[i] != heightSorted[heightSorted.length-1]) {
					totalUnbalanced++;
					continue;
				}
			}
			double left = 0;
			double right = 0;
			int index = Arrays.binarySearch(heightSorted,heights[i]);
			int numGreater = heights.length - 1 - index;
			for (int j = 0; j < i; j++) {
				if (heights[j] > heights[i]) {
					left++;
				}
			}
			right = numGreater - left;
			if (left == 0 && right > 0) {
				totalUnbalanced++;
				continue;
			}
			if (right == 0 && left > 0) {
				totalUnbalanced++;
				continue;
			} else if (right/left > 2.0 || left/right > 2.0) {
				totalUnbalanced++;
			}
		}
		
		for (int i = halfWay+1; i < N; i++) {
			if (i == N-1) {
				if (heights[i] != heightSorted[heightSorted.length-1]) {
					totalUnbalanced++;
					continue;
				}
			}
			double left = 0;
			double right = 0;
			int index = Arrays.binarySearch(heightSorted,heights[i]);
			int numGreater = heights.length - 1 - index;
			for (int j = i+1; j < N; j++) {
				if (heights[j] > heights[i]) {
					left++;
				}
			}
			right = numGreater - left;
			if (left == 0 && right > 0) {
				totalUnbalanced++;
				continue;
			}
			if (right == 0 && left > 0) {
				totalUnbalanced++;
				continue;
			} else if (right/left > 2.0 || left/right > 2.0) {
				totalUnbalanced++;
			}
		}
		
		
		
		
		/*for (int i = 0; i < N; i++) {
			double left = 0;
			double right = 0;
			for (int j = 0; j < i; j++) {
				if (heights[j] > heights[i]) {
					left++;
				}
			}
			for (int j = N-1; j > i; j--) {
				if (heights[j] > heights[i])
					right++;
			}
			if (i == 0 && right > 0) {
				totalUnbalanced++;
				continue;
			}
			if (i == N-1 && left > 0) {
				totalUnbalanced++;
				continue;
			}
			if (left == 0 && right > 0) {
				totalUnbalanced++;
				System.out.println(i);
				continue;
			} else if (left > 0 && right == 0) {
				totalUnbalanced++;
				System.out.println(i);
				continue;
			} else if (right/left > 2.0 || left/right > 2.0) {
				totalUnbalanced++;
				System.out.println(i);
			}
		}*/
		
		PrintWriter p = new PrintWriter(new FileWriter("bphoto.out"));
		p.println(totalUnbalanced);
		p.close();
	}
}
