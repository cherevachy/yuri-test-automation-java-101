package by.epam.tat.cherevach.module4.task1.unit_testing;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import by.epam.tat.cherevach.module3.lecture2.task1.taxipark.Car;
import by.epam.tat.cherevach.module3.lecture2.task1.taxipark.CustomerOperations;
import by.epam.tat.cherevach.module3.lecture2.task1.taxipark.TaxiPark;

import java.util.List;

public class TaxiParkTotalCostParametersTest {
	
	private CustomerOperations totalCost;
	private List<Car> cars;
	final int expectedToatalCost = 300;
	
	@BeforeClass
	public void setUp() {
		totalCost = new CustomerOperations();
	    cars = TaxiPark.createCarList();
	}
	
    @Test
    @Parameters({"testCarBrand", "testCarPrice", "testCarType", "testCarPetrolConsumption"})
    public void testParametr1(String testCarBrand, String testCarPrice, String testCarType, String testCarPetrolConsumption){
	Car newCar = new Car(testCarBrand, Integer.parseInt(testCarPrice), testCarType, Integer.parseInt(testCarPetrolConsumption));		
	cars.add(newCar);		 
	Assert.assertEquals(expectedToatalCost, totalCost.calculateTaxiParkCost(cars), "Unexpected value");
	}
  
}
