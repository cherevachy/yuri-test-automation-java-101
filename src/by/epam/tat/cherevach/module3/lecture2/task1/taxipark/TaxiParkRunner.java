package by.epam.tat.cherevach.module3.lecture2.task1.taxipark;

import java.io.*;
import java.util.*;

import by.epam.tat.cherevach.module3.lecture3.task1.exceptions.*;
import by.epam.tat.cherevach.module3.lecture3.task2.io.*;

public class TaxiParkRunner {

    private static Scanner userInput;	

    public static void main(String[] args) {
    	String exceptionInput = "Warning! Input level exception occured: ";
    	
    	//try {
    	
    	String exceptionMenu = "Warning! Operation level exception occured: ";
    	String exceptionOper = "Warning! Operation level exception occured: ";
    	userInput = new Scanner(System.in);
    	CustomerOperations carNameScanner = new CustomerOperations();
    	boolean executeScript = true;
    	
    	CustomerOperations displayTaxiPark = new CustomerOperations();
    	CustomerOperations currentCost = new CustomerOperations();
    	CustomerOperations carSorting = new CustomerOperations();
    	CustomerOperations selectParticularCar = new CustomerOperations();
    	CustomerOperations addCarToTaxiPark = new CustomerOperations();
    	
    	List<Car> carList = TaxiPark.createCarList();
    	//Reader
    	//List<Car> exportCarList = new ArrayList<Car>();
    	CarReaderInterface reader = new CarReader();
    	CarReaderInterface readerXml = new CarReaderXml();
    	CarReaderInterface readerDatabase = new CarReaderFromDB();
    	
    	//Writer
    	CarWriterInterface writer = new CarWriter();    	
    	CarWriterInterface writerXml = new CarWriterXml();
    	CarWriterInterface writerDatabase = new CarWriterToDB();
    	
    	while (executeScript) {
        System.out.println("\n~~~Yuri Cherevach TaxiPark main menu~~~");
        System.out.println("To see all available cars, please enter '1',");
        System.out.println("To calculate current overall TaxiPark cost, please enter '2',");
        System.out.println("To Sort the cars based on their petrol consumption, please enter '3',");
        System.out.println("To view a particular car, please enter '4',");
        System.out.println("To add a new car to the TaxiPark, please enter '5',");
        System.out.println("To read a car list from a file, please enter '6', ");
		System.out.println("To write the car list to a file, please enter '7', ");
		System.out.println("To write the car list to an XML file, please enter '8', ");
		System.out.println("To read the car list from the XML file, please enter '9', ");
		System.out.println("To write the car list to the database, please enter '10', ");
		System.out.println("To read the car list from the database, please enter '11', ");
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
					//try {
						selectParticularCar.selectParticularCar(carNameScanner.readUserInput(), carList);
					//} catch (CarNotFoundExc e) {
						//System.err.println("Runner_level_exc_message");
					//}
    				
    				//System.out.println("Enter the car brand to look for:");
    				//selectParticularCar.selectParticularCar(carNameScanner.readUserInput(), carList);  				    				
    				break;
    			case 5:
    				String exceptionMessage = "Some ints are null! ";
    				try{
    				
					System.out.println("Please Enter car Brand: ");
					String carBrand = carNameScanner.readUserInput();
					System.out.println("Please Enter car Price: ");
					String carPrice = carNameScanner.readUserInput();
					if (carPrice == null) {
						exceptionMessage += "Please enter some price!";
						throw new IllegalArgumentException("Please enter some price!");
					}
					System.out.println("Please Enter car Type ('Passenger' or 'Cargo'): ");
					String carType = carNameScanner.readUserInput();
					System.out.println("Please Enter car Petrol Consumption: ");
					String carPetrolConsumption = carNameScanner.readUserInput();
					if (carPetrolConsumption == null) {
						exceptionMessage += "Please enter some petrol consumption!";
						throw new IllegalArgumentException("Please enter some petrol consumption!");
					}
					Car newCar = new Car(carBrand, Integer.parseInt(carPrice), carType, Integer.parseInt(carPetrolConsumption));			
					addCarToTaxiPark.addCarToTaxiPark(newCar, carList);
					} catch (IllegalArgumentException e) {
						System.err.println(exceptionMessage);
					} 
					
    				break;
    			case 6:
    				carList = reader.readCarList();
					break;
				case 7:
					writer.writeCarList(carList);
					break;
				case 8:
    				writerXml.writeCarList(carList);
					break;
				case 9:
					carList = readerXml.readCarList();
					break;
				case 10:
    				writerDatabase.writeCarList(carList);
					break;
				case 11:
					carList = readerDatabase.readCarList();
					break;
    			default:
    				//System.out.println("Incorrect value! Please, try again!");
    				throw new MainMenuUnsupportedOperationExc("The selected menu option does not exist. Please try again.");
    				//break;
    			}
    		} 
    		catch (CarNotFoundException e) {
    			//user exception 1
    			System.err.println(exceptionOper + e.getMessage());
    		}
    		catch (MainMenuUnsupportedOperationExc e) {
    			//user exception 2
    			System.err.println(exceptionMenu + e.getMessage());
    		}
    		catch (IllegalArgumentException e) {
    			//system exception
    			System.err.println(exceptionOper + e.getMessage());
    		}
    		catch (PriceIsNullException e) {
    			//user exception 3
    			System.err.println(exceptionOper + e.getMessage());
    		}
    	    catch (Exception e) {
    //For import - ClassNotFoundException(?)
			System.err.println("Exception occured: " + e.getMessage());
			}
    		        }
  //}
    
    //catch (InputMismatchException e) {
		////system exception 1
		//System.err.println(exceptionInput);
		//e.printStackTrace();
	//}	
    //catch (NumberFormatException e) {
    		//system exception 2
    		//System.err.println(exceptionInput + e.getMessage());
    //}
}
}
