package by.epam.tat.cherevach.module5.webdriver;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.xml.sax.SAXException;

public class ChromeDriverSettings extends GMailOperations{
		
		static {
			System.setProperty("webdriver.chrome.driver", "D:\\Repos\\ChromeDriver\\chromedriver.exe");
		}

		public ChromeDriverSettings() {
			super(new ChromeDriver());
		}

	}
