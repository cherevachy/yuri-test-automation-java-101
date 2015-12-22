package by.epam.tat.cherevach.module5.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class GMailOperations {
	private WebDriver webDr =(WebDriver) new ChromeDriverSettings();
	
	public GMailOperations (WebDriver webDr) {
		this.webDr=webDr;
		//this.webDr.get("http://gmail.com");
		
	}
	
	SoftAssert softAssert = new SoftAssert();
	String subject="tam1_test1"+System.currentTimeMillis();
	
	
	@Test(description="Fail login", dataProvider="FailLoginProvider")
	public void logInGeneral(String emailData, String passwordData) {
		try {
			webDr.get("http://gmail.com");
			webDr.findElement(By.name("Email")).sendKeys(emailData);
			webDr.findElement(By.id("next")).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String errorMsg=webDr.findElement(By.xpath("//*[@class='input-wrapper focused']//*[@class='error-msg']")).getText();
			if (errorMsg!=null && !errorMsg.isEmpty()) {
				softAssert.assertTrue(errorMsg.equalsIgnoreCase("Please enter your email.")||errorMsg.equalsIgnoreCase("Sorry, Google doesn't recognize that email."),"get unknown errorMsg: "+errorMsg);
			} else {
				errorMsg=null;
				webDr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				webDr.findElement(By.name("Passwd")).sendKeys(passwordData);
				webDr.findElement(By.id("signIn")).click();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					errorMsg=webDr.findElement(By.xpath("//*[@class='slide-in ']//*[@class='error-msg']")).getText();
				} catch (NoSuchElementException e) {
					errorMsg=null;
				}
				if (errorMsg!=null && !errorMsg.isEmpty()) {
					softAssert.assertTrue(errorMsg.equalsIgnoreCase("The email and password you entered don't match.")||errorMsg.equalsIgnoreCase("Please enter your password."));
				} else {
					webDr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					webDr.findElement(By.xpath("//div[@role='button']")).getText().matches( "COMPOSE");
				}
			}
		} catch (NoSuchElementException e) {
			throw new AssertionError("Log in error: element not found"+e.getMessage(), e);
		}
	}
	
	@DataProvider(name = "FailLoginProvider")
    public Object[][] valuesForFailLogin() {
        return new Object[][] {
                {"ivanovtestbox@gmail.com",""},
                {"","Chupakabros2015"},
                {"incorrect@gmail.com","Chupakabros2015"},
                {"ivanovtestbox@gmail.com", "IncorrectPswd"},
                {"incorrect@gmail.com","IncorrectPswd"},
                {"",""}
        };
	}
	
	
	@Test(description="Pass login")
	public void logInPass() {
		logInGeneral("ivanovtestbox@gmail.com", "Chupakabros2015");
	}
	
	
	@Test(description="Sending email", dataProvider="=SendingEmailProvider", dependsOnMethods={"logInPass"})
	public void sendEmail(String to, String subject, String body)  {
		try {
			webDr.findElement(By.xpath("//div[@role='button' and text()='COMPOSE']")).click();
			webDr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//WebElement draftEmail= (new WebDriverWait(webDr, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='dialog']")));
			webDr.findElement(By.name("to")).sendKeys(to);
			webDr.findElement(By.name("subjectbox")).sendKeys(subject);
			webDr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			webDr.findElement(By.xpath("//div[@aria-label='Message Body']")).click();
			webDr.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys(body);
			webDr.findElement(By.xpath("//div[text()='Send']")).click();
			try {
				Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			if (!to.isEmpty()) {
				if (subject.isEmpty()&&body.isEmpty()) {
					webDr.switchTo().alert().accept();
				}
				webDr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				webDr.findElement(By.xpath("//div[contains(text(), 'Your message has been sent.')]"));
				
			} else {
				try {
				Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				String errorMsg=webDr.findElement(By.className("Kj-JD-Jz")).getText();
				webDr.findElement(By.xpath("//div[@class='Kj-JD-Jl']/button")).click();
				try {
					Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				webDr.findElement(By.xpath("//div[@data-tooltip='Discard draft']")).click();
				try {
					Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				Assert.assertEquals(errorMsg, "Please specify at least one recipient.");
			}
		} catch (NoSuchElementException e) {
			throw new AssertionError("Email creation error: element not found", e);
		}
	}
	
	
	@DataProvider(name = "SendingEmailProvider")
    public Object[][] DataForEmailComposing() {
       return new Object[][] {                  
                    {"ivanovtestbox@gmail.com","", ""},
                    {"ivanovtestbox@gmail.com","","Test1"},
                    {"ivanovtestbox@gmail.com","Test2",""},
                    {"ivanovtestbox@gmail.com","Test3","Hello, Yuri!"+System.currentTimeMillis()},
                    {"","Test4",""},
                    {"","","Test5"},
                    {"","Test6","Test6"},
                    {"","", ""},
            };
    }
	
	
	@Test(description="Email received", dataProvider="EmailReceivedProvider", dependsOnMethods={"sendEmail"})
	public void emailReceived(String to, String subject) {
		try {
			webDr.navigate().refresh();
			webDr.findElement(By.partialLinkText("Inbox")).click();
			webDr.findElement(By.xpath("//div[text()='Primary']")).click();
			String sender=webDr.findElement(By.xpath("//table//tr[1]//div[@class='yW']/span[@email]")).getText();
			String subjectDisplayed=webDr.findElement(By.xpath("//table//tr[1]//div[@class='y6']/span/b")).getText();
			softAssert.assertEquals(sender, to, "Email was send by "+sender);
			softAssert.assertEquals(subject, subject,"Email subject is "+subjectDisplayed);
			System.out.println("Email successfully received!");
		} catch (NoSuchElementException e) {
			throw new AssertionError("Email verification error: element not found", e);
		}
	}
	
	
	@DataProvider(name = "EmailReceivedProvider")
    public Object[][] DataForEmailReceived() {
       return new Object[][] {
                    {"me", subject}
            };
    }
	
	
	@AfterTest
	public void logout() {
		try {
			webDr.findElement(By.xpath("//a[contains(@title, 'Google Account')]")).click();
			webDr.findElement(By.linkText("Sign out")).click();
			webDr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			webDr.findElement(By.id("rsi-card"));
		} catch (NoSuchElementException e) {
			throw new AssertionError("Logout error: element not found", e);
		}
	}
	@AfterTest
	public void quit() {
		webDr.quit();
	}
}
