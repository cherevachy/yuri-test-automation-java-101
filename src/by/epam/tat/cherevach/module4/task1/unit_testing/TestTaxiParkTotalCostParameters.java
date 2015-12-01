package by.epam.tat.cherevach.module4.task1.unit_testing;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import by.epam.tat.cherevach.module3.lecture2.task1.taxipark.Car;
import by.epam.tat.cherevach.module3.lecture2.task1.taxipark.CustomerOperations;
import by.epam.tat.cherevach.module3.lecture2.task1.taxipark.TaxiPark;

import java.util.List;

public class TestTaxiParkTotalCostParameters {
	
  @Test
  @Parameters({"testCarBrand", "testCarPrice", "testCarType", "testCarPetrolConsumption"})
  public void testParametr1(String testCarBrand, String testCarPrice, String testCarType, String testCarPetrolConsumption){
	 CustomerOperations totalCost = new CustomerOperations();
	 List<Car> cars = TaxiPark.createCarList();
	 Car newCar = new Car(testCarBrand, Integer.parseInt(testCarPrice), testCarType, Integer.parseInt(testCarPetrolConsumption));		
	 cars.add(newCar);
					 
	Assert.assertEquals(300, totalCost.calculateTaxiParkCost(cars));
	}
  
}
