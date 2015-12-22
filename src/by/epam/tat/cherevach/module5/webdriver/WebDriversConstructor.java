package by.epam.tat.cherevach.module5.webdriver;

import org.testng.annotations.Factory;

public class WebDriversConstructor {
	@Factory
    public Object[] factoryMethod() {
       return new Object[] { new ChromeDriverSettings(), new FFDriverSettings(), new IEDriverSettings()};
    }
}
