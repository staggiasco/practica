package pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import pageFactory.AbstractPageObject;

public class HomePage extends AbstractPageObject {

	public HomePage(WebDriver driver, WebDriverWait driverWait) {
		super(driver, driverWait);
		// TODO Auto-generated constructor stub
	}

	
	WebDriverWait wait = new WebDriverWait(driver, 5);

	private WebElement IngresarUsuario = driver.findElement(By.id("Usuario"));
	private WebElement IngresarPassword = driver.findElement(By.id("Password"));
	private WebElement ClickEnterButton = driver.findElement(By.id("btnLogin"));
	private WebElement SelSuc = driver.findElement(By.id("cmbChannel"));
	private WebElement ClickearBotonLogin = driver.findElement(By.id("btnLogin"));

	
	
	public void ingresarEtiquetas() {
		 IngresarUsuario.sendKeys("useradmin");
		 IngresarPassword.sendKeys("fravega1559");		 
		 ClickEnterButton.click();
		 Select SeleccionarSucursal = new Select(SelSuc);
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		 SeleccionarSucursal.selectByValue("052");
		 ClickearBotonLogin.click();
		 System.out.println("Ingres� correctamente a Etiquetas");
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

}
