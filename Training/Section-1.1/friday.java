/*
ID: alanchu4
LANG: JAVA
TASK: friday
*/
import java.io.*;

public class friday {
	
    private static int[] days = new int[7];
    private static int countDays = 1;
    
    public static void main(String[] args) throws IOException {
    	BufferedReader b = new BufferedReader(new FileReader("friday.in"));
		PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        int numYears = Integer.parseInt(b.readLine());
        for(int i = 0; i <= numYears-1; i++) {
            if (isLeapYear(1900+i)) {
                int[] mWithLeap = {31,29,31,30,31,30,31,31,30,31,30,31};
                for (int j = 0; j <= 11; j++) {
                    for(int k = 1; k <= mWithLeap[j]; k++) {
                        if (k == 13)
                            increaseDays();
                        countDays++;
                    }
                }
            }
            else
            {
                int[] mWithNoLeap = {31,28,31,30,31,30,31,31,30,31,30,31};
                for (int j = 0; j <= 11; j++) {
                    for(int k = 1; k <= mWithNoLeap[j]; k++) {
                        if (k == 13)
                            increaseDays();
                        countDays++;
                    }
                }
            }
            
        }
        
        p.print(days[6] + " ");
        for(int i = 0; i <= 4; i++)
            p.print(days[i] + " ");
        p.println(days[5]);
        b.close();
        p.close();
    }
    
    public static boolean isLeapYear(int n) {
        if (n == 1900 || n == 2100 || n == 2200 || n == 2300 || n == 2500)
            return false;
        else if (n % 4 == 0)
            return true;
        return false;
    }
    
    //days[0] IS SUNDAY! NOT MONDAY!
    public static void increaseDays() {
        if (countDays % 7 == 0)
            days[0] = days[0] + 1;
        else if (countDays % 7 == 1)
            days[1] = days[1] + 1;
        else if (countDays % 7 == 2)
            days[2] = days[2]+1;
        else if (countDays % 7 == 3)
            days[3] = days[3] + 1;
        else if (countDays % 7 == 4)
            days[4] = days[4] + 1;
        else if (countDays % 7 == 5)
            days[5] = days[5] + 1;
        else if (countDays % 7 == 6)
            days[6] = days[6] + 1;
    }
}
