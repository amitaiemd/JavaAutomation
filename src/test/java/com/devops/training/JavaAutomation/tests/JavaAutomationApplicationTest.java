package com.devops.training.JavaAutomation.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


class JavaAutomationApplicationTest {

	public static WebDriver driver = null;
	
	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP USER\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
	}

	
	@Test
	public void verifySuccessfulRegistration() {
		try {
			System.out.println("Launching Welcome page of Angular App");
			driver.get("http://localhost:4200/welcome");
			System.out.println("Landed on Welcome page");
			//WebElement signIn=driver.findElement(By.id("login"));
			driver.get("http://localhost:4200/register");
			System.out.println("Clicked on Register button to redirect to user registration page");
			WebElement userName=driver.findElement(By.name("user_name"));
			WebElement userEmail=driver.findElement(By.name("user_email"));
			WebElement password=driver.findElement(By.name("password"));
			WebElement login=driver.findElement(By.className("btn-primary"));
			String tempEmail="amitautomation@testing.com";
			String tempPassword="abc123";
			String tempUserName="Automation User";
			userName.sendKeys(tempUserName);
			userEmail.sendKeys(tempEmail);
			password.sendKeys(tempPassword);
			login.click();
			System.out.println("Clicked on the Submit Button");
			Thread.sleep(500);
			System.out.println("Redirecting to sign in page");
			driver.get("http://localhost:4200/login");
			WebElement userEmailLogin=driver.findElement(By.name("user_email"));
			WebElement passwordLogin=driver.findElement(By.name("password"));
			WebElement loginButton=driver.findElement(By.className("btn-primary"));
			userEmailLogin.sendKeys(tempEmail);
			passwordLogin.sendKeys(tempPassword);
			Thread.sleep(500);
			loginButton.click();
			Thread.sleep(500);
			String welcomeMessage = driver.findElement(By.xpath("//div[@class = 'd-flex justify-content-centerd-flex justify-content-center fs-3 fw-lighter my-4']")).getText();
			String expectedMessage="Hi Automation User";
			assertEquals(expectedMessage,welcomeMessage);
			System.out.println("Asserting welcome message");
			Thread.sleep(500);
			closeBrowser();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifySuccessfulUserLogin() {
		try {
			System.out.println("Launching Welcome page of Angular App");
			driver.get("http://localhost:4200/welcome");
			System.out.println("Landed on Welcome page");
			//WebElement signIn=driver.findElement(By.id("login"));
			driver.get("http://localhost:4200/login");
			System.out.println("Clicked on Login button to redirect to login page");
			WebElement username=driver.findElement(By.name("user_email"));
			WebElement password=driver.findElement(By.name("password"));
			WebElement login=driver.findElement(By.className("btn-primary"));
			username.sendKeys("amit@testing.com");
			password.sendKeys("abc123");
			login.click();
			System.out.println("Clicked on the Sign In Button.");
			Thread.sleep(500);
			String welcomeMessage = driver.findElement(By.xpath("//div[@class = 'd-flex justify-content-centerd-flex justify-content-center fs-3 fw-lighter my-4']")).getText();
			String expectedMessage="Hi AutomationTestUser";
			assertEquals(expectedMessage,welcomeMessage);
			System.out.println("Asserting welcome message");
			Thread.sleep(500);
			closeBrowser();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeBrowser() {
		driver.close();
		System.out.println("The driver has been closed.");
	}

}
