package by.epam.tat.cherevach.module3.leacture1;

import java.util.*;
import java.lang.System;

public class Yuri_Calculator {
	public static void main (String [] args){
		
		try {
		
		Scanner inputValue = new Scanner(System.in);
		Scanner operatorValue = new Scanner (System.in);
		
		System.out.println("Please enter first value");
		double firstValue = inputValue.nextInt(); 
		
		System.out.println("PLease enter arithmetic operator(+, -, *, /)");
		String arithOperation = operatorValue.nextLine();
		
		System.out.println("Please enter second value");
		double secondValue = inputValue.nextInt();

		System.out.println(SwitchOperation.DefineOperation(firstValue, arithOperation, secondValue));
		
		    
	}
		catch (InputMismatchException e)
		{
			System.out.println ("Unexpected value, please try again");
			Yuri_Calculator.main(args);
		}
	}

	
	}