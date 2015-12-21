import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class LeapYearCalculator{ 
	public static void main(String[] args) throws IOException{ 
		
		InputStreamReader istream = new InputStreamReader(System.in) ;
        BufferedReader bufRead = new BufferedReader(istream) ;
        
   try {
        System.out.print("Enter a year: ");
        String stryear = bufRead.readLine();
        int intyear = Integer.parseInt(stryear);
        printIsLeapYear(intyear);
        subsequentLeapYear(intyear);
   }
   catch (IOException err) {
        System.out.println("Error reading line");
   }

		//printIsLeapYear(1000);
		//printIsLeapYear(4);
		//isLeapYear(1000);
		//isLeapYear(4);
		//subsequentLeapYear(1000);
		//subsequentLeapYear(4);
		
	}
	public static void printIsLeapYear(int year){   
        if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) //if year is divisible by 400 OR if year is divisible by 4 and not divisible by 100
                System.out.println(year + " is a leap year");
        else
                System.out.println(year + " is not a leap year");
	}
	public static boolean isLeapYear(int year){
		boolean isLeapYear;

        // divisible by 400 OR divisible by 4 and not 100
        if (isLeapYear = (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))){
        	//System.out.println(isLeapYear);
        	return true;
        }
        else{
        	//System.out.println(isLeapYear);
        	return false;
        }
        
	}
	public static int subsequentLeapYear(int year){
			year = year + 1;
			while (!isLeapYear(year)){
				year = year + 1;
			}
			System.out.println("The subsequent leap year is: " + year);
			return year;
	}
}
