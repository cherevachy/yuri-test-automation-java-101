package by.epam.tat.cherevach.module3.lecture2.task1.taxipark;

import java.util.*;

public interface CustomerInterface {

public int calculateTaxiParkCost(List<Car> carList);
public String displayTaxiPark(List<Car> carList);
public void Comparator(List<Car> carList);
public void selectParticularCar(String carBrand, List<Car> carList);

//User communication
public String readUserInput();
public void  displaySystemOutput(String data); 
}
