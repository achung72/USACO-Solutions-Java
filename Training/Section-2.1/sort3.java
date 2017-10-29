/*
ID: alanchu4
LANG: JAVA
TASK: sort3
 */
import java.util.*;
import java.io.*;
public class sort3 {
	static int[] nums;
	static int totalNum;
	// THE INDEX 0 DOES NOT CORRESPOND TO ANYTHING
	static int[] howManyNums;
	// THE INDEX 0 DOES NOT CORRESPOND TO ANYTHING
	static int[][] ranges;
	static int countSwaps;
	
	public static void main(String[] args) throws IOException {
		// Timing and Reading Data
		long startTime = System.currentTimeMillis();
		BufferedReader b = new BufferedReader(new FileReader("sort3.in"));
		totalNum = Integer.parseInt(b.readLine());
		nums = new int[totalNum];
		for(int i = 0; i < totalNum; i++) {
			nums[i] = Integer.parseInt(b.readLine());
		}
		b.close();
		///////////////////////////////////////////////////
		
		findNums();
		ranges = new int[4][2];
		ranges[1][0] = 0;
		ranges[1][1] = howManyNums[1]-1;
		ranges[2][0] = howManyNums[1];
		ranges[2][1] = howManyNums[1] + howManyNums[2]-1;
		ranges[3][0] = howManyNums[1] + howManyNums[2];
		ranges[3][1] = nums.length-1;
		
		////////////////////////////////////////////////////
		//print(nums);
		
		swap();
		
		System.out.println(countSwaps);
		PrintWriter p = new PrintWriter(new FileWriter("sort3.out"));
		p.println(countSwaps);
		p.close();
		
		long endTime = System.currentTimeMillis();
		System.out.println("Time Elapsed: " + (endTime - startTime));
	}
	
	public static void swap() {
		countSwaps = 0;
		ArrayList<Integer> threeIn1st = new ArrayList<Integer>();
		ArrayList<Integer> oneIn3rd = new ArrayList<Integer>();
		ArrayList<Integer> twoIn3rd = new ArrayList<Integer>();
		ArrayList<Integer> threeIn2nd = new ArrayList<Integer>();
		ArrayList<Integer> twoIn1st = new ArrayList<Integer>();
		ArrayList<Integer> oneIn2nd = new ArrayList<Integer>();
		
		for (int i = ranges[1][0]; i <= ranges[1][1]; i++) {
			if (nums[i] == 3) {
				threeIn1st.add(i);
			} else if (nums[i] == 2) {
				twoIn1st.add(i);
			}
		}
		
		for (int i = ranges[2][0]; i <= ranges[2][1]; i++) {
			if (nums[i] == 3) {
				threeIn2nd.add(i);
			} else if (nums[i] == 1) {
				oneIn2nd.add(i);
			}
		}
		
		for (int i = ranges[3][0]; i <= ranges[3][1]; i++) {
			if (nums[i] == 1) {
				oneIn3rd.add(i);
			} else if (nums[i] == 2) {
				twoIn3rd.add(i);
			}
		}
		// Swap 3's in the first section with 1's in the third section
		while(threeIn1st.size() > 0 && oneIn3rd.size() > 0) {
			swap(oneIn3rd.remove(0),threeIn1st.remove(0));
			countSwaps++;
			//print(nums);
		}
		// Suppose there are still 3's in the first section
		// Then we swap them with 2's in the third section
		while(threeIn1st.size() > 0 && twoIn3rd.size() > 0) {
			swap(threeIn1st.remove(0), twoIn3rd.remove(0));
			countSwaps++;
			//print(nums);
		}
		// Now there can only be 3's in the second section. 
		// We swap these 3's with the 2's in the third section
		while(threeIn2nd.size() > 0 && twoIn3rd.size() > 0) {
			swap(threeIn2nd.remove(0), twoIn3rd.remove(0));
			countSwaps++;
			//print(nums);
		}
		
		while(oneIn3rd.size() > 0 && threeIn2nd.size() > 0) {
			swap(oneIn3rd.remove(0), threeIn2nd.remove(0));
			countSwaps++;
			//print(nums);
		}
		// Now if our code works, there are no more three's anywhere.
		// It suffices to swap the one's and the two's
		
		twoIn1st = new ArrayList<Integer>();
		oneIn2nd = new ArrayList<Integer>();
		
		for (int i = ranges[1][0]; i <= ranges[1][1]; i++) {
			if (nums[i] == 2) {
				twoIn1st.add(i);
			}
		}
		
		for (int i = ranges[2][0]; i <= ranges[2][1]; i++) {
			if (nums[i] == 1) {
				oneIn2nd.add(i);
			}
		}
		
		
		while (twoIn1st.size() > 0 && oneIn2nd.size() > 0) {
			swap(oneIn2nd.remove(0), twoIn1st.remove(0));
			countSwaps++;
			//print(nums);
		}
		
		
		
		
		
	}
	
	public static void findNums() {
		howManyNums = new int[4];
		for (int i = 0; i < totalNum; i++) {
			howManyNums[nums[i]]++;
		}
	}
	
	public static void swap(int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
	
	public static void print(int[] x) {
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i] + " ");
		}
		System.out.println();
	}
}
