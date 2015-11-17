package by.epam.tat.cherevach.module3.lecture3.task2.io;

import java.io.*;
import java.util.*;
import by.epam.tat.cherevach.module3.lecture2.task1.taxipark.Car;

public interface ReadFromFileInterface {
	
	List<Car> readCarListFromFile(File file) throws IOException, ClassNotFoundException;

}
