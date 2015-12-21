import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class MakingChange {
	public static void main (String[] args) throws IOException{
		
		InputStreamReader istream = new InputStreamReader(System.in) ;
        BufferedReader bufRead = new BufferedReader(istream) ;
        
   try {
        System.out.print("Enter amount in cents: ");
        String change = bufRead.readLine();
        
        int total = Integer.parseInt(change);
		int toonies = total / 200;
		int remainder = total - toonies*200; //money - number of 2$ coins in money*200
		
		int loonies = remainder / 100;
		remainder = remainder - loonies*100; //remainder - number of 1$ coins in money*100
		
		int quarters = remainder / 25;
		remainder = remainder - quarters*25; //remainder - number of 25¢ coins in money*25
		
		int dimes = remainder / 10;
		remainder = remainder - dimes*10; //remainder - number of 10¢ coins in money*10
		
		int nickels = remainder / 5;
		remainder = remainder - nickels*5; //remainder - number of 5¢ coins in money*5
		
		int cents = remainder / 1;
		remainder = remainder - cents*1; //remainder - number of 1¢ coins in money*1
		
		System.out.println("Change for " + total + " cents is");
		System.out.println(toonies + " toonies");
		System.out.println(loonies + " loonies");
		System.out.println(quarters + " quarters");
		System.out.println(dimes + " dimes");
		System.out.println(nickels + " nickels");
		System.out.println(cents + " cents");
        
   }
   catch (IOException err) {
        System.out.println("Error reading line");
   }
   
		
	}
		
}
