/*
ID: alanchu4
LANG: JAVA
TASK: crypt1
*/
import java.io.*;
import java.util.*;
public class crypt1 {
	static int numDigits;
	static int[] allDigits;
	
	public static void main(String[] args) throws IOException {

		// Gets the input and stores it in an array
		Scanner b = new Scanner(new File("crypt1.in"));
		PrintWriter p = new PrintWriter(new FileWriter("crypt1.out"));
		
		numDigits = b.nextInt();
		allDigits = new int[numDigits];
		for(int i = 0; i < numDigits;i++) {
			allDigits[i] = b.nextInt();
		}
		
		int total = 0;
		for (int c = 0; c < numDigits; c++) {
			for (int a = 0; a < numDigits; a++) {
				for(int i = 0; i < numDigits; i++) {
					for(int j = 0; j < numDigits; j++) {
						for (int k = 0; k < numDigits; k++) {
							int first = allDigits[c]*(allDigits[i]+10*allDigits[j]+100*allDigits[k]);
							int second = allDigits[a]*(allDigits[i]+10*allDigits[j]+100*allDigits[k]);
							if (!checkDigits(first))
								continue;
							if (!checkDigits(second))
								continue;
							int third = 10*first + second;
							if (third > 9999) {
								continue;
							}
							if (!checkDigits(third%1000))
								continue;
							boolean temp = false;
							int temp1 = third/1000;
							for (int random = 0; random < allDigits.length;random++) {
								if (temp1 == allDigits[random])
									temp = true;
							}
							if (!temp)
								continue;
							total++;
						}
					}
				}
			}
		}
		p.println(total);
		p.close();
		b.close();
	}
	// Makes sure a is three digits and the digits are all legit
	public static boolean checkDigits(int a) {
		boolean[] ans = new boolean[3];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = false;
		}
		if (a > 999 || a < 100)
			return false;
		for (int i = 0; i < numDigits; i++) {
			if (a/100 == allDigits[i])
				ans[0] = true;
			if ((a%100)/10 == allDigits[i]) {
				ans[1] = true;
			}
			if ((a%10) == allDigits[i]) {
				ans[2] = true;
			}
		}
		if (ans[0] == false || ans[1] == false || ans[2] == false)
			return false;
		else
			return true;
	}
	
	
	
	
	
}
