package by.epam.tat.cherevach.module4.task1.unit_testing;

import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;

import by.epam.tat.cherevach.module3.lecture2.task1.taxipark.Car;
import by.epam.tat.cherevach.module3.lecture2.task1.taxipark.CustomerOperations;
import by.epam.tat.cherevach.module3.lecture2.task1.taxipark.TaxiPark;

public class TestTaxiParkTotalCost {
  
	@Test
	public void overalTaxiParkCost1() {
		CustomerOperations totalCost = new CustomerOperations();
		List<Car> cars = TaxiPark.createCarList();
		
		Assert.assertEquals(200, totalCost.calculateTaxiParkCost(cars));
        }
	
	@Test(dependsOnMethods = "overalTaxiParkCost1")
	public void overalTaxiParkCost2() {
		CustomerOperations totalCost = new CustomerOperations();
		List<Car> cars = TaxiPark.createCarList();
			
		Assert.assertNotEquals(100, totalCost.calculateTaxiParkCost(cars));
		}
	
	@Test(dependsOnMethods = "overalTaxiParkCost2")
	public void WithAddedCar1(){
		CustomerOperations totalCost = new CustomerOperations();
		List<Car> cars = TaxiPark.createCarList();
		//List<Car> updatedCars = new ArrayList<Car>();
		Car newCar = new Car( "TestCar", 99,  "Cargo", 100);
		//updatedCars.add(newCar); 
		cars.add(newCar);
		
		Assert.assertEquals(299, totalCost.calculateTaxiParkCost(cars));
		}

	@Test(dependsOnMethods = "WithAddedCar1")
	public void WithAddedCar2(){
		CustomerOperations totalCost = new CustomerOperations();
		List<Car> cars = TaxiPark.createCarList();
		//List<Car> updatedCars = new ArrayList<Car>();
		Car newCar = new Car( "TestCar", 66,  "Cargo", 100);
		//updatedCars.add(newCar); 
		cars.add(newCar);
		
		Assert.assertNotEquals(299, totalCost.calculateTaxiParkCost(cars));
		}

}
