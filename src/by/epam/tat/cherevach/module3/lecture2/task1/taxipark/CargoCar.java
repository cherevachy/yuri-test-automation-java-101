package by.epam.tat.cherevach.module3.lecture2.task1.taxipark;


public class CargoCar extends Car {

	private int maxCargoWeight;
	private String carMaxCargoWeightText = "\n Max cargo load for the car: ";
	
    public CargoCar(String carBrand, int carPrice, String carType, int carPetrolConsumption, int maxCargoWeight) {
		super(carBrand, carPrice, carType, carPetrolConsumption);
        this.maxCargoWeight = maxCargoWeight;
    }
    //Max Cargo Weight
  	public int getmaxCargoWeight(){
  	    return maxCargoWeight;
    }
  	
  	public void setmaxCargoWeight(int maxCargoWeight) {
  	    this.maxCargoWeight = maxCargoWeight;
  	}
    //
  	//Return
  	public String printMaxCargoInfo(){
  	return super.printCarInfo() + carMaxCargoWeightText + maxCargoWeight + "tons";  
  	}
	
	
}
