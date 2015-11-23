package by.epam.tat.cherevach.module3.lecture3.task2.io;

import java.io.*;
import java.util.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;

import by.epam.tat.cherevach.module3.lecture2.task1.taxipark.Car;

public class CarWriterXml implements CarWriterInterface {

	public void writeCarList(List<Car> cars) throws IOException {
		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("taxipark");
			doc.appendChild(rootElement);

			for (Car car : cars) {
				
				Element c = doc.createElement("car");
				rootElement.appendChild(c);
				//brand
				Element brand = doc.createElement("brand");
				brand.appendChild(doc.createTextNode(car.getCarBrand()));
				c.appendChild(brand);
				// price
				Element price = doc.createElement("price");
				price.appendChild(doc.createTextNode(String.valueOf(car.getCarPrice())));
				c.appendChild(price);
				//type
				Element type = doc.createElement("type");
				brand.appendChild(doc.createTextNode(car.getCarType()));
				c.appendChild(type);
				//petrol consumption
				Element petrolConsumption = doc.createElement("petrolConsumption");
				price.appendChild(doc.createTextNode(String.valueOf(car.getPetrolConsumption())));
				c.appendChild(petrolConsumption);
			}	

			// write to xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("D:\\EclipseWorkspace\\TAMYuri_Cherevach\taxiparkXML.xml"));
			transformer.transform(source, result);
			System.out.println("Saved to xml.");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
		catch (Exception e) {
		    System.err.println("Exception occured: " + e.getMessage());
		}
	}
}
