/*
ID: alanchu4
LANG: JAVA
TASK: lamps
*/

import java.util.*;
import java.io.*;
public class lamps {
	static int N;
	static int C;
	static boolean[] whichOn;
	static int[] finishOn;
	static int[] finishOff;
	static boolean[] whichOff;
	static int[] timesToPress;
	
	static boolean[] main;
	static ArrayList<String> answers;
	
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		BufferedReader b = new BufferedReader(new FileReader("lamps.in"));
		N = Integer.parseInt(b.readLine());
		C = Integer.parseInt(b.readLine());
		whichOn = new boolean[N];
		whichOff = new boolean[N];
		StringTokenizer st;
		st = new StringTokenizer(b.readLine());
		int temp1 = 0;
		for (int i = 0; i < N; i++) {
			int c = Integer.parseInt(st.nextToken());
			if (c == -1)
				break;
			else {
				temp1++;
				whichOn[c-1] = true;
			}
		}
		finishOn = new int[temp1];
		int count;
		count = 0;
		for (int i = 0; i < whichOn.length; i++) {
			if (whichOn[i]) {
				finishOn[count] = i;
				count++;
			}
		}
		
		int temp2 = 0;
		st = new StringTokenizer(b.readLine());
		for (int i = 0; i < N; i++) {
			int c = Integer.parseInt(st.nextToken());
			if (c == -1)
				break;
			else {
				temp2++;
				whichOff[c-1] = true;
			}
		}
		
		finishOff = new int[temp2];
		count = 0;
		for (int i = 0; i < whichOff.length; i++) {
			if (whichOff[i]) {
				finishOff[count] = i;
				count++;
			}
		}
		b.close();
		
		// The above should all work; we're just loading in the data
		// ---------------------------------------------------------------------
		ArrayList<Integer> howManyPress = count();
		timesToPress = new int[howManyPress.size()];
		for (int i = 0; i < timesToPress.length; i++) {
			timesToPress[i] = howManyPress.get(i);
		}
		
		boolean[] derp = new boolean[N];
		for (int i = 0; i < derp.length; i++) {
			derp[i] = true;
		}
		
		answers = new ArrayList<String>();
		for (int i = 0; i < timesToPress.length; i++) {
			solve(timesToPress[i], new boolean[4], derp);
		}
		
		/*for (int i = 0; i < answers.size(); i++) {
			System.out.println(answers.get(i));
		}*/
		
		String[] finalAnswer = new String[answers.size()];
		for (int i = 0; i < finalAnswer.length; i++) {
			finalAnswer[i] = answers.get(i);
		}
		
		Arrays.sort(finalAnswer);
		
		
		
		PrintWriter p = new PrintWriter(new FileWriter("lamps.out"));
		if (finalAnswer.length == 0)
			p.println("IMPOSSIBLE");
		for (int i = 0; i < finalAnswer.length; i++) {
			if (i == 0)
				p.println(finalAnswer[i]);
			else if (i >= 1 && !finalAnswer[i].equals(finalAnswer[i-1])) {
				p.println(finalAnswer[i]);
			}
		}
		p.close();
		
		

		long endTime = System.currentTimeMillis();
		System.out.println("Time Elapsed: " + (endTime - startTime));
	}
	
	public static void solve(int count, boolean[] used, boolean[] curState) {
		if (count == 0) {
			for (int i = 0; i < finishOn.length; i++) {
				if (!curState[finishOn[i]])
					return;
			}
			for (int i = 0; i < finishOff.length; i++) {
				if (curState[finishOff[i]])
					return;
			}
			String s = "";
			for (int i = 0; i < curState.length; i++) {
				if (curState[i])
					s = s + "1";
				else if (!curState[i])
					s = s + "0";
			}
			answers.add(s);
		} else {
			for (int i = 0; i < used.length; i++) {
				if (!used[i]) {
					boolean[] temp = curState.clone();
					boolean[] tempUsed = used.clone();
					//print(temp);
					if (i == 0) {
						func1(temp);
						//print(temp);
						tempUsed[i] = true;
						solve(count-1, tempUsed, temp);
					} else if (i == 1) {
						func2(temp);
						//print(temp);
						tempUsed[i] = true;
						solve(count-1, tempUsed, temp);
					} else if (i == 2) {
						func3(temp);
						//print(temp);
						tempUsed[i] = true;
						solve(count-1, tempUsed, temp);
					} else if (i == 3) {
						func4(temp);
						//print(temp);
						tempUsed[i] = true;
						solve(count-1, tempUsed, temp);
					}
				}
			}
		}
	}
	
	public static void func4(boolean[] main) {
		for (int i = 0; i < main.length; i++) {
			if (i % 3 == 0)
				main[i] = !main[i];
		}
	}
	
	public static void func3(boolean[] main) {
		for (int i = 0; i < main.length; i++) {
			if (i % 2 == 1)
				main[i] = !main[i];
		}
	}
	
	public static void func2(boolean[] main) {
		for (int i = 0; i < main.length; i++) {
			if (i % 2 == 0)
				main[i] = !main[i];
		}
	}
	
	public static void func1(boolean[] main) {
		for (int i = 0; i < main.length; i++) {
			main[i] = !main[i];
		}
	}
	
	// This method will return how many buttons can be pressed; 
	// A button pressed twice doesn't count, of course.
	public static ArrayList<Integer> count() {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int rand = C%2;
		for (int i = rand; i <= 10; i = i+2) {
			if (i <= 4 && i <= C)
				temp.add(i);
		}
		
		return temp;
	}
	
	public static void print(boolean[] temp) {
		for (int j = 0; j < temp.length; j++) {
			if (temp[j] == true)
				System.out.print("1");
			else
				System.out.print("0");
		}
		System.out.println();
	}
	
	
	
	
}
