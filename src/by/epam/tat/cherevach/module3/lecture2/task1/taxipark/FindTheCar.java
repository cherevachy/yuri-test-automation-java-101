package by.epam.tat.cherevach.module3.lecture2.task1.taxipark;

import java.util.*;

public class FindTheCar {

	public List<Car> list;
    String userInput;
    
    public FindTheCar(List<Car> carList) {
        list = carList;
    }
    
    public void setInput(String userInput) {
        this.userInput = userInput;
    }
    
    public void findCar() {
        int count = 0;
        for(Car car : list){

        if((car.getCarBrand().equals(userInput))) {
                System.out.println("The following entry is found: " + car);
                count++;
        }
        }
        if(count == 0) {
            System.out.println("No results found for the entered car brand.");
        }
}
}