import java.util.*;
import java.io.*;
public class cowcode {
	static String s;
	static long count;
	public static void main(String[] args) throws IOException {
		BufferedReader b = new BufferedReader(new FileReader("cowcode.in"));
		StringTokenizer st = new StringTokenizer(b.readLine());
		s = st.nextToken();
		count = Long.parseLong(st.nextToken());
		b.close();
		
		if (count == s.length()) {
			PrintWriter p = new PrintWriter(new FileWriter("cowcode.out"));
			p.println(s.charAt(s.length()-1));
			System.out.println(s.charAt(s.length()-1));
			p.close();
			return;
		}
		long len = s.length();
		int factor = 0;
		while (len < count) {
			len = 2*len;
		}
		
		long diff = len - count;
		long cur = len - diff;
		
		while (cur >= s.length()) {
			if (cur == s.length()) {
				break;
			}
			System.out.println("cur is " + cur + ", len is " + len + ", factor is " + factor + ", and diff is " + diff);
			if (cur == (len/2) + 1) {
				cur--;
				len = len/2;
			} else {
				cur = cur - (len/2) - 1;
				len = s.length();
				while (len < cur) {
					len = 2*len;
				}
			}
		}
		
		System.out.println("cur is " + cur + ", len is " + len + ", factor is " + factor + ", and diff is " + diff);
		
		System.out.println(s.charAt((int) cur - 1));
		PrintWriter p = new PrintWriter(new FileWriter("cowcode.out"));
		p.println(s.charAt((int) cur - 1));
		p.close();
	}
}
