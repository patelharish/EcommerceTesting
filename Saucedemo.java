package Ecomsaucedemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Saucedemo {
	WebDriver driver;

	@BeforeTest
	public void openUrl() {

		driver = new ChromeDriver();

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\patel\\OneDrive\\Desktop\\SDET\\chromedriver-win64\\chromedriver.exe");

		driver.get("http://www.automationpractice.pl/index.php");
		driver.manage().window().maximize();
	}

	@Test
	public void loginPage() {

		driver.findElement(By.xpath("//a[@class='login']")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("patelharish304@gmail.com");
		driver.findElement(By.xpath("(//input[@id='passwd'])[1]")).sendKeys("Harish@321");
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();

	}

	
	@SuppressWarnings("deprecation")
	@Test
	public void searchProduct(){
		driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("dress");
		driver.findElement(By.xpath("//button[@class=\"btn btn-default button-search\"]")).click();
		driver.findElement(By.xpath("(//img[@title='Printed Dress'])[1]")).click();
		driver.findElement(By.cssSelector("#color_24")).click();
		driver.findElement(By.cssSelector("button[name='Submit'] ")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[@title='Close window']")).click();
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void addTOCart() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("a[title='View my shopping cart']")).click();		
		
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}

}
