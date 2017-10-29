/*
ID: alanchu4
LANG: JAVA
TASK: runround
*/

import java.util.*;
import java.io.*;
public class runround {
	static long N;
	static String s;
	public static void main(String[] args) throws IOException {
		BufferedReader b = new BufferedReader(new FileReader("runround.in"));
		s = b.readLine();
		N = Long.parseLong(s);
		b.close();
		
		
		long curNum = N+1;
		while (N > 0) {
			if (checkStr(curNum + "")) {
				PrintWriter p = new PrintWriter(new FileWriter("runround.out"));
				p.println(curNum);
				p.close();
				return;
			}
			curNum++;
		}
		
		
	}
	
	public static boolean checkStr(String s) {
		boolean[] temp = new boolean[10];
		for (int i = 0; i < s.length(); i++) {
			int awesome = Integer.parseInt(s.substring(i,i+1));
			if (temp[awesome]) {
				return false;
			}
			temp[awesome] = true;
		}
		
		boolean[] good = new boolean[s.length()];
		int numTimes = s.length();
		int curTimes = 1;
		int curIndex = 0;
		int goTo = -4;
		while (curTimes <= numTimes) {
			//System.out.println(curIndex);
			good[curIndex] = true;
			goTo = Character.getNumericValue(s.charAt(curIndex));
			curIndex = (curIndex + goTo)%numTimes;
			curTimes++;
		}
		
		
		
		if (curIndex != 0)
			return false;
		
		for (int i = 0; i < good.length; i++) {
			if (!good[i])
				return false;
		}
		return true;
	}
}
