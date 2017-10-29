/*
ID: alanchu4
LANG: JAVA
TASK: ariprog
*/
import java.util.*;
import java.io.*;
public class ariprog {
	public static void main(String[] args) throws IOException {
		int total = 0;
		long startTime = System.currentTimeMillis();
		Scanner sc = new Scanner(new File("ariprog.in"));
		PrintWriter p = new PrintWriter(new FileWriter("ariprog.out"));
		
		// Defining Variables
		int seqLength = sc.nextInt();
		int squareBound = sc.nextInt();
		//ArrayList<Integer> allSums = new ArrayList<Integer>();
		int max = 2*squareBound*squareBound;
		boolean[] bisquares = new boolean[max+1];
		
		for(int i = 0; i <= squareBound; i++) {
			for (int j = 0; j <= squareBound; j++) {
				//allSums.add(i*i+j*j);
				bisquares[i*i+j*j] = true;
			}
		}
		//Set<Integer> temp = new HashSet<>();
		//temp.addAll(allSums);
		//allSums.clear();
		//allSums.addAll(temp);
		//Collections.sort(allSums);
		//System.out.println(allSums.size());
		
		int maxGap = 2*squareBound*squareBound/(seqLength-1);
		for(int i = 0; i < bisquares.length;i++)
			if (bisquares[i])
				System.out.print(i + " ");
		System.out.println();
		
		for(int gap = 1; gap <= maxGap; gap++) {
			for (int start = 0; start <= max; start++) {
				if (!bisquares[start])
					continue;
				boolean victory = true;
				for (int i = 1; i <= seqLength-1; i++) {
					if (start+gap*i > max) {
						victory = false;
						break;
					}
					if (!bisquares[start+gap*i]) {
						victory = false;
						break;
					}
				}
				if (victory) {
					p.println(start + " " + gap);
					total++;
				}
			}
		}
		
		if (total == 0)
			p.println("NONE");
		
		
		long endTime = System.currentTimeMillis();
		long totalTime = endTime-startTime;
		System.out.println(totalTime);
		
		
		sc.close();
		p.close();
	}
}
