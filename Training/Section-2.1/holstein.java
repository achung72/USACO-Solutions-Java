/*
ID: alanchu4
LANG: JAVA
TASK: holstein
 */
import java.util.*;
import java.io.*;
public class holstein {
	static int[] task;
	static int[][] scoops;
	static int numVitamins;
	static int numScoopTypes;
	static boolean[] best;
	static int bestNum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader b = new BufferedReader(new FileReader("holstein.in"));
		numVitamins = Integer.parseInt(b.readLine());
		StringTokenizer st = new StringTokenizer(b.readLine());
		task = new int[numVitamins];
		for (int i = 0; i < numVitamins; i++) {
			task[i] = Integer.parseInt(st.nextToken());
		}
		numScoopTypes = Integer.parseInt(b.readLine());
		scoops = new int[numScoopTypes][numVitamins];
		for (int i = 0; i < numScoopTypes; i++) {
			st = new StringTokenizer(b.readLine());
			for (int j = 0; j < numVitamins; j++) {
				scoops[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bestNum = Integer.MAX_VALUE;
		best = null;
		solve(0, new boolean[numScoopTypes], 0, new int[numVitamins]);
		System.out.println(bestNum);
		int count = 0;
		for (int i = 0; i < best.length; i++) {
			if (best[i])
				count++;
		}
		int[] ans = new int[count];
		int temp = 0;
		for (int i = 0; i < best.length; i++) {
			if(best[i]) {
				ans[temp] = i;
				temp++;
			}
		}
		Arrays.sort(ans);
		PrintWriter p = new PrintWriter(new FileWriter("holstein.out"));
		p.print(bestNum + " ");
		for (int i = 0; i < count; i++) {
			if (i == count-1)
				p.println(ans[i]+1);
			else 
				p.print(ans[i]+1 + " ");
		}
		p.close();
		System.out.println("count is " + count);
		for (int i = 0; i < best.length; i++) {
			System.out.print(best[i] + " ");
		}
	}	
	
	public static void solve(int at, boolean[] used, int count, int[] cur) {
		if (at == used.length) {
			for (int i = 0; i < numVitamins; i++) {
				if (cur[i] < task[i])
					return;
			}
			if (better(count, used)) {
				if (count == 0) {
					for (int i = 0; i < cur.length; i++) {
						System.out.println(cur[i]);
						System.out.println("task");
						System.out.println(task[i]);
					}
				}
				bestNum = count;
				best = used.clone();
			}
			return;
		}
		solve(at+1, used, count, cur);
		for (int i = 0; i < numVitamins; i++) {
			cur[i] += scoops[at][i];
		}
		used[at] = true;
		solve(at+1, used, count+1, cur);
		used[at] = false;
		for (int i = 0; i < numVitamins; i++) {
			cur[i] -= scoops[at][i];
		}
	}
	
	public static boolean better(int count, boolean[] used) {
		if (count < bestNum)
			return true;
		if (count > bestNum)
			return false;
		
		for (int i = 0; i < numVitamins; i++) {
			if (used[i] && !best[i])
				return true;
			if (!used[i] && best[i])
				return false;
		}
		return false;
	}
 }
