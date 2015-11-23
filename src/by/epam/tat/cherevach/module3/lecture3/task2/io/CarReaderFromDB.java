package by.epam.tat.cherevach.module3.lecture3.task2.io;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import by.epam.tat.cherevach.module3.lecture2.task1.taxipark.Car;

public class CarReaderFromDB implements CarReaderInterface {

	public List<Car> readCarList() throws IOException {

		Connection conn = DBUtil.getConnection();
		List<Car> cars = null;
		try {
			Statement stmt = conn.createStatement();
			cars = new ArrayList<Car>();
			ResultSet rs = stmt.executeQuery("SELECT * FROM CARS");
			while (rs.next()) {
				String name = rs.getString("brand");
				Double price = rs.getDouble("price");
				String type = rs.getString("type");
				Double petrol = rs.getDouble("petrol");
				Car car = new Car(name, price.intValue(),type, petrol.intValue());
				cars.add(car);
			}
			conn.close();
			System.out.println("Reading from DB status: COMPLETED");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cars;
	}
}
