/*
ID: alanchu4
LANG: JAVA
TASK: hamming
 */
import java.util.*;
import java.io.*;
public class hamming {
	static int N;
	static int B;
	static int D;
	static String[] allStrings;
	static int count;
	static int countStrings;
	static String[] good;
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		BufferedReader b = new BufferedReader(new FileReader("hamming.in"));
		StringTokenizer st = new StringTokenizer(b.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		b.close();
		
		///////////////////////////////////////////////////////
		count = 0;
		allStrings = new String[(int) Math.pow(2, B)];
		generate("",B);
		
		good = new String[N];
		countStrings = 0;
		int i = 0;
		good[countStrings] = allStrings[i];
		countStrings++;
		i++;
		while(countStrings < N) {
			boolean temp = false;
			int j = 0;
			while(good[j] != null && j < good.length) {
				if (!ham(good[j],allStrings[i])) {
					i++;
					temp = true;
					break;
				} 
				j++;
			}
			if (temp) continue;
			good[countStrings] = allStrings[i];
			i++;
			countStrings++;
		}
		
		for (int j = 0; j < good.length; j++) {
			System.out.println(good[j]);
		}
		
		for (int j = 0; j < good.length; j++) {
			System.out.print(binary(good[j]) + " ");
		}
		
		
		///////////////////////////////////////////////////////
		PrintWriter p = new PrintWriter(new FileWriter("hamming.out"));
	
		int count = 0;
		
		for (int j = 0; j < good.length; j++) {
			if (j == good.length-1) {
				p.println(binary(good[j]));
				break;
			}
			if ((j+1) % 10 == 0) {
				p.println(binary(good[j]));
				continue;
			}
			p.print(binary(good[j]) + " ");
		}
		
		p.close();
		long endTime = System.currentTimeMillis();
		System.out.println("Time Elapsed: " + (endTime - startTime));
	}
	
	public static int binary(String s) {
		int temp = 0;
		for (int i = 0; i <s.length(); i++) {
			if (s.charAt(i) == '1')
				temp += (int) Math.pow(2, s.length()-i-1);
		}
		
		return temp;
	}
	
	public static void generate(String s, int i) {
		if (i == 0) {
			allStrings[count] = s;
			count++;
		} else {
			generate(s + "0",i-1);
			generate(s + "1",i-1);
		}
	}
	
	public static boolean ham(String a, String b) {
		int temp = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i))
				temp++;
		}
		
		if (temp >= D)
			return true;
		else
			return false;
	}
}
