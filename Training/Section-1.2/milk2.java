/*
ID: alanchu4
LANG: JAVA
TASK: milk2
*/
import java.util.ArrayList;
import java.io.*;
import java.util.*;
public class milk2 {
	public static void main(String[] args) throws IOException {
		BufferedReader b = new BufferedReader(new FileReader("milk2.in"));
		PrintWriter p = new PrintWriter(new FileWriter("milk2.out"));
		int totalFarm = Integer.parseInt(b.readLine());
		if (totalFarm == 1) {
			StringTokenizer st = new StringTokenizer(b.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			p.print(second-first);
			p.println(" " + 0);
			b.close();
			p.close();
			return;
		}
		int[][] all = new int[totalFarm][2];
		String line;
		int count = 0;
		while ((line = b.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line);
			all[count][0] = Integer.parseInt(st.nextToken());
			all[count][1] = Integer.parseInt(st.nextToken());
			count++;
		}
		
		Arrays.sort(all, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if (a[0] > b[0])
					return 1;
				else if (a[0] == b[0])
					return 0;
				else
					return -1;
			}
		});
		ArrayList<int[]> notMain = new ArrayList<int[]>(Arrays.asList(all));
		
		for(int i = 0; i < notMain.size(); i++) {
			int[] awesome = notMain.get(i);
			System.out.println(awesome[0] + " " + awesome[1]);
		}
		ArrayList<int[]> main = new ArrayList<int[]>();
		int start = 0;
		while(start != -1) {
			int[] m = process(notMain,start);
			start = m[2];
			main.add(m);
		}
		
		for(int i = 0; i < main.size(); i++) {
			int[] cur = main.get(i);
			System.out.println(cur[0] + " " + cur[1]);
		}
		
		int bigInterval = -10000;
		for(int i = 0; i < main.size(); i++) {
			int[] cur = main.get(i);
			if (cur[1] - cur[0] > bigInterval)
				bigInterval = cur[1]-cur[0];
		}
		p.print(bigInterval + " ");
		int noFarm = -10000;
		System.out.println(main.size());
		if (main.size() == 1) {
			p.println(0);
			b.close();
			p.close();
			return;
		}
		for(int i = 0; i < main.size()-1; i++) {
			int[] first = main.get(i);
			int[] second = main.get(i+1);
			if (second[0]-first[1] > noFarm)
				noFarm = second[0]-first[1];
		}
		p.println(noFarm);
		b.close();
		p.close();

	}

	
	public static int[] process(ArrayList<int[]> arr, int start) {
		int[] temp = {0,0};
		int[] superTemp = arr.get(start);
		temp[0] = superTemp[0];
		temp[1] = superTemp[1];
		if (start == arr.size()-1) {
			int[] done = new int[3];
			done[0] = temp[0];
			done[1] = temp[1];
			done[2] = -1;
		}
		for(int i = start+1; i < arr.size(); i++) {
			int[] ok = arr.get(i);
			if (temp[1] >= ok[1]) {
				
			}
			else if (temp[1] >= ok[0]) {
				temp[1] = ok[1];
			}
			else {
				int[] done = new int[3];
				done[0] = temp[0];
				done[1] = temp[1];
				done[2] = i;
				return done;
			}
		}
		int[] done = new int[3];
		done[0] = temp[0];
		done[1] = temp[1];
		done[2] = -1;
		return done;
	}
}
