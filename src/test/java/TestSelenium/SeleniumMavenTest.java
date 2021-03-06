package TestSelenium;

 

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
 
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class SeleniumMavenTest {

	//login
			By txtusuario = By.id("txtUsuario");
			By btnnuevop = By.id("optNuevaCotizacion");
			//By cboproducto = By.xpath("//button[@data-id='cboProducto']");
			dataDriver d = new dataDriver();
			
			 
			
	@SuppressWarnings("deprecation")
	@Test
	public void ejecutaTest() throws InterruptedException, IOException {
		ArrayList data = d.getData("Escenario1");
		WebDriver driver;
		ChromeOptions options;
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
	 
		options = new ChromeOptions();
		options.addArguments("--ignore-certificate-errors");

  		driver = new ChromeDriver(options);
		driver.get("https://pricing-uat.extranetbanbif.com.pe/Pricing/login");
		
		driver.manage().window().maximize();

		Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		
		
		WebElement video = fWait.until(new Function<WebDriver,WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(txtusuario);
			}
		});
		 
		
		driver.findElement(txtusuario).sendKeys(""+data.get(1));
		driver.findElement(By.id("txtPassword")).sendKeys(""+data.get(2));
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(2000);
		
		//crear cotización
		Wait<WebDriver> fWait2 = new FluentWait<WebDriver>(driver)
				.withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		
		WebElement video1 = fWait2.until(new Function<WebDriver,WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(btnnuevop);
			}});
			
		driver.findElement(By.id("optNuevaCotizacion")).click();
		driver.findElement(By.id("txtNroDocumento")).sendKeys(""+data.get(3));		
		driver.findElement(By.id("btn")).click();
		
		//
		
		/*Wait<WebDriver> fWait3 = new FluentWait<WebDriver>(driver)
				.withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		
		WebElement video2 = fWait3.until(new Function<WebDriver,WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(cboproducto);
			}
		});*/
		
		//
		Thread.sleep(10000);

		//Select cboProduct = new Select (driver.findElement(By.xpath("//button[@data-id='cboProducto']")));
		Select cboProduct = new Select (driver.findElement(By.id("cboProducto")));
		cboProduct.selectByVisibleText(""+data.get(4));
		
		Thread.sleep(1000);

		//Select cboModalidad = new Select (driver.findElement(By.id("//button[@data-id='cboModalidad']")));
		Select cboModalidad = new Select (driver.findElement(By.id("cboModalidad")));
		cboModalidad.selectByVisibleText(""+data.get(5));
		
		Thread.sleep(1000);
		
		Select cboTipoIngreso = new Select (driver.findElement(By.id("cboTipoIngreso")));
		//cboTipoIngreso.selectByIndex(1);
		cboTipoIngreso.selectByVisibleText(""+data.get(6));
		Thread.sleep(1000);
		
		Select cboTipoRelacionLaboral = new Select (driver.findElement(By.id("cboTipoRelacionLaboral")));
		//cboTipoRelacionLaboral.selectByIndex(3);
		cboTipoRelacionLaboral.selectByVisibleText(""+data.get(7));
		
		Thread.sleep(1000);
		driver.findElement(By.id("txtIngresoEstimado")).sendKeys(Keys.RIGHT);	
		driver.findElement(By.id("txtIngresoEstimado")).sendKeys(""+data.get(8));		
		Thread.sleep(1000);
		Select cboMonedaOperacion = new Select (driver.findElement(By.id("cboMonedaOperacion")));
		//cboMonedaOperacion.selectByIndex(2);
		cboMonedaOperacion.selectByVisibleText(""+data.get(9));
		Thread.sleep(800);
		driver.findElement(By.id("txtMontoOperacion")).sendKeys(""+data.get(10));
		Thread.sleep(800);
		Select cboPlazo = new Select (driver.findElement(By.id("cboPlazo")));
		//cboPlazo.selectByIndex(1);
		cboPlazo.selectByVisibleText(""+data.get(11));
		Thread.sleep(800);
		driver.findElement(By.id("txtPlazo")).sendKeys(""+data.get(12));
		Thread.sleep(800);
		driver.findElement(By.id("txtFechaPrimeraC")).click();
 
 
		String year =driver.findElement(By.xpath("//div[@class='dtp-date']/div[3]/div[2]")).getText();
		int years = Integer.parseInt(year);
	//	System.out.println(years);
		Thread.sleep(800);
		
		String day =driver.findElement(By.xpath("//div[@class='dtp-date']/div[2]")).getText();
		int days = Integer.parseInt(day);
	//	System.out.println(days);
		

		
		String month =driver.findElement(By.xpath("//div[@class='dtp-date']/div/div[2]")).getText();
	//	System.out.println(month);
		Thread.sleep(800);	
		String mes = "OCT";
	 
			if(!month.equals(mes)) {
				String months;
	 			do {
					driver.findElement(By.xpath("//div[@class='dtp-date']/div/div[3]/a")).click();
					Thread.sleep(1000);
					months =driver.findElement(By.xpath("//div[@class='dtp-date']/div/div[2]")).getText();
					System.out.println(""+months);
					 
	 		    } while (!months.equals(mes));
 
	 			
	 			//months.equals("DIC")
	 		}else {
			//System.out.println("Es el mismo MES Ingresado");
			}
			
		
		
		Thread.sleep(800);	
			int yeari=2021;
			if(years<yeari) {
				int yearcont = yeari-years;
				for (int i = 0 ; i < yearcont; i++) {
					driver.findElement(By.xpath("//div[@class='dtp-date']/div[3]/div[3]/a")).click();;
					Thread.sleep(1000);	
					}
				}if(years>yeari) {
					int yearcont = years-yeari;
					for (int i = 0 ; i < yearcont; i++) {
						driver.findElement(By.xpath("//div[@class='dtp-date']/div[3]/div/a")).click();;
						Thread.sleep(1000);	
						}
				}	
				
		String idia = "30";
		driver.findElement(By.xpath("//td[@data-date='"+idia+"']")).click();;
		Thread.sleep(800);				 
				
		driver.findElement(By.xpath("//button[@class='dtp-btn-ok btn btn-primary btn-round btn-flat']")).click();; 
		Thread.sleep(800); 
		
		
	 
		driver.findElement(By.id("btnCalcularTasa")).click(); 
		Thread.sleep(800); 
		
		driver.findElement(By.id("txtRCI")).sendKeys(""+data.get(13));
		Thread.sleep(800);
		
		driver.findElement(By.id("btnGuardarOperacion")).click();
		Thread.sleep(800);
		
		driver.findElement(By.xpath("//button[@class='swal2-confirm btn btn-success btnConfirmarSA']")).click();
		Thread.sleep(7000);
		 
		driver.findElement(By.xpath("//button[@class='swal2-confirm btn btn-success btnConfirmarSA']")).click();
		Thread.sleep(7000);
		
		String coti = driver.findElement(By.xpath("//label[@id='lblIDSOL']")).getText();
		System.out.println(coti);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@id='optCotizaciones']/a/i")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//td[@class='cssColumna1']/button[2]")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("//button[@class='swal2-confirm btn btn-success btnConfirmarSA']")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("//button[@class='swal2-confirm btn btn-success btnConfirmarSA']")).click();
		Thread.sleep(5000);
	
		
		driver.findElement(By.xpath("//td[@class='cssColumna1']/button")).click();
		Thread.sleep(2000);
		
		
		int valor1 = (int)(Math.random()*(999999999-111111111+1)+999999999); 
		int valor2 = (int)(Math.random()*(9-1+1)+9);
		String numCadena1= valor1+"";
		String numCadena2= valor2+"";
		//System.out.println(numCadena1+numCadena2);
		driver.findElement(By.xpath("//input[@id='txtNroOperacion']")).sendKeys(String.valueOf(numCadena1+numCadena2));
		 
		 		 
		//driver.findElement(By.linkText("Aceptar")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//button[@id='btnVincularOperacion']")).click();
		Thread.sleep(12000);
		driver.findElement(By.xpath("//button[@class='swal2-confirm btn btn-success btnConfirmarSA']")).click();
		Thread.sleep(2000);
		
		driver.close();
	}
}
