package by.epam.tat.cherevach.module4.task2.calculator_testing;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import org.testng.annotations.DataProvider;

import com.epam.tat.module4.Calculator;


public class SubOperationTest {
	protected Calculator calculator;
	
	@BeforeClass
	public void setUp() {
		calculator = new Calculator();
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("Sub testing completed!");
	}
	
	@Test (groups = "subTest")
	@Parameters({"sub1", "sub2", "subResult"})
	public void testSubBasic(double sub1, double sub2, double subResult){
		double operationResult = calculator.sub(sub1, sub2);
		Assert.assertEquals(operationResult, subResult, "Invalid sub1!");	
	}
	
	@Test (dataProvider = "subProvider", groups = "subTest")
	public void testSubLong (long x, long y, long expectedValue){
	long operationResult = calculator.sub(x, y);
	Assert.assertEquals(operationResult, expectedValue, "Invalid sub2!");
	}
	
	@DataProvider (name = "subProvider")
	public Object[][] valuesForSub() {
		return new Object[][] {
				{11, 11, 0},
				{90000000, 9999999, 81111111},
				{-5, -2, -3},
				{-100, 100, -200},
				{0, 0, 0}
							
		};
	}	
}
