package by.epam.tat.cherevach.module3.lecture3.task2.io;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import by.epam.tat.cherevach.module3.lecture2.task1.taxipark.Car;

public class CarWriterToDB implements CarWriterInterface {

	public void writeCarList(List<Car> cars) throws IOException {

		Connection dbConnection = DBUtil.getConnection();
		try {
			Statement stmt = dbConnection.createStatement();

			stmt.execute("CREATE TABLE IF NOT EXISTS CARS (brand varchar(120), price double, type varchar(120), petrol double)");
			for (Car car : cars) {
				stmt.executeUpdate("INSERT INTO CARS(NAME,PRICE,TYPE,PETROL) VALUES('"
						+ car.getCarBrand() + "',"
						+ car.getCarPrice() + "',"
						+ car.getCarType() + "',"
						+ car.getPetrolConsumption() + ")");
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
