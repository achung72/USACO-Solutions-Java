import java.util.*;
import java.io.*;
public class cowdance {
	static int numCows;
	static int showLength;
	static int[] dances;
	static int count;
	static int time;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader b = new BufferedReader(new FileReader("cowdance.in"));
		StringTokenizer st = new StringTokenizer(b.readLine());
		numCows = Integer.parseInt(st.nextToken());
		showLength = Integer.parseInt(st.nextToken());
		dances = new int[numCows];
		for (int i = 0; i < numCows; i++) {
			dances[i] = Integer.parseInt(b.readLine());
		}
		count = 0;
		b.close();
		answer = Integer.MAX_VALUE;
		/*ArrayList<Integer> random = new ArrayList<Integer>();
		random.add(1);
		random.add(4);
		random.add(9);
		random.add(2);
		random.add(5);
		Collections.sort(random);
		System.out.println(Collections.binarySearch(random,new Integer((10))));*/
		
		int low = 1;
		int high = numCows;
		int mid = -2;
		while (low <= high) {
			mid = low + (high-low)/2;
			solve(mid);
			if (time > showLength) {
				low = mid + 1;
				//System.out.println("low is " + low);
			} else if (time <= showLength) {
				if (mid < answer) {
					answer = mid;
				}
				high = mid-1;
			}
		}
		System.out.println("mid is " + answer);
		
		PrintWriter p = new PrintWriter(new FileWriter("cowdance.out"));
		p.println(answer);
		p.close();
	}
	
	public static void solve(int K) {
		count = 0;
		time = 0;
		ArrayList<Integer> curCows = new ArrayList<Integer>();
		for (int i = 0; i < K; i++) {
			curCows.add(dances[count]);
			count++;
		}
		Collections.sort(curCows);
		/*for (int i = 0; i < curCows.size(); i++) {
			System.out.print(curCows.get(i) + " ");
		}*/
		System.out.println();
		while (time <= showLength && count <= numCows) {
			if (count == numCows) {
				time = time + curCows.remove(curCows.size()-1);
				//System.out.println("the end time was " + time + " when K was " + K);
				return;
			}
			int awesome = curCows.remove(0);
			time += awesome;
			//System.out.println("The time is " + time);
			
			for (int i = 0; i < curCows.size(); i++) {
				curCows.set(i, curCows.get(i) - awesome);
			}
			
			int temp = Collections.binarySearch(curCows,dances[count]);
			if (temp >= 0){
				curCows.add(temp, dances[count]);
				count++;
			}
			else {
				curCows.add(Math.abs(temp)-1,dances[count]);
				count++;
			}
		}
		//System.out.println("the end time was " + time + " when K was " + K);
	}
	
	
	
	
	
	
	
}
