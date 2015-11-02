package by.epam.tat.cherevach.module3.leacture1;

public class SwitchOperation {

	public static String DefineOperation(double firstValue, String arithOperation, double secondValue) {
		
	String str1 = null;
	String str2 = "Thanks for using my calculator!";

	switch (arithOperation){
	
	case "+":
		str1 = ("The result is " + ArithmeticOperation.addition(firstValue, secondValue));
		break;
	
	case "-":
		str1 = ("The result is " + ArithmeticOperation.subtraction(firstValue, secondValue));
		break;
		
	case "*":
		str1 = ("The result is " + ArithmeticOperation.multiplication(firstValue, secondValue));
		break;
		
	case "/":
		if (secondValue == 0){
			System.out.println("Division by zero detected");
			Yuri_Calculator.main(null);
		}
		else{
		System.out.println("The result is " + ArithmeticOperation.division(firstValue, secondValue));
		}
		break;
	
	default:
		System.out.println("Incorrect operator, please set +, -, * or /");
		Yuri_Calculator.main(null);				
	}
	
	return str1;
	
	}


	}





















