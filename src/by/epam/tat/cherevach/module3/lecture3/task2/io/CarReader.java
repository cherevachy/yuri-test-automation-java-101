package by.epam.tat.cherevach.module3.lecture3.task2.io;

import java.io.*;
import java.util.*;
import by.epam.tat.cherevach.module3.lecture2.task1.taxipark.Car;

public class CarReader implements CarReaderInterface {

	public List<Car> readCarList() throws IOException {
		File file = new File("TaxiPark.txt");
		FileReader reader = null;
		try {
			reader = new FileReader(file);
			BufferedReader buffReader = new BufferedReader(reader);
			List<Car> cars = new ArrayList<Car>();
			String line = "";
			while ((line = buffReader.readLine()) != null) {
				String[] data = line.split(";");
				Car car = new Car(data[0], Integer.parseInt(data[1]), data[0], Integer.parseInt(data[1]));
				cars.add(car);
			}
			return cars;
		} catch (IOException ex) {
		System.err.println("Reader exception: " + ex.getMessage());
		} finally {
			reader.close();
		}
		return null;
	}
}