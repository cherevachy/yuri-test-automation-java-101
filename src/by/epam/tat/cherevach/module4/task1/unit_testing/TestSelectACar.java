package by.epam.tat.cherevach.module4.task1.unit_testing;

//import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import by.epam.tat.cherevach.module3.lecture2.task1.taxipark.Car;
import by.epam.tat.cherevach.module3.lecture2.task1.taxipark.CustomerOperations;
import by.epam.tat.cherevach.module3.lecture2.task1.taxipark.TaxiPark;
import by.epam.tat.cherevach.module3.lecture3.task1.exceptions.CarNotFoundExc;

import java.util.List;

public class TestSelectACar {

	@Parameters("testCarBrand")
	@Test(description="This is a test for car entry selection",  expectedExceptions = {CarNotFoundExc.class})

	public void SelectACar(@Optional("some optional value") String  testCarBrand) {
		CustomerOperations findACar = new CustomerOperations();
		List<Car> cars = TaxiPark.createCarList();
		findACar.selectParticularCar(testCarBrand, cars);
				
	}	
	
	@Parameters("testCarBrand2")
	@Test(description="This one should fail",  expectedExceptions = {CarNotFoundExc.class})

	public void SelectACar2(@Optional("some optional value") String  testCarBrand2) {
		CustomerOperations findACar = new CustomerOperations();
		List<Car> cars = TaxiPark.createCarList();
		findACar.selectParticularCar(testCarBrand2, cars);
				
	}	
	
	
}
