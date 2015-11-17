package by.epam.tat.cherevach.module3.lecture3.task2.io;

import java.io.*;
import java.util.*;

import by.epam.tat.cherevach.module3.lecture2.task1.taxipark.Car;

public class CarWriter implements CarWriterInterface {

	public void writeCarList(List<Car> cars) throws IOException {
		FileOutputStream outputStream = null;
		PrintWriter writer = null;
		try {
			outputStream = new FileOutputStream(new File("TaxiPark.txt"));
			writer = new PrintWriter(outputStream);
			for (Car car : cars) {
				writer.println(car.getCarBrand() + ";" + car.getCarPrice() + ";" + car.getCarType() + ";" + car.getPetrolConsumption());
			}
			writer.flush();
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		} finally {
			writer.close();
			outputStream.close();

		}
	}
}		

