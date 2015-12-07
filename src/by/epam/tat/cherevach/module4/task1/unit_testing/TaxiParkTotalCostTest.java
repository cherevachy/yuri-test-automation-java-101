package by.epam.tat.cherevach.module4.task1.unit_testing;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import by.epam.tat.cherevach.module3.lecture2.task1.taxipark.Car;
import by.epam.tat.cherevach.module3.lecture2.task1.taxipark.CustomerOperations;
import by.epam.tat.cherevach.module3.lecture2.task1.taxipark.TaxiPark;

public class TaxiParkTotalCostTest {
  
	private CustomerOperations totalCost;
	private List<Car> cars;
	final int expectedCost = 200;
	final int expectedCost2 = 100;
	final int expectedCost3 = 299;

	@BeforeClass
	public void setUp() {
		totalCost = new CustomerOperations();
	    cars = TaxiPark.createCarList();
		}	
	
	@Test
	public void testOveralTaxiParkCost1() {
		Assert.assertEquals(expectedCost, totalCost.calculateTaxiParkCost(cars), "Unexpected value");
        }
	
	@Test(dependsOnMethods = "testOveralTaxiParkCost1")
	public void testOveralTaxiParkCost2() {
		Assert.assertNotEquals(expectedCost2, totalCost.calculateTaxiParkCost(cars), "Unexpected value");
		}
	
	@Test(dependsOnMethods = "testOveralTaxiParkCost2")
	public void testWithAddedCar1(){
		Car newCar = new Car( "TestCar", 99,  "Cargo", 100);
		cars.add(newCar);
		Assert.assertEquals(expectedCost3, totalCost.calculateTaxiParkCost(cars), "Unexpected value");
		}

	@Test(dependsOnMethods = "testWithAddedCar1")
	public void testWithAddedCar2(){
		Car newCar = new Car( "TestCar", 66,  "Cargo", 100); 
		cars.add(newCar);
		Assert.assertNotEquals(expectedCost3, totalCost.calculateTaxiParkCost(cars), "Unexpected value");
		}
}
