package by.epam.tat.cherevach.module3.lecture3.task2.io;

import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import by.epam.tat.cherevach.module3.lecture2.task1.taxipark.Car;

public class CarReaderXml implements CarReaderInterface {

		public List<Car> readCarList() throws IOException {
			List<Car> cars = new ArrayList<Car>();
			try {
				File xmlFile = new File("taxipark.xml");
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(xmlFile);

				doc.getDocumentElement().normalize();
				NodeList nList = doc.getElementsByTagName("car");
				for (int i = 0; i < nList.getLength(); i++) {
					Node nNode = nList.item(i);
					
					//reading xml
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

						Element item = (Element) nNode;
						String brand = item.getElementsByTagName("brand").item(0).getTextContent();
						int price = Integer.parseInt(item.getElementsByTagName("price").item(0).getTextContent());
						String type = item.getElementsByTagName("type").item(0).getTextContent();
						int petrolConsumption = Integer.parseInt(item.getElementsByTagName("petrolConsumption").item(0).getTextContent());
						Car car = new Car(brand, price, type, petrolConsumption);
						cars.add(car);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return cars;
		}
	}
