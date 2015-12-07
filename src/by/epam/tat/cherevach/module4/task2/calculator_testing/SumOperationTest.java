package by.epam.tat.cherevach.module4.task2.calculator_testing;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import org.testng.annotations.DataProvider;

import com.epam.tat.module4.Calculator;


public class SumOperationTest {
	protected Calculator calculator;
	
	@BeforeClass
	public void setUp() {
		calculator = new Calculator();
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("Sum testing completed!");
	}

	@Test (groups = "sumTest")
	@Parameters({"addend1", "addend2", "sum"})
	public void testSumBasic(double addend1, double addend2, double sum){
		double operationResult = calculator.sum(addend1, addend2);
		Assert.assertEquals(operationResult, sum, "Invalid sum1!");	
	}
	
	@Test (dataProvider = "sumProvider", groups = "sumTest")
	public void testSumLong (long x, long y, long expectedValue){
	long operationResult = calculator.sum(x, y);
	Assert.assertEquals(operationResult, expectedValue, "Invalid sum2!");
	}
	
	@DataProvider (name = "sumProvider")
	public Object[][] valuesForSum() {
		return new Object[][] {
				{11, 11, 22},
				{90000000, 9999999, 99999999},
				{-5, -2, -7},
				{-100, 100, 0},
				{0, 0, 0}
		};
	}	
}
