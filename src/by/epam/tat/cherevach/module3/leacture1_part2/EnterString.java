package by.epam.tat.cherevach.module3.leacture1_part2;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EnterString {

public static void main (String [] args) throws IOException{
		
		try {
		
		Scanner inputValue = new Scanner(System.in);
		
		System.out.println("Please enter your string of character using spaces as separators");
		String str1 = inputValue.nextLine(); 
		
		System.out.println("Your reverted string: " + RevertString.Revert(str1));
				    
	}
		catch (InputMismatchException e)
		{
			System.out.println ("Unexpected value, please try again");
			EnterString.main(args);
		}
	
}
}
