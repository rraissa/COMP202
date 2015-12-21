import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.lang.Math;

public class Cryptography{
	public static int toggle = 1;
	public static char[] alphabet = new char[26];
	public static void main(String[] args){
		Scanner user_input = new Scanner(System.in);
		System.out.println("Enter message:");
		String originalMessage = user_input.nextLine();
		System.out.println("Enter shift size:");
		int shift = user_input.nextInt();
		shift = shift % 26; 
		String encryptedMessage = ceasarEncrypt(originalMessage, shift);
		System.out.println("Coded message is: " + encryptedMessage);
		String decryptedMessage = ceasarDecrypt(encryptedMessage, shift);
		System.out.println("Decoded message is: " + decryptedMessage);
		String mostWords = crackCipher(originalMessage, shift);
		System.out.println("Message with most english words is: " + mostWords);
		encryptedMessage = permuteEncrypt(originalMessage);
		System.out.println("Encoded message is: " + encryptedMessage);
		user_input.close();
		
		//We'll refrain from checking if shift is a non-negative integer since the assignment requires us to assume so.
	}
	
	public static String ceasarEncrypt(String originalMessage, int shift){
		String codedMessage = "";
			shift = toggle*shift;
		
			for (int i = 0; i < originalMessage.length(); i++){
				char ch_originalMessage = originalMessage.charAt(i);
		
				if ((ch_originalMessage >= 'a' && ch_originalMessage <= 'z') || (ch_originalMessage >= 'A' && ch_originalMessage <= 'Z')){
				codedMessage = codedMessage + (char)(ch_originalMessage + shift);
			
			}
			else codedMessage = codedMessage + ch_originalMessage;
			
		}
		return codedMessage;
			}
		
	public static String ceasarDecrypt(String encoded, int shift){
		toggle = -1;
		String decodedMessage = ceasarEncrypt(encoded, shift);
		return decodedMessage;
	}
	
	public static String crackCipher(String encoded, int numberLetters){
		String[] decryption = new String [numberLetters];
		int[] wordcount = new int [numberLetters];
		int j = 0;
		int largest = 0;
		for (int i = 0; i <= numberLetters-1; i++){ 
			//In order to have meaningful English words, normally we should have had the following code: 
			//decryption[i] = ceasarDecrypt(ceasarEncrypt(encoded, i), i); 
			decryption[i] = ceasarDecrypt(encoded, i); 
			wordcount[i] = SentenceChecker.countEnglishWords(decryption[i]);
			if (wordcount[i] > largest){
				largest = wordcount[i];
				j = i;
			}
		}
		return decryption[j];
	}
	
	public static void shuffle(char [] arrayOfCharacters){
	Random generator = new Random(12345);	
		int index1 = 0;
		int index2 = 0;
		char swapchar;
		int n = arrayOfCharacters.length;
		for (int i = 1; i <= Math.pow(n, 4); i++){
			index1 = generator.nextInt(n);
			index2 = generator.nextInt(n);
			swapchar = arrayOfCharacters[index1];
			arrayOfCharacters[index1] = arrayOfCharacters[index2];
			arrayOfCharacters[index2] = swapchar;
		}
		
	}
	
	public static char[] generatePermutation(){
		for (int i = 0; i <= 25; i++){
			alphabet[i] = (char)('A' + i);
		}
		shuffle(alphabet);
		return alphabet;
	}
	
	public static String permuteEncrypt(String input){
		String encodedstring = "";
		char inputchar;
		int charposition;
		generatePermutation();
		input = input.toUpperCase();
		for (int i = 0; i < input.length(); i++){
			inputchar = input.charAt(i);
			if(inputchar >= 'A' && inputchar <= 'Z'){
				charposition = inputchar - 'A';
				encodedstring = encodedstring + alphabet[charposition];
			}
			else encodedstring = encodedstring + inputchar;
		}
		return encodedstring;
	}
	
}
