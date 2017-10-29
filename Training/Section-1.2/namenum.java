/*
ID: alanchu4
LANG: JAVA
TASK: namenum
*/
import java.io.*;
import java.util.*;
public class namenum {
	// Declares a map to store the stuff.
	private static Map<Integer,String[]> map = new HashMap<Integer,String[]>();
	private static String seq;
	private static ArrayList<String> total = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException {
		PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
		BufferedReader b = new BufferedReader(new FileReader("namenum.in"));
		BufferedReader dic = new BufferedReader(new FileReader("dict.txt"));

		seq = b.readLine();
		int count = 0;
		String line;
		while ((line = dic.readLine()) != null) {
			
			String cur = "";
			for(int i = 0; i < line.length(); i++) {
				char a = line.charAt(i);
				if (a == 'A')
					cur = cur + 2;
				else if (a == 'B')
					cur = cur + 2;
				else if (a == 'C')
					cur = cur + 2;
				else if (a == 'D')
					cur = cur + 3;
				else if (a == 'E')
					cur = cur + 3;
				else if (a == 'F')
					cur = cur + 3;
				else if (a == 'G')
					cur = cur + 4;
				else if (a == 'H')
					cur = cur + 4;
				else if (a == 'I')
					cur = cur + 4;
				else if (a == 'J')
					cur = cur + 5;
				else if (a == 'K')
					cur = cur + 5;
				else if (a == 'L')
					cur = cur + 5;
				else if (a == 'M')
					cur = cur + 6;
				else if (a == 'N')
					cur = cur + 6;
				else if (a == 'O')
					cur = cur + 6;
				else if (a == 'P')
					cur = cur + 7;
				else if (a == 'R')
					cur = cur + 7;
				else if (a == 'S')
					cur = cur + 7;
				else if (a == 'T')
					cur = cur + 8;
				else if (a == 'U')
					cur = cur + 8;
				else if (a == 'V')
					cur = cur + 8;
				else if (a == 'W')
					cur = cur + 9;
				else if (a == 'X')
					cur = cur + 9;
				else if (a == 'Y')
					cur = cur + 9;
				}
			if (cur.equals(seq)) {
				p.println(line);
				count++;
			}
		}
		if (count == 0)
			p.println("NONE");
		
		b.close();
		p.close();
		dic.close();
		
	}
	
	// We need to design a recursive method that depends on the number of digits. 
	// Let's say that base case is when we have numDigit equals 1, and another parameter is which map it is.
	public static void checkStrings(String cur, int numLeft, Integer key) throws IOException {
		BufferedReader b = new BufferedReader(new FileReader("dict.txt"));
		
		if (numLeft == 0) {
			String line;
			while ((line = b.readLine()) != null) {
				if (line.equals(cur)) {
					total.add(cur);
				}
			}
			
		} 
		else {
			String[] letters = map.get(key);
			for(int i = 0; i < letters.length; i++) {
				String awesome = cur + letters[i];
				int nLeft = numLeft-1;
				if (nLeft == 0) {
					checkStrings(awesome,0,new Integer(10));
				}
				else {
					int newKey = Character.getNumericValue(seq.charAt(seq.length()-nLeft));
					checkStrings(awesome,nLeft,new Integer(newKey));
				}
				
			}
			
		}
		b.close();
		
	}
}

//Puts all the keys into the Map
		/*map.put(new Integer(2),new String[] {"A","B","C"});
		map.put(new Integer(3),new String[] {"D","E","F"});
		map.put(new Integer(4),new String[] {"G","H","I"});
		map.put(new Integer(5),new String[] {"J","K","L"});
		map.put(new Integer(6),new String[] {"M","N","O"});
		map.put(new Integer(7),new String[] {"P","R","S"});
		map.put(new Integer(8),new String[] {"T","U","V"});
		map.put(new Integer(9),new String[] {"W","X","Y"});*/
