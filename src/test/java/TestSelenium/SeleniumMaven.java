package TestSelenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumMaven {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		ChromeOptions options;
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		
		options = new ChromeOptions();
		options.addArguments("--ignore-certificate-errors");

  		driver = new ChromeDriver(options);
		driver.get("https://pricing-uat.extranetbanbif.com.pe/Pricing/login");
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//login
		driver.findElement(By.id("txtUsuario")).sendKeys("RPADILLA");
		driver.findElement(By.id("txtPassword")).sendKeys("123456789");
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(4000);
		//Abre el modal
		driver.findElement(By.xpath("//td[@class='cssColumna1']/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtNroOperacion']")).sendKeys(String.valueOf("123356789012"));
 
 
	 
	 
		//driver.findElement(By.linkText("Aceptar")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//button[@id='btnVincularOperacion']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='swal2-confirm btn btn-success btnConfirmarSA']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='swal2-confirm btn btn-success btnConfirmarSA']")).click();
		Thread.sleep(2000);
		driver.close();
	}

}
