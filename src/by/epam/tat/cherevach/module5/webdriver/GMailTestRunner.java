package by.epam.tat.cherevach.module5.webdriver;

import java.io.IOException;
import java.sql.Time;
//import java.util.Date;

import javax.xml.parsers.ParserConfigurationException;
import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;
import org.xml.sax.SAXException;

public class GMailTestRunner {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//String email="ivanovtestbox@gmail.com";
		//String password="Chupakabros2015";
		//String to="ivanovtestbox@gmail.com";
		//String subject="tam1test1"+System.currentTimeMillis();
		//String body="Hello, Yuri!"+System.currentTimeMillis();
		//String toMatch="me";
		//GMailOperations[] browsers=new GMailOperations[]{new ChromeDriverSettings()
		//, new FFDriverSettings(), new IEDriverSettings()
		//};
		TestNG testng =new TestNG();
		
		//WebDriver webDr=new ChromeDriver();
		try {
			for //(GMailOperations webDr : browsers)
				(XmlSuite suite :  new Parser("./selenium_test.xml").parseToList()){
				//webDr.logInGeneral(email, password);
				//webDr.sendEmail(to, subject, body);
				//webDr.emailReceived(toMatch, subject);
				//webDr.logout();
				//webDr.quit();
				testng.setCommandLineSuite(suite);
		    }
		} 
		catch (AssertionError e) {
			e.printStackTrace();
		}
		testng.run();
	}

}	