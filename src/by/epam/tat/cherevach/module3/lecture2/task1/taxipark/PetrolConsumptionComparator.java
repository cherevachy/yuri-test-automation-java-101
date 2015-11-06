package by.epam.tat.cherevach.module3.lecture2.task1.taxipark;

import java.util.Comparator;

public class PetrolConsumptionComparator implements Comparator<Car> {

	@Override
	public int compare(Car o1, Car o2) {
		return o2.getPetrolConsumption() - o1.getPetrolConsumption();
	}
}
