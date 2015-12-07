package by.epam.tat.cherevach.module4.task2.calculator_testing;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import org.testng.annotations.DataProvider;

import com.epam.tat.module4.Calculator;


public class MultOperationTest {
	protected Calculator calculator;
	
	@BeforeClass
	public void setUp() {
		calculator = new Calculator();
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("Mult testing completed!");
	}
	
	@Test (groups = "multTest")
	@Parameters({"mult1", "mult2", "multResult"})
	public void testMultBasic(double mult1, double mult2, double multResult){
		double operationResult = calculator.mult(mult1, mult2);
		Assert.assertEquals(operationResult, multResult, "Invalid mult1!");	
	}
	
	@Test (dataProvider = "multProvider", groups = "multTest")
	public void testMultLong (long x, long y, long expectedValue){
	long operationResult = calculator.mult(x, y);
	Assert.assertEquals(operationResult, expectedValue, "Invalid mult2!");
	}
	
	@DataProvider (name = "multProvider")
	public Object[][] valuesForMult() {
		return new Object[][] {
				{11, 11, 121},
				{90, 99, 8910},
				{-5, -2, 10},
				{-5, 0, 0},
				{-100, 100, -10000},
				{0, 0, 0}
							
		};
	}	
}
