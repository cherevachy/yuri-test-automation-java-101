package by.epam.tat.cherevach.module3.lecture2.task1.taxipark;

import java.util.*;

public class TaxiParkRunner {

    private static Scanner userInput;	

    public static void main(String[] args) {
    	userInput = new Scanner(System.in);
    	CustomerOperations carNameScanner = new CustomerOperations();
    	boolean executeScript = true;
    	CustomerOperations displayTaxiPark = new CustomerOperations();
    	CustomerOperations currentCost = new CustomerOperations();
    	CustomerOperations carSorting = new CustomerOperations();
    	CustomerOperations selectParticularCar = new CustomerOperations();
    	
    	List<Car> carList = TaxiPark.createCarList(); 
    	
    	
    	while (executeScript) {
        System.out.println("\n~~~Yuri Cherevach TaxiPark main menu~~~");
        System.out.println("To see all available cars, please enter '1',");
        System.out.println("To calculate current overall TaxiPark cost, please enter '2',");
        System.out.println("To Sort the cars based on their petrol consumption, please enter '3',");
        System.out.println("To view a particular car, please enter '4',");
        System.out.println("For exit, please enter '0'.");
    	
    	int input = userInput.nextInt();
    	
    		try {
    			switch (input) {
    			case 0:
    				executeScript = false;
    				System.out.println("See you soon!");
    				break;
    			case 1:
    				System.out.println("The following cars are available at the moment:");
    				System.out.println(displayTaxiPark.displayTaxiPark(carList));
    				break;
    			case 2:
    				System.out.println("The current overall TaxiPark cost is: " + currentCost.calculateTaxiParkCost(carList) + "$");
    				break;
    			case 3:
    				carSorting.Comparator(carList);    				
    				break;
    			case 4:
    				System.out.println("Enter the car brand to look for:");
    				selectParticularCar.selectParticularCar(carNameScanner.readUserInput(), carList);  				    				
    				break;
    			default:
    				System.out.println("Incorrect value! Please, try again!");
    				break;
    			}
    		}
    		catch (Exception e) {
					System.err.println("Unexpected input!");
    		}
        }
    }
}
