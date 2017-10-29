/*
ID: alanchu4
LANG: JAVA
TASK: beads
*/
import java.io.*;
public class beads {
	public static void main(String[] args) throws IOException {
		BufferedReader b = new BufferedReader(new FileReader("beads.in"));
		PrintWriter p = new PrintWriter(new FileWriter("beads.out"));
		int numBeads = Integer.parseInt(b.readLine());
		String str = b.readLine();
		int[] num = new int[numBeads];
		if (str.indexOf("b") == -1) {
			p.println(str.length());
			p.close();
			b.close();
			return;
		}
		if (str.indexOf("r") == -1) {
			p.println(str.length());
			p.close();
			b.close();
			return;
		}
//		System.out.println("hi!");
//		System.out.println(lookLeft(str,349));
//		System.out.println(lookRight(str,349));
		int index = 0;
		for(int i = 0; i <= numBeads-1; i++) {
			num[i] = lookLeft(str,i) + lookRight(str,i);
		}
		int max = num[0];
		for(int i = 1; i <= num.length-1; i++) {
			if (max < num[i]) {
				max = num[i];
				index = i;
			}
		}
		if (max >= str.length()) {
			p.println(str.length());
			p.close();
			b.close();
			return;
		}
		else {
		    p.println(max);
//		    p.println(index);
		}
//		p.println(index);
//		p.println(lookLeft(str,index));
//		p.println(lookRight(str,index));
//		p.println(lookLeft(str,349));
//		p.println(lookRight(str,349));
		b.close();
		p.close();
	}
	// Note that one case is missing. We're missing the case where we look left
	// from the element at the last index.
	
	//NOTE THAT THE THE LOOP WITH SCROLL FROM 0 TO 
	//  0 1 2 3 4 5 6 7 8 9 
	// w b b w r r b w r b
	public static int lookLeft(String str, int index) {
		
		char main = ' ';
		int count = 0;
		if (index == 0) {
			return leftOverflow(str);
		}
		if (str.charAt(index) == 'w') {
			while(str.charAt(index) == 'w') {
				count++;
				if (index == 0 && str.charAt(0) == 'w') {
					return count + leftOverflow(str)-1;
				}
				else if (index == 0)
					return count;
				index--;
			}
			main = str.charAt(index);
			while(str.charAt(index) == main || str.charAt(index) == 'w') {
				count++;
				if (index == 0 && (str.charAt(0) == main || str.charAt(0) == 'w')) {
					return count + leftOverflow(str)-1;
				}
				else if (index == 0)
					return count;
				index--;
			}
		}
		else {
			main = str.charAt(index);
			while(str.charAt(index) == main || str.charAt(index) == 'w') {
				count++;
				if (index == 0 && (str.charAt(0) == main || str.charAt(0) == 'w')) {
					return count + leftOverflow(str)-1;
				}
				else if (index == 0)
					return count;
				index--;
			}
		}
		return count;
	}
	// THIS METHOD INCLUDES THE CHAR AT 0!!
	public static int leftOverflow(String str) {
		char main = ' ';
		int count = 1;
		int index = str.length()-1;
		if (str.charAt(0) == 'w') {
			while(str.charAt(index) == 'w') {
				count++;
				index--;
			}
			main = str.charAt(index);
			while(str.charAt(index) == 'w' || str.charAt(index) == main) {
				count++;
				index--;
			}
			return count;
		}
		else {
			main = str.charAt(0);
			while(str.charAt(index) == main || str.charAt(index) == 'w') {
				count++;
				index--;
			}
			return count;
		}
	}
//	if (index+1 == str.length()-1 && str.charAt(index+1) == str.charAt(str.length()-1)) {
	//	return count + rightOverflow(str);
//	}
	
	public static int lookRight(String str, int index) {
		char main = ' ';
		int count = 0;
		if (index == str.length()-1) {
			return lookRight(str,-1);
		}
		/*System.out.println("This is the index!");
		System.out.println(str.length() + " This is the length?");
		System.out.println(index);
		System.out.println((index+1==str.length()-1));*/
		
		if (str.charAt(index+1) == 'w') {
			while(str.charAt(index+1) == 'w') {
				count++;
				if (index+1 == str.length()-1 && str.charAt(index+1) == 'w') {
					return count + rightOverflow(str)-1;
				}
				if (index+1 == str.length()-1) {
					return count;
				}
				index++;
			}
			main = str.charAt(index+1);
			while(str.charAt(index+1) == main || str.charAt(index+1) == 'w') {
				count++;
				
				if (index+1 == str.length()-1 && (str.charAt(index+1) == main || str.charAt(index+1) == 'w')) {
					return count + rightOverflow(str)-1;
				}
				else if (index + 1 == str.length()-1)
					return count;
				index++;
			}
		}
		else {
			main = str.charAt(index+1);
			if (index+1 == str.length()-1) {
				return count + rightOverflow(str);
			}
			while(str.charAt(index+1) == main || str.charAt(index+1) == 'w') {
				count++;
				
				if (index+1 == str.length()-1 && (str.charAt(index+1) == 'w' || str.charAt(index+1) == main)) {
					return count + rightOverflow(str)-1;
				}
				else if (index + 1 == str.length()-1)
					return count;
				index++;
			}
		}
		return count;
	}
	//INCLUDES THE CHARACTER AT str.length()-1
	public static int rightOverflow(String str) {
		char main = ' ';
		int count = 1;
		int index = 0;
		if (str.charAt(str.length()-1) == 'w') {
			while(str.charAt(index) == 'w') {
				count++;
				index++;
			}
			main = str.charAt(index+1);
			while(str.charAt(index) == 'w' || str.charAt(index) == main) {
				count++;
				index++;
			}
			return count;
		}
		else {
			main = str.charAt(str.length()-1);
			while(str.charAt(index) == main || str.charAt(index) == 'w') {
				count++;
				index++;
			}
			return count;
		}
	}
}
