import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class DnaUtilities {
	public static void main(String[] args) throws IOException{
		InputStreamReader istream = new InputStreamReader(System.in) ;
        BufferedReader bufRead = new BufferedReader(istream) ;
        
   try {
        System.out.print("Enter a DNA string: ");
        String dnaString = bufRead.readLine();
        System.out.println(watsonCrickTripletComplement(dnaString));
   }
   catch (IOException err) {
        System.out.println("Error reading line");
   }
   
		
		//System.out.println(isValidBase('A'));
		//System.out.println(isValidBase('a'));
		//System.out.println(isValidBase('X'));
		//System.out.println(watsonCrickComplement('A'));
		//System.out.println(watsonCrickComplement('t'));
		//System.out.println(watsonCrickComplement('4'));
		//System.out.println(watsonCrickTripletComplement("AGA"));
		//System.out.println(watsonCrickTripletComplement("agA"));
		//System.out.println(watsonCrickTripletComplement("AAAA"));
		
	}
	
	public static boolean isValidBase(char x){
		boolean isValidBase;
		
		if (isValidBase = (x == 'A') || (x == 'C') || (x == 'G') || (x == 'T')){
			return true; 
		}
		else{
			return false;
		}	
	}
	
	public static char watsonCrickComplement(char y){
		if (isValidBase(y)){
			if (y == 'A'){
			    y = 'T';
			}
			    else if (y == 'C'){
			    	y = 'G';
			    }
			else if (y == 'G'){
				y = 'C';
			}
		
			else if (y == 'T'){
				y = 'A';
			}
			return y;
	}
		else{
			return y;
		}

	}
	
	public static String watsonCrickTripletComplement(String dnaSequence){
		int length = dnaSequence.length();
		String tripletcomplement = "";
		if (length != 3){
			return "";
		}
		for (int i = 0; i<3; i++){
			if (isValidBase(dnaSequence.charAt(i))){
				tripletcomplement = tripletcomplement + watsonCrickComplement(dnaSequence.charAt(i));
			}
			else{
				return "";
			}
		}
		return "The DNA complement is: " + tripletcomplement;
	}
	
}
