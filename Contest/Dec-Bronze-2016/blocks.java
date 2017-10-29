import java.util.*;
import java.io.*;
public class blocks {
	// Number of boards
	static int N;
	
	// All words
	static String[][] allWords;
	
	static char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
	public static void main(String[] args) throws IOException {
		BufferedReader b = new BufferedReader(new FileReader("blocks.in"));
		N = Integer.parseInt(b.readLine());
		StringTokenizer st;
		allWords = new String[N][2];
		for (int i = 0; i < N; i++ ){
			st = new StringTokenizer(b.readLine());
			allWords[i][0] = st.nextToken();
			allWords[i][1] = st.nextToken();
		}
		b.close();
		
		/*
		for (int i = 0; i < allWords.length; i++) {
			System.out.println(allWords[i][0] + " " + allWords[i][1]);
		}
		
		for (int i = 0; i < alphabet.length; i++) {
			System.out.println(alphabet[i]);
		}
		*/
		
		
		PrintWriter p = new PrintWriter(new FileWriter("blocks.out"));
		
		int temp = -100;
		for (int i = 0; i < alphabet.length; i++) {
			temp = bash(alphabet[i]);
			p.println(temp);
		}
		p.close();
	}
	
	public static int bash(char x) {
		int total = 0;
		int first = 0;
		int second = 0;
		
		for (int i = 0; i < allWords.length; i++) {
			String word1 = allWords[i][0];
			String word2 = allWords[i][1];
			for (int j = 0; j < word1.length(); j++) {
				if (word1.charAt(j) == x)
					first++;
			}
			for (int j = 0; j < word2.length(); j++) {
				if (word2.charAt(j) == x)
					second++;
			}
			total += Math.max(first, second);
			first = 0;
			second = 0;
		}
		
		
		return total;
	}
}
