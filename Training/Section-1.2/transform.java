/*
ID: alanchu4
LANG: JAVA
TASK: transform
*/
import java.io.*;
public class transform {
	public static void main(String[] args) throws IOException {
		BufferedReader b = new BufferedReader(new FileReader("transform.in"));
		PrintWriter p = new PrintWriter(new FileWriter("transform.out"));
		int d = Integer.parseInt(b.readLine());
		if (d == 1) {
			p.println(6);
			p.close();
			return;
		}
		String[][] first1 = new String[d][d];
		String[][] first2 = new String[d][d];
		String[][] first3 = new String[d][d];
		String[][] first4 = new String[d][d];
		String[][] first5 = new String[d][d];
		String[][] first6 = new String[d][d];
		String[][] first7 = new String[d][d];
		String[][] first8 = new String[d][d];
		for(int i = 0; i < d; i++) {
			String row = b.readLine();
			for(int j = 0; j < d; j++) {
				first1[i][j] = "" + row.charAt(j);
				first2[i][j] = "" + row.charAt(j);
				first3[i][j] = "" + row.charAt(j);
				first4[i][j] = "" + row.charAt(j);
				first5[i][j] = "" + row.charAt(j);
				first6[i][j] = "" + row.charAt(j);
				first7[i][j] = "" + row.charAt(j);
				first8[i][j] = "" + row.charAt(j);
			}
		}
		
		String[][] second = new String[d][d];
		for(int i = 0; i < d; i++) {
			String row = b.readLine();
			for(int j = 0; j < d; j++) {
				second[i][j] = "" + row.charAt(j);
			}
		}
		if (sameArray(ninety(first1), second)) {
			p.println(1);
			b.close();
			p.close();return;
		}
		else if (sameArray(oneEighty(first2), second)) {
			p.println(2);
			b.close();
			p.close();return;
		}
		else if (sameArray(twoSeventy(first3), second)) {
			p.println(3);
			b.close();
			p.close();return;
		}
		else if (sameArray(reflection(first4), second)) {
			p.println(4);
			b.close();
			p.close();return;
		}
		else if (sameArray(ninety(reflection(first5)), second)) {
			p.println(5);
			b.close();
			p.close();return;
		}
		else if (sameArray(oneEighty(reflection(first6)), second)) {
			p.println(5);
			b.close();
			p.close();return;
		}
		else if (sameArray(twoSeventy(reflection(first7)), second)) {
			p.println(5);
			b.close();
			p.close();
			return;
		}
		else if (sameArray(first8, second)) {
			p.println(6);
			b.close();
			p.close();
			return;
		}
		else{
			p.println(7);
			b.close();
			p.close();
			return;
		}
	}
	
	public static String[][] ninety(String[][] arr) {
		for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                String temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length/2; j++) {
				String temp = arr[i][arr.length-j-1];
                arr[i][arr.length-j-1] = arr[i][j];
                arr[i][j] = temp;
			}
		}
		return arr;
	}
	
	public static String[][] oneEighty(String[][] arr) {
		for(int i = 0; i < arr.length/2; i++) {
			for(int j = 0; j < arr.length; j++) {
				String temp = arr[i][j];
				arr[i][j] = arr[arr.length-i-1][j];
				arr[arr.length-i-1][j] = temp;
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length/2; j++) {
				String temp = arr[i][arr.length-j-1];
                arr[i][arr.length-j-1] = arr[i][j];
                arr[i][j] = temp;
			}
		}
		return arr;
	}
	
	public static String[][] twoSeventy(String[][] arr) {
		for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                String temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
		
		for(int i = 0; i < arr.length/2; i++) {
			for(int j = 0; j < arr.length; j++) {
				String temp = arr[i][j];
				arr[i][j] = arr[arr.length-i-1][j];
				arr[arr.length-i-1][j] = temp;
			}
		}
		return arr;
	}
	
	public static String[][] reflection(String[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length/2; j++) {
				String temp = arr[i][j];
				arr[i][j] = arr[i][arr.length-j-1];
				arr[i][arr.length-j-1] = temp;
			}
		}
		
		return arr;
	}
	
	public static boolean sameArray(String[][] a, String[][] b){
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a.length; j++) {
				if (!a[i][j].equals(b[i][j]))
					return false;
			}
		}
		return true;
	}
}
