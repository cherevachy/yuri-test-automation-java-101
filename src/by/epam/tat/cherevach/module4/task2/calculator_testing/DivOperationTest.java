package by.epam.tat.cherevach.module4.task2.calculator_testing;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import org.testng.annotations.DataProvider;

import com.epam.tat.module4.Calculator;


public class DivOperationTest {
	protected Calculator calculator;
	
	@BeforeClass
	public void setUp() {
		calculator = new Calculator();
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("Div testing completed!");
	}
	
	@Test (groups = "divTest")
	@Parameters({"div1", "div2", "divResult"})
	public void testDivBasic(double div1, double div2, double divResult){
		double operationResult = calculator.div(div1, div2);
		Assert.assertEquals(operationResult, divResult, "Invalid div1!");	
	}
	
	@Test (dataProvider = "divProvider", groups = "divTest")
	public void testDivLong (long x, long y, long expectedValue){
	long operationResult = calculator.div(x, y);
	Assert.assertEquals(operationResult, expectedValue, "Invalid div2!");
	}
	
	@Test (expectedExceptions = NumberFormatException.class)
	public void divByZero(){
		double operationResult = calculator.div(123, 0);
	}	
	
	@DataProvider (name = "divProvider")
	public Object[][] valuesForDiv() {
		return new Object[][] {
				{11, 11, 1},
				{90, 9, 10},
				{-5, -2, -2.5},
				{0, 12345, 0},
				{-100, 100, -1}
							
		};
	}	
}
