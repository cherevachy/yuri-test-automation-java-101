package by.epam.tat.cherevach.module3.lecture2.task1.taxipark;

import java.util.*;

public class TaxiPark {

    public static List<Car> createCarList() {

	Car car1 = new PassengerCar("Audi", 20, "Passenger", 8, 3);
	Car car2 = new PassengerCar("BMW", 25, "Passenger", 9, 3);
	Car car3 = new PassengerCar("Nissan", 30, "Passenger", 7, 5);
	Car car4 = new CargoCar("Renault", 50, "Cargo", 9, 5);
	Car car5 = new CargoCar("Ford", 75, "Cargo", 12, 10);
		
	List<Car> carList = new ArrayList<Car>();
	carList.add(car1);
	carList.add(car2);
	carList.add(car3);
	carList.add(car4);
	carList.add(car5);

    return carList;	
    }
}