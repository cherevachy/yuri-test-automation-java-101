package by.epam.tat.cherevach.module3.lecture3.task2.io;

import java.io.*;
import java.util.*;
import by.epam.tat.cherevach.module3.lecture2.task1.taxipark.Car;

public interface WriteToFileInterface {
	
	List<Car> writeCarListToFile(List<Car> cars, String fileName) throws IOException;

}
