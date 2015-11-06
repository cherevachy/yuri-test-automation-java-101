package by.epam.tat.cherevach.module3.lecture2.task1.taxipark;


public class PassengerCar extends Car {

    private int maxPassengerCount;
    private String carMaxPassengerCountText = "\n Max passengers: ";
		
    public PassengerCar(String carBrand, int carPrice, String carType, int carPetrolConsumption, int maxPassengerCount) {
			super(carBrand, carPrice, carType, carPetrolConsumption);
	        this.maxPassengerCount = maxPassengerCount;
	}
	//Max Passenger Count
    public int getMaxPassengerCount() {
	  	    return maxPassengerCount;
	}
	  	
    public void setMaxPassengerCount(int maxPassengerCount) {
	  	    this.maxPassengerCount = maxPassengerCount;
	}
	//
	//Return
    public String printPassengerCount() {
    return super.printCarInfo() + carMaxPassengerCountText + maxPassengerCount + "persons";  
	}
}
