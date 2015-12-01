package by.epam.tat.cherevach.module4.task1.unit_testing;

import javax.xml.parsers.ParserConfigurationException;
import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;
import org.xml.sax.SAXException;


public class UnitTestRunner {

	public static void main(String[] args) throws Exception, SAXException, ParserConfigurationException  {
	  	TestNG testng =new TestNG();
	   for (XmlSuite suite :  new Parser("./testng.xml").parseToList()){
		   testng.setCommandLineSuite(suite);
	   }
	  testng.run();
	}
}
