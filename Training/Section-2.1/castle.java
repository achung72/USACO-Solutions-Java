/*
ID: alanchu4
LANG: JAVA
TASK: castle
*/
import java.util.*;
import java.io.*;
public class castle {
	static int numRows;
	static int numCols;
	static int[][] allnum;
	static int[][] components;
	static int[][] tempComponents;
	static int num_components;
	//max room that is
	static int maxRoom;
	static int maxTemp;
	static String whichWall;
	static int[] biggestroom;
	static int bigIndex;
	
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		BufferedReader b = new BufferedReader(new FileReader("castle.in"));
		StringTokenizer st = new StringTokenizer(b.readLine());
		numCols = Integer.parseInt(st.nextToken());
		numRows = Integer.parseInt(st.nextToken());
		allnum = new int[numRows][numCols];
		components = new int[numRows][numCols];
		for (int i = 0; i < numRows; i++) {
			st = new StringTokenizer(b.readLine());
			for (int j = 0; j < numCols; j++) {
				allnum[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		b.close();
		
		num_components = 0;
		maxTemp = 0;
		solve();
		findBiggestRoom();
		
		long midTime = System.currentTimeMillis();
		System.out.println("Middle Time: " + (midTime - startTime));
		
		whichWall = "1 " + (numCols) + " E";
		
		
		
		
		PrintWriter p = new PrintWriter(new FileWriter("castle.out"));
		
		p.println(num_components);
		System.out.println(num_components);
		p.println(maxRoom);
		System.out.println(maxRoom);
		removeVertWalls();
		removeHoriWalls();
		p.println(maxRoom);
		System.out.println(maxRoom);
		p.println(whichWall);
		System.out.println(whichWall);

		p.close();
		
		long endTime = System.currentTimeMillis();
		System.out.println("Time Elapsed: " + (endTime - startTime));
	}
	
	public static void removeVertWalls() {
		for (int i = 0; i < components.length; i++) {
			for (int j = 0; j < components[0].length-1; j++) {
				if (components[i][j] != components[i][j+1]) {
					int temp = biggestroom[components[i][j]] + biggestroom[components[i][j+1]];
					if (temp > maxRoom) {
						maxRoom = temp;
						whichWall = (i+1) + " " + (j+1) + " E";
						if (i+1 == 3 && j+1 == 3) {
							System.out.println("here1");
						}
					} else if (temp == maxRoom) {
						StringTokenizer st = new StringTokenizer(whichWall);
						int curRow = Integer.parseInt(st.nextToken());
						int curCol = Integer.parseInt(st.nextToken());
						String dir = st.nextToken();
						if (j+1 < curCol) {
							whichWall = (i+1) + " " + (j+1) + " E";
						} else if (j+1 == curCol && i+1 > curRow) {
							whichWall = (i+1) + " " + (j+1) + " E";
						}
					}
				}
			}
		}
	}
	
	public static void removeHoriWalls() {
		for (int i = 0; i < components.length-1; i++) {
			for (int j = 0; j < components[0].length; j++) {
				if (components[i][j] != components[i+1][j]) {
					int temp = biggestroom[components[i][j]] + biggestroom[components[i+1][j]];
					if (temp > maxRoom) {
						maxRoom = temp;
						whichWall = (i+2) + " " + (j+1) + " N";
					} else if (temp == maxRoom) {
						StringTokenizer st = new StringTokenizer(whichWall);
						int curRow = Integer.parseInt(st.nextToken());
						int curCol = Integer.parseInt(st.nextToken());
						String dir = st.nextToken();
						if (j+1 < curCol) {
							whichWall = (i+2) + " " + (j+1) + " N";
						} else if (j+1 == curCol && i+2 > curRow) {
							whichWall = (i+2) + " " + (j+1) + " N";
						} else if (j+1 == curCol && i+2 == curRow) {
							whichWall = (i+2) + " " + (j+1) + " N";
						}
					}
				}
			}
		}
	}
	
	public static void findBiggestRoom() {
		biggestroom = new int[num_components+1];
		for (int i = 0; i < components.length; i++) {
			for (int j = 0; j < components[0].length; j++) {
				biggestroom[components[i][j]]++;
			}
		}
		int max = biggestroom[1];
		bigIndex = 1;
		for (int i = 0; i < biggestroom.length; i++) {
			if (max < biggestroom[i]) {
				max = biggestroom[i];
				bigIndex = i;
			}
		}
		maxRoom = max;
	}
	
	public static void solve() {
		for (int i = 0; i < allnum.length; i++) {
			for (int j = 0; j < allnum[0].length; j++) {
				if (components[i][j] == 0) {
					num_components++;
					components[i][j] = -2;
					floodFill(num_components);
				}
			}
		}
	}
	
	public static void floodFill(int newComponent) {
		int numvisited;
		do {
			numvisited = 0;
			for (int i = 0; i < allnum.length; i++) {
				for (int j = 0 ; j < allnum[0].length; j++) {
					if (components[i][j] == -2) {
						numvisited++;
						components[i][j] = newComponent;
						int temp = allnum[i][j];
						if (temp < 8 && components[i+1][j] == 0) {
							components[i+1][j] = -2;
						}
						temp = temp%8;
						// System.out.println("temp is " + temp + " i is " + i + " j is " + j);
						if (temp < 4 && components[i][j+1] == 0)
							components[i][j+1] = -2;
						temp = temp%4;
						if (temp < 2 && components[i-1][j] == 0)
							components[i-1][j] = -2;
						temp = temp%2;
						if (temp == 0 && components[i][j-1] == 0)
							components[i][j-1] = -2;
					}
				}
			}
		} while (numvisited != 0);
	}
}
