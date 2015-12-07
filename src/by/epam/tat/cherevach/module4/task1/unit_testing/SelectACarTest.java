package by.epam.tat.cherevach.module4.task1.unit_testing;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import by.epam.tat.cherevach.module3.lecture2.task1.taxipark.Car;
import by.epam.tat.cherevach.module3.lecture2.task1.taxipark.CustomerOperations;
import by.epam.tat.cherevach.module3.lecture2.task1.taxipark.TaxiPark;
import by.epam.tat.cherevach.module3.lecture3.task1.exceptions.CarNotFoundException;

import java.util.List;

public class SelectACarTest {

	private CustomerOperations findACar;
	private List<Car> cars;

	@BeforeClass
	public void setUp() {
	    findACar = new CustomerOperations();
	    cars = TaxiPark.createCarList();
	}

	@Parameters("testCarBrand")
	@Test(description="This is a test for car entry selection",  expectedExceptions = {CarNotFoundException.class})
	public void testSelectACar(@Optional("some optional value") String  testCarBrand) {
		findACar.selectParticularCar(testCarBrand, cars);
	}	
	
	@Parameters("testCarNotInList")
	@Test(description="This one should fail",  expectedExceptions = {CarNotFoundException.class})
	public void testFindIncorrectBrand(@Optional("some optional value") String  testCarNotInList) {
		findACar.selectParticularCar(testCarNotInList, cars);
	}	
}
