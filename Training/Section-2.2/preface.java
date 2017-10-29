/*
ID: alanchu4
LANG: JAVA
TASK: preface
*/
import java.util.*;
import java.io.*;
public class preface {
	static int N;
	static HashMap<Integer, String> letters;
	static int[] all;
	static HashMap<String, Integer> index;
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		BufferedReader b = new BufferedReader(new FileReader("preface.in"));
		N = Integer.parseInt(b.readLine());
		b.close();
		
		all = new int[7];
		letters = new HashMap<Integer, String>();
		letters.put(new Integer(1), "I");
		letters.put(new Integer(5), "V");
		letters.put(new Integer(10), "X");
		letters.put(new Integer(50), "L");
		letters.put(new Integer(100), "C");
		letters.put(new Integer(500), "D");
		letters.put(new Integer(1000), "M");
		
		index = new HashMap<String, Integer>();
		index.put("I", new Integer(0));
		index.put("V", new Integer(1));
		index.put("X", new Integer(2));
		index.put("L", new Integer(3));
		index.put("C", new Integer(4));
		index.put("D", new Integer(5));
		index.put("M", new Integer(6));
		
		for (int i = 1; i <= N; i++) {
			String first = "" + helper(i%10);
			for (int j = 0; j < first.length(); j++) {
				if (first.substring(j, j+1).equals("O")) {
					all[Integer.valueOf(index.get(letters.get(new Integer(1))))]++;
					System.out.println(i + " " + letters.get(new Integer(1)));
				} else if (first.substring(j, j+1).equals("F")) {
					all[Integer.valueOf(index.get(letters.get(new Integer(5))))]++;
					System.out.println(i + " " + letters.get(new Integer(5)));
				} else if (first.substring(j, j+1).equals("T")) {
					all[Integer.valueOf(index.get(letters.get(new Integer(10))))]++;
					System.out.println(i + " " + letters.get(new Integer(10)));
				}
			}
			int temp = i/10;
			String second = "" + helper(temp%10);
			for (int j = 0; j < second.length(); j++) {
				if (second.substring(j, j+1).equals("O")) {
					all[Integer.valueOf(index.get(letters.get(new Integer(10))))]++;
					System.out.println(i + " " + letters.get(new Integer(10)));
				}
				else if (second.substring(j, j+1).equals("F")) {
					all[Integer.valueOf(index.get(letters.get(new Integer(50))))]++;
					System.out.println(i + " " + letters.get(new Integer(50)));
				} else if (second.substring(j, j+1).equals("T")) {
					all[Integer.valueOf(index.get(letters.get(new Integer(100))))]++;
					System.out.println(i + " " + letters.get(new Integer(100)));
				}
			}
			int temp1 = i/100;
			String third = "" + helper(temp1%10);
			for (int j = 0; j < third.length(); j++) {
				if (third.substring(j, j+1).equals("O")) {
					all[Integer.valueOf(index.get(letters.get(new Integer(100))))]++;
					System.out.println(i + " " + letters.get(new Integer(100)));
				}
				else if (third.substring(j, j+1).equals("F")) {
					all[Integer.valueOf(index.get(letters.get(new Integer(500))))]++;
					System.out.println(i + " " + letters.get(new Integer(500)));
				} else if (third.substring(j, j+1).equals("T")) {
					all[Integer.valueOf(index.get(letters.get(new Integer(1000))))]++;
					System.out.println(i + " " + letters.get(new Integer(1000)));
				}
			}
			int temp2 = i/1000;
			String fourth = "" + helper(temp2);
			for (int j = 0; j < fourth.length(); j++) {
				if (fourth.substring(j, j+1).equals("O")) {
					all[Integer.valueOf(index.get(letters.get(new Integer(1000))))]++;
					System.out.println(i + " " + letters.get(new Integer(1000)));
				}
				else if (fourth.substring(j, j+1).equals("F")) {
					all[Integer.valueOf(index.get(letters.get(new Integer(5000))))]++;
					System.out.println(i + " " + letters.get(new Integer(5000)));
				} else if (fourth.substring(j, j+1).equals("T")) {
					all[Integer.valueOf(index.get(letters.get(new Integer(10000))))]++;
					System.out.println(i + " " + letters.get(new Integer(10000)));
				}
			}
		}
		
		PrintWriter p = new PrintWriter(new FileWriter("preface.out"));
		if (all[0] > 0)
			p.println("I " + all[0]);
		if (all[1] > 0)
			p.println("V " + all[1]);
		if (all[2] > 0)
			p.println("X " + all[2]);
		if (all[3] > 0)
			p.println("L " + all[3]);
		if (all[4] > 0)
			p.println("C " + all[4]);
		if (all[5] > 0)
			p.println("D " + all[5]);
		if (all[6] > 0)
			p.println("M " + all[6]);
		p.close();
		
		long endTime = System.currentTimeMillis();
		System.out.println("Time Elapsed: " + (endTime - startTime));
	}
	
	public static String helper(int x) {
		if (x == 0)
			return " ";
		else if (x == 1)
			return "O";
		else if (x == 2)
			return "OO";
		else if (x == 3)
			return "OOO";
		else if (x == 4)
			return "OF";
		else if (x == 5)
			return "F";
		else if (x == 6)
			return "FO";
		else if (x == 7)
			return "FOO";
		else if (x == 8)
			return "FOOO";
		else if (x == 9)
			return "OT";
		return "troll";
	}
	
	
	
	
	
	
	
	
}
