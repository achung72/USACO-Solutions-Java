/*
ID: alanchu4
LANG: JAVA
TASK: gift1
*/
import java.io.*;
public class gift1 {
	public static void main (String[] args) throws IOException {
		BufferedReader b = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
		int numPeople = Integer.parseInt(b.readLine());
		String[] names = new String[numPeople];
		int[] values = new int[numPeople];
		for(int i = 0; i <= numPeople-1; i++) {
			names[i] = b.readLine();
		}
		for(int i = 0; i <= numPeople-1; i++) {
			String curString = b.readLine();
			for (int j = 0; j <= numPeople-1; j++) {
				if (names[j].equals(curString)) {
					String money = b.readLine();
					int paid = Integer.parseInt(money.substring(0, money.indexOf(' ')));
					int paidPeople = Integer.parseInt(money.substring(money.indexOf(' ')+1));
					if (paidPeople == 0)
						continue;
					values[j] -= paid - (paid%paidPeople);
					for (int k = 0; k <= paidPeople-1; k++) {
						String name = b.readLine();
						for(int m = 0; m <= numPeople-1; m++) {
							if (names[m].equals(name)) {
								values[m] += paid/paidPeople;
							}
						}
					}
				}
			}
		}
		for (int i = 0; i <= numPeople-1; i++) {
			p.println(names[i] + " " + values[i]);
		}
		b.close();
		p.close();
	}
}


