/*
ID: alanchu4
LANG: JAVA
TASK: dualpal
*/
import java.io.*;
import java.util.*;
public class dualpal {
	public static void main(String[] args) throws IOException {
		BufferedReader b = new BufferedReader(new FileReader("dualpal.in"));
		PrintWriter p = new PrintWriter(new FileWriter("dualpal.out"));
		StringTokenizer st = new StringTokenizer(b.readLine());
		int count = Integer.parseInt(st.nextToken());
		int root = Integer.parseInt(st.nextToken())+1;
		while(count>0) {
			int secondCount = 0;
			for(int i = 2; i <= 10; i++) {
				if (isPalindrone(Integer.toString(root, i))) {
					secondCount++;
				}
				if (secondCount==2) {
					count--;
					p.println(root);
					break;
				}
			}
			root++;
		}
		b.close();
		p.close();
	}
	
	public static boolean isPalindrone(String s) {
		for(int i = 0; i <= s.length()/2; i++) {
			if (s.charAt(i) != s.charAt(s.length()-i-1)) {
				return false;
			}
		}
		return true;
	}
}
