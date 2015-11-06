package by.epam.tat.cherevach.module3.lecture2.task1.taxipark;

import java.util.*;

public class CustomerOperations implements CustomerInterface{

	//User communication implementation
	public String readUserInput() {
	return new Scanner(System.in).nextLine();
	}
		
	public void displaySystemOutput(String data) {
	System.out.println(data);
	}
	//
	//Calculating overall TaxiPark cost 
	public int calculateTaxiParkCost(List<Car> carList) {
		int overallTaxiParkCost = 0;
		for (Car car : carList) {
			overallTaxiParkCost += car.getCarPrice();
	    }
	return overallTaxiParkCost; 
	}
	//
	//Show the list of all cars in TaxiPark
	public String displayTaxiPark(List<Car> carList) {
	String carListDisplay = "";
	    for (Car car : carList) {
		    carListDisplay += car.printCarInfo();
	    }
	    return carListDisplay; 
	}
	//
	//Sorting on car petrol consumption
	public void Comparator(List<Car> carList) {
		Collections.sort(carList, new PetrolConsumptionComparator());
		System.out.println("The cars are sorted based on their petrol consumption:");
		for (int i =0; i < carList.size(); i++) {
            System.out.println(carList.get(i).getCarBrand() + "\t" + carList.get(i).getPetrolConsumption());
		}
		}
	//
	//Select a car
	public void selectParticularCar(String carBrand, List<Car> carList) {
		int count = 0;
        for(Car car : carList){

        if((car.getCarBrand().equals(carBrand))) {
                System.out.println("The following entry is found: " + car);
                count++;
        }
        }
        if(count == 0) {
            System.out.println("No results found for the entered car brand.");
        }        		        	
        
    }
	//
}
