/*
ID: alanchu4
LANG: JAVA
TASK: zerosum
*/
import java.util.*;
import java.io.*;


public class zerosum {
	static int N;
	static ArrayList<String> answers;
	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		BufferedReader b = new BufferedReader(new FileReader("zerosum.in"));
		N = Integer.parseInt(b.readLine());
		b.close();
		answers = new ArrayList<String>();
		run(0,new char[N]);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
//		for (int i = 0; i < answers.size(); i++) {
//			System.out.println(answers.get(i));
//		}
		
		PrintWriter p = new PrintWriter(new FileWriter("zerosum.out"));
		for (int i = 0; i < answers.size()/3; i++) {
			p.println(answers.get(3*i));
		}
		p.close();
	}
	
	public static void run(int cur, char[] characters) {
		if (cur == N) {
			if (compute(characters) == 0) {
				String temp = "";
				for (int i = 0; i < N-1; i++) {
					temp = temp + (i+1);
					temp = temp + characters[i];
				}
				temp = temp + N;
				answers.add(temp);
			}
		} else {
			char[] awesome = Arrays.copyOf(characters, characters.length);
			awesome[cur] = ' ';
			run(cur+1, awesome);
			awesome[cur] = '+';
			run(cur+1, awesome);
			awesome[cur] = '-';
			run(cur+1, awesome);
		}
	}
	
	public static int compute(char[] characters) {
		String temp = "";
		for (int i = 0; i < N-1; i++) {
			temp = temp + (i+1);
			temp = temp + characters[i];
		}
		temp = temp + N;
		temp = temp.replaceAll("\\s+", "");
		int sum = 0;
		
		Stack<String> values = new Stack<String>();
		Stack<String> operators = new Stack<String>();
		int curIndex = temp.length();
		for (int i = temp.length()-1; i >= 0; i--) {
			if (temp.charAt(i) == '+' || temp.charAt(i) == '-') {
				values.push(temp.substring(i+1,curIndex));
				operators.push("" + temp.charAt(i));
				curIndex = i;
			}
			if (i == 0) {
				values.push(temp.substring(0,curIndex));
			}
		}
		while (!operators.empty()) {
			int first = Integer.parseInt(values.pop());
			int second = Integer.parseInt(values.pop());
			char operate = operators.pop().charAt(0);
			if (operate == '+') {
				values.push("" + (first + second));
			} else if (operate == '-') {
				values.push("" + (first - second));
			}
		}
		return Integer.parseInt(values.pop());
	}
}












