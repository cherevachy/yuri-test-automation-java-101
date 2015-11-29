package by.epam.tat.cherevach.module3.lecture3.task2.io;

import java.io.*;
import java.sql.*;
import java.util.*;

import by.epam.tat.cherevach.module3.lecture2.task1.taxipark.Car;

public class CarWriterToDB implements CarWriterInterface {

	public void writeCarList(List<Car> cars) throws IOException {

		Connection dbConnection = DBUtil.getConnection();
		try {
			Statement stmt = dbConnection.createStatement();

			stmt.execute("CREATE TABLE IF NOT EXISTS CARS (brand varchar(120), price integer, type varchar(120), petrol integer)");
			//stmt.execute("SHUTDOWN");
			for (Car car : cars) {
				//stmt.executeUpdate("INSERT INTO CARS(BRAND,PRICE,TYPE,PETROL) VALUES('"
						//+ car.getCarBrand() + "',"
						//+ car.getCarPrice() + "',"
						//+ car.getCarType() + "',"
						//+ car.getPetrolConsumption() + ")");
				stmt.executeUpdate("INSERT INTO CARS(BRAND,PRICE) VALUES('"
						+ car.getCarBrand() + "',"
						+ car.getCarPrice() + ")");
						//+ car.getCarType() + ")");
						//+ car.getPetrolConsumption() + ")");		
			}
			stmt.close();
			System.out.println("Writing to DB status: COMPLETED");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dbConnection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
