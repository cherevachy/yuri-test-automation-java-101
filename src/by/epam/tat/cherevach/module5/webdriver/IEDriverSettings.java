package by.epam.tat.cherevach.module5.webdriver;

import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDriverSettings extends GMailOperations {
		
		static {
			System.setProperty("webdriver.ie.driver", "D:\\Repos\\IEDriver\\IEDriverServer.exe");
		}

		public IEDriverSettings() {
			super(new InternetExplorerDriver());
		}

	}
