/*
ID: alanchu4
LANG: JAVA
TASK: combo
*/
import java.io.*;
import java.util.*;
public class combo {
	public static void main(String[] args) throws IOException {
		BufferedReader b = new BufferedReader(new FileReader("combo.in"));
		PrintWriter p = new PrintWriter(new FileWriter("combo.out"));
		int numbers = Integer.parseInt(b.readLine());
		StringTokenizer first = new StringTokenizer(b.readLine());
		StringTokenizer second = new StringTokenizer(b.readLine());
		int[] combo1 = new int[3];
		int[] combo2 = new int[3];
		if (numbers <= 5) {
			p.println(numbers*numbers*numbers);
			p.close();
			b.close();
			return;
		}
		for(int i = 0; i < 3; i++) {
			combo1[i] = Integer.parseInt(first.nextToken());
		}
		for(int i = 0; i < 3; i++) {
			combo2[i] = Integer.parseInt(second.nextToken());
		}
		ArrayList<Integer> firstPoss = new ArrayList<Integer>();
		ArrayList<Integer> secondPoss = new ArrayList<Integer>();
		ArrayList<Integer> thirdPoss = new ArrayList<Integer>();
		for(int i = -2; i <= 2; i++) {
			firstPoss.add(mod(combo1[0]+i,numbers));
			secondPoss.add(mod(combo1[1]+i,numbers));
			thirdPoss.add(mod(combo1[2]+i,numbers));
		}
		for(int i = -2; i <= 2; i++) {
			if (!(firstPoss.contains(mod(combo2[0]+i,numbers)))) {
				firstPoss.add(mod(combo2[0]+i,numbers));
			}
			if (!(secondPoss.contains(mod(combo2[1]+i,numbers)))) {
				secondPoss.add(mod(combo2[1]+i,numbers));
			}
			if (!(thirdPoss.contains(mod(combo2[2]+i,numbers)))) {
				thirdPoss.add(mod(combo2[2]+i,numbers));
			}
		}
		for(int i = 0; i < firstPoss.size(); i++) {
			System.out.print(firstPoss.get(i) + " ");
		}
		System.out.println();
		for(int i = 0; i < secondPoss.size(); i++) {
			System.out.print(secondPoss.get(i) + " ");
		}
		System.out.println();
		for(int i = 0; i < thirdPoss.size(); i++) {
			System.out.print(thirdPoss.get(i) + " ");
		}
		System.out.println();
		int count = 0;
		int[] choice1 = new int[firstPoss.size()];
		int[] choice2 = new int[secondPoss.size()];
		int[] choice3 = new int[thirdPoss.size()];
		for(int i = 0; i < choice1.length;i++) {
			choice1[i] = firstPoss.get(i).intValue();
		}
		for(int i = 0; i < choice2.length;i++) {
			choice2[i] = secondPoss.get(i).intValue();
		}
		for(int i = 0; i < choice3.length;i++) {
			choice3[i] = thirdPoss.get(i).intValue();
		}
		Arrays.sort(choice1);
		Arrays.sort(choice2);
		Arrays.sort(choice3);
		for(int i : choice1)
			System.out.print(i + " ");
		System.out.println();
		for(int i : choice2)
			System.out.print(i + " ");
		System.out.println();
		for(int i : choice3)
			System.out.print(i + " ");
		System.out.println();
		for(int i : firstPoss) {
			for(int j : secondPoss) {
				for(int k : thirdPoss) {
					if (isValid(i,j,k,combo1,numbers)) {
						count++;
					}
					else if (isValid(i,j,k,combo2,numbers)) {
						count++;
					}
				}
			}
		}
		p.println(count);
		b.close();
		p.close();
	}
	
	// n is the int we want to mod, m is the mod.
	public static int mod(int n, int m) {
		while (n >= m) {
			n -= m;
		}
		while (n < 0) {
			n += m;
		}
		return n;
	}
	
	public static boolean isValid(int a, int b, int c, int[] comb,int num) {
		if (Math.abs(mod(a-comb[0],num)) > 2 && Math.abs(mod(comb[0] - a,num)) > 2)
			return false;
		else if (Math.abs(mod(b-comb[1],num)) > 2 && Math.abs(mod(comb[1] - b,num)) > 2) {
			return false;
		}
		else if (Math.abs(mod(c-comb[2],num)) > 2 && Math.abs(mod(comb[2] - c,num)) > 2) {
			return false;
		}
		return true;
	}
}

