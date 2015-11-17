package by.epam.tat.cherevach.module3.lecture2.task1.taxipark;

public class Car {
    protected String carBrand;
    protected int carPetrolConsumption;
    protected String carType;
    protected int carPrice;
    //Text variables for messages
    private static String carTypeText = "| Car Type: ";
    private static String carBrandText = "\n| Car Brand: ";
    private static String carPriceText = "| Car Price: ";
    private static String carPetrolConsumptionText = "| Car Petrol Consumption: ";
    private static String petrolText = " lit./100km |";
		
	public Car(String carBrand, int carPrice, String carType, int i) {
	    this.carBrand = carBrand;
	    this.carPrice = carPrice;
	    this.carType = carType;
	    this.carPetrolConsumption = i;
	}
    //Brand
	public String getCarBrand() {
	    return carBrand;
	}
	
	public void setCarBrand(String carBrand) {
	    this.carBrand = carBrand;
	}
    //
    //Price
	public Integer getCarPrice() {
	    return carPrice;
	}
	
	public void setCarPrice(int carPrice) {
	    this.carPrice = carPrice;
	}
    //
    //Type
	public String getCarType() {
	    return carType;
	}
	
	public void setCarType(String carType) {
	    this.carType = carType;
    }
    //
    //Petrol Consumption
	public Integer getPetrolConsumption() {
	    return carPetrolConsumption;
    }
	
	public void setCarPetrolConsumption(int carPetrolConsumption) {
	    this.carPetrolConsumption = carPetrolConsumption;
	}
	//
	// for FindACAr
	@Override
	public String toString(){
		return carBrandText + this.carBrand + carTypeText + this.carType + carPriceText + this.carPrice + "$" + carPetrolConsumptionText + this.carPetrolConsumption + petrolText;
	}
	//
	//Return
	public String printCarInfo() {
	    return carBrandText + carBrand + carTypeText + carType + carPriceText + carPrice + "$" + carPetrolConsumptionText + carPetrolConsumption + petrolText;
	}
}