import java.util.*;
import java.io.*;
public class badmilk {
	// Numbers of Guests
	static int N;
	
	// Number of Milks
	static int M;
	
	// Number of Milk Drinks
	static int D;
	
	// Number of Sick Incidences
	static int S;
	
	static int[][] drinks;
	static int[][] sicknesses;
	static boolean[] candidates;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("badmilk.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("badmilk.out"));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		drinks = new int[D][3];
		sicknesses = new int[S][2];
		
		for(int i = 0; i < D; i++) {
			st = new StringTokenizer(br.readLine());
			drinks[i][0] = Integer.parseInt(st.nextToken());
			drinks[i][1] = Integer.parseInt(st.nextToken());
			drinks[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());
			sicknesses[i][0] = Integer.parseInt(st.nextToken());
			sicknesses[i][1] = Integer.parseInt(st.nextToken());
		}
		
		boolean[] sickNum = new boolean[51];
		int numSick = 0;
		for (int i = 0; i < S; i++) {
			sickNum[sicknesses[i][0]] = true;
		}
		for (int i = 0; i < sickNum.length; i++) {
			if (sickNum[i])
				numSick++;
		}
		
		candidates = new boolean[51];
		int[] candidate1 = new int[51];
		for(int i = 0; i < S; i++) {
			for (int j = 0; j < D; j++) {
				if (sicknesses[i][0] == drinks[j][0]) {
					if (drinks[j][2] < sicknesses[i][1]) {
						candidate1[drinks[j][1]]++;
					}
				}
			}
		}
		// This makes sense because all of the sick people must've drank the infected milk
		// So it follows that candidate[i] >= S
		for(int i = 1; i < candidate1.length; i++) {
			if (candidate1[i] >= numSick) {
				candidates[i] = true;
			}
		}
		boolean[] temp = new boolean[51];
		int count = 0;
		for(int i = 1; i < D; i++) {
			if (candidates[drinks[i][1]] && !temp[drinks[i][0]]) {
				count++;
				temp[drinks[i][0]] = true;
				System.out.println(drinks[i][0]);
			}
		}
		
		pw.println(count);
		br.close();
		pw.close();
	}
	
	/* Arrays.sort(drinks, new Comparator<int[]>() {
    @Override
    public int compare(final int[] entry1, final int[] entry2) {
        final int time1 = entry1[0];
        final int time2 = entry2[0];
        if (time1 > time2)
        	return 1;
        else if (time1 < time2)
        	return -1;
        else
        	return 1;
    }
});

Arrays.sort(sicknesses, new Comparator<int[]>() {
    @Override
    public int compare(final int[] entry1, final int[] entry2) {
        final int time1 = entry1[0];
        final int time2 = entry2[0];
        if (time1 > time2)
        	return 1;
        else if (time1 < time2)
        	return -1;
        else
        	return 1;
    }
}); 

for(int i = 0; i < D; i++) {
for(int j = 0; j < 3; j++) {
	System.out.print(drinks[i][j] + " ");
}
System.out.println();
}

for(int i = 0; i < S; i++) {
for(int j = 0; j < 2; j++) {
	System.out.print(sicknesses[i][j] + " ");
}
System.out.println();
}

*/
	
}
