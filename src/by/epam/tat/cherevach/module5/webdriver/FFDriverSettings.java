package by.epam.tat.cherevach.module5.webdriver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FFDriverSettings extends GMailOperations{
		
		static {
			//System.setProperty("webdriver.firefox.driver", "C:\\%PROGRAMFILES%\\Mozilla Firefox\firefox.exe");
			System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox");
		}

		public FFDriverSettings() {
			super(new FirefoxDriver());
		}

	}
