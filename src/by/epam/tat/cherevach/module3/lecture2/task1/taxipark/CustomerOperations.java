package by.epam.tat.cherevach.module3.lecture2.task1.taxipark;

import java.util.*;

import by.epam.tat.cherevach.module3.lecture3.task1.exceptions.CarNotFoundExc;
import by.epam.tat.cherevach.module3.lecture3.task1.exceptions.PriceIsNullExc;

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
       // try {
			throw new CarNotFoundExc("No results found for the entered car brand.");
			
		//} catch (CarNotFoundExc e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
    }
        //System.out.println("No results found for the entered car brand.");  
    }
	//Add a new car
	public void addCarToTaxiPark(Car newCar, List<Car> carList) {
		
		validate(newCar);
		carList.add(newCar);
	}
	private void validate(Car car) {
		
		if (car.getCarBrand() == null) {
			throw new IllegalArgumentException("Please enter valid car brand!");
		}
		if (car.getCarPrice() <= 0) {
			throw new IllegalArgumentException("Please enter price > 0!");
		}
		if (car.getCarType() == null) {
			throw new IllegalArgumentException("Please enter valid car type!");
		}
		if (car.getPetrolConsumption() <= 0) {
			throw new IllegalArgumentException("Please enter petrol consumption > 0!");
		}
		if (car.getCarPrice() == null) {
			throw new PriceIsNullExc("Please enter valid price value!");
		}
		if (car.getPetrolConsumption() == null) {
			throw new PriceIsNullExc("Please enter valid petrol consumption value!");
		}
	//}
		 //catch (IllegalArgumentException e) {
		//System.err.println(e.getMessage());
		//} 
		//catch (NumberFormatException e) {
		//	System.err.println(e.getMessage());
		//}
	}        		        	
        
}
	//
