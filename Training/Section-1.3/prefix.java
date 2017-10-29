/*
ID: alanchu4
LANG: JAVA
TASK: prefix
*/
import java.util.*;
import java.io.*;
public class prefix {
	static String[] prefixes;
	static String bash = "";
	static boolean[] values;
	
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		// ------------------ Loading Data ---------------------------
		
		BufferedReader b = new BufferedReader(new FileReader("prefix.in"));
		prefixes = new String[0];
		String str;
		while(2 > 1) {
			String temp = b.readLine();
			if (temp.equals("."))
				break;
			else {
				String[] temp1 = temp.split(" ");
				prefixes = concat(prefixes, temp1);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while ((str = b.readLine()) != null)
		    sb.append(str);

		bash = sb.toString();
		
//		while (2 > 1) {
//			String temp = b.readLine();
//			if (temp == null)
//				break;
//			else {
//				bash = bash + temp;
//			}
//		}
		
		b.close();
		
		long midTime = System.currentTimeMillis();
		
		System.out.println("Time Elapsed: " + (midTime - startTime));
//		Arrays.sort(prefixes, new java.util.Comparator<String>() {
//			@Override
//			public int compare(String s1, String s2) {
//				return s1.length() - s2.length();
//		}
//		});
		
		// ------------------------ Running ---------------------------
		
		values = new boolean[bash.length() + 1];
		values[0] = true;
		int curWinner = 0;
		for (int i = 1; i <= bash.length(); i++) {
			for (int j = 0; j < prefixes.length; j++) {
				String curPrefix = prefixes[j];
				int len = curPrefix.length();
				if (i >= len) {
					//System.out.println(i-len);
					String toMatch = bash.substring(i - len, i);
					if (toMatch.equals(curPrefix) && values[i-len]) {
						values[i] = true;
						curWinner = i;
						break;
					}
				}
			}
		}
		
		
		
		
		// ------------------------ Printing Answer --------------------
		
		PrintWriter p = new PrintWriter(new FileWriter("prefix.out"));
		
		p.println(curWinner);
		p.close();
	}
	
	public static String[] concat(String[] a, String[] b) {
		String[] temp = new String[a.length + b.length];
		for (int i = 0; i < a.length; i++) {
			temp[i] = a[i];
		}
		for (int i = 0; i < b.length; i++) {
			temp[a.length + i] = b[i];
		}
		return temp;
	}
	
	public static int getMax(boolean[] temp) {
		for (int i = temp.length-1; i >= 0; i--) {
			if (temp[i]) {
				return i+1;
			}
		}
		return 0;
	}
}
