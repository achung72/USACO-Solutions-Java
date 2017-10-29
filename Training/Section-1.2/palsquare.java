/*
ID: alanchu4
LANG: JAVA
TASK: palsquare
*/
import java.io.*;
public class palsquare {
	public static void main(String[] args) throws IOException {
		BufferedReader b = new BufferedReader(new FileReader("palsquare.in"));
		PrintWriter p = new PrintWriter(new FileWriter("palsquare.out"));
		int base = Integer.parseInt(b.readLine());
		for(int n = 1; n <= 300; n++) {
			if (isPalindrone(Integer.toString(n*n,base))) {
				p.print(Integer.toString(n,base).toUpperCase() + " ");
				p.print(Integer.toString(n*n,base).toUpperCase());
				p.println();
			}
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
